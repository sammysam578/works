public class CustomStack {
    private int[] stack;
    private int top;

    public CustomStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full!");
        } else {
            top++;
            stack[top] = val;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public static void main(String[] args) {
        CustomStack myStack = new CustomStack(3);
        myStack.push(5);
        myStack.push(10);
        myStack.push(15);
        myStack.push(20);
        System.out.println("Top is: " + myStack.peek());
    }
}
