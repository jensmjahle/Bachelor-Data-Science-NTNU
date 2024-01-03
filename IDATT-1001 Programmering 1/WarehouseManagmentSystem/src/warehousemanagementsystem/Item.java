package warehousemanagementsystem;

/**
 * Represents an item with the following important attributes:
 * weight, item number, description, brand, length, height, color, category, price and stock.
 * It has methods to retrieve attributes and assign new values to some attributes.
 *
 * @author Jens Martin Jahle
 * @version 10.12.2022
 */
public class Item {
  private final String itemNumber;
  private final String itemBrand;
  private final double itemWeight;
  private final double itemLength;
  private final double itemHeight;
  private final String itemColor;
  private final Category itemCategory;
  private String itemDescription;
  private double itemPrice;
  private int itemStock;
  private double priceDiscount;


  /**
   * Creates an item.
   * Validates input format.
   *
   * @param itemNumber      The item number. As a String.
   * @param itemDescription A description of the item. As a String.
   * @param itemPrice       The price of the item in NOK. As a double.
   * @param itemBrand       The brand of the item. As a String.
   * @param itemWeight      The weight of the item in kg. As a double.
   * @param itemLength      The length of the item in meters. As a double.
   * @param itemHeight      The height of the item in meters. As a double.
   * @param itemColor       The color of the item. As a String.
   * @param itemStock       The current stock of the item. As an integer.
   * @param itemCategory    The item category. As an enum Category.
   */
  public Item(String itemNumber, String itemDescription, double itemPrice, String itemBrand,
              double itemWeight, double itemLength, double itemHeight, String itemColor,
              int itemStock, Category itemCategory) {

    this.validatePositive(itemPrice, "Item Price");
    this.validatePositive(itemWeight, "Item Weight");
    this.validatePositive(itemLength, "Item Length");
    this.validatePositive(itemHeight, "Item height");
    this.validatePositive(itemStock, "Item stock");
    this.validateNotBlank(itemDescription, "Item description");
    this.validateNotBlank(itemBrand, "Item brand");
    this.validateNotBlank(itemColor, "Item color");
    if (itemNumber.length() != 6) {
      throw new IllegalArgumentException("Item number must be 6 characters");
    }
    if (itemCategory == null) {
      throw new IllegalArgumentException("Item category input must be a valid category");
    }
    this.itemNumber = itemNumber;
    this.itemDescription = itemDescription;
    this.itemPrice = itemPrice;
    this.itemBrand = itemBrand;
    this.itemWeight = itemWeight;
    this.itemLength = itemLength;
    this.itemHeight = itemHeight;
    this.itemColor = itemColor;
    this.itemStock = itemStock;
    this.itemCategory = itemCategory;
  }

  /**
   * Creates a deep copy of the given item.
   *
   * @param item An item. As an Item.
   */
  public Item(Item item) {
    this.itemNumber = item.getItemNumber();
    this.itemDescription = item.getItemDescription();
    this.itemPrice = item.getItemPrice();
    this.itemBrand = item.getItemBrand();
    this.itemWeight = item.getItemWeight();
    this.itemLength = item.getItemLength();
    this.itemHeight = item.getItemHeight();
    this.itemColor = item.getItemColor();
    this.itemStock = item.getItemStock();
    this.itemCategory = item.getItemCategory();
    this.priceDiscount = item.getDiscount();
  }

  /**
   * The method retrieves the item number.
   *
   * @return The item number.
   */
  public String getItemNumber() {
    return itemNumber;
  }

  /**
   * Validates that a number is positive (not less than zero).
   *
   * @param val Value to be validated. As a double.
   * @param argName Nave of the validated value.
   */
  private void validatePositive(double val, String argName) throws IllegalArgumentException {
    if (val < 0) {
      throw new IllegalArgumentException(argName + " must be positive. Not less that 0.");
    }
  }

  /**
   * Validates that a string is not blank.
   *
   * @param val The string to validate.
   * @param argName Name of the validated value.
   */
  private void validateNotBlank(String val, String argName) {
    if (val.isBlank()) {
      throw new IllegalArgumentException(argName + " cannot be blank.");
    }
  }

  /**
   * The method retrieves the item description.
   *
   * @return The item description.
   */
  public String getItemDescription() {
    return itemDescription;
  }

