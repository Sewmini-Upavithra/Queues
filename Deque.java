package FIFOqueues;
import java.util.LinkedList;
import java.util.Queue;

public class Deque<T> {

	private Queue<T> frontQueue;
    private Queue<T> backQueue;

    // Constructor to initialize the D
    public Deque() {
        frontQueue = new LinkedList<>();
        backQueue = new LinkedList<>();
    }

    // Add an element to the front of the D
    public void addFirst(T element) {
        frontQueue.add(element);
    }

    // Add an element to the back of the D
    public void addLast(T element) {
        backQueue.add(element);
    }

    // Remove and return the first element from the D
    public T removeFirst() {
        if (frontQueue.isEmpty()) {
            while (!backQueue.isEmpty()) {
                frontQueue.add(backQueue.remove());
            }
        }
        return frontQueue.poll();
    }

    // Remove and return the last element from the D
    public T removeLast() {
        if (backQueue.isEmpty()) {
            while (!frontQueue.isEmpty()) {
                backQueue.add(frontQueue.remove());
            }
        }
        return backQueue.poll();
    }

    // Check if the D is empty
    public boolean isEmpty() {
        return frontQueue.isEmpty() && backQueue.isEmpty();
    }

    // Return the size of the D
    public int size() {
        return frontQueue.size() + backQueue.size();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        
        // Add different elements to the D
        deque.addFirst(23);
        deque.addFirst(45);
        deque.addLast(67);
        deque.addLast(89);

        // Remove and print elements from the D
        System.out.println(deque.removeFirst()); // Should print 45
        System.out.println(deque.removeLast());  // Should print 89
        System.out.println(deque.removeFirst()); // Should print 23
    }
}