import java.util.Scanner;

public class SuperMarketQueue {
    private String[] queue;
    private int front, rear, size;

    public SuperMarketQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addCustomer(String name) {
        if (size == queue.length) {
            System.out.println("Queue is full!");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = name;
            size++;
        }
    }

    public void serveCustomer() {
        if (size == 0) {
            System.out.println("No one in queue!");
        } else {
            System.out.println("Serving: " + queue[front]);
            front = (front + 1) % queue.length;
            size--;
        }
    }

    public void showQueue() {
        if (size == 0) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Customers: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % queue.length] + " ");
            }
            System.out.println();
        }
    }

    public void countCustomers() {
        System.out.println("Total customers: " + size);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SuperMarketQueue sq = new SuperMarketQueue(5);
        int choice;

        do {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Show Queue");
            System.out.println("4. Count Customers");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    sq.addCustomer(name);
                    break;
                case 2:
                    sq.serveCustomer();
                    break;
                case 3:
                    sq.showQueue();
                    break;
                case 4:
                    sq.countCustomers();
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
            }
        } while (choice != 5);
    }
}
