package Oving11;

public class Property {
  private int municipalityNumber;
  private String municipalityName;
  private int lotNumber;
  private int sectionNumber;
  private String name;
  private double area;
  private String nameOfOwner;

  /**
   * This constructor creates a property with the following attributes:
   *
   * @param municipalityNumber Property municipality number. As an integer.
   * @param municipalityName Property municipality name. As a string.
   * @param lotNumber Property lot number. As an integer.
   * @param sectionNumber Property section number. As an integer.
   * @param name Property name. As a string.
   * @param area Property area in square meters. As a double.
   * @param nameOfOwner Name of the owner of the property. As a string.
   */
  public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
                  String name, double area, String nameOfOwner) {
    if (municipalityNumber >= 101 && municipalityNumber <= 5054){
      this.municipalityNumber = municipalityNumber;
    } else {
      throw new IllegalArgumentException("Municipality number must be a whole number between 100 and 5055");
    }

    this.municipalityName = municipalityName;
    this.lotNumber = lotNumber;
    this.sectionNumber = sectionNumber;
    this.name = name;
    this.area = area;
    this.nameOfOwner = nameOfOwner;
  }

  /**
   * This method retrieves the property municipality number.
   *
   * @return Municipality number.
   */
  public int getMunicipalityNumber() {
    return municipalityNumber;
  }

  /**
   * This method sets a new municipality number.
   *
   * @param municipalityNumber New municipality number.
   */
  public void setMunicipalityNumber(int municipalityNumber) {
    this.municipalityNumber = municipalityNumber;
  }

  /**
   * This method retrieves the property municipality name.
   *
   * @return Municipality name.
   */
  public String getMunicipalityName() {
    return municipalityName;
  }

  /**
   * This method sets a new municipality name.
   *
   * @param municipalityName New municipality name.
   */
  public void setMunicipalityName(String municipalityName) {
    this.municipalityName = municipalityName;
  }

  /**
   * This method retrieves the property lot number.
   *
   * @return Lot number.
   */
  public int getLotNumber() {
    return lotNumber;
  }

  /**
   * This method sets a new lot number.
   *
   * @param lotNumber New lot number.
   */
  public void setLotNumber(int lotNumber) {
    this.lotNumber = lotNumber;
  }

  /**
   * This method retrieves the property section number.
   *
   * @return Section number.
   */
  public int getSectionNumber() {
    return sectionNumber;
  }

  /**
   * This method sets a new property section number.
   *
   * @param sectionNumber New section number.
   */
  public void setSectionNumber(int sectionNumber) {
    this.sectionNumber = sectionNumber;
  }

  /**
   * This method retrieves the property name.
   *
   * @return Property name.
   */
  public String getName() {
    return name;
  }

  /**
   * This method sets a new property name.
   *
   * @param name New property name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method retrieves the property area in square meters.
   *
   * @return Property area.
   */
  public double getArea() {
    return area;
  }

  /**
   * This method sets a new property area.
   *
   * @param area New property area.
   */
  public void setArea(double area) {
    this.area = area;
  }

  /**
   * This method retrieves the property owners name.
   *
   * @return Name of the owner.
   */
  public String getNameOfOwner() {
    return nameOfOwner;
  }

  /**
   * This method sets a new property owner name.
   *
   * @param nameOfOwner New name of the owner.
   */
  public void setNameOfOwner(String nameOfOwner) {
    this.nameOfOwner = nameOfOwner;
  }

  /**
   * This method retrieves the property ID on the form: 0000-00/00.
   * @return Property ID.
   */
  public String getPropertyID(){
    return municipalityNumber + "-"
            + lotNumber + "/"
            + sectionNumber;
  }

  @Override
  public String toString() {
    return "Property{" +
            " Municipality number = " + municipalityNumber +
            ", Municipality name = '" + municipalityName + '\'' +
            ", Lot number = " + lotNumber +
            ", Section number = " + sectionNumber +
            ", Name = '" + name + '\'' +
            ", Area = " + area +
            ", Owner = '" + nameOfOwner + '\'' +
            '}' + "\n";
  }
}
