public class Person {
  private final String firstname;
  private final String surname;
  private final int birthYear;

  /**
   * Oppretter objektet Person med folgende parameter
   *
   * @param firstname Oppretter fornavn
   * @param surname   Oppretter etternavn
   * @param birthYear Oppretter fodselsar
   */
  public Person(String firstname, String surname, int birthYear) {
    this.firstname = firstname;
    this.surname = surname;
    this.birthYear = birthYear;
  }

  /**
   * Metoden henter fornavnet til personen
   *
   * @return fornavn
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * Metoden henter etternavnet til personen
   *
   * @return etternavn
   */
  public String getSurname() {
    return surname;
  }

  /**
   * Metoden henter fodselaret til personen
   *
   * @return fodselsar
   */
  public int getBirthYear() {
    return birthYear;
  }


}
