package compulsory;

import java.io.*;
import java.net.*;

public class GameClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            socket = new Socket("localhost", 5000); // connect to server
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        while ((userInput = stdIn.readLine()) != null) { // send messages to server
            out.println(userInput);
            if(userInput.equals("exit")){
                out.close();
                in.close();
                stdIn.close();
                socket.close();
                return;
            }
            System.out.println(in.readLine()); // receive response from server
            if(userInput.equals("stop")){
                out.close();
                in.close();
                stdIn.close();
                socket.close();
                return;
            }
        }
    }
}
