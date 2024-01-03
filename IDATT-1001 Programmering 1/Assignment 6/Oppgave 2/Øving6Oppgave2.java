import java.util.Arrays;

class Tekstanalyse {

    private int[] antallTegn;
    private static String[] alfabet = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "æ", "ø", "å" };

    public Tekstanalyse(String tekst) {
        int[] antallTegn = new int[30];
        for (int i = 0; i < 30; i++) {
            antallTegn[i] = 0;
        }
        tekst = tekst.toLowerCase();
        for (int i = 0; i < tekst.length(); i++) {
            char input = tekst.charAt(i);
            String bokstav = Character.toString((char) input);
            int index = Arrays.asList(alfabet).indexOf(bokstav);
            if (index == -1) {
                index = 29;
            }
            antallTegn[index] += 1;

        }
        this.antallTegn = antallTegn;
    }

    public int getAntallUlikeBokstaver() {
        int resultat = 0;
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > 0) {
                resultat++;
            }
        }
        return resultat;
    }

    public int getTotAntallBokstaver() {
        int resultat = 0;
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > 0) {
                resultat += antallTegn[i];
            }

        }
        return resultat;
    }

    public double getProsentIkkeBokstaver() {
        double resultat = 0;
        double antallBokstaver = 0;
        double antallIkkeBokstaver = 0;
        for (int i = 0; i < 30; i++) {
            if (i < 29) {
                antallBokstaver += antallTegn[i];
            } else {
                antallIkkeBokstaver += antallTegn[i];
            }

        }
        resultat = antallIkkeBokstaver / (antallBokstaver + antallIkkeBokstaver) * 100;
        return resultat;
    }

    public int getAntallForekomsterEnBokstav(String bokstav) {
        int resultat = 0;
        int index = Arrays.asList(alfabet).indexOf(bokstav);
        if (index > -1) {
            resultat += antallTegn[index];
        }
        return resultat;
    }

    public String getMestForekommetBokstav() {
        int hoyest = -1;
        String hoyestBokstav = "";
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > hoyest) {
                hoyest = antallTegn[i];
                hoyestBokstav = alfabet[i];
            } else if (antallTegn[i] == hoyest) {
                hoyestBokstav = hoyestBokstav + ", " + alfabet[i];
            }
        }
        String resultat = hoyestBokstav + " forekom " + hoyest + " gang(er)";
        return resultat;
    }

}
