package utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;

public class ConnectionManager {

    private DatagramChannel channel;
    private SocketAddress socket;

    public ConnectionManager(String ip, int port) throws IOException {
        channel = DatagramChannel.open();
        socket = new InetSocketAddress(ip, port);
        channel.connect(socket);
    }

    public DatagramChannel getChannel() {
        return channel;
    }

    public SocketAddress getSocket() {
        return socket;
    }
}
