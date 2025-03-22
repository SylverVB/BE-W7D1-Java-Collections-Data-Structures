package QueueLab;

import java.util.Deque;
import java.util.Queue;
import java.util.ArrayDeque;

/**
 * Demonstrates the use of Queue and Deque data structures in Java.
 * 
 * Queues follow the FIFO (First In, First Out) principle, similar to a checkout line. They are used in algorithms where 
 * it is necessary to keep track of the order in which elements were inserted. For example, tech support tickets may be
 * waiting in a queue until a tech support specialist can address them.
 * 
 * For example, 
 * adding to the back of the queue:
 * 1 | 1 | 1
 *   | 2 | 2 
 *   |   | 3
 * then, removing from the front of the queue:
 * 1 | 2 | 3
 * 2 | 3 |  
 * 3 |   |  
 * 
 * ArrayDeque serves as both a queue and a stack. A Deque can be thought of as a deck of cards (pronounced the
 * same), where cards can be removed from either the top or the bottom. ArrayDeque can be used to perform queue 
 * operations. More information about ArrayDeque can be found in the official Javadocs here:
 * https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html
 * Additionally, more details about the Queue interface can be found here:
 * https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
 * Note that ArrayDeque implements multiple interfaces, including Queue!
 *
 * PriorityQueue is another implementation of Queue that provides additional functionality
 * for handling multiple 'priorities' of items.
 */
public class Lab {
    /**
     * Instantiate and return some type of Deque, which is a class that contains Queue and Stack functionality.
     * @return an instantiated Deque. Queue, by itself, doesn't have a class, so we should use a class that
     * implements the Queue interface, such as ArrayDeque. Deques contain all the methods required for both Queue and
     * Stack behavior.
     */
    public Deque<String> createQueue(){
        return new ArrayDeque<>();
    }

    /**
     * Return the size of a queue.
     * @param queue A Queue<String> object.
     * @return The length of queue.
     */
    public int getSize(Queue<String> queue){
        return queue.size();
    }

    /**
     * Adds an item to the end of the queue. The item will be processed once all items before it have been removed.
     * @param queue A Queue<String> object.
     * @param item The item to be added to the queue.
     */
    public void addToEndOfQueue(Queue<String> queue, String item){
        queue.add(item);
    }

    /**
     * Removes and returns the item at the front of the queue.
     * @param queue A Queue<String> object.
     * @return The item at the front of the queue (the oldest item).
     */
    public String removeFromStartOfQueue(Queue<String> queue){
        return queue.poll();
    }

    /**
     * Returns the next item from a queue which is due to be removed, but do not remove it. 
     * This is referred to as a 'peek'.
     * @param queue a Queue<String> object.
     * @return The item at the front of the queue (the oldest item), or null if the queue is empty.
     */
    public String getStartOfQueueWithoutRemoving(Queue<String> queue){
        return queue.peek();
    }
}