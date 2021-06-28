import request.Request;
import request.RequestType;
import utils.ConnectionManager;
import utils.ConsoleManager;
import utils.MarineBuilder;
import utils.NetworkManager;

import java.io.*;
import java.util.Arrays;

public class Application {

    private final ConsoleManager consoleManager;

    public Application() {
        consoleManager = new ConsoleManager();
    }

    public void run() throws IOException, ClassNotFoundException {
        NetworkManager networkManager = new NetworkManager(new ConnectionManager("localhost", 4445));
        while (true) {
            String[] input = consoleManager.read().toLowerCase().trim().split("\\s+");
            if (input[0].equals("exit")) {
                break;
            }
            networkManager.send(new Request(input[0], Arrays.copyOfRange(input, 1, input.length)));

            Request request = networkManager.receive();
            if (request.getRequestType() == RequestType.DATA) {
                networkManager.send(new Request(new MarineBuilder(consoleManager).buildMarine()));
                request = networkManager.receive();
            }
            consoleManager.println(request.getMessage());
        }
    }


}
