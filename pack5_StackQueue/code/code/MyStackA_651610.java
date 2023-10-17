package code;

public class MyStackA_651610 {
    int MAX_SIZE = 100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;

    public void push(double d) {
        if (top < MAX_SIZE) {
            stack[top++] = d;
        } else {
            System.out.println("Stack is full. Cannot push element.");
        }
    }

    public double pop() {
        if (!isEmpty()) {
            return stack[--top];
        } else {
            System.out.println("Stack is empty. Cannot pop element.");
            return Double.NaN; // Return a special value to indicate an error or empty stack
        }
    }

    public boolean isFull() {
        return top == MAX_SIZE;
    }

    public boolean isEmpty() {
        return top == 0;
    }

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("top->");
		for(int i = top-1; i>=0; i--) {
			sb.append("[");
			sb.append(stack[i]);
			sb.append("]->");
		}
		sb.append("bottom");
		return sb.toString();
	}
}

