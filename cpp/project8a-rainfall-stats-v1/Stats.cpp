/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/21/2013
  Instructor:     Robert Main
  
  Project #:      8
  File Name:      Stats.cpp
  Programmer:     Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include "Stats.h"

Stats::Stats(void) {
    index = 0;
}

bool Stats::storeValue(double a) {
    if(index == 30) {
        // Do nothing
        return false;
    } else {
        statArray[index] = a;
        index++;
        return true;
    }
}

double Stats::getValue(int a) const {
    return statArray[a];
}

double Stats::total() const {
    double total = 0;
    for (int i = 0; i < index; i++)
        total += statArray[i];
    return total;
}

double Stats::average() const {
    double sum = total();
    double average = sum / index;
    return average;
}

int Stats::highest() const {
    double highest = statArray[0];
    int highestIndex = 0; // Tracks index number of highest number

    for(int i = 1; i < index; i++) {
        if(statArray[i] > highest) {
            highest = statArray[i];
            highestIndex = i;
        }
    }
    return highestIndex;
}

int Stats::lowest() const {
    double lowest = statArray[0];
    int lowestIndex = 0; // Tracks index number of lowest number

    for(int i = 1; i < index; i++) {
        if(statArray[i] < lowest) {
            lowest = statArray[i];
            lowestIndex = i;
        }
    }
    return lowestIndex;
}
