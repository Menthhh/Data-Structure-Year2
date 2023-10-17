package code;



public class Stack {
    
    private Node top;
    private int height;

    public class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public Stack(){
        top = null;
        height = 0;
    }

    public void printStack(){
        Node temp = top;
        System.out.print("[");
        while (temp != null){
            System.out.print(temp.value + ",");
            temp = temp.next;
        }
        System.out.print("]\n");
    }

    public void push(int value){
        Node newNode = new Node(value);
        if (height == 0){
            top = newNode;
           
        }else{
            newNode.next = top;
            top = newNode;
           
        }
         height++;
    }

    public Node pop(){
        if (height == 0) return null;
        
        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public int top(){
        return top.value;
    }

    public int size(){
        return height;
    }

}
