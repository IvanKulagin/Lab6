package utils;

import java.io.IOException;
import java.net.DatagramSocket;

public class ConnectionManager {
    private final DatagramSocket socket;

    public ConnectionManager(int port) throws IOException {
        socket = new DatagramSocket(port);
    }

    public DatagramSocket getSocket(){
        return socket;
    }
}
