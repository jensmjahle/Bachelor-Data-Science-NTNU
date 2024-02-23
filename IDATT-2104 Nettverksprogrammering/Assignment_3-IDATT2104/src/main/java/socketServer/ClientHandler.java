package socketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
  private Socket clientSocket;

  public ClientHandler(Socket socket) {
    this.clientSocket = socket;
  }

  public void run() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      while(true) {
        // Les input fra klienten
        String tallInput = in.readLine();
        System.out.println("Mottatt tall fra klienten: " + tallInput);

        // Les operasjon fra klienten
        String operasjon = in.readLine();
        System.out.println("Mottatt operasjon fra klienten: " + operasjon);

        // Utfør beregning basert på input og send tilbake til klienten
        try {
          double resultat = beregnResultat(tallInput, operasjon);
          out.println(resultat);
        } catch (Exception e) {
          out.println("Feil: " + e.getMessage());
        }


        String svar = in.readLine();
        if (svar.equalsIgnoreCase("Hade bra!")) {
          System.out.println("En klient har avsluttet forbindelsen");
          break;
        }

      }

      // Lukk strømmer og socket
      in.close();
      out.close();
      clientSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private double beregnResultat(String tallInput, String operasjon) {
    try {
    // Deler opp tallene og operasjonen fra klienten
    String[] tallArray = tallInput.split(" ");
    double tall1 = Double.parseDouble(tallArray[0]);
    double tall2 = Double.parseDouble(tallArray[1]);

    // Utfører den valgte operasjonen
    double resultat = 0;
    if (operasjon.equalsIgnoreCase("addisjon")) {
      resultat = tall1 + tall2;
    } else if (operasjon.equalsIgnoreCase("subtraksjon")) {
      resultat = tall1 - tall2;
    } else {
      throw new IllegalArgumentException("Ugyldig operasjon");
    }
    return resultat;
    } catch (Exception e) {
      if (e.getMessage() == "Ugyldig operasjon") {
        throw new IllegalArgumentException("Ugyldig operasjon, skriv 'addisjon' eller 'subtraksjon'");
      } else {
        throw new IllegalArgumentException("Kan ikke konvertere input til tall, skriv to tall separert med mellomrom");
      }
    }
  }

}
