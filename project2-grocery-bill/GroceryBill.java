/*-----------------------------------------------------------------------------
  CS 211
  01/18/2015
  Kathryn Brusewitz

  Class: GroceryBill
  Super Class: Object
  Implements: None

  GroceryBills interact with GroceryItem objects and compiles a regular (non-
  discounted) bill for a GroceryEmployee object. Items can be added to the bill 
  and a total can be retreived. The bill prints out who it's for, each item 
  description and the total bill amount. 
 
  Public Interface ------------------------------------------------------------

  GroceryBill(GroceryEmployee, int)  Initializing Constructor
  GroceryBill(GroceryBill)       Copy Constructor
  equals(Object)                 Test this with other object for equality
  void add(GroceryItem)          Add a grocery item to this bill
  void printReceipt() 		     Print out this bills items and total cost
  double getTotal() 		     Return total of all the items in this bill

  Protected Interface ---------------------------------------------------------

  GroceryEmployee getClerk()      Return employee object that this bill is for
  GroceryItem[] getItemArray()    Return the grocery item array
  int getMaxItems()               Return max items
  int getNextIndex() 		      Return index marker

  Private Methods -------------------------------------------------------------

  non-static  GroceryEmployee clerk       Who this bill is for
  non-static  int             maxItems    Maximum items allowed in itemArray
  non-static  GroceryItem[]   itemArray   Holds grocery item objects
  non-static  int             nextIndex   The next available index in itemArray

 ------------------------------------------------------------------------------*/

public class GroceryBill {

	public GroceryBill(GroceryEmployee clerk, int maxItems) {
		if (maxItems < 1) throw new IllegalArgumentException();
		this.clerk    = clerk;
		this.maxItems = maxItems;
		itemArray     = new GroceryItem[maxItems];
		nextIndex     = 0;
	}

	public GroceryBill(GroceryBill other) {
		clerk    = other.clerk;
		maxItems = other.maxItems;
	}

	@Override public boolean equals(Object object) {
		if (object instanceof GroceryBill) {
			GroceryBill other = (GroceryBill) object; 
			for (int i = 0; i < maxItems; i++) {
				if (!itemArray[i].equals(other.itemArray[i])) return false;
			}
			return true;
		} else return false;
	}

	public void add(GroceryItem item) {
		if (nextIndex == maxItems) throw new ArrayIndexOutOfBoundsException();
		itemArray[nextIndex] = item;
		nextIndex++;
	}

	public void printReceipt() {
		System.out.format("%s%n%n", clerk.shortDescription());
		for (int i = 0; i < nextIndex; i++) {
			itemArray[i].displayDiscount(false);
			System.out.format("%s", itemArray[i].toString());
		}
		System.out.format("%n%-6s %.2f%n%n", "Total:", this.getTotal());
	}

	// Non-discounted total bill cost
	public double getTotal() {
		double total = 0.0;
		for (int i = 0; i < nextIndex; i++) {
			total += itemArray[i].getPrice();
		}
		return total;
	}

	// Added by me
	protected GroceryEmployee getClerk() {
		return clerk;
	}

	// Added by me
	protected GroceryItem[] getItemArray() {
		return itemArray;
	}

    // Added by me
    protected int getMaxItems() {
        return maxItems;
    }

	// Added by me
	protected int getNextIndex() {
		return nextIndex;
	}

	private GroceryEmployee clerk;
	private GroceryItem[]   itemArray;
	private int             maxItems, nextIndex;

}