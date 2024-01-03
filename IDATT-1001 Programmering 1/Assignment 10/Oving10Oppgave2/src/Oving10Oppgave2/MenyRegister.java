package Oving10Oppgave2;

import java.util.ArrayList;

public class MenyRegister {
  private ArrayList<Meny> menyer;
  private ArrayList<Rett> retter;

  /**
   * Kostruktøren lager en tom liste med menyer og en tom liste med retter.
   */
  public MenyRegister() {
    menyer = new ArrayList<Meny>();
    retter = new ArrayList<Rett>();
  }

  /**
   * Metoden henter alle menyene i listen med menyer.
   *
   * @return Liste med menyer.
   */
  public ArrayList<Meny> getMenyer() {
    return menyer;
  }

  /**
   * Metoden henter alle rettene i listen med retter.
   *
   * @return Liste med retter.
   */
  public ArrayList<Rett> getRetter() {
    return retter;
  }

  /**
   * Metoden registrerer en ny rett i listen med retter.
   *
   * @param navn Navn på retten. String.
   * @param type Type rett. String.
   * @param pris Pris på retten. Double.
   * @param oppskrift Oppskriften på retten. String.
   *
   * @return Den nye retten.
   */
  public Rett registrerNyRett(String navn, String type, double pris, String oppskrift){
    Rett nyRett = new Rett(navn, type, pris, oppskrift);
    retter.add(nyRett);
    return nyRett;
  }

  /**
   * Metoden finner en rett ut ifra rettens navn.
   *
   * @param navn Rettens navn. String.
   *
   * @return En rett.
   */
  public ArrayList<Rett> getRettNavn(String navn) {
    ArrayList<Rett> rett = new ArrayList<Rett>();
    for (int i = 0; i < getRetter().size(); i++) {
      if (getRetter().get(i).getNavn().toLowerCase().equals(navn.toLowerCase())) {
        rett.add(getRetter().get(i));
      }
    }
    return rett;
  }

  /**
   * Metoden finner alle retter i en gitt type.
   *
   * @param type type rett.
   * @return alle retten i denne typen.
   */
  public ArrayList<Rett> getRettType(String type) {
    ArrayList<Rett> typeArr = new ArrayList<Rett>();
    for (int i = 0; i < getRetter().size(); i++) {
      if (getRetter().get(i).getType().toLowerCase().equals(type.toLowerCase())) {
        typeArr.add(getRetter().get(i));
      }
    }
    return typeArr;
  }


  /**
   * Metoden registrerer en ny meny.
   *
   * @param menyRetter
   * @return Ny meny.
   */
  public Meny NyMeny(ArrayList<Rett> menyRetter) {
    Meny nyMeny = new Meny(menyRetter);
    getMenyer().add(nyMeny);
    return nyMeny;
  }


  /**
   * Metoden finner alle menyer med totalpris innenfor gitt intervall.
   * @param min minimums pris.
   * @param max maximum pris.
   * @return
   */
  public ArrayList<Meny> getMenyerMedPrisintervall(double min, double max) {
    ArrayList<Meny> menyArr = new ArrayList<Meny>();
    for (int i = 0; i < getMenyer().size(); i++) {
      if (getMenyer().get(i).getTotalpris() >= min && getMenyer().get(i).getTotalpris() <= max) {
        menyArr.add(getMenyer().get(i));
      }
    }
    return menyArr;
  }
}
