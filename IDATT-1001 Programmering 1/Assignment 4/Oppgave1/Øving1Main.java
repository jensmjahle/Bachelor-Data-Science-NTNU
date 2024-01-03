import java.util.Scanner;

class Øving4Oppgave1 {
    public static void main(String[] args) {

        Valuta euro = new Valuta(10.02, "EUR");
        Valuta sek = new Valuta(1.06, "NOK");
        Valuta dollar = new Valuta(10.03, "USD");

        Scanner in = new Scanner(System.in);
        System.out.println(
                "Velkommen til valutakalkulatoren :)\n Du har nå syv valg \n Tast 0 for å avslutte \n Tast 1 for NOK til EUR \n Tast 2 for EUR til NOK \n Tast 3 for NOK til SEK \n Tast 4 for SEK til NOK \n Tast 5 for NOK til USD \n Tast 6 for USD til NOK");
        int valg = in.nextInt();

        while (valg != 0) {

            System.out.println("Tast inn antall:"); // Får input hvor mye som skal omformes
            double input = in.nextDouble();

            switch (valg) {
                case 1:
                    System.out.println(input + " NOK blir " + euro.doCalculationFrom(input) + " EUR");// Fra NOK til EUR
                    break;
                case 2:
                    System.out.println(input + " EUR blir " + euro.doCalculationTo(input) + " NOK"); // Fra EUR til NOK
                    break;
                case 3:
                    System.out.println(input + " NOK blir " + sek.doCalculationFrom(input) + " SEK"); // Fra NOK til SEK
                    break;
                case 4:
                    System.out.println(input + " SEK blir " + sek.doCalculationTo(input) + " NOK"); // Fra SEK til NOK
                    break;
                case 5:
                    System.out.println(input + " NOK blir " + dollar.doCalculationFrom(input) + " USD");// Fra NOK til
                                                                                                        // USD
                    break;
                case 6:
                    System.out.println(input + " USD blir " + dollar.doCalculationTo(input) + "NOK"); // Fra USD til NOK
                    break;
            }
            System.out.println(
                    "Du har nå syv valg \n Tast 0 for å avslutte \n Tast 1 for NOK til EUR \n Tast 2 for EUR til NOK \n Tast 3 for NOK til SEK \n Tast 4 for SEK til NOK \n Tast 5 for NOK til USD \n Tast 6 for USD til NOK");
            valg = in.nextInt();

        }
        System.out.println("HADE!");
        in.close();

    }

}
