// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 12 - Recursion

public class Chapter12 {

	public static void main(String[] args) {
		System.out.println("doubleDigits(): " + doubleDigits(9703));
		System.out.println("isReverse(): " + isReverse("hello", "oLLeH"));
		System.out.println("lastIndexOf(): " + lastIndexOf("car", "scar incarnation"));
		System.out.println("permut(): " + permut(7, 4));
	}

	public static int doubleDigits(int n) {
		if (n == 0) {
			return 0;
		} else {
			return (n % 10 * 10) + (n % 10) + (doubleDigits(n / 10) * 100);
		}
	}

	public static boolean isReverse(String a, String b) {
		// If lengths are not same, they are not reverse of each other
		if (a.length() != b.length()) {
      return false;
    }

		// If lengths are both 0, they are reverse of each other
		if (a.length() == 0 && b.length() == 0) {
      return true;
    }

		// Get first and last character from each String
		String letterA = "" + a.charAt(a.length() - 1);
    String letterB = "" + b.charAt(0);

    // Check
    if (letterA.equalsIgnoreCase(letterB)) { // Match letterA with letterB
      String tempA = a.substring(0, a.length() - 1); // Leave out first character to shorten string
      String tempB = b.substring(1, b.length()); // Leave out last character to shorten string
      return isReverse(tempA, tempB);
    }

    return false;
	}

	public static int lastIndexOf(String word, String sentence){
		// Check if the sentence has the word
		if (!sentence.contains(word)) {
			return -1;
		} else {
			// If it does not have word, call method again
			return lastIndexOf(false, word, sentence, word.length(), sentence.length());
		}
	}

	public static int lastIndexOf(boolean isMatch, String word, String sentence, int wordLength, int sentenceLength) {
		if (isMatch) {
			// Return the position of first character back up the stack
			return (sentenceLength - wordLength);
		} else {
			// If word matches with sentence, set isMatch to true
			if (word.equals(sentence.substring((sentenceLength - wordLength), sentenceLength))){
				isMatch = true;
				return lastIndexOf(isMatch, word, sentence, wordLength, sentenceLength);
			} else {
				// Otherwise keep going
				return lastIndexOf(isMatch, word, sentence, wordLength, (sentenceLength - 1));
			}
		}
	}

	public static int permut(int a, int b) {
		// Is a less than the difference between a and b?
		if (a <= (a - b)) {
			return 1;
		} else {
			return a * permut((a - 1), (b - 1));
		}
	}

}
