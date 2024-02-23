package webServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class WebServerThread extends Thread {
  private Socket client;

  public WebServerThread(Socket client) {
    this.client = client;
  }

  @Override
  public void run() {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        OutputStream outputStream = client.getOutputStream()) {

      String request = reader.readLine();
      System.out.println("Received request: " + request);

      String response = processRequest(request);

      outputStream.write(response.getBytes());
      outputStream.flush();

      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String processRequest(String request) {
    StringBuilder response = new StringBuilder();
    response.append("HTTP/1.0 200 OK\n");
    response.append("Content-Type: text/html; charset=utf-8\n\n");
    response.append("<HTML><BODY>\n");
    response.append("<H1>Hællæ, du er nå koblet opp til min web server </h1>\n");
    response.append("<UL>\n");
    response.append("<LI> Assignment_3-IDATT2104 </LI>\n");
    response.append("</UL>\n");
    response.append("<LI> Client IP: ").append(client.getInetAddress()).append("</LI>\n");
    response.append("<LI> HTTP Request Header: <pre>").append(request).append("</pre></LI>\n");
    response.append("</BODY></HTML>\n");

    return response.toString();
  }
}