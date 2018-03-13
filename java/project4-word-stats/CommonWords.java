/*-----------------------------------------------------------------------------
  CS 211
  01/27/2015
  Kathryn Brusewitz

  Class: CommonWords
  Super Class: Object
  Implements: None

  Reads words in two different files, determines number of times each word 
  occurs in both files, and determines the common words between them.
  
  toString() gives a string containing the statistics for each file: 
    - Total number of words in the file
    - Number of discarded words
    - Number of unique words in the file
    - Number of common words
    - List of common words and their frequency in each file

 ------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;

public class CommonWords {

    public CommonWords() {
        wordMap1 = new TreeMap<String, Integer>();
        wordMap2 = new TreeMap<String, Integer>();
        intersection = new TreeSet<String>();
        numOfTotalWords2 = 0;
        numOfTotalWords2 = 0;
        numOfRemainingWords1 = 0;
        numOfRemainingWords2 = 0;
    }

    public void determineCommonWords(File file1, File file2) throws FileNotFoundException {
        if (!file1.exists() || !file2.exists()) 
            throw new FileNotFoundException("Files not found!");
        fileName1 = file1.getName();
        fileName2 = file2.getName();
        Scanner s1 = new Scanner(file1);
        Scanner s2 = new Scanner(file2);
        s1.useDelimiter("[^a-zA-Z']");
        s2.useDelimiter("[^a-zA-Z']");

        while(s1.hasNext()) {
            String scanned = s1.next().toLowerCase();
            // Increment total words for scanned things that are at least 1 character:
            if (scanned.length() != 0) numOfTotalWords1++;
            // Remove leading apostrophe before setting it as the word:
            String word = scanned.startsWith("'") ? scanned.substring(1) : scanned;
            // Add the word. Skip if it became empty after removing the apostrophe:
            if (!word.isEmpty()) {
                // Increment remaining words since the word is valid:
                numOfRemainingWords1++;
                if (!wordMap1.containsKey(word)) {
                    // If the word doesn't exist yet, add it to wordMap1 and intersection:
                    wordMap1.put(word, 1);
                    intersection.add(word);
                } else {
                    // Get the words current count and increment by 1:
                    int count = wordMap1.get(word);
                    wordMap1.put(word, count + 1);
                }
            }
        }

        while(s2.hasNext()) {
            String scanned = s2.next().toLowerCase();
            if (scanned.length() > 0) numOfTotalWords2++;
            String word = scanned.startsWith("'") ? scanned.substring(1) : scanned;

            if (!word.isEmpty()) {
                numOfRemainingWords2++;
                if (!wordMap2.containsKey(word) ) {
                    wordMap2.put(word, 1);
                } else {
                    int count = wordMap2.get(word);
                    wordMap2.put(word, count + 1);
                }
            }
        }
        
        intersection.retainAll(wordMap2.keySet());
        s1.close();
        s2.close();
    }

    @Override public String toString() {
        String s = String.format("Statistics for: %s%n", fileName1);
        s += String.format("  There are a total of %d words in the file.%n", numOfTotalWords1);
        s += String.format("  Of those, %d were ignored, leaving %d words to process.%n", numOfTotalWords1 - numOfRemainingWords1, numOfRemainingWords1);
        s += String.format("  After processing, there are %d distinct words in the file%n%n", wordMap1.size());
        s += String.format("Statistics for: %s%n", fileName2);
        s += String.format("  There are a total of %d words in the file.%n", numOfTotalWords2);
        s += String.format("  Of those, %d were ignored, leaving %d words to process.%n", numOfTotalWords2 - numOfRemainingWords2, numOfRemainingWords2);
        s += String.format("  After processing, there are %d distinct words in the file%n%n", wordMap2.size());
        s += String.format("There are %d common words in files %s and %s.%nThe common words are:%n", intersection.size(), fileName1, fileName2);
        s += String.format("    Word      %-14s%s%n", fileName1, fileName2);
        s += String.format("------------  ------------  ------------%n");
        for(String word : intersection) {
            s += String.format("%-14s %6s %14s%n", word, wordMap1.get(word), wordMap2.get(word));
        }
        return s;
    }

    private Map<String, Integer> wordMap1, wordMap2;
    private Collection<String> intersection;
    private String fileName1, fileName2;
    private int numOfTotalWords1, numOfTotalWords2, numOfRemainingWords1, numOfRemainingWords2;

}