package exceptions;

public class NoSuchCommandException extends Exception{
    public NoSuchCommandException(){
        super("Команда не найдена, введите help для списка доступных команд");
    }
}
