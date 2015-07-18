# BC CS 211 Projects
Git repository to store my Bellevue College CS 211 projects.

## Notes

### project2-grocery-bill

For DiscountBill.java, I did a lot of reading on `protected` versus `private`, since I needed a way to access the superclass' member variables. I went with protected getter methods that return the private variables. The consensus is that one should hardly ever use `protected`. And, from an OO perspective, it breaks encapsulation.