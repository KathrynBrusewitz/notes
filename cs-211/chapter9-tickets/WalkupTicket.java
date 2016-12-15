// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Building Java Programs Chapter 9 Exercise 5 w/ Extra Requirements

public class WalkupTicket extends Ticket {

  public WalkupTicket(String number) {
    super(number);
  }

  public WalkupTicket(int number) {
    super(Integer.toString(number));
  }

  public void setNumber(String number) {
    super.number = number;
  }

  public void setNumber(int number) {
    super.number = Integer.toString(number);
  }

  public String getNumber() {
    return super.getNumber();
  }

  public double getPrice() {
    return this.price;
  }

  private double price = 50.00;

}
