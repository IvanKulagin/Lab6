package commands;

import utils.CollectionManager;

public class CommandAdd implements Command {
    private final CollectionManager manager;
    public CommandAdd(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.add();
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
