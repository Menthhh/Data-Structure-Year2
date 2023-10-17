package code;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE]; // default value 0
    protected int size = 0;

    public MyArrayBasic(int... d) {
        if (d != null) {
            int n = Math.min(d.length, MAX_SIZE); // this line 
            for (int i = 0; i < n; i++) {
                data[i] = d[i];
                size++;
            }
        }
    }

   
    public void insert(int d, int index){
        if (size >= MAX_SIZE) {
            System.out.println("Array is full");
            return;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = d;
        size++;
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == d) {
                return mid;
            } else if (data[mid] < d) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void add(int d) {
        // index out of bound due to overflow
        if (size >= MAX_SIZE) {
            System.out.println("Array is full");
            return;
        }
        data[size] = d;
        size++;
        
    }

    public void delete(int index){
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
    }
}
