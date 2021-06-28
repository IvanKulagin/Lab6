package commands;

import utils.CollectionManager;

public class CommandRemoveById implements Command {
    private final CollectionManager manager;

    public CommandRemoveById(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.remove_by_id(Integer.parseInt(args[0]));
    }

    @Override
    public String getDescription() {
        return "Удалить элемент из коллекции по его id";
    }

    @Override
    public String getUsage() {
        return "Использование: remove_by_id id";
    }
}
