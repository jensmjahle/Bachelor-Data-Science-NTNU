import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn tekst:");
        String text = in.nextLine();
        System.out.println("Skriv inn en bokstav du vil ta vekk:");
        char bokstav = in.next().charAt(0);
        NyString nyString = new NyString(text);
        String forkortetText = nyString.forkorte();
        System.out.println(text);
        System.out.println("Forkortet: " + forkortetText);
        String nyTekst = nyString.fjernTegn(bokstav);
        System.out.println("Tekst uten " + bokstav + ":" + nyTekst);

    }
}