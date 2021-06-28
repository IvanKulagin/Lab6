package commands;

import utils.CollectionManager;

public class CommandRemoveFirst implements Command {
    private final CollectionManager manager;

    public CommandRemoveFirst(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.remove_first();
    }

    @Override
    public String getDescription() {
        return "Удалить первый элемент из коллекции";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
