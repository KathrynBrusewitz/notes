/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/26/2013
  Instructor:     Robert Main
  
  Project #:      9
  File Name:      List.cpp
  Programmer:     Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include "List.h"     // Class Definition file
#include <iostream>   // Defines objects and classes used for stream I/O

List::List(void) {
    position = 0;
}

bool List::storeValue(int value) {
    if (position == SIZE) {
        // Do nothing; Reached size limit
        return false;
    } else {
        array[position] = value;
        position++;
        return true;
    }
}

void List::bubbleSort() {
    int passCount = 0,
        temp;
    bool swap;

    do {
        passCount++;
        swap = false;

        for (int i = 0; i < (SIZE - 1); i++) { // i = 0, 1, 2, 3, 4, 5, 6
            if (array[i] > array[i + 1]) {     // 0 > 1, 1 > 2, [...], 6 > 7
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swap = true;
            }
        }

        // Display array contents after each pass
        std::cout << "Pass #" << passCount << ": ";
        showArray();
        std::cout << std::endl;

    } while (swap); // Repeat loop if a swap occured on this pass
}

void List::selectionSort() {
    int passCount = 0,
        startScan, 
        minIndex, 
        minValue;

      // startScan = 0, 1, 2, 3, 4, 5, 6
    for (startScan = 0; startScan < (SIZE - 1); startScan++) { 
        passCount++;
        minIndex = startScan;
        minValue = array[startScan];

              // index = 1, 2, 3, 4, 5, 6, 7
        for (int index = (startScan + 1); index < SIZE; index++) {
            // Starting from startScan, look for anything less than the min value
            if (array[index] < minValue) {
                minValue = array[index];
                minIndex = index;
            }
        }

        array[minIndex] = array[startScan];
        array[startScan] = minValue;

        // Display array contents after each pass
        std::cout << "Pass #" << passCount << ": ";
        showArray();
        std::cout << std::endl;
    }
}

void List::showArray() const {
    for (int i = 0; i < SIZE; i++)
        std::cout << array[i] << " ";
}
