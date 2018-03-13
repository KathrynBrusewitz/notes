/*-----------------------------------------------------------------------------
  CS 211
  01/20/2015
  Kathryn Brusewitz

  Class: ShoppingCart
  Super Class: Object
  Implements: None

  ShoppingCart represents a shoppers overall order. Allows item orders to 
  be added to and removed from cart and replace older orders for the same item. 
 
  Public Interface ------------------------------------------------------------

  ShoppingCart()               Default Constructor: Init empty list of orders
  boolean equals(Object)       Test this with other class object for equality
  String  toString()           RETurns "String" description of this item
  void    add(ItemOrder)       Adds an order to the list, replaces old orders
  void    setDiscount(boolean) Sets whether or not this order gets a discount 
  double  getTotal()           RETurns the total cost of the shopping cart

  Private Methods -------------------------------------------------------------

  non-static  ArrayList<ItemOrder>  orders      ArrayList that holds ItemOrders
  non-static  boolean               discount    Setting for adding discount

 ------------------------------------------------------------------------------*/
 
import java.util.*;

public class ShoppingCart {

    public ShoppingCart() {
        orders = new ArrayList<ItemOrder>();
    }

    @Override public boolean equals(Object object) {
        if (object instanceof ShoppingCart) {
            ShoppingCart other = (ShoppingCart) object;
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).equals(other.orders.get(i))) return false;
            }
            return true;
        } else return false;
    }

    @Override public String toString() {
        String s = "";
        for (int i = 0; i < orders.size(); i++) {
            s += String.format("Item %d:%n%s", i + 1, orders.get(i));
        }
        if (discount) {
            s += String.format("%8s: $%7.2f%n", "SubTotal", this.getTotal());
            s += String.format("%8s: $%7.2f%n", "Discount", this.getTotal() * .1);
            s += String.format("%8s: $%7.2f%n", "Total", this.getTotal() - this.getTotal() * .1);
        } else {
            s += String.format("Total: $ %.2f%n", this.getTotal());
        }
        return s;
    }

    public void add(ItemOrder itemOrder) {
        int i = 0;
        boolean replaced = false;
        while (i < orders.size() && replaced == false) {
            // Find the matching item:
            if (orders.get(i).getItem() == itemOrder.getItem()) {
                // If itemOrder is 0, remove the old order:
                if (itemOrder.getQuantity() == 0) orders.remove(i);
                // Otherwise, replace the old order:
                else orders.set(i, itemOrder);
                replaced = true;
            }
            i++;
        }
        // Just add order if orders is empty or nothing was replaced:
        if (orders.isEmpty() || replaced == false) orders.add(itemOrder);
    }

    public void setDiscount(boolean value) {
        // True  - 10% discount to the total
        // False - No discount
        discount = value;
    }
    
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < orders.size(); i++) {
            total += orders.get(i).getPrice();
        }
        return total;
    }

    private ArrayList<ItemOrder> orders;
    private boolean              discount;
}