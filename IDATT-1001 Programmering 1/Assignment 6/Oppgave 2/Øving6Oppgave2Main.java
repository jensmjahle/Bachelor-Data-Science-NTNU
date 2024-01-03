import java.util.Scanner;

class TekstanalyseKlient {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Skriv en tekst");
        String tekst = in.nextLine();
        Tekstanalyse tekstanalyse = new Tekstanalyse(tekst);

        int antallUlikeBokstaver = tekstanalyse.getAntallUlikeBokstaver();
        int antallBokstaver = tekstanalyse.getTotAntallBokstaver();
        double prosentIkkeBokstaver = tekstanalyse.getProsentIkkeBokstaver();
        int antallForekomsterEnBokstav = tekstanalyse.getAntallForekomsterEnBokstav("h");
        String mestForekommetBokstav = tekstanalyse.getMestForekommetBokstav();

        System.out.println("Antall ulike bokstaver: " + antallUlikeBokstaver);
        System.out.println("Antall bokstaver: " + antallBokstaver);
        System.out.println(prosentIkkeBokstaver + "% er ikke bokstaver");
        System.out.println("Bokstaven " + "h" + " forekom(er) " + antallForekomsterEnBokstav + " gang(er)");
        System.out.println("Mest forekommet bokstav(er): " + mestForekommetBokstav);

        in.close();
    }
}