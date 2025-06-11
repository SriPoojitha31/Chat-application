import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer{
    private static final int PORT = 12346;
    private static final List<PrintWriter> clientWriters = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        System.out.println("Server started on port "+ PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);

        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected...");
            new ClientHandler(clientSocket).start();
        }
    }
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
            }
        }

        private void broadcast(String message) {
            for(PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}