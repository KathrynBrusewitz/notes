/*-----------------------------------------------------------------------------
  CS 211
  01/18/2015
  Kathryn Brusewitz

  Class: DiscountBill
  Super Class: GroceryBill
  Implements: None

  DiscountBill extends GroceryBill. Adds functionality for discounted items. If 
  the employee for whom this bill is for is a preferred customer, discounted 
  items will be counted. Otherwise, this bill is just like a regular bill.
 
  Public Interface ------------------------------------------------------------

  DiscountBill(GroceryEmployee, int, boolean)  Initializing Constructor
  DiscountBill(DiscountBill)  		Copy Constructor
  equals(Object)              		Test this with other object for equality
  void add(GroceryItem)       		Add a grocery item to this bill
  void printReceipt() 		   		Print out this bills items and total cost
  double getTotal() 		   		Return total of all the items in this bill
  int getDiscountCount()      		Return number of items discounted
  double getDiscountAmount()  		Return total discount amount for all items
  double getDiscountPercentage()  	Return total discount as a percentage

  Private Methods -------------------------------------------------------------

  non-static  boolean	preferred      	Flags true for preferred customers
  non-static  int   	discountCount  	Number of discounted items
  non-static  double   	discountAmount 	Total discount amount for all items

 ------------------------------------------------------------------------------*/

public class DiscountBill extends GroceryBill {

	public DiscountBill (GroceryEmployee clerk, int maxItems, boolean preferred) {
		super(clerk, maxItems);
		if (maxItems < 1) throw new IllegalArgumentException();
		this.preferred = preferred;
		discountCount  = 0;
		discountAmount = 0.0;
	}

	public DiscountBill (DiscountBill other) {
		super(other);
		preferred      = other.preferred;
		discountCount  = other.discountCount;
		discountAmount = other.discountAmount;
	}

	@Override public boolean equals(Object object) {
		if (object instanceof DiscountBill) {
			DiscountBill other = (DiscountBill) object;
			return this.getTotal()              == other.getTotal()              &&
                   this.discountAmount          == other.discountAmount          &&
                   this.discountCount           == other.discountCount           &&
                   this.getDiscountPercentage() == other.getDiscountPercentage() &&
                   this.preferred               == other.preferred;
		} else return false;
	}

	@Override public void add(GroceryItem item) {
		// Update discounted count and total discount amount if a preferred customer
		if (preferred && item.getDiscountPerCent() > 0.0) {
			discountCount++;
			discountAmount += item.getDiscount();
		}
		super.add(item);
	}

	@Override public void printReceipt() {
		if (preferred) {
			System.out.format("%s%n", super.getClerk().shortDescription());
			for (int i = 0; i < super.getNextIndex(); i++) { 
				// Don't display discount for items with 0% discount
				if (super.getItemArray()[i].getDiscountPerCent() == 0.0) {
					super.getItemArray()[i].displayDiscount(false);
				}
				System.out.format("%s", super.getItemArray()[i].toString());
			}
			System.out.format("%n%8s: %.2f%n",   "SubTotal",         super.getTotal());
			System.out.format("%8s: %.2f%n",     "Discount",         this.getDiscountAmount());
			System.out.format("%8s: %.2f%n%n",   "Total",            this.getTotal());
			System.out.format("%16s: %d%n",      "Discounted Items", discountCount);
			System.out.format("%14s %%: %.2f%%", "Discount",         this.getDiscountPercentage());
            System.out.format("%n%n");
		} else {
			// Print non-discounted receipt for non-preferred customer
			super.printReceipt();
		}
	}

	// Discounted total bill cost
	@Override public double getTotal() {
		return super.getTotal() - discountAmount;
	}

	public int getDiscountCount() {
		return discountCount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getDiscountPercentage() {
		return discountAmount * 100 / super.getTotal();
	}
	
	private boolean preferred;
	private int     discountCount;
	private double  discountAmount;

}