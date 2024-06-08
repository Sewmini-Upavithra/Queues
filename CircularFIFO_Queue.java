package FIFOqueues;
import java.util.*; 


public class CircularFIFO_Queue {

	// Maximum size of the circular queue 
    private int maxSize;     
    
    // Array to store the circular queue elements 
    private int[] queueArray;    
    
    // Index of the front element 
    private int front;          
    
    // Index of the rear element 
    private int rear;           
  
    // Constructor to initialize the circular queue with a given size 
    public CircularFIFO_Queue(int size) { 
        maxSize = size; 
        queueArray = new int[maxSize]; 
        
        // Initially set front and rear to -1 to indicate an empty queue 
        front = -1;   
        rear = -1; 
    } 
  
    // Method to enqueue (add) an item to the circular queue 
    public void enqueue(int item) { 
        if (isEmpty()) { 
            front = 0; 
            rear = 0; 
            queueArray[rear] = item; 
        } else { 
            // Circular increment of rear index 
            rear = (rear + 1) % maxSize;   
            if (rear == front) { 
                System.out.println("Queue is full. Cannot enqueue."); 
                
                // Reset rear to its previous value 
                rear = (rear - 1 + maxSize) % maxSize;  
            } else { 
                queueArray[rear] = item; 
            } 
        } 
    } 
  
    // Method to dequeue (remove) an item from the circular queue 
    public int dequeue() { 
        int item = -1; // Assuming -1 represents an empty value 
  
        if (!isEmpty()) { 
            item = queueArray[front]; 
            if (front == rear) { 
                // Reset front and rear to -1 to indicate an empty queue 
                front = -1; 
                rear = -1;   
            } else { 
                // Circular increment of front index 
                front = (front + 1) % maxSize;   
            } 
        } else { 
            System.out.println("Queue is empty. Cannot dequeue."); 
        } 
  
        return item; 
    } 
  
    // Method to peek at the front element of the circular queue without removing it 
    public int peek() { 
        if (!isEmpty()) { 
            return queueArray[front]; 
        } else { 
            System.out.println("Queue is empty. No peek value."); 
            return -1; // Assuming -1 represents an empty value 
        } 
    } 
  
    // Method to check if the circular queue is empty 
    public boolean isEmpty() { 
        return front == -1 && rear == -1; 
    } 
  
    // Main method for testing the CircularQueue class 
    public static void main(String[] args) { 
    	CircularFIFO_Queue circularQueue = new CircularFIFO_Queue(5); 
  
        // Enqueue different elements
        circularQueue.enqueue(10); 
        circularQueue.enqueue(20); 
        circularQueue.enqueue(30); 
        circularQueue.enqueue(40); 
        circularQueue.enqueue(50); // This will fill the queue
  
        // Try to enqueue another element (should fail as the queue is full)
        circularQueue.enqueue(60); // Should print "Queue is full. Cannot enqueue."
  
        // Should print 10 
        System.out.println("Peek: " + circularQueue.peek());  
  
        // Should print 10 
        System.out.println("Dequeue: " + circularQueue.dequeue());  
  
        // Should print 20 
        System.out.println("Peek after dequeue: " + circularQueue.peek());  
    } 
}