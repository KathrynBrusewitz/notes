// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 14

import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;

public class Chapter14 {

	public static Stack<String> stutter(Stack<String> stack) {

		// Check if stack is empty
		if (stack == null || stack.isEmpty()) {
			throw new EmptyStackException();
		}

		// Create a copy of stack
		Stack<String> stackCopy = new Stack<String>();
		stackCopy.add(stack.pop());

		// Create final stutter stack
		Stack<String> stackFinal = new Stack<String>();
		while (!stackCopy.isEmpty()) {
			String str = stackCopy.pop();
			stack.add(str);
			stackFinal.add(str);
			stackFinal.add(str);
		}

		return stackFinal;

	}

	public static boolean equals(Stack<String> stack1, Stack<String> stack2) {

		boolean bool = true;

		if (stack1 == null || stack2 == null) {
			// Check if stacks are empty
			throw new EmptyStackException();
		} else if (stack1.size() != stack2.size()) {
			// If they are different size, they are not same
			bool = false;
		} else if (stack1 == stack2) {
			// If they are equal, they are same
			bool = true;
		} else {
			// Get size of stack1
			int sizeOfStack1 = stack1.size();

			Stack<String> stackTemp1 = new Stack<String>();
			Stack<String> stackTemp2 = new Stack<String>();

			for (int i = 0; i < sizeOfStack1; i++) {

				// Stores the values in the both stack or declare them
				String string2 = stack2.pop();
				String string1 = stack1.pop();

				// If string1 is equal to string2, set false
				if (!string1.equals(string2)) {
					bool = false;
				}

				// For every string, push to temporary stacks
				stackTemp1.push(string1);
				stackTemp2.push(string2);
			}

			// Pop from temporary stacks to original stacks
			for (int i = 0; i < sizeOfStack1; i++) {
				stack2.push(stackTemp2.pop());
				stack1.push(stackTemp1.pop());
			}
		}

		return bool;
	}

	public static boolean isSorted(Stack<String> stack1) {

		if (stack1 == null || stack1.isEmpty()) {
			// If stack is empty
			throw new EmptyStackException();
		} else if (stack1.size() == 0 || stack1.size() == 1) {
			// If either stack are same size
			return true;
		} else {
			boolean bool = true;

			// Create second stack
			Stack<String> stack2 = new Stack<String>();

			// Get first number
			String string1 = stack1.pop();

			// Push the string into stack2
			stack2.push(string1);

			// While stack1 is not empty
			while (!stack1.isEmpty()) {
				String string2 = stack1.pop();

				if (string1.compareTo(string2) > 0) {
					bool = false;
				}

				// Set string1 same as string2
				string1 = string2;

				// Push string2 to stack2
				stack2.push(string2);
			}

			// while stack2 is not empty
			while (!stack2.isEmpty()) {
				// Pop from stack2 and push to stack1
				stack1.push(stack2.pop());
			}

			return bool;
		}

	}
	public static String removeMin(Stack<String> stack1) {

		// If stack is empty
		if (stack1 == null || stack1.isEmpty()) {
			throw new EmptyStackException();
		}

		// Start with empty string
		String min = "";

		// Peek first
		min = stack1.peek();

		Queue<String> queueTemp = new java.util.LinkedList<String>();
		Stack<String> stackTemp = new Stack<String>();

		// While stack not empty
		while (!stack1.isEmpty()) {
			String num = stack1.pop();

			if (num.compareTo(min) < 0) {
				min = num;
			}

			queueTemp.add(num);
		}

		// While queue not empty
		while (!queueTemp.isEmpty()) {

			if (queueTemp.peek() == min) {
				queueTemp.remove();
			} else {
				stackTemp.push(queueTemp.remove());
			}

		}

		// While stackTemp not empty
		while (!stackTemp.isEmpty()) {
			stack1.push(stackTemp.pop());
		}

		return min;
	}
}
