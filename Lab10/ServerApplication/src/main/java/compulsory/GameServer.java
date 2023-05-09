package compulsory;

import java.io.*;
import java.net.*;

public class GameServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(5000); // create a new server socket
        } catch (IOException e) {
            System.err.println("Could not listen on port: 5000.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            System.out.println("Waiting for connection.....");
            clientSocket = serverSocket.accept(); // wait for a client connection
            System.out.println("Connection established.....");
            new ClientThread(clientSocket).start();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        } finally {
            serverSocket.close();
        }

//        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//        String inputLine;
//
//        while ((inputLine = in.readLine()) != null) { // receive messages from client
//            System.out.println("Received message: " + inputLine);
//            out.println("Server received: " + inputLine); // send message to client
//        }
//
//        out.close();
//        in.close();
//        clientSocket.close();
//        serverSocket.close();
    }
}
