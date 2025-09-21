import java.util.Scanner;

// Custom Exception: Queue Overflow
class QueueOverflowException extends Exception {
    public QueueOverflowException(String message) {
        super(message);
    }
}

// Custom Exception: Queue Underflow
class QueueUnderflowException extends Exception {
    public QueueUnderflowException(String message) {
        super(message);
    }
}

// Queue ADT
class QueueADT {
    private int[] arr;
    private int front, rear, size, capacity;

    // Constructor
    public QueueADT(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void enQueue(int value) throws QueueOverflowException {
        if (size == capacity) {
            throw new QueueOverflowException("Queue Overflow! Cannot insert " + value);
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    // Dequeue
    public int deQueue() throws QueueUnderflowException {
        if (size == 0) {
            throw new QueueUnderflowException("Queue Underflow! Queue is empty.");
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Get front element
    public int getFront() throws QueueUnderflowException {
        if (size == 0) {
            throw new QueueUnderflowException("Queue is empty! No front element.");
        }
        return arr[front];
    }

    // Get rear element
    public int getRear() throws QueueUnderflowException {
        if (size == 0) {
            throw new QueueUnderflowException("Queue is empty! No rear element.");
        }
        return arr[rear];
    }

    // Get current length
    public int getLength() {
        return size;
    }

    // Display queue
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

// Driver Class
public class QueueDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Get queue capacity from user
            System.out.print("Enter maximum size of the queue: ");
            int maxSize = sc.nextInt();

            QueueADT queue = new QueueADT(maxSize);

            boolean running = true;
            while (running) {
                System.out.println("\n--- Queue Operations ---");
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.println("3. Get Front");
                System.out.println("4. Get Rear");
                System.out.println("5. Get Length");
                System.out.println("6. Display Queue");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter value to enqueue: ");
                            int val = sc.nextInt();
                            queue.enQueue(val);
                            break;
                        case 2:
                            System.out.println("Dequeued: " + queue.deQueue());
                            break;
                        case 3:
                            System.out.println("Front: " + queue.getFront());
                            break;
                        case 4:
                            System.out.println("Rear: " + queue.getRear());
                            break;
                        case 5:
                            System.out.println("Current Length: " + queue.getLength());
                            break;
                        case 6:
                            queue.display();
                            break;
                        case 7:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice! Try again.");
                    }
                } catch (QueueOverflowException | QueueUnderflowException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
        } finally {
            sc.close();
        }
    }
}
