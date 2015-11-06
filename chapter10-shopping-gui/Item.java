// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 10 - Shopping Cart with JFrame

import java.text.NumberFormat;

public class Item {

  public Item(String name, double price) {
    if (price < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.price = price;
    bulkQuantity = 1;
    bulkPrice = price;
  }

  public Item(String name, double price, int bulkQuantity, double bulkPrice) {
    if (price < 0 || bulkQuantity < 0 || bulkPrice < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.price = price;
    this.bulkQuantity = bulkQuantity;
    this.bulkPrice = bulkPrice;
  }

  // Returns the price for a given quantity of the item
  public double priceFor(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
    int r = amount  % bulkQuantity;
    double total  = bulkPrice * ((amount - r) / bulkQuantity);
    return total += r * price;
  }

  @Override
  public String toString() {
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    String s = name + ", ";
    s += nf.format(price);
    if (bulkQuantity > 1) {
      s += " (" + bulkQuantity + " for " + nf.format(bulkPrice) + ")";
    }
    return s;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Item) {
        Item other = (Item) object;
        return (name == other.name &&
            price == other.price &&
            bulkQuantity == other.bulkQuantity &&
            bulkPrice == other.bulkPrice);
    } else {
      return false;
    }
  }

  private String name;
  private double price;
  private double bulkPrice;
  private int bulkQuantity;

}
