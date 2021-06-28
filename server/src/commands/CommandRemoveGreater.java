package commands;

import utils.CollectionManager;

public class CommandRemoveGreater implements Command {
    private final CollectionManager manager;

    public CommandRemoveGreater(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.remove_greater();
    }

    @Override
    public String getDescription() {
        return "Удалить из коллекции все элементы, превышающие заданный";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
