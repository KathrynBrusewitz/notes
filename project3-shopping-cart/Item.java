/*-----------------------------------------------------------------------------
  CS 211
  01/20/2015
  Kathryn Brusewitz

  Class: Item
  Super Class: Object
  Implements: None

  Item holds an items name and price. Includes a bulk price.
 
  Public Interface ------------------------------------------------------------

  Item(String, double)        Initializing Constructor: name, price
  Item(String, double, int, double)  Initializing Constructor: 
                                     name, price, bulkQuanity, bulkPrice
  boolean equals(Object)      Test this with other class object for equality
  String  toString()          RETurns "String" description of this item
  double  priceFor(int)       RETurns the price for a given quantity of item

  Private Methods -------------------------------------------------------------

  non-static  String      name          Name of this item
  non-static  double      price         Regular price of this item
  non-static  double      bulkPrice     Price per bulk quantity
  non-static  int         bulkQuantity  Quantity that qualifies for bulk price

 ------------------------------------------------------------------------------*/

public class Item {

	public Item(String name, double price) {
        if (price < 0.0) throw new IllegalArgumentException();
        this.name    = name;
        this.price   = price;
        bulkQuantity = 1;
        bulkPrice    = price;
	}

    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        if (price < 0.0 || bulkQuantity < 1 || bulkPrice < 0.0) 
            throw new IllegalArgumentException();
        this.name         = name;
        this.price        = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice    = bulkPrice;
	}

    @Override public boolean equals(Object object) {
        if (object instanceof Item) {
            Item other = (Item) object;
            return name         == other.name         && 
                   price        == other.price        && 
                   bulkQuantity == other.bulkQuantity &&
                   bulkPrice    == other.bulkPrice;
        } else return false;
    }

    @Override public String toString() {
        String s = String.format("%s @ %.2f", name, price);
        if (bulkQuantity > 1) 
            s += String.format(" (%d for %.2f)", bulkQuantity, bulkPrice);
        return s;
    }

	public double priceFor(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException();
        int remainder = quantity  % bulkQuantity;
        double total  = bulkPrice * ((quantity - remainder) / bulkQuantity);
        return total += remainder * price;
	}

    private String name;
    private double price, bulkPrice;
    private int    bulkQuantity;
}