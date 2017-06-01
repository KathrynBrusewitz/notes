#pragma once
#ifndef LIST_H
#define LIST_H

/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/26/2013
  Instructor:     Robert Main
  
  Project #:      9
  File Name:      List.h
  Programmer:     Kathryn Brusewitz

  List stores up to 8 integers to be sorted. 
  These values can be sorted through bubble or selection sorting.

 --------------------------------------------------------------------*/

class List {
private:
    // Constant Value Declarations
    static const int SIZE = 8;

    // Variable Declarations
    int array[SIZE];
    int position;

public:
    // Class Constructor(s)
    List(void);

    // Client Methods
    bool storeValue(int);
    void bubbleSort();
    void selectionSort();
    void showArray() const;
};

#endif
