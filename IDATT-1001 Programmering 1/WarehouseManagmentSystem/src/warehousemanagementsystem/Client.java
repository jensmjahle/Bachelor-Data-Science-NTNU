package warehousemanagementsystem;

import java.util.Scanner;

/**
 * Represents a user-friendly client program for a warehouse management system.
 * The class has methods to search, view, add, delete and change items.
 *
 * @author Jens Martin Jahle
 * @version 10.12.2022
 */
public class Client {
  private static final int SEARCH = 1;
  private static final int ADD_NEW_ITEM = 2;
  private static final int CHANGE_STOCK = 3;
  private static final int PRINT_ALL_ITEMS = 4;
  private static final int REMOVE_ITEM = 5;
  private static final int CHANGES_IN_PRICE_DESCRIPTION_DISCOUNTS = 6;
  private static final int EXIT = 7;
  private static final Scanner in = new Scanner(System.in);
  private static final ItemRegister itemRegister = new ItemRegister();
  private static final String ERROR_MESSAGE =
          "Ops, something went wrong. See the error code bellow and try again\n";

  /**
   * Runs the program warehouse management system.
   *
   * @param args Program arguments (not relevant).
   */
  public static void main(String[] args) {
    System.out.println("****Warehouse Management System****");
    itemRegister.testData();
    mainMenu();
  }

