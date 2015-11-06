// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 11

import java.util.*;

public class Chapter11 {

	// Chapter 11 Exercise 4
	public static List<Integer> partition(List<Integer> list, int E) {
		// Empty temporary list
		List<Integer> temp = new LinkedList<Integer>();
		// Iterators
		Iterator<Integer> itr1 = list.iterator();
		Iterator<Integer> itr2 = list.iterator();

		// First add all the lower numbers to the temporary list:
		// For each (n)umber in list...
		while(itr1.hasNext()) {
			Integer n = itr1.next();
			// If it is true that n is less than E...
			if (n.compareTo(E) < 0) {
				// Add n to the temporary list...
				temp.add(n);
			}
		}

		// Then will add all the higher numbers to the temporary list:
		// For each (n)umber in list...
		while(itr2.hasNext()) {
			Integer n = itr2.next();
			// If it is true that n is greater than E...
			if (n.compareTo(E) < 0) {
				// Add n to the temporary list...
				temp.add(n);
			}
		}

		return temp;
	}

	// Chapter 11 Exercise 5
	public static Set<Integer> sortAndRemoveDuplicates(Set<Integer> set) {
		// Tree sets are already in sorted ascending order and has no duplicates
		Set<Integer> treeSet = new TreeSet<Integer>(set);

		// [7, 4, –9, 4, 15, 8, 27, 7, 11, –5, 32, –9, –9]
		// would become
		// [–9, –5, 4, 7, 8, 11, 15, 27, 32]
		return treeSet;
	}

	// Chapter 11 Exercise 11
	public static Set<Integer> symmetricSetDifference(Collection<Integer> s1, Collection<Integer> s2) {
		// Empty temporary set
		Set<Integer> temp = new TreeSet<Integer>();

		// For each (n)umber in list...
		for (Integer n : s1)  {
			// If it is true that set 2 does not contain set 1's number...
			if (!s2.contains(n)) {
				// Add set 1's number to the temporary list...
				temp.add(n);
			}
		}

		// For each (n)umber in list...
		for (Integer n : s2) {
			// If it is true that set 1 does not contain set 2's number...
			if (!s1.contains(n)) {
				// Add set 2's number to the temporary list...
				temp.add(n);
			}
		}

		return temp;
	}

	// Chapter 11 Exercise 17
	public static boolean subMap(Map<String,String> m1, Map<String,String> m2) {
		// Check if first map is empty
		if (m1.isEmpty()) return true;
		int i = 0;

		// For each string in first map...
		for (String s:m1.keySet()) {
			// Store each string value...
			String v1 = m1.get(s);
			String v2 = m2.get(s);
			// If both strings are equal...
			if (v1 == v2) {
				i++;
			}
		}

		// Do first map's size and counter match?
		return (i == m1.size());
	}

}
