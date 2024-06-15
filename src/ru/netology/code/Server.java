package ru.netology.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // public static final Integer PORT = 8083;

    public static void main(String[] args) throws IOException {
        int port = 8083;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server Start:");
            while (true) {
                Socket clientSocket = serverSocket.accept(); // ждем подключения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                {
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        } catch (IOException e) {

            throw new IOException(e);
        }
    }
}
