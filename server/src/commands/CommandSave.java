package commands;

import utils.CollectionManager;

public class CommandSave implements Command {
    private final CollectionManager manager;

    public CommandSave(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
            manager.save();
            return null;
    }

    @Override
    public String getDescription() {
        return "Сохранить коллекцию в файл";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
