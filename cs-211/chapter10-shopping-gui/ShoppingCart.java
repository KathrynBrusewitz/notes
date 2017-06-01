// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 10 - Shopping Cart with JFrame

// Stores information about the overall order

import java.util.ArrayList;

public class ShoppingCart extends ArrayList {

  public ShoppingCart() {
    orderList = new ArrayList<ItemOrder>();
  }

  // Adds an item order to the list, replacing any previous order
  // for this item with the new order
  public void add(ItemOrder order) {
    int i = 0;
    boolean replaced = false;

    // While finding the item that matches
    // If order is size 0, remove older order
    // If not, replace older order
    while (i < orderList.size() && replaced == false) {
      if (orderList.get(i).getItem() == order.getItem()) {
        if (order.quantity == 0) {
          orderList.remove(i);
        } else {
          orderList.set(i, order);
        }
        replaced = true;
      }
      i++;
    }

    // Otherwise add order if empty/not replaced
    if (orderList.isEmpty() || replaced == false) {
      orderList.add(order);
    }
  }

  public void setDiscount(boolean discount) {
    hasDiscount = discount;
  }

  public double getTotal() {
    double total = 0.0;

    for (int i = 0; i < orderList.size(); i++) {
      total += orderList.get(i).getPrice();
    }

    if (hasDiscount) {
      double discount = .1 * total;
      total -= discount;
    }

    return total;
  }

  private ArrayList<ItemOrder> orderList;
  private boolean hasDiscount;

}
