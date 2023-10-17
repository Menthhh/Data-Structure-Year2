
package code;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linked List");
        System.out.println("---------------------------------------------");
        LinkedList myLinkedList = new LinkedList();
        int[] data = {5,16,20,25,30};
        for (int i = 0; i < data.length; i++){
            myLinkedList.append(data[i]);
        }

        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());
        

        System.out.println("remove last value: " + myLinkedList.removeLast().value);
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());
        

        myLinkedList.prepend(10);
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());
        

        System.out.println("Remove First value:" + myLinkedList.removeFirst().value);
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());

        System.out.println("Index 2: " + myLinkedList.Get(2).value);

        myLinkedList.Set(2, 100);
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());

        System.out.println("Insert 2, 200");
        myLinkedList.insert(2, 200);
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());

        System.out.println(myLinkedList.remove(3).value);
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());


        myLinkedList.reverse();
        myLinkedList.printList();
        System.out.println("Size of Linked List: " + myLinkedList.size());

        System.out.println("Head: " + myLinkedList.getHead());
        System.out.println("Tail: " + myLinkedList.getTail());
        System.out.println("---------------------------------------------");

        System.out.println("Stack");
        System.out.println("---------------------------------------------");
        Stack myStack = new Stack(20);
        int[] data2 = {5,16,20,25,30};
        for (int i : data2){
            myStack.push(i);
        }
        
        myStack.printStack();
        myStack.pop();

        myStack.printStack();
        System.out.println("Top of Stack: " + myStack.top());
        System.out.println("Size of Stack: " + myStack.size());
        System.out.println("---------------------------------------------");
        
        System.out.println("Queue");
        System.out.println("---------------------------------------------");
        Queue myQueue = new Queue(20);
        int[] data3 = {5,16,20,25,30};
        for (int i : data3){
            myQueue.enqueue(i);
        }
        myQueue.printQueue();

        myQueue.dequeue();
        myQueue.printQueue();

        System.out.println("First in Queue: " + myQueue.getFirst());
        System.out.println("Last in Queue: " + myQueue.getLast());
        System.out.println("Size of Queue: " + myQueue.getLength());

        System.out.println(9 - 3 + (5 + 12 / 3 * 2 ) * (6 - 7 * 4 + 1));
    }
}
