import java.util.LinkedList;
import java.util.Queue;

public class Chapter14 {

	/* AVAILABLE METHODS I CAN USE BECAUSE I FORGET
	 * Queue
	 * add(value) = Adds the given value at the back of the queue
	 * remove() = Removes and returns the value at the front of the queue
	 * isEmpty() = Returns true if this queue contains no values
	 * peek() = Returns the value at the front of the queue without removing it
	 * size() = Returns the number of values in the queue
	 * 
	 * Stack
	 * push = Pushes the given value onto the top of the stack
	 * pop = Removes and returns the value at the top of the stack 
	 * empty = Returns true if this stack contains no values
	 * peek = Returns the value at the top of the stack without removing it
	 * toString
	 */
	
	/* Exercise 2
	 * 
	 * Write a method called stutter that accepts a stack of integers 
	 * as a parameter and replaces every value in the stack with two 
	 * occurrences of that value. Preserve the original relative order. 
	 * For example, if the stack stores [3, 7, 1, 14, 9], your method 
	 * should change it to store [3, 3, 7, 7, 1, 1, 14, 14, 9, 9]. 
	 * Use a single queue as auxiliary storage.
	 * 
	 * Return the stuttered stack and leave the original stack unchanged.
	 */
	public static Stack<CalendarDate> stutter(Stack<CalendarDate> stack) {
		
		// If stack is empty, just return it
		if (stack.empty()) {
			return stack;
		}

		// STEP 1: REVERSE THE STACK

		Queue<CalendarDate> queue = new LinkedList<CalendarDate>(); // Auxiliary storage
		Stack<CalendarDate> stutter = new Stack<CalendarDate>(); // Return this

		// stack        [ a, b, c, d, e, f, g ]
		// queue        [ ]
		// stutter      [ ]

		// Pop last element from stack
		// Add that element to queue
		while (!stack.empty()) {
			queue.add(stack.pop());
		}
		// stack        [ ]
		// queue        [ g, f, e, d, c, b, a ]
		// stutter      [ ]

		// Remove first element from queue
		// Push that element to stack
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		// stack        [ g, f, e, d, c, b, a ]
		// queue        [ ]
		// stutter      [ ]

		// STEP 2. BUILD STUTTER

		// Use queue to store elements in original order
		// And push twice to stutter
		while (!stack.empty()) {
			CalendarDate date = stack.pop();
			queue.add(date);
			stutter.push(date);
			stutter.push(date);
		}
		// stack        [ ]
		// queue        [ a, b, c, d, e, f, g ]
		// stutter      [ a, a, b, b, c, c, d, d, e, e, f, f, g, g ]

		// Rebuild original stack as per new requirement
		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		// stack        [ a, b, c, d, e, f, g ] <- original stack, yay!
		// queue        [ ]
		// stutter      [ a, a, b, b, c, c, d, d, e, e, f, f, g, g ]

		return stutter;
	}

	/* Exercise 5
	 * 
	 * Write a method called equals that accepts two stacks of integers 
	 * as parameters and returns true if the two stacks store exactly 
	 * the same sequence of integer values in the same order. Your method 
	 * must restore the two stacks to their original state before returning. 
	 * Use one stack as auxiliary storage.
	 * 
	 * Use the compareTo method for comparisons and leave the original 
	 * Stacks unchanged.
	 * 
	 * Handle the case they are the same object.
	 * Two empty stacks are equal.
	 */
	public static boolean equals(Stack<CalendarDate> stack1, Stack<CalendarDate> stack2) {
		// If stacks refer to same object, they are equal
		if (stack1 == stack2) {
			return true;
		}
		
		// If stacks are empty, they are equal
		if (stack1.empty() && stack2.empty()) {
			return true;
		}
		
		boolean flag = true; // Stacks are considered matching until proven guilty (of not matching)
		Stack<CalendarDate> aux = new Stack<CalendarDate>(); // Auxiliary storage
		CalendarDate date1;
		CalendarDate date2;
		
		// STEP 1. GO THROUGH STACKS UNTIL EITHER:
		// - flag becomes false (there is a non-match)
		// - at least one of the stacks become empty
		while (flag && !stack1.empty() && !stack2.empty()) {
			date1 = stack1.peek();
			date2 = stack2.peek();
			
			if (date1.compareTo(date2) != 0) {
				flag = false;
			}
			
			if (flag) {
				aux.push(stack1.pop());
				stack2.pop();
			}
		}
		
		// STEP 2. FLAG FALSE IF ONLY ONE STACK IS EMPTY
		if ((stack1.empty() && !stack2.empty()) || (!stack1.empty() && stack2.empty())) {
			flag = false;
		}
		
		// STEP 3. REBUILD STACKS:
		while (!aux.empty()) {
			CalendarDate date = aux.pop();
			stack1.push(date);
			stack2.push(date);
		}
		
		return flag;
	}

