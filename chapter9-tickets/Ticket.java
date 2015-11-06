// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Building Java Programs Chapter 9 Exercise 5 w/ Extra Requirements

public abstract class Ticket {

  public Ticket(String number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Number: " + getNumber() + ", Price: " + getPrice();
  }

  public String getNumber() {
    return this.number;
  }

  // Subclasses implement this
  public abstract double getPrice();

  protected String number;

}
