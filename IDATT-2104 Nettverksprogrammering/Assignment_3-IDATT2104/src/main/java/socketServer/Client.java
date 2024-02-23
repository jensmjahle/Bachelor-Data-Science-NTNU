package socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    final String HOST = "localhost";
    final int PORT = 2222;

    try {
      Socket socket = new Socket(HOST, PORT);
      System.out.println("Klienten er koblet til tjeneren.");

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        overloop:
        while(true) {

          // Les input fra brukeren
          System.out.print("Skriv inn to tall: ");
          String tallInput = userInput.readLine();
          out.println(tallInput);

          // Les operasjon fra brukeren
          System.out.print("Velg operasjon (addisjon eller subtraksjon): ");
          String operasjon = userInput.readLine();
          out.println(operasjon);

          // Les svaret fra tjeneren og vis det til brukeren
          String svar = in.readLine();
          System.out.println("Svar fra tjeneren: " + svar);



          while (true) {
            System.out.println("Vil du fortsette? (ja/nei)");
            String svar2 = userInput.readLine();
            if (svar2.equals("nei")) {
              break overloop;
            } else if (svar2.equals("ja")) {
              out.println("ja");
              break;
            } else {
              System.out.println("Skriv inn ja eller nei");
            }
          }

        }

         out.println("Hade bra!");


        // Lukk strømmer og socket
        out.close();
        in.close();
        socket.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