	/* Exercise 15
	 * 
	 * Write a method called isSorted that accepts a stack of integers 
	 * as a parameter and returns true if the elements in the stack occur 
	 * in ascending (nondecreasing) order from top to bottom. That is, 
	 * the smallest element should be on top, growing larger toward the 
	 * bottom. For example, if the stack stores [20, 20, 17, 11, 8, 8, 3, 2], 
	 * your method should return true. An empty or one-element stack is 
	 * considered to be sorted. Your method must restore the parameter stack 
	 * to its original state before returning. Use one queue or stack (but 
	 * not both) as auxiliary storage.
	 * 
	 * Use compareTo to evaluate if sorted and leave the original Stack 
	 * unchanged.
	 */
	public static boolean isSorted(Stack<CalendarDate> stack) {
		// An empty stack is sorted
		if (stack.empty()) {
			return true;
		}

		Queue<CalendarDate> queue = new LinkedList<CalendarDate>(); // Auxiliary storage
		boolean isSorted = true; // Assume stack is sorted until proven otherwise
		CalendarDate date;

		date = stack.pop();
		queue.add(date);
		
		// STEP 1: GO THROUGH STACK UNTIL EITHER:
		// - stack is empty
		// - isSorted becomes false (dates are not descending)
		while (!stack.empty() && isSorted != false) {
			if (stack.peek().compareTo(date) < 0 ) {
				isSorted = false;
			} else {
				date = stack.pop();
			}
			if (isSorted) {
				queue.add(date);
			}
		}
		
		// Now, the stack is empty 
		// and the queue is in reverse order of original stack
		// and our isSorted flag is set to either true or false
		
		// STEP 2: REBUILD THE STACK BACK TO ORIGINAL ORDER
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		if (isSorted) {
			while(!stack.empty()) {
				queue.add(stack.pop());
			}
			while(!queue.isEmpty()) {
				stack.push(queue.remove());
			}
		}
		
		return isSorted;
	}

	/* Exercise 15
	 * 
	 * Write a method called removeMin that accepts a stack of integers as a 
	 * parameter and removes and returns the smallest value from the stack.
	 * For example, if the stack stores [2, 8, 3, 19, 2, 3, 2, 7, 12, -8, 4], 
	 * your method should remove and return -8, leaving the stack storing 
	 * [2, 8, 3, 19, 2, 3, 2, 7, 12, 4]. If the minimum value appears more 
	 * than once, all occurrences of it should be removed. For example, given 
	 * the same stack, if we again call removeMin on it,the method would 
	 * return 2 and leave the stack storing [8, 3, 19, 3, 7, 12, 4]. Use one 
	 * queue as auxiliary storage.
	 * 
	 * Use compareTo for evaluating the minimum.
	 * Stack will be modified.
	 */
	public static CalendarDate removeMin(Stack<CalendarDate> stack) {
		// An empty stack has no elements, so return null
		if (stack.empty()) {
			return null;
		}
		
		Queue<CalendarDate> queue = new LinkedList<CalendarDate>(); // Auxiliary storage
		CalendarDate date;
		CalendarDate min;
		
		date = stack.pop();
		min = date;
		queue.add(date);
		
		// STEP 1: FIND SMALLEST VALUE
		while (!stack.empty()) {
			date = stack.pop();
			if (min.compareTo(date) > 0) {
				min = date;
			}
			queue.add(date);
		}
		
		// Now we have: 
		// - the smallest value (min)
		// - empty stack
		// - queue that is reverse copy of original stack
		
		// STEP 2: REBUILD STACK BUT LEAVE OUT MIN
		while (!queue.isEmpty()) {
			date = queue.remove();
			if (date.compareTo(min) != 0) {
				stack.push(date);
			}
		}
		
		// STEP 3: REVERSE STACK BACK TO ORIGINAL ORDER
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		
		while(!stack.empty()) {
			queue.add(stack.pop());
		}
		
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		
		return min;
	}
}
