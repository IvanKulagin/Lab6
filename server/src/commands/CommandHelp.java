package commands;

import utils.NetworkManager;
import java.util.Map;

public class CommandHelp implements Command {

    private final Map<String, Command> commands;

    public CommandHelp(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute(String[] args) {
        StringBuilder message = new StringBuilder();
        commands.forEach((key, value) -> message.append(key).append(": ").append(value.getDescription()).append("\n"));
        return message.toString();
    }

    @Override
    public String getDescription() {
        return "Вывести эту справку";
    }

    @Override
    public String getUsage() {
        return null;
    }
}
