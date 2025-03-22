// Exercise
// Write a Java program that uses the Queue interface to create a line of twelve customers, 
// then assigns delicatessen ticket numbers, starting at 1 to those customers, in the proper order.

package QueueLab.QueueExercise;

import java.util.*;

public class DelicatessenQueue {
    public static void main(String[] args) {
        // Create a Queue to represent the line of customers
        Queue<String> queue = new LinkedList<>();
        
        // Add customers to the queue
        for (int i = 1; i <= 12; i++) {
            queue.add("Customer " + i);
        }
        
        // Assign ticket numbers starting from 1
        int ticketNumber = 1;
        
        // Process customers in the queue and assign ticket numbers
        while (!queue.isEmpty()) {
            String customer = queue.poll(); // Remove customer from the queue
            System.out.println(customer + " gets ticket number: " + ticketNumber);
            ticketNumber++; // Increment the ticket number for the next customer
        }
    }
}