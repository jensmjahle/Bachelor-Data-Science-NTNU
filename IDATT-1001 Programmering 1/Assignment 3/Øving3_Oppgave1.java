import java.util.Scanner;

class øving3Oppgave1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn nedre grense for gangetabellen:");
        int nedreGrense = in.nextInt();
        System.out.println("Skriv inn øvre grense for gangetabellen:");
        int ovreGrense = in.nextInt();
        in.close();

        if (ovreGrense > nedreGrense) {

            for (int i = (ovreGrense - nedreGrense) + 1; i > 0; i--) {
                String tekst = String.format("Gangetabellen til %d:", nedreGrense);
                System.out.println(tekst);

                for (int u = 1; u < 11; u++) {
                    int sum = nedreGrense * u;
                    String utskrift = String.format("%d x %d = %d", nedreGrense, u, sum);
                    System.out.println(utskrift);
                }
                nedreGrense++;

            }
        } else {
            System.out.println("Den øvre grensen må være større enn den nedre grensen");
        }
    }

}
