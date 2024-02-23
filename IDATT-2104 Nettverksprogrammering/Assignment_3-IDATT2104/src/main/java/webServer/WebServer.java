package webServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
  public static void main(String[] args) throws IOException {
    final int PORT = 80;

    try (ServerSocket server = new ServerSocket(PORT)) {
      System.out.println("Server started. Waiting...");
      while (true) {
        Socket client = server.accept();
        System.out.println("Client from address: " + client.getInetAddress() + ", connected!");
        WebServerThread sst = new WebServerThread(client);
        sst.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}