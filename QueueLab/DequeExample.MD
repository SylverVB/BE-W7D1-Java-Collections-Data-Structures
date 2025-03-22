# Queue and Deque in Java

## Introduction

To visualize a queue, let's use a quick analogy. Imagine we've just opened our first business – a hot dog stand. We want to serve our new potential clients in the most efficient way possible for our small business; one at a time. We ask them to form an orderly line in front of our stand, with new customers joining at the rear. Those who get in line first will be served first, and this will allow us to distribute our tasty hot dogs in a fair way.

Queues in Java work in a similar way. Queues place objects on a “waiting list”, typically based on First-In-First-Out (FIFO) and are useful for storing objects prior to processing them. After we declare our Queue, we can add new elements to the back (tail), and remove them from the front (head).

Some queue-specific methods are:
- **offer()** – Inserts a new element onto the Queue
- **poll()** – Removes an element from the front of the Queue
- **peek()** – Inspects the element at the front of the Queue, without removing it

### PriorityQueue Exception

One such exception to the FIFO rule is the PriorityQueue. When new elements are inserted into the PriorityQueue, they are ordered based on their natural ordering, or by a defined Comparator provided when we construct the PriorityQueue. Priority queues are discussed in detail in a separate topic.

## Sub-Interfaces

Generally, the Queue interface is inherited by three main sub-interfaces: **Blocking Queues**, **Transfer Queues**, and **Deques**.

Together, these three interfaces are implemented by the vast majority of Java's available Queues. Let's take a quick look at what these interfaces have been set out to do.

### Blocking Queues

The **BlockingQueue** interface supports additional operations which force threads to wait on the Queue depending on the current state. A thread may wait on the Queue to be non-empty when attempting a retrieval, or for it to become empty when adding a new element.

Standard Blocking Queues include:
- **LinkedBlockingQueue**
- **SynchronousQueue**
- **ArrayBlockingQueue**

### Transfer Queues

The **TransferQueue** interface extends the BlockingQueue interface but is tailored toward the producer-consumer pattern. It controls the flow of information from producer to consumer, creating backpressure in the system.

Java includes one implementation of the TransferQueue interface:
- **LinkedTransferQueue**

### Deques

**Deque** (pronounced "deck") is short for **Double-Ended Queue** and is analogous to a deck of cards – elements may be taken from both the start and end of the Deque. Much like the traditional Queue, the Deque provides methods to add, retrieve, and peek at elements held at both the top and bottom. Deques can be used to implement a stack, with Last-In-First-Out (LIFO) behavior.

Some Deque implementations include:
- **LinkedList**
- **ArrayDeque**

## Commonly Used Implementing Classes

- **LinkedList**: Implements both the List and Deque interfaces.
- **ArrayDeque**: Resizable-array implementation of the Deque interface that is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
- **ArrayBlockingQueue**: Array-backed, implements BlockingQueue interface which supports operations that wait on the queue to contain an element or for space to become available in the queue. Solution to the producer-consumer problem, where a producer thread inputs elements into the array while a consumer thread removes them for processing.
- **PriorityQueue**: Elements in the queue are ordered by priority based on their natural ordering (or a Comparator).

## Thread Safety

Adding items to Queues is particularly useful in multi-threaded environments. A Queue can be shared amongst threads, and be used to block progress until space is available – helping us overcome some common multi-threaded problems.

For example, writing to a single disk from multiple threads creates resource contention and can lead to slow writing times. Creating a single writer thread with a BlockingQueue can alleviate this issue and lead to vastly improved write speeds.

Luckily, Java offers **ConcurrentLinkedQueue**, **ArrayBlockingQueue**, and **ConcurrentLinkedDeque**, which are thread-safe and perfect for multi-threaded programs.

## Real World Application

Queues are used when things don’t have to be processed immediately, but have to be processed in First In First Out order. This property of Queue makes it also useful in the following kinds of scenarios:
- When a resource is shared among multiple consumers. Examples include CPU scheduling, Disk Scheduling.
- When data is transferred asynchronously (data not necessarily received at the same rate as sent) between two processes. Examples include IO Buffers, pipes, file IO, etc.
- In Operating Systems:
  - Semaphores
  - FCFS (First Come First Serve) scheduling, example: FIFO queue
  - Spooling in printers
  - Buffer for devices like keyboards
- In Networks:
  - Queues in routers/ switches
  - Mail Queues

Some other applications of Queue:
- Waiting lists for a single shared resource like CPU, Disk, Printer.
- Buffers on MP3 players and portable CD players.
- How operating systems handle interruptions/exceptions.
- Add a song at the end of a playlist.

## Implementation

### Creating Queue Objects

Since Queue is an interface, objects cannot be created of the type Queue. We always need a class which implements this interface in order to create an object. And also, after the introduction of Generics in Java 1.5, it is possible to restrict the type of object that can be stored in the Queue. The following is an example of creating a queue:

```java
Queue<Obj> queue = new PriorityQueue<Obj>();
```

### Example Queue

