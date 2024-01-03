public class NyString {
    private String text;

    public NyString(String input){
        this.text = input;
    }

    public String forkorte() {
        String resultat = "";
        String[] ord = text.split(" "); //lager en tabell med alle ord i teksten
        for (int i = 0; i < ord.length; i++) {
            char bokstav = ord[i].charAt(0); //finner første bokstav i hvert ord
            resultat = resultat + bokstav; //legger første bokstav til i resultatet
        }
        return resultat;
    }

    public String fjernTegn(char tegn){
        String resultat = text;
        while (resultat.indexOf(tegn) != -1){ //så lenge teksten inneholder valgt bokstav kjører loopen
            int i = resultat.indexOf(tegn); // finner indexen til valgt bokstav
            resultat = resultat.substring(0,i) + resultat.substring(i+1); //lager en ny tekst frem til valgt bokstav pluss resten av teksten etter bokstaven.

        }
        return resultat;
    }
}
