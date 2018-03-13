// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 10 - Shopping Cart with JFrame

// ItemOrder stores information about a particular item and
// the quantity ordered for that item

public class ItemOrder {

	public ItemOrder(Item item, int quantity) {
    if (quantity < 0) {
      throw new IllegalArgumentException();
    }
    this.item = item;
    this.quantity = quantity;
	}

	public double getPrice() {
    return item.priceFor(quantity);
	}

	public Item getItem() {
    return item;
	}

  private Item item;
  public int quantity;

}