```java
// Java program to demonstrate a Queue
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Adds elements {0, 1, 2, 3, 4} to the queue
        for (int i = 0; i < 5; i++)
            q.add(i);

        // Display contents of the queue
        System.out.println("Elements of queue: " + q);

        // To remove the head of queue
        int removedEle = q.remove();
        System.out.println("Removed element: " + removedEle);

        System.out.println(q);

        // To view the head of queue
        int head = q.peek();
        System.out.println("Head of queue: " + head);

        // Rest all methods of collection interface like size and contains can be used with this implementation.
        int size = q.size();
        System.out.println("Size of queue: " + size);
    }
}
```

### Creating Deque Objects

Since Deque is an interface, objects cannot be created of the type Deque. We always need a class that implements this interface in order to create an object. And also, after the introduction of Generics in Java 1.5, it is possible to restrict the type of object that can be stored in the Deque.

```java
// Java program to demonstrate the working of a Deque in Java
import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();

        // We can add elements to the queue in various ways

        // Add at the last
        deque.add("Element 1 (Tail)");

        // Add at the first
        deque.addFirst("Element 2 (Head)");

        // Add at the last
        deque.addLast("Element 3 (Tail)");

        // Add at the first
        deque.push("Element 4 (Head)");

        // Add at the last
        deque.offer("Element 5 (Tail)");

        // Add at the first
        deque.offerFirst("Element 6 (Head)");

        System.out.println(deque + "\n");

        // We can remove the first element or the last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing first and last: " + deque);
    }
}
```

### Summary

- **Queue** places objects on a “waiting list”, typically based on First-In-First-Out (FIFO).
  - Useful for storing objects prior to processing.
  - Elements are added to the tail of the queue.
  - Elements can be removed from the front of the queue.
  
- **Deque Interface** extends the Queue interface.
  - Short for “double-ended queue”.
  - Pronounced “deck”.
  - Supports element insertion and removal from both ends of the queue.
  - Can be used to implement a stack, with Last-In-First-Out (LIFO) behavior.

- **Queue implementations** include:
  - LinkedList
  - ArrayDeque
  - PriorityQueue
  - ArrayBlockingQueue

### Methods for Deque

1. **`add()`**:
   - Adds an element to the tail (the end) of the deque.
   - Example: `deque.add("Element 1 (Tail)")`.

2. **`addFirst()`**:
   - Adds an element to the front (head) of the deque.
   - Example: `deque.addFirst("Element 2 (Head)")`.

3. **`addLast()`**:
   - Adds an element to the tail (end) of the deque, similar to `add()`.
   - Example: `deque.addLast("Element 3 (Tail)")`.

4. **`push()`**:
   - Adds an element to the front (head) of the deque. It’s similar to `addFirst()`, but specifically associated with the "stack-like" nature of deques.
   - Example: `deque.push("Element 4 (Head)")`.

5. **`offer()`**:
   - Adds an element to the tail (end) of the deque. It behaves the same way as `add()`, but doesn't throw an exception if the deque is full.
   - Example: `deque.offer("Element 5 (Tail)")`.

6. **`offerFirst()`**:
   - Adds an element to the front (head) of the deque, just like `addFirst()`, but it returns `false` if the element cannot be added.
   - Example: `deque.offerFirst("Element 6 (Head)")`.

### Comparison to Queue Methods

- **Queue Methods (typical)**:
   - `add()`: Adds an element at the tail (like `Deque.addLast()`).
   - `offer()`: Adds an element at the tail (like `Deque.offerLast()`), but returns `false` if the element cannot be added.
   - `peek()`: Views the element at the head without removing it.
   - `poll()`: Removes and returns the element at the head.

- **Deque Methods (additional capabilities)**:
   - `addFirst()`: Adds an element to the front (head), not available in `Queue`.
   - `addLast()`: Adds an element to the tail (like `add()` in `Queue`).
   - `push()`: Adds an element to the front (head), behaving similarly to `addFirst()`, but intended for stack-like behavior.
   - `offerFirst()`: Adds an element to the front (head), similar to `offer()` in `Queue`, but allows for `false` return when it cannot be added.

### Example with Deque

```java
import java.util.*;

public class DequeExample2 {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // Add to the tail
        deque.add("Element 1 (Tail)");
        deque.addLast("Element 2 (Tail)");
        deque.offer("Element 3 (Tail)");

        // Add to the head
        deque.addFirst("Element 4 (Head)");
        deque.push("Element 5 (Head)");
        deque.offerFirst("Element 6 (Head)");

        // Display all elements
        System.out.println("Deque: " + deque);
    }
}
```

#### Output:

```
Deque: [Element 6 (Head), Element 5 (Head), Element 4 (Head), Element 1 (Tail), Element 2 (Tail), Element 3 (Tail)]
```

### Key Differences

- **Queue** only supports operations from one end: typically **adding** elements at the tail and **removing** from the head.
- **Deque** supports operations at both ends, so you can add or remove elements from the **head** and **tail** of the queue, making it more flexible.

### In Summary:

- The methods for `Deque` are similar to those for `Queue`, but with additional methods to handle the head and tail of the deque, providing greater flexibility in how elements are added and removed.