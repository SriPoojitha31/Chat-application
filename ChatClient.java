import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "localhost";
    private static final int PORT = 12346;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, PORT);
            System.out.println("Connected to chat server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Thread to receive messages
            new Thread(() -> {
    try {
        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Friend: " + msg);
        }
    } catch (IOException e) {
        System.out.println("Disconnected from server.");
    }
}).start();

            // Sending messages
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                out.println(message);
            }

        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