  /**
   * It should be possible to change the description of an item.
   * Sets a new item description to an item.
   *
   * @param itemDescription New item description. As a String.
   */
  public void setItemDescription(String itemDescription) {
    if (itemDescription.isBlank()) {
      throw new IllegalArgumentException("Item description cannot be blank");
    }
    this.itemDescription = itemDescription;
  }

  /**
   * The method retrieves the item price.
   *
   * @return The item price.
   */
  public double getItemPrice() {
    return itemPrice;
  }

  /**
   * It should be possible to change the price of an item.
   * Sets a new item price.
   *
   * @param itemPrice New item price.
   */
  public void setItemPrice(double itemPrice) {
    if (itemPrice < 0) {
      throw new IllegalArgumentException("The item price cannot be less than 0");
    }
    this.itemPrice = (itemPrice / 100) * (100 - priceDiscount);

  }

  /**
   * Retrieves the item brand.
   *
   * @return THe item brand.
   */
  public String getItemBrand() {
    return itemBrand;
  }

  /**
   * Retrieves the item weight.
   *
   * @return The item weight.
   */
  public double getItemWeight() {
    return itemWeight;
  }

  /**
   * Retrieves the item length.
   *
   * @return The item length.
   */
  public double getItemLength() {
    return itemLength;
  }

  /**
   * Retrieves the item height.
   *
   * @return The item height.
   */
  public double getItemHeight() {
    return itemHeight;
  }

  /**
   * Retrieves the item color.
   *
   * @return The item color.
   */
  public String getItemColor() {
    return itemColor;
  }

  /**
   * Retrieves the current item stock.
   *
   * @return The current item stock.
   */
  public int getItemStock() {
    return itemStock;
  }

  /**
   * It should be possible to change the stock of an item.
   * Sets a new stock amount for the item.
   *
   * @param itemStock The new stock amount. As an integer.
   */
  public void setItemStock(int itemStock) {
    if (itemStock < 0) {
      throw new IllegalArgumentException("There is not enough items in stock to make this change. "
              + "Item stock cannot be less than 0");
    } else {
      this.itemStock = itemStock;
    }
  }

  /**
   * Retrieves the item category.
   *
   * @return The item category. As an enum Category.
   */
  public Category getItemCategory() {
    return itemCategory;
  }

  /**
   * Retrieves the current discount of the item.
   *
   * @return The current discount of the item in percentage. As a double.
   */
  public double getDiscount() {
    return priceDiscount;
  }

  /**
   * It should be possible to change the price discount of an item.
   * Sets a new discount to the item.
   *
   * @param discount New discount in percentage. As a double.
   */
  public void setDiscount(double discount) {
    if (discount < 0 || discount >= 100) {
      throw new IllegalArgumentException("Price discount is a percentage "
              + "and cannot be less than 0 or more or equal to 100");
    }
    this.itemPrice = (itemPrice / (100 - priceDiscount)) * 100;
    this.priceDiscount = discount;
    this.itemPrice = (itemPrice / 100) * (100 - discount);
  }

  /**
   * Retrieves an items itemNumber and description as a string.
   *
   * @return ItemNumber and description. As a String.
   */
  public String smallToString() {
    return "\n" + getItemNumber() + "  " + getItemDescription();
  }

  /**
   * Retrieves a readable list of an items attributes.
   *
   * @return A readable list of an items attributes. As a String.
   */
  @Override
  public String toString() {
    return "\nItem: "
            + "\n    Item number : " + itemNumber
            + "    Description : " + itemDescription
            + "\n    Brand : " + itemBrand
            + "\n    Length : " + itemLength + "m"
            + "    Height : " + itemHeight + "m"
            + "    Weight : " + itemWeight + "kg"
            + "\n    Color : " + itemColor
            + "\n    Category : " + itemCategory
            + ((priceDiscount > 0)
            ?
                      "\n    Price (with discount) : " + Math.round(itemPrice) + " NOK"
                    + "    Price (without discount) : "
                              + Math.round((itemPrice / (100 - priceDiscount)) * 100) + " NOK"
                    + "    Discount : " + priceDiscount + "%"
            :         "\n    Price  : " + Math.round(itemPrice) + " NOK"
                )
              + "\n    Current stock : " + itemStock;

  }
}

