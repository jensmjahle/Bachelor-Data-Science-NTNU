package socketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    final int PORT = 2222;

    try {
      ServerSocket serverSocket = new ServerSocket(PORT);
      System.out.println("Tjeneren er startet og venter på tilkoblinger...");


      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("En klient har koblet seg til.");

        // Opprett en tråd for hver klient
        ClientHandler clientHandler = new ClientHandler(clientSocket);
        clientHandler.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
