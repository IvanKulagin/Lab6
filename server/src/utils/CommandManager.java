package utils;

import commands.*;
import exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private Map<String, Command> commands;

    public CommandManager(CollectionManager manager, NetworkManager networkManager) {
        commands = new HashMap<>();
        commands.put("help", new CommandHelp(commands));
        commands.put("add", new CommandAdd(manager));
        commands.put("show", new CommandShow(manager));
        commands.put("info", new CommandInfo(manager));
        commands.put("update", new CommandUpdate(manager));
        commands.put("remove_by_id", new CommandRemoveById(manager));
        commands.put("clear", new CommandClear(manager));
        commands.put("save", new CommandSave(manager));
        commands.put("execute_script", new CommandExecuteScript(manager, commands));
        commands.put("remove_first", new CommandRemoveFirst(manager));
        commands.put("add_if_min", new CommandAddIfMin(manager));
        commands.put("remove_greater", new CommandRemoveGreater(manager));
        commands.put("count_less_than_heart_count", new CommandCountLessThanHeartCount(manager));
        commands.put("count_greater_than_weapon_type", new CommandCountGreaterThanWeaponType(manager));
        commands.put("filter_by_heart_count", new CommandFilterByHeartCount(manager));
    }

    public String executeCommand(String command, String[] args) throws Exception {
        if (commands.containsKey(command)) {
            try {
                return commands.get(command).execute(args);
            } catch (Exception e) {
                throw new InvalidArgumentException(commands.get(command).getUsage());
            }
        } else {
            throw new NoSuchCommandException();
        }
    }
}
