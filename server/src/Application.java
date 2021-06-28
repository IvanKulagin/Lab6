import request.Request;
import utils.*;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    private final CommandManager commandManager;
    private final NetworkManager networkManager;
    private boolean running;

    public Application() throws IOException {
        networkManager = new NetworkManager(new ConnectionManager(4445));
        CollectionManager collectionManager = new CollectionManager(networkManager);
        commandManager = new CommandManager(collectionManager, networkManager);
        running = true;
        collectionManager.load();
    }

    public void run() {
        while (running) {
            try {
                System.out.println("Waiting");
                Request request = networkManager.receive();
                System.out.println(request.getCommand());
                networkManager.send(new Request(commandManager.executeCommand(request.getCommand(), request.getArgs())));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                try {
                    networkManager.send(new Request(e.getMessage()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    public void exit() {
        running = false;
    }
}
