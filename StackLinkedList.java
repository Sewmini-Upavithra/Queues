package Stack;
import java.util.*;


public class StackLinkedList {

	static class Node {
        int element;
        Node next;

        Node(int data) {
            this.element = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        // Check if the stack is empty
        public static boolean isEmpty() {
            return (head == null);
        }

        // Push a new element onto the stack
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // Pop an element from the stack
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = head.element;
            head = head.next;
            return top;
        }

        // Peek at the top element of the stack without removing it
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.element;
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();

        // Push different elements onto the stack
        s.push(34);
        s.push(21);
        s.push(87);
        s.push(13);

        // Print and pop elements from the stack until it is empty
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}