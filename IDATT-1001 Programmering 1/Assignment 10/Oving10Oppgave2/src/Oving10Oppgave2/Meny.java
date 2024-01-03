package Oving10Oppgave2;
import java.util.ArrayList;

public class Meny {
  private ArrayList<Rett> meny;

  /**
   * Konstruktøren oppretter en meny.
   * @param meny menyen.
   */
  public Meny(ArrayList<Rett> meny) {
    this.meny = meny;
  }

  /**
   * Metoden henter en meny.
   *
   * @return Menyen.
   */
  public ArrayList<Rett> getMeny() {
    return meny;
  }

  /**
   * Metoden regner ut totalprisen til en meny.
   *
   * @return Totalprisen til den gitte menyen.
   */
  public double getTotalpris() {
    double pris = 0;
    for (int i = 0; i < getMeny().size(); i++) {
      pris = pris + getMeny().get(i).getPris();
    }
    return pris;
  }

  @Override
  public String toString() {
    return "Meny{" +
            "meny=" + meny +
            '}';
  }

}
