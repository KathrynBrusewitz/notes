Algorithms Basics
===
__Operation Running Time__
:  Number of instructions executed per operation

Algorithm Complexity
---
Suppose _X_ is an algorithm and _n_ is the size of input data. The time and space used by the algorithm _X_ decide the efficiency of _X_.

__Time Factor__
:  Number of key operations.

__Space Factor__
:  The maximum memory space required by the algorithm.

Algorithm complexity _f(n)_ gives the running time and/or the storage space required by the algorithm in terms of _n_ as the size of input data.

Space Complexity
---
Space complexity _S(P)_ of an algorithm represents the amount of memory space required by the algorithm in its life cycle. The space required by an algorithm is equal to the sum of the following two components:

  * A fixed part that is a space required to store certain data and variables, that are independent of the size of the problem. 
    - Simple variables and constants used, program size
  * A variable part is a space required by variables, whose size depends on the size of the problem.
    - Dynamic memory allocation, recursion stack space, etc.

Space complexity _S(P)_ of any algorithm _P_ is S(P) = C + SP(I), where C is the fixed part and S(I) is the variable part of the algorithm, which depends on instance characteristic I. Following is a simple example that tries to explain the concept:

	Algorithm: SUM(A, B)
	Step 1 -  START
	Step 2 -  C ← A + B + 10
	Step 3 -  Stop

Here we have three variables A, B, and C and one constant. Hence S(P) = 1 + 3. Now, space depends on data types of given variables and constant types and it will be multiplied accordingly.

https://www.tutorialspoint.com/data_structures_algorithms/algorithms_basics.htm