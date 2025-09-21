/* 
 Class to demonstrate Producer-Consumer problem using threads and synchronization.
 It uses a shared circular buffer of fixed size where:
   - Producers insert items into the buffer.
   - Consumers remove items from the buffer.

 Synchronization ensures that:
   - Producers wait if the buffer is full.
   - Consumers wait if the buffer is empty.
   - Proper notification is given when buffer state changes.

 This implementation prevents race conditions using synchronized blocks,
 wait(), and notifyAll() methods for thread coordination.

 Author: Akshay Basak
 Date: 15-07-2025
*/

package Assignment12;

class SharedBuffer {
    // Static shared array (circular queue)
    static int[] buffer = new int[5];   // size = 5
    static int in = 0;   // points to next write position
    static int out = 0;  // points to next read position
    static int count = 0; // number of items in buffer
}

class Producer extends Thread {
    private int item;

    public Producer(int item) {
        this.item = item;
    }

    @Override
    public void run() {
        synchronized (SharedBuffer.buffer) {
            while (SharedBuffer.count == SharedBuffer.buffer.length) {
                // Buffer is full → Producer must wait
                try {
                    SharedBuffer.buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Insert item into circular queue
            SharedBuffer.buffer[SharedBuffer.in] = item;
            System.out.println("Producer produced: " + item);

            SharedBuffer.in = (SharedBuffer.in + 1) % SharedBuffer.buffer.length;
            SharedBuffer.count++;

            // Notify consumer(s)
            SharedBuffer.buffer.notifyAll();
        }
    }
}

class Consumer extends Thread {
    private int id;

    public Consumer(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (SharedBuffer.buffer) {
            while (SharedBuffer.count == 0) {
                // Buffer is empty → Consumer must wait
                try {
                    SharedBuffer.buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Fetch item from circular queue
            int item = SharedBuffer.buffer[SharedBuffer.out];
            System.out.println("Consumer " + id + " consumed: " + item);

            SharedBuffer.out = (SharedBuffer.out + 1) % SharedBuffer.buffer.length;
            SharedBuffer.count--;

            // Notify producer(s)
            SharedBuffer.buffer.notifyAll();
        }
    }
}

// Test class with main
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        // Create multiple producers and consumers
        for (int i = 1; i <= 10; i++) {
            new Producer(i).start();  // Produces items 1 to 10
        }

        for (int i = 1; i <= 10; i++) {
            new Consumer(i).start();  // Consumers
        }
    }
}
