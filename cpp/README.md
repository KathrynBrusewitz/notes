# C++ Notes

Place to store my Bellevue College PROG 111 Projects.

## Notes

### project6a-judge-scores.cpp

I wanted a way to make sure the user enters a number and not a string or character. I found I could test if `cin` had failed to transfer the data, which then sets a failbit or badbit error state flag. If true, use `cin.clear()` to reset the stream back to a goodbit state so that `cin.ignore()` could be used to clear out the bad input from the stream. I’ve read that I don’t even need `clear()` but it’s harmless in this situation.

### project8a-rainfall-stats-v1

I wasn't sure where to define a `static const` data member for a class, but I think I understand after looking it up. Instead of declaring inside the header file and initializing in the source file, C++ allows a simpler way for `const int` types. So I can both declare and initialize `ARRAY_SIZE` inside the class body in the header file.

### project9-sorting

I tried to use `void bubbleSort(int &array[], int)` but got an error. When I left out the reference operator, the original in main was affected, as if it was passed by reference. I checked online and found out these function declarations pass by reference and essentially work the same (with slight differences):

```c++
void bubbleSort(int * array); // Array degrades to a pointer. Cannot use sizeof, etc.

void bubbleSort(int array[]); // Array degrades to a pointer. What I'm using.

void bubbleSort(int (&array)[8]); // Preserves as a reference. Only accepts arrays of 8 ints.
```

So it was an error in syntax. Without the parantheses, the subscript has higher precedence over the & operator and would be passing an array of references:

```c++
void bubbleSort(int &array[8]); // Invalid: Passing an array of references
```
