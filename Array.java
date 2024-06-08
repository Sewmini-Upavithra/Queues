package Stack;
import java.util.*;

public class Array {

	 int size;
	    int[] array; 
	    int top; 

	    // Constructor to initialize the stack with a given size
	    Array(int size) { 
	        this.size = size;
	        this.array = new int[size];
	        this.top = -1; 
	    }

	    // Check if the stack is empty
	    public boolean isEmpty() {
	        return (top == -1);
	    }

	    // Check if the stack is full
	    public boolean isFull() {
	        return (size - 1 == top);
	    }

	    // Push a new element onto the stack
	    public void push(int pushed) {
	        if (!isFull()) {
	            array[++top] = pushed;
	            System.out.println("Pushed element: " + pushed);
	        } else {
	            System.out.println("Stack is full!");
	        }
	    }

	    // Pop an element from the stack
	    public int pop() {
	        if (!isEmpty()) {
	            int popped = array[top--];
	            System.out.println("Popped element: " + popped);
	            return popped;
	        } else {
	            System.out.println("Stack is empty!");
	            return -1;
	        }
	    }

	    // Peek at the top element of the stack without removing it
	    public int peek() {
	        if (!isEmpty()) {
	            return array[top];
	        } else {
	            System.out.println("Stack is empty!");
	            return -1;
	        }
	    }

	    public static void main(String[] args) {
	        // Create a new stack with a size of 50
	        Array stack = new Array(50);

	        // Attempt to pop an element from the empty stack
	        stack.pop();

	        // Push elements onto the stack
	        stack.push(15);
	        stack.push(42);
	        stack.push(99);
	        stack.push(74);
	        stack.push(63);

	        // Pop elements from the stack
	        stack.pop();
	        stack.pop();
	        stack.pop();

	        // Peek at the top element of the stack
	        System.out.println("Top element is: " + stack.peek());
	    }
	}
