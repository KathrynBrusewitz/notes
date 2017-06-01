// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 10 - Methods for ArrayLists

import java.util.ArrayList;

public class Chapter10 {

	// minToFront moves the minimum value in the list
	// to the front; preserves the order of the elements
	public static void minToFront(ArrayList<Comparable> list) {
		int element = 0;
		Comparable min = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).compareTo(min) < 0) {
				min = list.get(i);
				element = i;
			}
		}

		list.remove(element);
		list.add(0, min);
	}

	public static void removeDuplicates(ArrayList<Comparable> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) == 0) {
					list.remove(j--);
				}
			}
		}
	}

	public static void removeInRange(ArrayList<Comparable>list, Comparable min, Comparable max) {
		// min and max are inclusive
		int index = 0;

		while (index < list.size()) {
			if (list.get(index).compareTo(min) >= 0 && list.get(index).compareTo(max) <= 0) {
				list.remove(index--);
			}
			index++;
		}
	}

	// swapPairs switches the order of values in a pairwise fashion
	public static void swapPairs(ArrayList<Comparable>list) {
		Comparable pair1;
		Comparable pair2;

		// When the size is even...
		if (list.size() % 2 == 0) {
			for (int i = 0; i < list.size(); i += 2) {
				pair1 = list.get(i);
				pair2 = list.get(i + 1);
				list.set(i, pair2);
				list.set(i + 1, pair1);
			}
		} else { // Otherwise, the size is odd...
			for (int i = 0; i < list.size() - 1; i += 2) {
				pair1 = list.get(i);
				pair2 = list.get(i + 1);
				list.set(i, pair2);
				list.set(i + 1, pair1);
			}
		}
	}

}
