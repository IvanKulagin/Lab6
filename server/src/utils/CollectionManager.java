package utils;

import commands.Command;
import marine.SpaceMarine;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class CollectionManager {

    private ArrayDeque<SpaceMarine> marines;
    private final LocalDateTime creationDate;
    private final DateTimeFormatter formatter;
    private final MarineReceiver marineReceiver;
    private final Parser parser;
    private int id;

    public CollectionManager(NetworkManager networkManager) {
        marines = new ArrayDeque<>();
        creationDate = LocalDateTime.now();
        marineReceiver = new MarineReceiver(networkManager);
        parser = new Parser();
        formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss");
        id = 0;
    }

    public String info(){
        return "Тип коллекции: " + marines.getClass().getName() + "\nДата инициализации: " + creationDate.format(formatter) + "\nКоличество элементов: " + marines.size();
    }

    public String add() {
        try {
            marines.add(marineReceiver.buildMarine(++id));
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Элемент успешно добавлен в коллекцию";
    }

    public String update(Integer id) {
        marines.removeIf(marine -> marine.getId().equals(id));
        try {
            marines.add(marineReceiver.buildMarine(id));
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Обновлён элемент с id " + id;
    }

    public String remove_by_id(Integer id) {
        marines.removeIf(marine -> marine.getId().equals(id));
        return "Элемент с id " + id + " успешно удалён";
    }

    public String clear() {
        marines.clear();
        id = 0;
        return "Коллекция очищена";
    }

    public void save() {
        try {
            parser.generate(marines);
        }
        catch (FileNotFoundException e){
            System.out.println("Указанный файл не найден");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void load() {
        try {
            marines = parser.parse();
            id = marines.stream().max(Comparator.comparing(SpaceMarine::getId)).get().getId();
            System.out.println(id);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public String remove_first() {
        marines.removeFirstOccurrence(marines.stream().min(SpaceMarine::compareTo).get());
        return "Удалён первый элемент в коллекции";
    }

    public String add_if_min() {
        try {
            SpaceMarine comparable = marineReceiver.buildMarine(++id);
            System.out.println(comparable.compareTo(marines.stream().min(SpaceMarine::compareTo).get()));
            if (comparable.compareTo(marines.stream().min(SpaceMarine::compareTo).get()) < 0){
                marines.add(comparable);
                return "Элемент успешно добавлен в коллекцию";
            }
            else {
                id--;
                return "Элемент не был добавлен в коллекцию";
            }
        } catch (Exception e) {
           return e.getMessage();
        }
    }

    public String remove_greater() {
        try {
            SpaceMarine comparable = marineReceiver.buildMarine();
            marines.removeIf(marine -> comparable.compareTo(marine) < 0);
        }
        catch (Exception e){
           return e.getMessage();
        }
        return "Элементы были удалены из коллекции";
    }

    public Stream<SpaceMarine> getStream(){
        return marines.stream();
    }

    public void execute_script(String script, Map<String, Command> commands, Stack<String> history){
        try {
            Scanner reader = new Scanner(new File(script));
            boolean skip = false;
            //Scanner prevScanner = serverInputManager.getInput();
            //serverInputManager.setInput(reader);
            history.push(script);
            while (reader.hasNextLine()) {
                String str = reader.nextLine().toLowerCase().trim();
                String[] input = str.split("\\s+");
                if (commands.containsKey(input[0])) {
                    if (input[0].equals("execute_script")) {
                        for (String filename : history) {
                            if (input[1].equals(filename)) {
                                System.out.println("Обнаружена рекурсия в файле " + history.peek() + ", пропуск команды");
                                skip = true;
                                break;
                            }
                        }
                    }
                    if (!skip) {
                        try {
                            commands.get(input[0]).execute(Arrays.copyOfRange(input, 1, input.length));
                        } catch (Exception e) {
                            System.out.println(commands.get(input[0]).getUsage());
                            break;
                        }
                    }
                } else if (!input[0].equals("")) {
                    System.out.println("Команда не найдена, введите help для списка доступных команд");
                    break;
                }
            }
            history.pop();
            //serverInputManager.setInput(prevScanner);
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Указанный файл не найден");
        }
    }
}
