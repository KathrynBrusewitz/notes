// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 11 - Vocabulary

import java.io.*;
import java.util.*;

public class CharCounter {

	private static Map<String, Integer> wordMap;

	// Default Constructor does nothing
	public CharCounter() {
		// Empty default constructor
	}

	// Constructor Overload
	public CharCounter(Scanner scanner) {

		// Scan to end of the file
		scanner.useDelimiter("\\Z");
		String everything = "";

		// Store everything into a string
		while (scanner.hasNext()) {
			everything += scanner.next().toLowerCase();
		}

		// Initialize the empty wordMap as a TreeMap
		// TreeMap has no duplicates and is sorted in ascending order
		wordMap = new TreeMap<String, Integer>();

		// Go through everything and put each character into wordMap
		for (int i = 0; i < everything.length(); i++) {
			// If wordMap does not yet contain next character as a key...
		    if (!wordMap.containsKey(Character.toString(everything.charAt(i)))) {
		    	// Store this character as a string into wordMap and pair it with a count of 1
	   			wordMap.put(Character.toString(everything.charAt(i)), 1);
		    } else {
		    	// If already in wordMap, obtain its count, increase it by one, and store back
		    	int count = wordMap.get(Character.toString(everything.charAt(i))) + 1;
		    	wordMap.put(Character.toString(everything.charAt(i)), count);
	       }
		}
	}

	// Return entire Map of <Character, Integer> counts
	public static Map<String, Integer> getCounts() {
		// Just return the wordMap
		return wordMap;
	}

	// Return integer of character
	public static int getCounts(char character) {
		// Change the character into string so that wordMap can retrieve it
		String s = Character.toString(character);
		return wordMap.get(s);
	}

	// If negative number, show Map of lowest number counts (3 shows bottom three)
	// If positive number, show Map of highest number counts (3 shows top three)
	public static Map<String, Integer> getCounts(int number) {

		// Create Empty Map
		Map<String, Integer> tempMap = new TreeMap<String, Integer>();

		// Create two lists that contains all the values and contains all the keys
		List<Integer> listValues = new ArrayList<Integer>(wordMap.values());
		List<String> listKeys = new ArrayList<String>(wordMap.keySet());

		// Store highest value
		int highestValue = 0;

		// Go through wordMap once, find highest value
		for (int i = 0; i < listKeys.size(); i++) {
			if (highestValue < listValues.get(i)) {
				// Store higher value
				highestValue = listValues.get(i);
			}
		}

		if (number > 0) {
			// Show highest counts
			for (int a = 0; a < number; a++) {

				int value = 0; // Highest value
				int index = 0;

				// Find highest value
				for (int i = 0; i < listKeys.size(); i++) {
					if (value < listValues.get(i)) {
						// Store higher value
						value = listValues.get(i);
						index = i;
					}
				}

				tempMap.put(listKeys.get(index), value);

				// Remove from the value and key from each list
				listValues.remove(index);
				listKeys.remove(index);

			}
		} else {
			// Show lowest counts
			for (int a = 0; a > number; a--) {

				int value = highestValue; // lowest value
				int index = 0;

				// Find lowest value
				for (int i = 0; i < listKeys.size(); i++) {
					if (value > listValues.get(i)) {
						// Store lower value
						value = listValues.get(i);
						index = i;
					}
				}

				tempMap.put(listKeys.get(index), value);

				// Remove from the value and key from each list
				listValues.remove(index);
				listKeys.remove(index);
			}
		}

		return tempMap;
	}

	public static void main (String[] args) throws FileNotFoundException {
		System.out.println("MOBYDICK");
		Scanner text1 = new Scanner(new File("mobydick.txt"));
		CharCounter cc1 = new CharCounter(text1); // reads data from file, contains all the code to read file
		System.out.println(cc1.getCounts(3)); // shows Map of highest 3 counts
		System.out.println(cc1.getCounts('a')); // returns int count of char 'a'
		System.out.println(cc1.getCounts(-3)); // shows Map of lowest 3 counts
		System.out.println(cc1.getCounts()); // shows entire Map of <Character, Integer> counts

		System.out.println();
		System.out.println("HAMLET");
		Scanner text2 = new Scanner(new File("hamlet.txt"));
		CharCounter cc2 = new CharCounter(text2);
		System.out.println(cc2.getCounts(3));
		System.out.println(cc2.getCounts('a'));
		System.out.println(cc2.getCounts(-3));
		System.out.println(cc2.getCounts());
	}

}
