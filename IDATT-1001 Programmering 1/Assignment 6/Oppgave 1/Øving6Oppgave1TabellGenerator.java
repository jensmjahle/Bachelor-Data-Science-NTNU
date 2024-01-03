import java.util.*;

class RandomTallTabell {
    private static Random random = new Random();
    private static int antall = 10;
    private static int runder = 1000;
    private static int[] tabell = new int[antall];

    public static void main(String[] args) {

        for (int i = 0; i < runder; i++) {
            int tall = random.nextInt(antall);
            tabell[tall]++;
        }
        /* Skriver ut resultatet */
        for (int i = 0; i < antall; i++) {
            int resultat = tabell[i];
            System.out.println(String.format("Tallet %d: %d", i, resultat));
        }

    }
}
