import java.util.Scanner;

class Øving2_Oppgave1 {
    public static void main(String[] args) {
        try (Scanner input_årstall = new Scanner(System.in)) {
            System.out.println("Skriv in et årstall her:");
            int Årstall = input_årstall.nextInt();

            if (Årstall % 100 == 0) { // sjekker om årstaller er et hundreår

                if (Årstall % 400 == 0) {
                    System.out.println("År " + Årstall + " er et skuddår");
                } else
                    System.out.println("År " + Årstall + " er ikke et skuddår");
                // Dersom årstallet er delelig med 400 blir det et skuddår

            } else {
                if (Årstall % 4 == 0) {
                    System.out.println("År " + Årstall + " er et skuddår");
                } else
                    System.out.println("År " + Årstall + " er ikke et skuddår");
            } // Dersom årstallet er delelig med 4 er det et skuddår
        }

    }
}