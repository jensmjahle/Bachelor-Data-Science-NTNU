package Oving11;

import java.util.Scanner;

public class Client {

  private final int ADD_PROPERTY = 1;
  private final int LIST_ALL_PROPERTIES = 2;
  private final int FIND_PROPERTY = 3;
  private final int CALCULATE_AVERAGE_AREA = 4;
  private final int DELETE_PROPERTY = 5;
  private final int LIST_ALL_PROPERTIES_LOT_NUMBER = 6;
  private final int EXIT = 9;
  private PropertyRegister propertyRegister = new PropertyRegister();


  /**
   * Presents the menu for the user, and awaits input from the user. The menu
   * choice selected by the user is being returned.
   *
   * @return the menu choice by the user as a positive number starting from 1.
   * If 0 is returned, the user has entered a wrong value
   */
  private int showMenu()
  {
    int menuChoice = 0;
    System.out.println("\n***** Property Register Application v0.1 *****\n");
    System.out.println("1. Add property");
    System.out.println("2. List all properties");
    System.out.println("3. Search property");
    System.out.println("4. Calculate average area");
    System.out.println("5. Delete property");
    System.out.println("6. Search for lot number");
    System.out.println("9. Quit");
    System.out.println("\nPlease enter a number between 1 and 9.\n");
    Scanner sc = new Scanner(System.in);
    if (sc.hasNextInt()) {
      menuChoice = sc.nextInt();
    } else {
      System.out.println("You must enter a number, not text");
    }
    return menuChoice;
  }
  /**
   * Starts the application. This is the main loop of the application,
   * presenting the menu, retrieving the selected menu choice from the user,
   * and executing the selected functionality.
   */
  public void start() {
    Scanner in = new Scanner(System.in);

    testData();

    boolean finished = false;
// The while-loop will run as long as the user has not selected
// to quit the application
    while (!finished) {
      int menuChoice = this.showMenu();
      switch (menuChoice)
      {
        case ADD_PROPERTY:
          System.out.println("Municipality Number:");
          int newMunicipalityNumber = in.nextInt();
          System.out.println("Municipality name:");
          in.nextLine();
          String newMunicipalityName = in.nextLine();
          System.out.println("Lot number:");
          int newLotNumber = in.nextInt();
          System.out.println("Section number:");
          int newSectionNumber = in.nextInt();
          System.out.println("Name:");
          in.nextLine();
          String newName = in.nextLine();
          System.out.println("Area (m^2):");
          int newArea = in.nextInt();
          in.nextLine();
          System.out.println("Name of owner:");
          String newNameOfOwner = in.nextLine();
          propertyRegister.addNewProperty(newMunicipalityNumber, newMunicipalityName, newLotNumber, newSectionNumber, newName,
                  newArea, newNameOfOwner);
          break;
        case LIST_ALL_PROPERTIES:
          System.out.println(propertyRegister);
          break;
        case FIND_PROPERTY:
          System.out.println("Type in the property ID (municipality number-lot number/section number):");
          String propertyID = in.nextLine();
          System.out.println(propertyRegister.findProperty(propertyID));
          break;
        case CALCULATE_AVERAGE_AREA:
          System.out.println("Average area: " + propertyRegister.averageArea() + "m^2");
          break;
        case DELETE_PROPERTY:
          System.out.println("Municipality number:");
          int muncipalityNumber = in.nextInt();
          System.out.println("Lot number:");
          int lotNumber = in.nextInt();
          System.out.println("Section number:");
          int sectionNumber = in.nextInt();
          System.out.println("Deleting property " + muncipalityNumber + "-" + lotNumber + "/" + sectionNumber + "...");
          propertyRegister.deleteProperty(muncipalityNumber, lotNumber, sectionNumber);
          break;
        case LIST_ALL_PROPERTIES_LOT_NUMBER:
          System.out.println("Lot number:");
          int searchLotNumber = in.nextInt();
          System.out.println(propertyRegister.getPropertiesLotNumber(searchLotNumber));
          break;
        case EXIT:
          System.out.println("Thank you for using the Properties app!\n");
          finished = true;
          break;
        default:
          System.out.println("Unrecognized menu selected..");
          break;
      }
    }
  }

  public void testData(){
    propertyRegister.addNewProperty(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen");
    propertyRegister.addNewProperty(1445, "Gloppen", 77, 131, "Suningom", 661.3, "Nicolay Madsen");
    propertyRegister.addNewProperty(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evelyn Jensen");
    propertyRegister.addNewProperty(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten");
    propertyRegister.addNewProperty(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");

  }

}