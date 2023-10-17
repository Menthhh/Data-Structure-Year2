package code;

public class MyArray extends MyArrayBasic {
    private static final int DEFAULT_MAX_SIZE = 2_000_000;
    private int maxSize;
    
    public MyArray() {
        this(DEFAULT_MAX_SIZE); // Constructor / Default max size

    }

    public MyArray(int max) { // Constructor / Custom max size
        MAX_SIZE = max;
        maxSize = max;
        data = new int[maxSize];
        
    }

    public boolean isFull(){
        return size >= maxSize;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int[] expandByK(int k) {
        int newMaxSize = maxSize * k;
        if (newMaxSize <= maxSize) {
            System.out.println("Overflow! Cannot expand array.");
            return data; // Return the current array as-is
        }

        int[] newData = new int[newMaxSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        MAX_SIZE = newMaxSize;
        data = newData;
        return data;
    }

    public int[] expand() {
        //double max size
        return expandByK(2);
    }

    @Override
    public void add(int d) {
        if (isFull()) {
            System.out.println("Array is full. Expanding the array...");
            //expend the array
            expand();
        }
        super.add(d);
    }

}
