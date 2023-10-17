package code;


public class MyArrDemo<T> {
    public final int MAX_SIZE = 9;
    private int size = 0;
    private Object [] arr = new Object[MAX_SIZE];

    public void add(T instance) {
            arr[size++] = instance;
    }

    public void set(int i, T instance) {
            arr[i] = instance;
    }

    public T get(int i) {
        @SuppressWarnings("unchecked")
        final T element = (T)arr[i];
        return element;
    }

    // void swap(int i, int j)
    public void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    // create void selectionSort(MyArrDemo<SillyLuckyNumber> arr)
    public void selectionSort(MyArrDemo<SillyLuckyNumber> arr) {
        for (int i = 0; i < arr.currentSize(); i++) {
            int min = i;
            for (int j = i + 1; j < arr.currentSize(); j++) {
                if (arr.get(j).getLuckyNumber() < arr.get(min).getLuckyNumber()) {
                    min = j;
                }
            }
            arr.swap(i, min);
        }
    }



    public int currentSize() {
        return size;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("My snapshot looks like this -> ");
        for (int i = 0; i < size; i++)
            sb.append(arr[i] + ",");
        return sb.toString();
    }
}