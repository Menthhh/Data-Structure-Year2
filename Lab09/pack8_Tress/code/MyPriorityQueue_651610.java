package code;


public class MyPriorityQueue_651610 implements MyQueueInterface {
    MyMinHeap_651610 heap = new MyMinHeap_651610();
    
    public void enqueue(int d) {
        if (!isFull()) {
            heap.insert(d);
        } else {
            System.out.println("Queue is full. Cannot enqueue " + d);
        }
    }
    public int dequeue() {
        if (!isEmpty()) {
            return heap.remove();
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; 
        }
    }
    public int front() {
        if (!isEmpty()) {
            return heap.peek();
        } else {
            System.out.println("Queue is empty. No front.");
            return -1; 
        }
    }
    public boolean isFull() {
        return heap.isFull();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public String toString() {
        return heap.toString();
    }
}