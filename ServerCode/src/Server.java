import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(123);
            ArrayList<Client> clients = new ArrayList<>();

            while (true) {
                Socket socket = serverSocket.accept();
                Client client = new Client(socket, clients);
                clients.add(client);

                Thread clientThread = new Thread(client);
                clientThread.start();

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
