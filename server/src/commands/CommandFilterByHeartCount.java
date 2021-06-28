package commands;

import marine.SpaceMarine;
import utils.CollectionManager;

import java.util.stream.Collectors;

public class CommandFilterByHeartCount implements Command {
    private final CollectionManager manager;
    public CommandFilterByHeartCount(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.getStream().filter(marine -> marine.getHeartCount().equals(Integer.parseInt(args[0]))).sorted().map(SpaceMarine::toString).collect(Collectors.joining("\n\n"));
    }

    @Override
    public String getDescription() {
        return "Вывести элементы, значение поля heartCount которых равно заданному";
    }

    @Override
    public String getUsage() {
        return "Использование: filter_by_heart_count heartCount";
    }
}
