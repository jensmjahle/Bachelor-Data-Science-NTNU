package Oving11;

import java.util.ArrayList;
import java.util.List;

public class PropertyRegister {
  private ArrayList<Property> propertyRegister;

  /**
   * This constructor creates an empty property register.
   */
  public PropertyRegister() {
    propertyRegister = new ArrayList<>();
  }

  /**
   * This method checks if a property exist based of its lot number.
   *
   * @param lotNumber Lot number of the property.
   * @return Returns true if the property exist, false if not.
   */
  public boolean propertyExist(int municipalityName, int lotNumber, int sectionNumber){
    boolean propertyExist = false;

    for (int i = 0; i < propertyRegister.size(); i++){
      if (propertyRegister.get(i).getPropertyID().equals(municipalityName + "-" + lotNumber + "/" + sectionNumber)){
        propertyExist = true;
        break;
      }
    }
    return propertyExist;
  }

  /**
   * This method finds witch place a property has in the register.
   *
   * @param municipalityNumber The municipality number of the property. As an integer.
   * @param lotNumber The lot number of the property. As an integer.
   * @param sectionNumber The section number of the property. As an integer.
   * @return The place of the property in the register. As an integer.
   */
  private int getPropertyIndex(int municipalityNumber, int lotNumber, int sectionNumber){
    int index = -1;
    if (propertyExist(municipalityNumber, lotNumber, sectionNumber)){
      for (int i = 0; i < propertyRegister.size(); i++){
        if (propertyRegister.get(i).getPropertyID().equals(municipalityNumber + "-" + lotNumber + "/" + sectionNumber)){
          index = i;
          break;
        }
      }
    } else {
      throw new IllegalArgumentException("This property does not exist");
    }
    return index;
  }

  /**
   * This method adds a new property to the property register.
   *
   * @param municipalityNumber The new property municipality number. As an integer.
   * @param municipalityName The new property municipality name. As a string.
   * @param lotNumber The new property lot number. As an integer.
   * @param sectionNumber The new property section number. As an integer.
   * @param name The new property name. As a string.
   * @param area The area of the new property. As a double.
   * @param nameOfOwner The name of the owner of the new property. As a string.
   */
  public void addNewProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber,
  String name,double area, String nameOfOwner){
    if (propertyExist(municipalityNumber, lotNumber, sectionNumber)){
      throw new IllegalArgumentException("This property already exist");
    } else {
      propertyRegister.add(new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name,
              area, nameOfOwner));
    }
  }

  /**
   * This method removes a property from the register.
   *
   * @param municipalityNumber The municipality number of the property.
   * @param lotNumber The lot number of the property witch is being deleted.
   * @param sectionNumber The section number of the property.
   */
  public void deleteProperty(int municipalityNumber, int lotNumber, int sectionNumber){
    if (propertyExist(municipalityNumber, lotNumber, sectionNumber)){
      int index = getPropertyIndex(municipalityNumber, lotNumber, sectionNumber);
      propertyRegister.remove(index);
    } else {
      throw new IllegalArgumentException("This property does not exist");
    }
  }

  /**
   * This method retrieves the total amount of properties in the register.
   *
   * @return Total amount of properties. As an integer.
   */
  public int getTotProperties(){
    return propertyRegister.size();
  }

  /**
   * This method finds a property based on its property ID 0000-00/00.
   *
   * @param propertyID Property ID of the property.
   * @return A property.
   */
  public Property findProperty(String propertyID){
    int index = -1;
    for (int i = 0; i < propertyRegister.size(); i++){
      if (propertyRegister.get(i).


























      ().equals(propertyID)){
        index = i;
        break;
      }
    }
    return propertyRegister.get(index);
  }

  /**
   * This method calculates the average area per property in the register.
   *
   * @return Average area per property.
   */
  public double averageArea(){
    double totArea = 0;
    for (int i = 0; i < propertyRegister.size(); i++){
      totArea = totArea + propertyRegister.get(i).getArea();
    }
    return totArea / propertyRegister.size();
  }

  /**
   * This method returns a list of properties with a given lot number.
   *
   * @param lotNumber The lot number of witch the list is being filled by.
   * @return A list of properties with the given lot number.
   */
  public List<Property> getPropertiesLotNumber(int lotNumber){
    List<Property> propertiesLotNumber = new ArrayList<>();
    for (Property property : propertyRegister) {
      if (property.getLotNumber() == lotNumber) {
        propertiesLotNumber.add(property);
      }
    }
    return propertiesLotNumber;
  }

  @Override
  public String toString() {
    return "PropertyRegister " +
            "= \n" + propertyRegister + "\n" +
            '}';
  }
}
