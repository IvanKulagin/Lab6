package commands;

import utils.CollectionManager;

import java.util.Map;
import java.util.Stack;

public class CommandExecuteScript implements Command {

    private final CollectionManager manager;
    private final Map<String, Command> commands;
    private final Stack<String> history;

    public CommandExecuteScript(CollectionManager manager, Map<String, Command> commands) {
        this.manager = manager;
        this.commands = commands;
        history = new Stack<>();
    }

    @Override
    public String execute(String[] args) throws Exception {
        manager.execute_script(args[0], commands, history);
        return null;
    }

    @Override
    public String getDescription() {
        return "Считать и исполнить скрипт из указанного файла";
    }

    @Override
    public String getUsage() {
        return "Использование: execute_script path_to_file";
    }
}
