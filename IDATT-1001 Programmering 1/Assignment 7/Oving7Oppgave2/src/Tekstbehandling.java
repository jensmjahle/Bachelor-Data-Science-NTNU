public class Tekstbehandling {
    private String tekst;
    private String[] ord;
    private String[] periode;

    public Tekstbehandling(String input){
        this.tekst = input;
        this.ord = tekst.split(" "); //lager en liste med alle ordene i teksten
        this.periode = tekst.split("[.!:?]"); //lager en liste med alle setninger fra teksten
        
    }

    public int getAntallOrd(){
        int antallOrd = ord.length; //finner antall ord fra lengden på listen med ord
        return antallOrd;
    }
    public int getPeriodeLengde(){
        return periode.length;
    }
    public double getGjenomsnittOrdlengde(){
        double totOrdLengde = 0;
        for(int i = 0; i < periode.length; i++){
            String[] ordliste = periode[i].split(" "); //lager en liste med ord fra hver setning
            for(int u = 0; u < ordliste.length; u++){
                totOrdLengde = totOrdLengde + ordliste[u].length(); //legger til lengden på hvert ord til den totale ord lengden
            }
        }
        double gjennomsnitt = totOrdLengde / ord.length; //finner gjennomsnitlig ordlengde ved å dele totalt ordlengde på antall ord
        return gjennomsnitt;
    }
    public double getGjenomsnittOrdPerPeriode(){
        double totPeriodeOrd = 0;
        for(int i = 0; i < periode.length; i++){
            String[] ordliste = periode[i].split(" "); //splitter hver periode inn i en liste med ord
            double antallOrd = 0;
            if(i > 0) {
                antallOrd = ordliste.length - 1; //finner antall ord i perioden ved å ta lengden av listen med ord per periode. minus 1 siden listen deles inn etter mellomrom og det er et mellomrom helt først i setningen
            }
            else
                antallOrd = ordliste.length; //finner antall ord i perioden ved å ta lengden av listen med ord per periode. ikke minus 1 siden det ikke er noe mellomrom helt først i første setning

            totPeriodeOrd = totPeriodeOrd + antallOrd; //legger antall ord i perioden til den totale summen av ord
        }
        double snittOrdPeriode = totPeriodeOrd / periode.length; //regner ut gjennomsnittet
        return  snittOrdPeriode;
    }
    public String getTekst(){
        return tekst;
    }
    public String getTekstStoreBokstaver(){
        String tekstStoreBokstaver = tekst.toUpperCase(); //gjør alt til store bokstaver
        return tekstStoreBokstaver;
    }
    public String doSkifteOrd(String bytteFra, String bytteTil){
        String nyTekst = tekst.toLowerCase(); //gjør alt til små bokstaver
        if (nyTekst.indexOf(bytteFra) != -1){ //hvis teksten inneholder stringen bytteFra
            nyTekst = nyTekst.replaceAll(bytteFra, bytteTil); //bytter alle ordene (bytteFra) til nye ord(bytteTil)
        }
        return nyTekst;
    }


}
