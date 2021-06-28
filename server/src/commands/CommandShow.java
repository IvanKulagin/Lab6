package commands;

import marine.SpaceMarine;
import utils.CollectionManager;

import java.util.stream.Collectors;

public class CommandShow implements Command {
    private final CollectionManager manager;

    public CommandShow(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String execute(String[] args) {
        return manager.getStream().sorted().map(SpaceMarine::toString).collect(Collectors.joining("\n\n"));
    }

    @Override
    public String getDescription() {
        return "Вывести все элементы коллекции";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
