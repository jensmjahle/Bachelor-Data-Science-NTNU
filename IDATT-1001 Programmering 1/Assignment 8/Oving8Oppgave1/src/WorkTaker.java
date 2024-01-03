import java.util.Calendar;

public class WorkTaker {
  private final Person person;
  private final int workTakerNr;
  private final int yearOfHire;
  java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
  private double monthlySalary;
  private double taxPercent;

  /**
   * Oppretter objektet workTaker med følgende parameter
   *
   * @param person        Henter personalia fra klassen Person: Fornavn, Etternavn og fødselsår
   * @param workTakerNr   Oppretter workTakeNr
   * @param yearOfHire    Oppretter yearOfHire
   * @param monthlySalary Oppretter monthlySalary i NOK
   * @param taxPercent    Oppretter taxPercent i prosent
   */
  public WorkTaker(Person person, int workTakerNr, int yearOfHire, double monthlySalary, double taxPercent) {
    this.person = person;
    this.workTakerNr = workTakerNr;
    this.yearOfHire = yearOfHire;
    this.monthlySalary = monthlySalary;
    this.taxPercent = taxPercent;
  }

  /**
   * Metoden returnerer navnet til person på formen: Nordmann, Ola
   *
   * @return fult navn på formen ETTERNAVN, FORNAVN.
   */
  public String getName() {
    return getSurname() + ", " + getFirstname();
  }

  /**
   * Metoden henter fornavn i klassen Person og returnerer det
   *
   * @return fornavn.
   */
  public String getFirstname() {
    return person.getFirstname();
  }

  /**
   * Metoden henter etternavn i klassen Person og returnerer det
   *
   * @return etternavn.
   */
  public String getSurname() {
    return person.getSurname();
  }

  /**
   * Metoden henter fodselsar i klassen Person og returnerer det
   *
   * @return fødselsår
   */
  public int getBirthYear() {
    return person.getBirthYear();
  }

  /**
   * Metoden henter arbeidstakernummeret
   *
   * @return arbeidstakernummeret til personen.
   */
  public int getWorkTakerNr() {
    return workTakerNr;
  }

  /**
   * Metoden henter year of hire
   *
   * @return året personen ble ansatt.
   */
  public int getYearOfHire() {
    return yearOfHire;
  }

  /**
   * Metoden henter månedslønn lønn
   *
   * @return månedslønnen.
   */
  public double getMonthlySalary() {
    return monthlySalary;
  }

  /**
   * Metoden setter ny månedslønn til arbeidstaker
   *
   * @param monthlySalary ny månedslønn.
   */
  public void setMonthlySalary(double monthlySalary) {
    this.monthlySalary = monthlySalary;
  }

  /**
   * Metoden henter skatteprosenten til arbeidstaker.
   *
   * @return Nåværende skatteprosent.
   */
  public double getTaxPercent() {
    return taxPercent;
  }

  /**
   * Metoden setter ny skatteprosent til arbeidstaker.
   *
   * @param taxPercent ny skatteprosent.
   */
  public void setTaxPercent(double taxPercent) {
    this.taxPercent = taxPercent;
  }

  /**
   * Metoden regner ut hvor mye skatt personen betaler per måned.
   *
   * @return Skatt personen betaler per måned i kroner
   */
  public double getmonthlyTax() {
    double tax = getMonthlySalary() * (getTaxPercent() / 100);
    return tax;
  }

  /**
   * Metoden regner ut årlig brutto lønn og returnerer svaret
   *
   * @return årlig brutto lønn.
   */
  public double getYearlyBruttoSalary() {
    double yearlyBruttoSalary = getMonthlySalary() * 12;
    return yearlyBruttoSalary;
  }

  /**
   * Metoden regner ut årlig skatt og returnerer svaret.
   *
   * @return årlig skatt.
   */
  public double getYearlyTax() {
    double yearlyTax = 0;
    for (int i = 0; i < 13; i++) {
      double monthlyTax;
      if (i == 6) {
        monthlyTax = 0;
      } else if (i == 12) {
        monthlyTax = getmonthlyTax() / 2;
      } else {
        monthlyTax = getmonthlyTax();
      }
      yearlyTax = yearlyTax + monthlyTax;
    }
    return yearlyTax;
  }

  /**
   * Metoden regner ut alder til personen
   *
   * @return alder til personen
   */
  public int getAge() {
    int year = kalender.get(Calendar.YEAR);
    int age = year - person.getBirthYear();
    return age;
  }

  /**
   * Metoden regner ut hvor mange år personen har jobbet i bedriften.
   *
   * @return år i bedriften
   */
  public int getYearsInCompany() {
    int year = kalender.get(Calendar.YEAR);
    int yearsInCompany = year - getYearOfHire();
    return yearsInCompany;
  }

  /**
   * Metoden regner ut om personen har vært ansatt mer en et gitt antall år
   *
   * @param input hvor mange år personen skal ha jobbet
   * @return true hvis personen har jobbet mer enn eller likt som input
   */
  public boolean hasThePersonWorkedForMoreThan(int input) {
    int year = kalender.get(Calendar.YEAR);
    if (year - getYearOfHire() >= input) {
      return true;
    } else {
      return false;
    }
  }

}
