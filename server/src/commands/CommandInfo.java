package commands;

import utils.CollectionManager;

public class CommandInfo implements Command {
    private final CollectionManager manager;

    public CommandInfo(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.info();
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о коллекци";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
