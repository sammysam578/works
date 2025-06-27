import java.util.Scanner;

public class CallCenterQueue {
    private String[] calls;
    private int front, rear, size;

    public CallCenterQueue(int capacity) {
        calls = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addCall(String callId) {
        if (size == calls.length) {
            System.out.println("Call queue is full!");
        } else {
            rear = (rear + 1) % calls.length;
            calls[rear] = callId;
            size++;
        }
    }

    public void handleCall() {
        if (size == 0) {
            System.out.println("No calls to handle!");
        } else {
            System.out.println("Handling: " + calls[front]);
            front = (front + 1) % calls.length;
            size--;
        }
    }

    public void showCalls() {
        if (size == 0) {
            System.out.println("No pending calls.");
        } else {
            System.out.print("Calls in queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(calls[(front + i) % calls.length] + " ");
            }
            System.out.println();
        }
    }

    public void pendingCalls() {
        System.out.println("Pending calls: " + size);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CallCenterQueue ccq = new CallCenterQueue(5);
        int choice;

        do {
            System.out.println("\n1. Add Call");
            System.out.println("2. Handle Call");
            System.out.println("3. Show Call Queue");
            System.out.println("4. Show Pending Calls");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Call ID: ");
                    String id = sc.nextLine();
                    ccq.addCall(id);
                    break;
                case 2:
                    ccq.handleCall();
                    break;
                case 3:
                    ccq.showCalls();
                    break;
                case 4:
                    ccq.pendingCalls();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 5);
    }
}
