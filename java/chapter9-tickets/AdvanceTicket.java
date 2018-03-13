// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Building Java Programs Chapter 9 Exercise 5 w/ Extra Requirements

public class AdvanceTicket extends Ticket {

  public AdvanceTicket(String number, int days) {
    super(number);
    this.price = (days >= 10) ? 30.00 : 40.00;
  }

  public AdvanceTicket(int number, int days) {
    super(Integer.toString(number));
    this.price = (days >= 10) ? 30.00 : 40.00;
  }

  public double getPrice() {
    return this.price;
  }

  private double price;

}
