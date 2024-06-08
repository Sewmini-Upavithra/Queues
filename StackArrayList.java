package Stack;
import java.util.*;

public class StackArrayList {

	public class Stack_ArrayList {
	    static class Stack {
	        static ArrayList<Integer> list = new ArrayList<>();

	        // Check if the stack is empty
	        public static boolean isEmpty() {
	            return (list.size() == 0);
	        }

	        // Push a new element onto the stack
	        public static void push(int element) {
	            list.add(element);
	        }

	        // Pop an element from the stack
	        public static int pop() {
	            if (isEmpty()) {
	                System.out.println("Stack is empty!");
	                return -1;
	            }
	            int top = list.get(list.size() - 1);
	            list.remove(list.size() - 1);
	            return top;
	        }
	    
	        // Peek at the top element of the stack without removing it
	        public static int peek() {
	            if (isEmpty()) {
	                System.out.println("Stack is empty!");
	                return -1;
	            }
	            return list.get(list.size() - 1);
	        }
	    }

	    public static void main(String args[]) {
	        Stack s = new Stack();
	        
	        // Push different elements onto the stack
	        s.push(23);
	        s.push(46);
	        s.push(78);
	        s.push(89);

	        // Print and pop elements from the stack until it is empty
	        while (!s.isEmpty()) {
	            System.out.println(s.peek());
	            s.pop();
	        }
	    }
    }
}