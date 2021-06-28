package commands;

public interface Command {
    String execute(String[] args) throws Exception;
    String getDescription();
    String getUsage();
}
