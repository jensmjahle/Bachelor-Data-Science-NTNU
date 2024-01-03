import java.util.Scanner;

class Øving5Oppgave2 {

    public static void main(String[] args) {
        MinRandom RandomTall = new MinRandom();
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn nedre grense");
        int nedreGrense = in.nextInt();
        System.out.println("Skriv inn øvre grense");
        int ovreGrense = in.nextInt();
        System.out.println("Tast 1 for heltall \n Tast 2 for desimaltall \n Tast 0 for å avslutte");
        int inputMeny = in.nextInt();

        switch (inputMeny) {
            case 0:
                System.out.println("Hade");
            case 1:
                int resultat = RandomTall.nesteHeltall(nedreGrense, ovreGrense);
                System.out.println("Her har du et random tall: " + resultat);
                main(args);
            case 2:
                double resultatDesimal = RandomTall.nesteDesimaltall(nedreGrense, ovreGrense);
                System.out.println("Her har du et random tall: " + resultatDesimal);
                main(args);
                in.close();
        }
    }
}
