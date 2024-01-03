import java.util.*;

class MinRandom {

    private static Random random = new Random();

    public MinRandom() {
    }

    public int nesteHeltall(int nedre, int ovre) {
        int max = ovre - nedre;
        int resultat = random.nextInt(max);
        resultat = resultat + nedre;
        return resultat;
    }

    public double nesteDesimaltall(double nedre, double ovre) {
        double differanse = ovre - nedre;
        double tilfeldig = random.nextDouble();
        double resultat = nedre + (differanse * tilfeldig);
        return resultat;
    }
}
