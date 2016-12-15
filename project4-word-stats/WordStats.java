/*-----------------------------------------------------------------------------
  CS 211
  01/27/2015
  Kathryn Brusewitz

  Class: WordStats

  This file compares two books: Hamlet and King Lear. 
  Using CommonWords.java to find unique words in both files and displays 
  statistics about the words and their frequency in each file.

 ------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;

class WordStats {
    
    public static void main (String[] args) throws FileNotFoundException {
        System.out.format("%n%n%46s%n", "Chapter 11, Assigned Project #4");
        System.out.format("This program determines the distinct words in two different books%n");
        System.out.format("(from disk files) and the number of times each word occurs in the%n");
        System.out.format("file, determines the common words in both files, and final displays%n");
        System.out.format("the results.%n%n");

        File file1 = new File("Hamlet.txt");
        File file2 = new File("KingLear.txt");
        CommonWords commonWords = new CommonWords();

        commonWords.determineCommonWords(file1, file2);

        System.out.format("%s%n", commonWords.toString());

    }

}