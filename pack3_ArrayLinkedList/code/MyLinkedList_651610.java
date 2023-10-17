package code;

public class MyLinkedList_651610 {
    
    public class Node {
        int data;
        Node next;
        public Node(int d) {data = d;}
    }
    Node head = null;

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
        }

    public void insert(int d) 
    {
        Node p = new Node(d);
        if(head==null) {
            head = p;
            return;
        }
        if(head.data>d) {
            p.next = head;
            head = p;
            return;
        }
        Node q = head;
        while(q.next!=null) {
            if(q.next.data>d) {
                p.next = q.next;
                q.next = p;
                return;
            }
            q = q.next;
        }
        q.next = p;
    
    }
       
    public void delete(int d){
        if(head==null) return;
        if(head.data==d) {
            head = head.next;
            return;
        }
        Node p = head;
        while(p.next!=null) {
            if(p.next.data==d) {
                p.next = p.next.next;
                return;
            }
            p = p.next;
        }
    }

    public int find(int d) {
        Node p = head;
        int i = 0;
        while(p!=null) {
            if(p.data==d) return i;
            p = p.next;
            i++;
        }
        return -1;
    }

    public int size() {
        Node p = head;
        int i = 0;
        while(p!=null) {
            p = p.next;
            i++;
        }
        return i;
    }

    public void add(int[] a) {
        for(int i=a.length-1; i>=0; i--) add(a[i]);
    }

    public void insert(int[] a) {
        for(int i=0; i<a.length; i++) insert(a[i]);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
        sb.append("--> [");
        sb.append(p.data);
        sb.append("] ");
        p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }

    public void q1_rotate_clockwise(int k){
        if (k <= 0 || k >= size()) return;
        Node p = head;
        for(int i = 0; i < k - 1; i++){
            p = p.next;
        }
        Node q = p.next;
        p.next = null;
        Node r = q;
        while(r.next != null){
            r = r.next;
        }
        r.next = head;
        head = q;
    }


    public void q2_reverse(){
        Node p = head;
        Node q = null;
        Node r = null;
        while(p!=null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;
    }

    public void q3_remove_dup() {
        Node p = head;
        while(p!=null) {
            Node q = p;
            while(q.next!=null) {
                if(q.next.data==p.data) q.next = q.next.next;
                else q = q.next;
            }
            p = p.next;
        }
    }

    public void q4_increment_digits(){
        Node p = head;
        Node q = null;
        while(p != null){
            if(p.data != 9){
                q = p;
            }
            p = p.next;
        }
        if(q == null){
            q = new Node(0);
            q.next = head;
            head = q;
        }
        q.data++;
        p = q.next;
        while(p != null){
            p.data = 0;
            p = p.next;
        }
    }
    public boolean q5_isPalindrome(){
        Node p = head;
        Node q = head;
        Node r = null;
        while(q!=null && q.next!=null) {
            r = p;
            p = p.next;
            q = q.next.next;
        }
        if(q!=null) p = p.next;
        Node s = null;
        while(p!=null) {
            q = p.next;
            p.next = s;
            s = p;
            p = q;
        }
        while(s!=null) {
            if(s.data!=head.data) return false;
            s = s.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("-demo1--------");
        demo1();
        System.out.println("-demo2--------");
        demo2();
        System.out.println("-q1--------");
        q1();
        System.out.println("-q2--------");
        q2();
        System.out.println("-q3--------");
        q3();
        System.out.println("-q4--------");
        q4();
        System.out.println("-q5--------");
        q5();
    }
    static void demo1() {
        MyLinkedList_651610 list = new MyLinkedList_651610();
        list.add(5);
        list.add(1);
        list.insert(4);
        list.insert(3);
        System.out.println(list);
        list.delete(2);
        System.out.println("5 is at " + list.find(5));
        System.out.println(list);
    }
    static void demo2() {
        MyLinkedList_651610 mList = new MyLinkedList_651610();
        mList.insert(50);
        mList.insert(40);
        mList.insert(30);
        mList.insert(20);
        mList.insert(10);
        System.out.println(mList);
    }
    static void q1() {
        int [] d = {10,20,30,40,50};
        MyLinkedList_651610 mList = new MyLinkedList_651610();
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q1_rotate_clockwise(1);
        System.out.println("(k = " + 1 + ")  -> " + mList);
        mList.q1_rotate_clockwise(3);
        System.out.println("(k = " + 3 + ")  -> " +mList);
        mList.q1_rotate_clockwise(7);
        System.out.println("(k = " + 7 + ")  -> " +mList);
    }
    static void q2() {
        int [] d = {1,2,3,4,5,6,7,8};
        MyLinkedList_651610 mList = new MyLinkedList_651610();
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q2_reverse();
        System.out.println("after  -> " + mList);
    }
    static void q3() {
        int [] d = {13, 11, 4, 15, 4};
        MyLinkedList_651610 mList = new MyLinkedList_651610();
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after  -> " + mList);
        int [] e = {13, 11, 15, 4};
        mList = new MyLinkedList_651610();
        mList.insert(e);
        System.out.println("before -> " + mList);
        mList.q3_remove_dup();
        System.out.println("after  -> " + mList);
    }
    static void q4() {
        int [] d = {1, 9, 9, 9};
        MyLinkedList_651610 mList = new MyLinkedList_651610();
        //mList.add(d);
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q4_increment_digits();     
        System.out.println("after  -> " + mList);  
        /* // bonus 
        d[0] = 9;
        mList.insert(d);
        System.out.println("before -> " + mList);
        mList.q4_increment_digits();     
        System.out.println("after  -> " + mList);      
        */    
    }
    static void q5() {
        int [] d = {21, 33, 33, 21};
        boolean isPalind;
        MyLinkedList_651610 mList = new MyLinkedList_651610();
        mList.add(d);
        isPalind = mList.q5_isPalindrome();     
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] e = {21, 33, 44, 33, 21};
        mList = new MyLinkedList_651610();
        mList.add(e);
        isPalind = mList.q5_isPalindrome();  
        System.out.println(mList + " isPalindrome() = " + isPalind);
        int [] f = {1, 9, 9, 9};
        mList = new MyLinkedList_651610();
        mList.add(f);
        isPalind = mList.q5_isPalindrome();  
        System.out.println(mList + " isPalindrome() = " + isPalind);
    }
}

