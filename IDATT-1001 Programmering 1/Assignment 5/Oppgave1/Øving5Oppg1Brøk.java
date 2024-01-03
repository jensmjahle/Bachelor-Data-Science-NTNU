class Brøk {
    private int teller;
    private int nevner;
    private int resultatTeller;
    private int resultatNevner;

    public Brøk(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevner må være ulik 0");
        } else {
            this.teller = teller;
            this.nevner = nevner;
        }
    }

    public Brøk(int teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    public void addere(Brøk B) {
        int resultatTeller = (this.teller * B.nevner) + (B.teller * this.nevner);
        int resultatNevner = (this.nevner * B.nevner);
        this.resultatTeller = resultatTeller;
        this.resultatNevner = resultatNevner;
    }

    public void subtrahere(Brøk B) {
        int resultatTeller = (this.teller * B.nevner) - (B.teller * this.nevner);
        int resultatNevner = (this.nevner * B.nevner);
        this.resultatTeller = resultatTeller;
        this.resultatNevner = resultatNevner;
    }

    public void multiplisere(Brøk B) {
        int resultatTeller = this.teller * B.teller;
        int resultatNevner = this.nevner * B.nevner;
        this.resultatTeller = resultatTeller;
        this.resultatNevner = resultatNevner;
    }

    public void dividere(Brøk B) {
        int resultatTeller = this.teller * B.nevner;
        int resultatNevner = this.nevner * B.teller;
        this.resultatTeller = resultatTeller;
        this.resultatNevner = resultatNevner;
    }

    @Override
    public String toString() {
        return teller + " / " + nevner;
    }

}