/*-----------------------------------------------------------------------------
  CS 211
  01/18/2015
  Kathryn Brusewitz

  Class: GroceryItem
  Super Class: Object
  Implements: None

  GroceryItem has a price and discount. There are public getter methods 
  retrieve its non-discounted price, its discounted amount and its discount 
  as a percentage. 

  Each item also has a flag for displaying its discount. toString() uses this 
  to decide whether or not to print out the discount. Every time toString() is
  used, the flag is reset to true.

  By default, the flag is set true and has a public setter method.
 
  Public Interface ------------------------------------------------------------

  GroceryItem(String, double, double)  Initializing Constructor
  GroceryItem(GroceryItem)      Copy Constructor
  equals(Object)                Test this with other object for equality
  toString()                    Return price/discount info of this item
  void displayDiscount(boolean) Set display discount flag setting
  double getPrice()             Return the non-discounted price of this item
  double getDiscount()          Return the discounted amount for this item
  double getDiscountPerCent()   Return the percent discount for this item

  Private Methods -------------------------------------------------------------

  non-static  boolean         flag             Setting to display discount
  non-static  String          description      Item name
  non-static  double          price            Item non-discounted price
  non-static  double          discountPerCent  Item percent discount

 ------------------------------------------------------------------------------*/

public class GroceryItem {

	public GroceryItem(String description, double price, double discountPerCent) {
		if (price <= 0.0 || discountPerCent < 0.0) 
			throw new IllegalArgumentException();
		this.displayDiscount(true);
		this.description     = description;
		this.price           = price;
		this.discountPerCent = discountPerCent;
	}

	public GroceryItem(GroceryItem other) {
		this.displayDiscount(other.flag);
		this.description     = other.description;
		this.price           = other.price;
		this.discountPerCent = other.discountPerCent;
	}

    @Override public String toString() { 
        String s = String.format("%n%-6s %s %n%-6s %.2f %n", "Item:", description, "Price:", price);
        
        // Append this items discount information if displayDiscount flag is true:
        if (flag) 
        	s += String.format("  %s: %.2f, %.2f %% %n", "Discount", this.getDiscount(), discountPerCent);
        
        // Reset displayDiscount flag to true after toString is used for this item:
        displayDiscount(true); 
        return s; 
    }

    @Override public boolean equals(Object object) {
        if (object instanceof GroceryItem) {
            GroceryItem other = (GroceryItem) object;
            return description     == other.description     && 
                   price           == other.price           && 
                   discountPerCent == other.discountPerCent &&
                   flag            == other.flag;
        } else return false;
    }

    public void displayDiscount(boolean display) { 
        flag = display; 
    }

	public double getPrice() {
		return price;
	}

	public double getDiscount() {
		return discountPerCent * .01 * price; 
	}

	public double getDiscountPerCent() {
		return discountPerCent;
	}
	
	private boolean flag;
	private String  description;
	private double  price, discountPerCent;

}