  /**
   * The main menu that provides the user with all the functions that the program offers.
   * The user can search, read and do changes to the item register through the main menu.
   */
  public static void mainMenu() {
    boolean programRunning = true;
    while (programRunning) {
      try {
        int mainMenuChoice = validateInteger("""
                                                
                    ****Main menu****
                    Type 1 -> Search
                    Type 2 -> New item
                    Type 3 -> Change stock
                    Type 4 -> Print all items
                    Type 5 -> Remove item
                    Type 6 -> Change price, descriptions and discounts
                    Type 7 -> Exit program""");

        switch (mainMenuChoice) {
          case SEARCH -> search();
          case ADD_NEW_ITEM -> addNewItem();
          case CHANGE_STOCK -> changeStock();
          case PRINT_ALL_ITEMS -> printAllItems();
          case REMOVE_ITEM -> removeItem();
          case CHANGES_IN_PRICE_DESCRIPTION_DISCOUNTS -> changesDiscounts();
          case EXIT -> programRunning = false;
          default -> System.out.println("Type a number between 1 and 7");
        }
      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    }
  }

  /**
   * Validates that the user input is not blank.
   *
   * @param userMessage A message that the user sees to understand what to input.
   * @return A String.
   */
  private static String validateInput(String userMessage) {
    boolean validationRunning = true;
    String string = null;
    while (validationRunning) {
      try {
        System.out.println(userMessage);
        string = in.nextLine();
        if (string.isEmpty()) {
          throw new IllegalArgumentException();
        }
        validationRunning = false;
      } catch (IllegalArgumentException e) {
        System.out.println("No input detected. Try again.");
      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    }
    return string;
  }

  /**
   * Validates that the user input is an integer.
   *
   * @param userMessage A message that the user sees to understand what to input.
   * @return An integer.
   */
  private static int validateInteger(String userMessage) {
    boolean validationRunning = true;
    int integer = 0;
    while (validationRunning) {
      try {
        System.out.println(userMessage);
        integer = Integer.parseInt(in.nextLine());
        validationRunning = false;
      } catch (NumberFormatException e) {
        System.out.println("Input must be a whole number (no decimal sign)");
      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    }
    return integer;
  }

  /**
   * Validates that the user input is a double.
   *
   * @param userMessage A message that the user sees to understand what to input.
   * @return A double.
   */
  private static double validateDouble(String userMessage) {
    boolean validationRunning = true;
    double d = 0;
    while (validationRunning) {
      try {
        System.out.println(userMessage);
        d = Double.parseDouble(in.nextLine());
        validationRunning = false;
      } catch (NumberFormatException e) {
        System.out.println("Input must be a number. "
                + "Use period instead of comma in decimal numbers");
      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    }
    return d;
  }

  /**
   * Validates that the user provides a valid category.
   *
   * @param userMessage A message that the user sees to understand what to input.
   * @return A Category.
   */
  private static Category validateCategory(String userMessage) {
    boolean validationRunning = true;
    Category category = null;
    while (validationRunning) {
      try {
        System.out.println(userMessage);
        category = Category.values()[Integer.parseInt(in.nextLine()) - 1];
        validationRunning = false;
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Input must be a number between 1 and 4.");
      } catch (NumberFormatException e) {
        System.out.println("Input must be a whole number.");
      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    }
    return category;
  }

  /**
   * Gives the user opportunity to search
   * in the item register by item number, description or category.
   */
  private static void search() {
    boolean searchRunning = true;
    do {
      try {
        int searchChoice = validateInteger("""
                              
                ****Search****
                Type 1 -> Item number
                Type 2 -> Description
                Type 3 -> Category
                Type 0 -> Main menu
                """);

        switch (searchChoice) {
          case 0 -> searchRunning = false;
          case 1 -> searchItemNumber();
          case 2 -> searchDescription();
          case 3 -> searchCategory();
          default -> System.out.println("Enter a number between 0 and 3");

        }

      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    } while (searchRunning);
  }

  /**
   * Gives the user opportunity to search for an item from its item number.
   */
  private static void searchItemNumber() {
    try {
      System.out.println("\n****Search by item number****");
      String itemNumber = validateInput("Item number:");
      System.out.println(itemRegister.getItem(itemNumber));
    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }

  /**
   * Gives the user opportunity to search for items from an item description using keywords.
   */
  private static void searchDescription() {
    System.out.println("\n****Search by description****");
    String searchWords = validateInput("Type in search words."
            + "\nUsing keywords gives a better result");
    System.out.println("\n****Search result****");
    System.out.println(itemRegister.getSearchResultItemDescription(searchWords));
  }

  /**
   * Gives the user opportunity to search for items from a given category.
   */
  private static void searchCategory() {
    System.out.println("\n****Search by category****");
    Category categorySearch = validateCategory("""
            Category:
                    Type 1 -> Laminate floor
                    Type 2 -> Windows
                    Type 3 -> Doors
                    Type 4 -> Lumber""");
    System.out.println("\n****Search result****");
    System.out.println(itemRegister.getSearchResultItemCategory(categorySearch));
  }

  /**
   *Provides the user the opportunity to add a new item to the item register.
   * The user provides all the parameters of the new item.
   */
  private static void addNewItem() {
    try {
      System.out.println("""
                    
                    ****New item****
                    Fill in the information bellow to add an new item.
                    Use period instead of comma in decimal numbers,
                    """);
      String newItemNumber = validateInput("Item number (6 characters):");
      String newItemDescription = validateInput("Item description:");
      double newItemPrice = validateDouble("Price (NOK) :");
      String newItemBrand = validateInput("Brand:");
      double newItemWeight = validateDouble("Weight (kg):");
      double newItemLength = validateDouble("Length (m):");
      double newItemHeight = validateDouble("Height (m):");
      String newItemColor = validateInput("Color:");
      int newItemStock = validateInteger("Current stock:");
      Category newItemCategory = validateCategory("""
                    Category:
                    Type 1 -> Laminate floor
                    Type 2 -> Windows
                    Type 3 -> Doors
                    Type 4 -> Lumber""");

      itemRegister.addNewItem(newItemNumber, newItemDescription, newItemPrice, newItemBrand,
              newItemWeight, newItemLength, newItemHeight, newItemColor,
              newItemStock, newItemCategory);

      System.out.println("You added: \n" + itemRegister.getItem(newItemNumber));

      int choice = validateInteger("""
                    
                    Type 1 -> Confirm and save new item
                    Type 2 -> Cancel""");

      boolean running = true;
      do {
        switch (choice) {
          case 1 -> {
            System.out.println("Item saved...");
            running = false;
          }
          case 2 -> {
            itemRegister.removeItem(newItemNumber);
            System.out.println("Item not saved...");
            running = false;
          }
          default -> System.out.println("You must type either 1 to save or 2 to cancel.");
        }
      } while (running);

    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }

  /**
   * Provides the user the opportunity to change the stock of an item.
    */
  private static void changeStock() {
    try {
      System.out.println("\n****Change stock****");
      System.out.println(itemRegister.smallToString());
      String itemNumber = validateInput("Item number:");
      System.out.println(itemRegister.getItem(itemNumber));
      int stockChange = validateInteger("""
              
              Type in the change.
              If the change is negative use the minus (-) character.""");
      System.out.println("Change: From -> " + itemRegister.getItemStock(itemNumber) + "pcs"
                              + " To -> "
                              + (itemRegister.getItemStock(itemNumber) + stockChange) + "pcs");
      int confirmationChoice = validateInteger("""
              Type 1 -> Confirm and save
              Type 2 -> Cancel""");
      switch (confirmationChoice) {
        case 1 -> {
          itemRegister.changeItemStock(itemNumber, stockChange);
          System.out.println("The change was saved...");
        }
        case 2 -> System.out.println("Change canceled...");
        default -> System.out.println("Invalid input, the change was not saved...");
      }
    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }

  /**
   * Prints out every item in the item register with all its attributes.
   */
  private static void printAllItems() {
    System.out.println(itemRegister);
  }

  /**
   * Provides the user the opportunity to completely remove an item from the item register.
   */
  private static void removeItem() {
    try {
      System.out.println("\n****Remove item****");
      System.out.println(itemRegister.smallToString());
      String itemNumber = validateInput("Item number:");
      System.out.println(itemRegister.getItem(itemNumber));
      System.out.println("""
              ****Remove item****
              Are you sure you want to delete this item for good?
              The item wil no longer be accessible in the item register
              and all its information will be lost.
              """);
      int userChoice = validateInteger("""
              Type 1 -> Confirm and delete item
              Type 2 -> Cancel""");
      switch (userChoice) {
        case 1 -> {
          itemRegister.removeItem(itemNumber);
          System.out.println("The item " + itemNumber.toUpperCase() + " is deleted...");
        }
        case 2 -> System.out.println("Canceled. The item was not deleted...");
        default -> System.out.println("You typed neither 1 or 2. The item was not deleted...");
      }
    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }

  /**
   * Gives the user opportunity to change price and item description.
   * It also gives the user opportunity to put discounts on specific items.
   */
  private static void changesDiscounts() {
    boolean changesDiscountRunning = true;
    do {
      try {
        int userChoice = validateInteger("""
                             
               ****Changes and discounts****
               Type 1 -> Change price
               Type 2 -> Change item description
               Type 3 -> Discounts
               Type 0 -> Main menu""");
        switch (userChoice) {
          case 0 -> changesDiscountRunning = false;
          case 1 -> changePrice();
          case 2 -> changeItemDescription();
          case 3 -> changeDiscount();
          default -> System.out.println("You mast enter a number between 0 and 3");
        }
      } catch (Exception e) {
        System.out.println(ERROR_MESSAGE + e);
      }
    } while (changesDiscountRunning);
  }

  /**
   * Gives the user the opportunity to change the price of an item.
   */
  private static void changePrice() {
    try {
      System.out.println("\n****Change price****");
      System.out.println(itemRegister.smallToString());
      String itemNumber = validateInput("Item number:");
      System.out.println("Current price: " + itemRegister.getItemPrice(itemNumber) + "NOK");
      double newPrice = validateDouble("\nNew price:");
      System.out.println("\n****Change price****"
                       + "\nItem: " + itemNumber
                       + "\nChange:"
                       + "\nFrom -> "
                       + itemRegister.getItemPrice(itemNumber) + "NOK To -> " + newPrice + "NOK");
      int userChoice = validateInteger("""
              
              Type 1 -> Confirm change
              Type 2 -> Cancel""");
      switch (userChoice) {
        case 1 -> {
          itemRegister.setItemPrice(itemNumber, newPrice);
          System.out.println("New price saved...");
        }
        case 2 -> System.out.println("Canceled...");
        default -> System.out.println("Invalid input. The change was not saved...");
      }
    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }

  /**
   * Gives the user the opportunity to change the description of an item.
   */
  private static void changeItemDescription() {
    try {
      System.out.println("\n****Change description****");
      System.out.println(itemRegister.smallToString());
      String itemNumber = validateInput("Item number:");
      System.out.println("Current description: " + itemRegister.getItemDescription(itemNumber));
      String newItemDescription = validateInput("New description:");
      System.out.println("\n****Change description****"
                       + "\nFrom -> " + itemRegister.getItemDescription(itemNumber)
                       + "\nTo -> " + newItemDescription);

      int userChoice = validateInteger("""
              Type 1 -> Confirm and save new description"
              Type 2 -> Cancel""");
      switch (userChoice) {
        case 1 -> {
          itemRegister.setItemDescription(itemNumber, newItemDescription);
          System.out.println("Change saved...");
        }
        case 2 -> System.out.println("Change canceled...");
        default -> System.out.println("Invalid input. Change canceled...");
      }
    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }

  /**
   * Gives the user the opportunity to change discounts of an item.
   */
  private static void changeDiscount() {
    try {
      System.out.println("\n****Discounts****");
      System.out.println(itemRegister.smallToString());
      String itemNumber = validateInput("Item number:");
      System.out.println("Item number: " + itemNumber.toUpperCase()
                     + "\nCurrent discount: " + itemRegister.getDiscount(itemNumber) + "%");
      double newDiscount = validateDouble("New discount (%):");
      int userChoice = validateInteger("""
              Type 1 -> Confirm
              Type 2 -> Cancel""");
      switch (userChoice) {
        case 1 -> {
          itemRegister.setDiscount(itemNumber, newDiscount);
          System.out.println("New discount saved...");
        }
        case 2 -> System.out.println("Change canceled...");
        default -> System.out.println("Invalid input. Change canceled...");
      }
    } catch (Exception e) {
      System.out.println(ERROR_MESSAGE + e);
    }
  }
}
