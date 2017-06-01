/*-----------------------------------------------------------------------------
  CS 211
  01/20/2015
  Kathryn Brusewitz

  Class: ItemOrder
  Super Class: Object
  Implements: None

  ItemOrder represents a shoppers order for a given Item in a given quantity. 
 
  Public Interface ------------------------------------------------------------

  ItemOrder(Item, int)        Initializing Constructor: item, quantity
  boolean equals(Object)      Test this with other class object for equality
  String  toString()          RETurns "String" description of this order
  double  getPrice()          RETurns the cost for this order
  Item    getItem()           RETurns a reference to the item in this order
  int     getQuantity()       RETurns the quantity of this order

  Private Methods -------------------------------------------------------------

  non-static  Item            item          The Item object this order is for
  non-static  int             quantity      Quantity ordered of the Item

 ------------------------------------------------------------------------------*/

public class ItemOrder {

    public ItemOrder(Item item, int quantity) {
        if (quantity < 0) throw new IllegalArgumentException();
        this.item = item;
        this.quantity = quantity;
    }

    @Override public boolean equals(Object object) {
        if (object instanceof ItemOrder) {
            ItemOrder other = (ItemOrder) object;
            return item            == other.item        && 
                   quantity        == other.quantity    &&
                   this.getPrice() == other.getPrice();
        } else return false;
    }

    @Override public String toString() {
        return String.format("  %s%n  Quantity: %d%n  Final Price: %.2f%n%n", item, quantity, this.getPrice());
    }

    public double getPrice() {
        return item.priceFor(quantity);
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    private Item item;
    private int  quantity;
}