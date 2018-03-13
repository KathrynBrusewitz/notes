/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/26/2013
  Instructor:     Robert Main
  
  Project #:      9
  File Name:      main.cpp
  Programmer:     Kathryn Brusewitz

  Demonstrates two sorting algorithms: bubble and selection sorting.

 --------------------------------------------------------------------*/

#include <iostream>  // Defines objects and classes used for stream I/O
#include "List.h"    // Class Definition header file
#include <time.h>    // Definitions for manipulating time/date information

const int SIZE = 8;

int main() {

    int randNum;
    List a;
    List b;

    srand(time(0));

    std::cout << "This program sorts through two identical arrays using two "
         << "different algorithms.\n\n\n";

    // Set up arrays
    for (int i = 0; i < SIZE; i++) {
        randNum = ((rand() % 30) + 1);
        if (!a.storeValue(randNum) || !b.storeValue(randNum))
            std::cout << "Can't add another value." << std::endl;
    }

    // Display contents of Array A
    std::cout << "Array A contents: ";
    a.showArray();
    std::cout << std::endl << std::endl;

    // Call function that bubble sorts Array A and prints after each pass
    std::cout << "Now bubble sorting Array A..." << std::endl << std::endl;
    std::cout << "Contents after:" << std::endl;
    a.bubbleSort();
    std::cout << std::endl << std::endl;

    // Display contents of Array B
    std::cout << "Array B contents: ";
    b.showArray();
    std::cout << std::endl << std::endl;

    // Call function that selection sorts Array B and prints after each pass
    std::cout << "Now selection sorting Array B..." << std::endl << std::endl;
    std::cout << "Contents after:" << std::endl;
    b.selectionSort();
    std::cout << std::endl << std::endl;

    // Prevent Console Window from closing during debug mode
    std::cin.ignore(std::cin.rdbuf()->in_avail());
    std::cout << "\nPress only the 'Enter' key to exit program: ";
    std::cin.get();

    return 0;
}
