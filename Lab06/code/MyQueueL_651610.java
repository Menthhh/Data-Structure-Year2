package code;

class Node { 
    String value; 
    Node next; //next date type is Node, the value is the address of the next node
    public Node(String v) {  
    value = v; 
    next = null; 
    } 
}
  
public class MyQueueL_651610 {
    private Node head, tail;

    public MyQueueL_651610() {
        head = tail = null;
    }
    
    public void enqueue(String d) { 
        Node n = new Node(d); 
        if (head == null)  
        head = tail = n; 
        /* your code  */
        else {
            tail.next = n; 
            tail = n; 
        }
    } 
    
    public String dequeue() {  
        if (isEmpty()) return "";  
        String value = head.value;  
        head = head.next; 
        /* your code  */
        return value; 
    } 
    /* isFull() isEmpty() */ 
    public boolean isEmpty() { 
        return head == null; 
    }

    public boolean isFull() { 
        return false; 
    }

    public String top() { 
        return head.value; 
    }

    public String getLast() { 
        return tail.value; 
    }

    public String dumpToString() { 
        StringBuffer sb = new 
        StringBuffer();  Node n = head; 
        while (n != null) { 
        sb.append(n.value + " ");  n = n.next; 
        } 
        return sb.toString();

    }
    @Override 
    public String toString() {  
        StringBuilder sb = new  StringBuilder();  
        sb.append("First->"); 
        Node temp = head; 
        while (temp != null) {   
            sb.append(temp.value).append("->");  
            temp = temp.next; 
    } 
        sb.append("Last"); 
        return sb.toString(); 
    }

}

     
