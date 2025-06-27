public class Stack {
    private int[] stack;   
    private int top;       

    
    public Stack(int capacity) {
        stack = new int[capacity]; 
        top = -1; 
    }

    
    public void push(int element) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            stack[top] = element;
        }
    }

    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int popped = stack[top];
            top--;
            return popped;
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

    
    public int size() {
        return top + 1;
    }

    
    public static void main(String[] args) {
        Stack s = new Stack(5);  

        s.push(10);  
        s.push(20);  
        System.out.println("Top: " + s.peek()); 
        System.out.println("Removed: " + s.pop()); 
        System.out.println("Size: " + s.size()); 
    }
}
