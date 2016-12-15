/*-----------------------------------------------------------------------------
  CS 211
  01/11/2015
  Kathryn Brusewitz

  Super Class: (Inferred: Object)
  Implements: Cloneable

  Represents a date consisting of a year, month and day. Includes methods that
  can move the date by any number of days or weeks, check if it's the same date
  as another date and return how many days are in between.
 
  Public Interface ------------------------------------------------------------

  Date(int, int, int)         Initializing Constructor: set year, month, day
  Date(Date)                  Copy Constructor
  clone()                     Clone this date
  toString()                  Return this date in string format yy/mm/dd
  equals(Object)              Test this with other object for equality
  daysTo(Date)                Return number of days from this to other date
  nextDay()                   Advance this date one day
  addDays(int)                Advance this date a certain number of days
  addWeeks(int)               Advance this date a certain numbers of weeks
  getDayOfWeek()              Return name of day of this date
  getYear()                   Return this date's year
  getMonth()                  Return this date's month
  getDay()                    Return this date's day
  isLeapYear()                Check if this date's year is a leap year

  Private Methods -------------------------------------------------------------

  getDaysInMonth()            Return number of days in this dates month

 ------------------------------------------------------------------------------*/

public class Date implements Cloneable {

  public Date(int y, int m, int d) {
    if (y < 1000 || m < 1 || m > 12 || d < 1 || d > 31) 
      throw new IllegalArgumentException(String.format("Initializers not in range: %d, %d, %d", y, m, d));
    year = y;
    month = m;
    day = d;
  }

  public Date(Date other) {
    year = other.year;
    month = other.month;
    day = other.day;
  }

  @Override public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override public String toString() {
    return String.format("%d/%d/%d", year, month, day);
  }

  @Override public boolean equals(Object object) {
    if (object instanceof Date) {
      // Won't compile without typecast
      Date other = (Date)object;
      return year == other.getYear() && month == other.getMonth() && day == other.getDay();
    } else return false;
  }

  public int daysTo(Date other) {
    Date d1 = new Date(this);
    Date d2 = new Date(other);
    int i = 0;

    while (!d1.equals(d2)) {
      if (year <= d2.getYear() && month <= d2.getMonth() && day < d2.getDay()) {
        // d1 is earlier than d2: increment i
        d1.nextDay();
        i++;
      } else { 
        // d2 is earlier than d1: decrement i
        d2.nextDay();
        i--;
      }
    }

    return i;
  }
  
  public void nextDay() {
    if (day < this.getDaysInMonth()) {
      day++;
    } else if (month < 12) {
      month++;
      day = 1;
    } else {
      year++;
      month = 1;
      day = 1;
    }
  }
  
  public void addDays(int days) {
    if (days < 1) 
      throw new IllegalArgumentException("Days are less than 1: " + days);
    for (int i = 0; i < days; i++) this.nextDay();
  }

  public void addWeeks(int weeks) {
    if (weeks < 1) 
      throw new IllegalArgumentException("Weeks are less than 1: " + weeks);
    this.addDays(weeks * 7);
  }

  public String getDayOfWeek() {
    // 1 January 1753 is a Monday
    Date d = new Date(1753, 1, 1);
    int n = d.daysTo(this);
    return NAME_OF_DAY[n % 7];
  }

  public final int getYear() {
    return year;
  }

  public final int getMonth() {
    return month;
  }

  public final int getDay() {
    return day;
  }

  public boolean isLeapYear() {
    // A leap year is divisible by 4; must be divisible by 400 if divisible by 100
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  private int getDaysInMonth() {
    return this.isLeapYear() ? NUM_OF_DAYS_L[month - 1] : NUM_OF_DAYS[month - 1];
  }

  private int year, month, day;
  private static final int[] NUM_OF_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private static final int[] NUM_OF_DAYS_L = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private static final String[] NAME_OF_DAY = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

}