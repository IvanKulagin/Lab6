package utils;

import request.*;

import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class NetworkManager {

    private final ConnectionManager connectionManager;
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final byte[] buffer;
    private InetAddress clientAddress;
    private int clientPort;

    public NetworkManager(ConnectionManager connectionManager) throws IOException {
        this.connectionManager = connectionManager;
        byteArrayOutputStream = new ByteArrayOutputStream(4096);
        buffer = new byte[4096];
    }

    public Request receive() throws IOException, ClassNotFoundException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        connectionManager.getSocket().receive(packet);
        clientAddress = packet.getAddress();
        clientPort = packet.getPort();
        return (Request) new ObjectInputStream(new ByteArrayInputStream(packet.getData())).readObject();
    }

    public void send(Request request) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        connectionManager.getSocket().send(new DatagramPacket(byteArrayOutputStream.toByteArray(), byteArrayOutputStream.size(), clientAddress, clientPort));
        byteArrayOutputStream.reset();
    }
}