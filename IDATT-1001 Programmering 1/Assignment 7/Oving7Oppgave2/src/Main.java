import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("tekst:");
        String tekst = in.nextLine();

        System.out.println("Hva vil du bytte ut?");
        String utbytte = in.nextLine();


        System.out.println("Hva vil du bytte til?");
        String innbytte = in.nextLine();
        Tekstbehandling tekstbehandling = new Tekstbehandling(tekst);
        System.out.println("Ny tekst: " + tekstbehandling.doSkifteOrd(utbytte,innbytte));

        System.out.println("Antall ord: " + tekstbehandling.getAntallOrd()); // printer antall ord
        System.out.println("Gjennomsnittlig ordlengde: " + tekstbehandling.getGjenomsnittOrdlengde() + " bokstaver");
        System.out.println("Gjennomsnittlig ord per periode: " + tekstbehandling.getGjenomsnittOrdPerPeriode());
        System.out.println("Antall perioder: " + tekstbehandling.getPeriodeLengde());
        System.out.println("Teksten: " + tekstbehandling.getTekst());
        System.out.println("Teksten med store bokstaver: " + tekstbehandling.getTekstStoreBokstaver());



    }
}