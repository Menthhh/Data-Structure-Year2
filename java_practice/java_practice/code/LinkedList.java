package code;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    
    //create new Nde
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
        
    }
    //for undefined constructor 
    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public void printList(){
        Node temp = head;
        System.out.print("[");
        while (temp != null){
            System.out.print(temp.value + ",");
            temp = temp.next;
        }
        System.out.print("]\n");
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0 ){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode; //point the tail next to New Node
            tail = newNode; // change tail to new node
        }
        length++;
    }

    // it will return Node
    //Note Node have value, and next. 
    public Node removeLast(){
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst(){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node Get(int index){
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean Set(int index, int value){
        Node temp = Get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index >= length) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = Get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node temp = Get(index - 1);
        Node removed = temp.next;
        temp.next = removed.next;
        removed.next = null;
        length--;
        return removed;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        for (int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
            
        }
    }

    public int getHead(){
        return head.value;
    }

    public int getTail(){
        return tail.value;
    }

    public int size(){
        return length;
    }

    
}
