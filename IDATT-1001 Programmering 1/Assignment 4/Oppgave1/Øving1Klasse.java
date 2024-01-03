class Valuta {
    private double valutaKurs;
    private String valutaNavn;

    public Valuta(double valutaKurs, String valutaNavn) {
        this.valutaKurs = valutaKurs;
        this.valutaNavn = valutaNavn;

    }

    public double getValutaKurs() {
        return valutaKurs;
    }

    public double doCalculationTo(double amount) {
        double sum = amount * getValutaKurs();
        return sum;
    }

    public double doCalculationFrom(double amount) {
        double sum = amount / getValutaKurs();
        return sum;
    }

}