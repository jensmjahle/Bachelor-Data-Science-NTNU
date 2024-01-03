package warehousemanagementsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a register that stores items for a warehouse management system.
 * It holds items from the Item class.
 * It has methods to read information stored in the register
 * along with methods to change some item attributes.
 *
 * @author Jens Martin Jahle
 * @version 10.12.2022
 */
public class ItemRegister {
  private final ArrayList<Item> items;

  /**
   * Creates an empty list of items from the class Item.
   */
  public ItemRegister() {
    this.items = new ArrayList<>();
  }

  /**
   * Checks if an item exists based on an item number.
   *
   * @param itemNumber The item number. As a String.
   * @return Returns true if the item exists, and false if the item does not exist.
   */
  private boolean itemExists(String itemNumber) {
    boolean itemExists = false;
    for (Item item : items) {
      if (item.getItemNumber().equals(itemNumber.toUpperCase())) {
        itemExists = true;
        break;
      }
    }
    return itemExists;
  }

  /**
   * Retrieves which place in the list items the chosen item has.
   *
   * @param itemNumber The item number of the chosen item. As a String.
   * @return The place of the given item in the item register. As an integer.
   */
  private int getItemId(String itemNumber) {
    int itemId = -1;
    if (!itemExists(itemNumber)) {
      throw new IllegalArgumentException("This item does not exist");
    }

    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getItemNumber().equals(itemNumber.toUpperCase())) {
        itemId = i;
        break;
      }
    }

    return itemId;
  }

  /**
   * It should be possible to add items to the item register.
   * Adds a new item to the list items.
   *
   * @param itemNumber      The item number. As a String.
   * @param itemDescription A description of the item. As a String.
   * @param itemPrice       The price of the item. As a double.
   * @param itemBrand       The brand of the item. As a String.
   * @param itemWeight      The weight of the item. As a double.
   * @param itemLength      The length of the item. As a double.
   * @param itemHeight      The height of the item. As a double.
   * @param itemColor       The color of the item. As a String.
   * @param itemStock       The current stock of the item. As an integer.
   * @param itemCategory    The item category. As an enum Category.
   */
  public void addNewItem(String itemNumber, String itemDescription, double itemPrice,
                         String itemBrand, double itemWeight, double itemLength,
                         double itemHeight, String itemColor, int itemStock,
                         Category itemCategory) {
    if (itemExists(itemNumber)) {
      throw new IllegalArgumentException("This item already exists.");
    }
    items.add(new Item(itemNumber.toUpperCase(), itemDescription, itemPrice, itemBrand,
              itemWeight, itemLength, itemHeight, itemColor, itemStock, itemCategory));
  }

  /**
   * It should be possible to remove items from the item register.
   * Deletes an item from the list items.
   *
   * @param itemNumber The item number of the item to be removed.
   */
  public void removeItem(String itemNumber) {
    items.remove(getItemId(itemNumber));
  }

  /**
   * Retrieves an item from its item number.
   *
   * @param itemNumber The item number of the retrieved item.
   * @return An item with the given item number.
   */
  public Item getItem(String itemNumber) {
    return new Item(items.get(getItemId(itemNumber)));

  }

  /**
   * Retrieves the current stock of an item.
   *
   * @param itemNumber The item number of the item. As a String.
   * @return The current item stock. As an integer.
   */
  public int getItemStock(String itemNumber) {
    return items.get(getItemId(itemNumber)).getItemStock();
  }


  /**
   * It should be possible to change the stock of an item.
   * The method changes the current stock of a specific item.
   *
   * @param itemNumber  The item number.
   *                    Used to identify which item the change is meant for. As a String.
   * @param stockChange The stock change.
   */
  public void changeItemStock(String itemNumber, int stockChange) {
    items.get(getItemId(itemNumber)).setItemStock(getItemStock(itemNumber) + stockChange);
  }

  /**
   * Retrieves the item price from a given item number.
   *
   * @param itemNumber Item number of the item. As a String.
   * @return The price of the item.
   */
  public double getItemPrice(String itemNumber) {
    return items.get(getItemId(itemNumber)).getItemPrice();
  }

  /**
   * It should be possible to change the price of an item.
   * Sets a new item price to an item from a given item number.
   *
   * @param itemNumber Item number of the item. As a String.
   * @param itemPrice  New price of the item. As a double.
   */
  public void setItemPrice(String itemNumber, double itemPrice) {
    items.get(getItemId(itemNumber)).setItemPrice(itemPrice);
  }

  /**
   * Retrieves the item description of an item.
   *
   * @param itemNumber The item number of the item. As a String.
   * @return The item description. As a String.
   */
  public String getItemDescription(String itemNumber) {
    return items.get(getItemId(itemNumber)).getItemDescription();
  }

  /**
   * It should be possible to change the description of an item.
   * Sets a new description to an item from a given item number.
   *
   * @param itemNumber Item number of the item. As a String.
   * @param itemDescription New item description. As a String.
   */
  public void setItemDescription(String itemNumber, String itemDescription) {
    items.get(getItemId(itemNumber)).setItemDescription(itemDescription);
  }

  /**
   * Retrieves the current price discount of an item in percentage.
   *
   * @param itemNumber Item number of the chosen item. As a String.
   * @return The current discount of an item in percentage. As a double.
   */
  public double getDiscount(String itemNumber) {
    return items.get(getItemId(itemNumber)).getDiscount();
  }

  /**
   * It should be possible to change the discount of an item.
   * Sets a new discount to the price of an item.
   *
   * @param itemNumber Item number of the chosen item. As a String.
   * @param newDiscount The new discount in percentage. As a double.
   */
  public void setDiscount(String itemNumber, double newDiscount) {
    items.get(getItemId(itemNumber)).setDiscount(newDiscount);
  }

  /**
   * Retrieves a list of items witch the
   * item description contains at least one of the gives search words.
   *
   * @param searchWords Search words. As a String.
   * @return A list of items.
   */
  public List<Item> getSearchResultItemDescription(String searchWords) {
    ArrayList<Item> searchResults = new ArrayList<>();
    String[] searchWordList = searchWords.toLowerCase().replaceAll("([.,!?&])", "").split(" ");

    for (Item item : items) {
      for (String s : searchWordList) {
        if (item.getItemDescription().toLowerCase().contains(s)
                && !searchResults.contains(item) && !s.isBlank()) {
          searchResults.add(new Item(item));
        }
      }
    }
    return searchResults;
  }

  /**
   * Retrieves a list of all the items in a given category.
   *
   * @param category The given category.
   * @return A list of items.
   */
  public List<Item> getSearchResultItemCategory(Category category) {
    ArrayList<Item> searchResults = new ArrayList<>();
    for (Item item : items) {
      if (item.getItemCategory().equals(category)) {
        searchResults.add(new Item(item));
      }
    }
    return searchResults;
  }

  /**
   * Fills the list items with a set of standard items to test the program.
   */
  public void testData() {
    addNewItem("ABC001", "Laminate floor", 100, "Pergo",
            3.4, 1.4, 0.20, "White", 150, Category.LAMINATE);
    addNewItem("ABC002", "Window. Large square", 499, "Hunton",
            24, 2.00, 1.00, "Black", 200, Category.WINDOWS);
    addNewItem("ADE241", "Bathroom door", 789, "Egger",
            56.5, 90, 2.4, "Black", 75, Category.DOORS);
    addNewItem("ABC003", "Window. Round", 100,
            "Pergo", 50, 2, 4, "White", 150, Category.WINDOWS);
    addNewItem("BCA555", "Outer door. Thick", 599,
            "Swedoor", 47.5, 0.8, 2.0, "Brown",
            20, Category.DOORS);
    addNewItem("ADE447", "Laminate floor", 69, "Opus",
            4, 1.5, 0.1, "Grey", 250, Category.LAMINATE);
    addNewItem("BDV211", "Thick wall panels in oak", 89, "Hunton",
            1.5, 4.7, 0.15, "White", 500, Category.LUMBER);
  }

  /**
   * Retrieves a list of all items in the item register
   * with just the variables item number and description.
   *
   * @return All items in the item register
   *         with just the variables item number and description. As a String.
   */
  public StringBuilder smallToString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Item item : items) {
      stringBuilder.append(item.smallToString());
    }
    return stringBuilder;
  }

  /**
   * Retrieves a readable list of all the items in the item register with all item variables.
   *
   * @return All the items in the item register. As a String.
   */
  @Override
  public String toString() {
    return "****ItemRegister****" + items;
  }
}