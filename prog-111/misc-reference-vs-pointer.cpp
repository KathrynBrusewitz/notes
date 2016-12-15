/*------------------------------------------------------------------------------

  File: reference-vs-pointer.cpp
  Kathryn Brusewitz

  Complete Explanations: 
  http://www.cplusplus.com/forum/articles/20193/
  http://www.reddit.com/r/learnprogramming/comments/21lmqt/homeworkc_having_trouble_grasping_pointerspointer/cge7tkz

  A pointer variable holds the memory address of a variable.

    1. Use pointer syntax to access the values pointed to by the pointer.
    2. Can redirect the pointer to point it to a different target variable.
    3. Can make a pointer point to nothing (ie. NULL pointer).

  A reference variable refers to another variable.

    1. References must be initialized at the point of instantiation.
    2. References must ALWAYS "refer to" a variable
        (you cannot have a reference variable that refers to nothing, the 
        equivalent of a NULL pointer).
    3. Once a reference is set to refer to a particular variable, you
        cannot, during its lifetime, rebind it to refer to a different
        variable.
    4. Use normal value syntax to access the value being referred to.

 ------------------------------------------------------------------------------*/
    
#include <iostream>

int main () {

    std::cout << "POINTER EXAMPLE" << std::endl;
    int i, j;
    int* pInt;                      // Instantiate our pointer called pInt

    pInt = &i;                      // pInt "points to" i
    *pInt = 42;                     // Assign the variable pointed to by pInt to 42
    std::cout << i << std::endl;    // Prints "42"
    std::cout << pInt << std::endl; // Prints address of i

    *pInt = 28;                     // Reassign the variable pointed to by pInt to 28
    std::cout << i << std::endl;    // Prints "28"


    pInt = &j;                      // pInt now points to j instead of i
    std::cout << j << std::endl;    // Prints "0"
    std::cout << pInt << std::endl; // Prints address of j


    pInt = NULL;                    // Makes pInt point to nothing. 
    std::cout << pInt << std::endl; // Prints "0x0"

    std::cout << "REFERENCE EXAMPLE" << std::endl;
    int x = 20, y = 10;
    int& xref = x;                  // Instantiate xref and make it refer to x
                                    // Initialization MUST happen at the point of instantiation
                                    // xref == &x

    xref = 42;                      // Assign the value of x to 42
    std::cout << x << std::endl;    // Prints "42"
    std::cout << xref << std::endl; // Prints "42"
    xref = y;                       // Assign the value of x to 10 (the value of y)
    std::cout << x << std::endl;    // Prints "20"
    std::cout << xref << std::endl; // Prints "20"

    std::cout << &xref << std::endl;// Prints address of x

    std::cout << "ARRAY EXAMPLE" << std::endl;
    int numbers[10];                // Instantiate array
    int* p = &numbers[0];           // Create p and point to array

    for (int i = 0; i < 10; i++) {  // Assign values to array
        numbers[i] = 8 * i;
    }

    for (int i = 0; i < 10; i++) {  // Prints array via pointer
        std::cout << (p + i) << " " << *(p + i) << std::endl;
    }

    return 0;
}