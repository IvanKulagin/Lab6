package commands;

import utils.CollectionManager;

public class CommandAddIfMin implements Command {
    private final CollectionManager manager;
    public CommandAddIfMin(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.add_if_min();
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
