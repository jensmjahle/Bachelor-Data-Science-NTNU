import java.util.Scanner;

class BrøkKalkulator {
    public static void main(String[] args) {

        Brøk A;
        Brøk B;

        Scanner in = new Scanner(System.in);

        System.out.println(
                "Du har nå fem valg \n Tast 1 for å addere \n Tast 2 for å subtrahere \n Tast 3 for å multiplisere \n Tast 4 for å dividere \n Tast 0 for å avslutte");
        int valg = in.nextInt();

        A = new Brøk(1, 2);
        B = new Brøk(1, 4);

        switch (valg) {
            case 1:
                A.addere(B);
                System.out.println(A.toString());
                break;
            case 2:
                A.subtrahere(B);
                System.out.println(A);
                break;
            case 3:
                A.multiplisere(B);
                System.out.println(A.toString());
                break;
            case 4:
                A.dividere(B);
                System.out.println(A.toString());
                break;
        }
        in.close();

    }
}