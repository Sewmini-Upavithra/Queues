package FIFOqueues;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<Item> implements Iterable<Item> { 

	private Node first; // Pointer to the first node
    private Node last; // Pointer to the last node
    private int size; // Number of elements in the S

    private class Node {
        Item item; // Data stored in the node
        Node next; // Pointer to the next node
    }

    // Constructor to initialize an empty S
    public Steque() {
        first = null;
        last = null;
        size = 0;
    }

    // Method to check if the S is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to return the size of the S
    public int size() {
        return size;
    }

    // Method to add an item to the front of the S
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) {
            last = first; // If the S was empty, set last to first
        }
        size++;
    }

    // Method to add an item to the end of the S
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last; // If the S was empty, set first to last
        } else {
            oldLast.next = last; // Otherwise, link the previous last node to the new last node
        }
        size++;
    }

    // Method to remove and return the item from the front of the S
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Steque underflow");
        }
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null; // If the S becomes empty after popping, set last to null
        }
        return item;
    }

    // Method to return an iterator over the items in the S
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }

    // Private inner class implementing the Iterator interface for S
    private class StequeIterator implements Iterator<Item> {
        private Node current = first; // Current node being iterated over

        // Method to check if there is a next item in the S
        public boolean hasNext() {
            return current != null;
        }

        // Method to return the next item in the S
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        // Method to remove an item from the S (not supported)
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // Main method for testing the S implementation
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.enqueue(1);
        steque.enqueue(2);
        steque.push(3);
        steque.enqueue(4);

        System.out.println("Size of Steque: " + steque.size());

        System.out.println("Items in Steque:");
        for (int item : steque) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Popped item: " + steque.pop());
        System.out.println("Popped item: " + steque.pop());

        System.out.println("Size of Steque after popping: " + steque.size());

        System.out.println("Items in Steque after popping:");
        for (int item : steque) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}