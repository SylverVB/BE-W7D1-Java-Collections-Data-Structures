package QueueLab;

import java.util.Deque;

public class Application {
    /**
     * This class contains a main method to manually test Queue operations.
     * The tests verify key functionalities such as adding, removing, and peeking elements in the queue.
     * 
     * No changes made here affect automated test cases; manual verification is recommended.
     * All core implementation logic is in the Lab class.
     */
    public static void main(String[] args) {
        Lab queueLab = new Lab();
        System.out.println("Was the queue properly instantiated? this will print '[]' if yes, null if no");
        Deque<String> myQueue = queueLab.createQueue();
        System.out.println(myQueue);

        System.out.println("Can we add 'item 1' to the back of the queue? Now the values are:");
        queueLab.addToEndOfQueue(myQueue, "item 1");
        System.out.println(myQueue);

        System.out.println("Can we add 'item 2' to the back of the queue? Now the values are:");
        queueLab.addToEndOfQueue(myQueue, "item 2");
        System.out.println(myQueue);

        System.out.println("Can we remove an item from the front of the queue? Now the values are:");
        queueLab.removeFromStartOfQueue(myQueue);
        System.out.println(myQueue);

        System.out.println("Can we peek the front of the queue without removing it? The value is:");
        System.out.println(queueLab.getStartOfQueueWithoutRemoving(myQueue));
    }
}