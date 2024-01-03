package Oving10Oppgave2;

public class Rett {
  private String navn;
  private String type;
  private double pris;
  private String oppskrift;

  /**
   * Konstruktøren lager en rett.
   *
   * @param navn Navn på retten.
   * @param type Type rett.
   * @param pris Pris på retten.
   * @param oppskrift Oppskrift.
   */
  public Rett(String navn, String type, double pris, String oppskrift) {
    this.navn = navn;
    this.type = type;
    this.pris = pris;
    this.oppskrift = oppskrift;
  }

  /**
   * Metoden henter navnet til retten.
   *
   * @return Navn.
   */
  public String getNavn() {
    return navn;
  }

  /**
   * Metoden gir retten nytt navn.
   *
   * @param navn Nytt navn.
   */
  public void setNavn(String navn) {
    this.navn = navn;
  }

  /**
   * Metoden henter rett typen.
   *
   * @return Type rett.
   */
  public String getType() {
    return type;
  }

  /**
   * Metoden gir retten ny type.
   *
   * @param type ny type rett.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Metoden henter pris på retten.
   *
   * @return Prisen på retten.
   */
  public double getPris() {
    return pris;
  }

  /**
   * Metoden setter ny pris på retten.
   *
   * @param pris Ny pris.
   */
  public void setPris(double pris) {
    this.pris = pris;
  }

  /**
   * Metoden henter oppskriften til retten.
   *
   * @return Oppskriften til retten.
   */
  public String getOppskrift() {
    return oppskrift;
  }

  /**
   * Metoden setter ny oppskrift til retten.
   *
   * @param oppskrift Ny oppskrift.
   */
  public void setOppskrift(String oppskrift) {
    this.oppskrift = oppskrift;
  }

  @Override
  public String toString() {
    return "Rett{" +
            "navn='" + navn + '\'' +
            ", type='" + type + '\'' +
            ", pris=" + pris +
            ", oppskrift='" + oppskrift + '\'' +
            '}';
  }

  public String toSmallString() {
    return this.getNavn() + " (" + this.getPris() + " kr)";
  }
}
