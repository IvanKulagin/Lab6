package commands;

import utils.CollectionManager;

public class CommandUpdate implements Command {
    private final CollectionManager manager;

    public CommandUpdate(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.update(Integer.parseInt(args[0]));
    }

    @Override
    public String getDescription() {
        return "Обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getUsage() {
        return "Использование: update id";
    }
}
