/*-----------------------------------------------------------------------------
  CS 211
  01/20/2015
  Kathryn Brusewitz

  Class: Catalog
  Super Class: Object
  Implements: None

  Catalog stores information (name, regular price, and discounted-pricing for 
  a given bulk quantity) about a collection of Item objects.
 
  Public Interface ------------------------------------------------------------

  Catalog(String)             Initializing Constructor: name
  boolean equals(Object)      Test this with other class object for equality
  String  toString()          RETurns "String" description of this item
  void    add(Item)           Adds an Item at the end of the ArrayList<Item> list
  int     size()              RETurns the number of items in the list
  Item    get(int)            RETurns a reference to the Item with a given index
  String  getName()           RETurns the name of this catalog.

  Private Methods -------------------------------------------------------------

  non-static  String          name          Name of this catalog
  non-static  ArrayList<Item> items         ArrayList that holds Item objects

 ------------------------------------------------------------------------------*/

import java.util.*;

public class Catalog {

	public Catalog(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
	}

    @Override public boolean equals(Object object) {
        if (object instanceof Catalog) {
            Catalog other = (Catalog) object;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) != other.items.get(i)) return false;
            }
            return name == other.name;
        } else return false;
    }

    @Override public String toString() {
        String s = String.format("Catalog: %s:%n", name);
        for (int i = 0; i < items.size(); i++) {
            s += String.format("  Item %d:%n    %s%n", i + 1, items.get(i));
        }
        return s;
    }

	public void add(Item item) {
        items.add(item);
	}

	public int size() {
        return items.size();
	}

	public Item get(int index) {
        return items.get(index);
	}

	public String getName() {
        return name;
	}

    private String          name;
    private ArrayList<Item> items;
}