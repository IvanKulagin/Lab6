package commands;

import utils.CollectionManager;

public class CommandClear implements Command {
    private final CollectionManager manager;

    public CommandClear(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.clear();
    }

    @Override
    public String getDescription() {
        return "Очистить коллекцию";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
