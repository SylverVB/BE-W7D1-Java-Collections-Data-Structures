# Sets

The Set interface contains only methods inherited from Collection and adds the restriction that duplicate elements are prohibited.

Set also adds a stronger contract on the behavior of the equals and hashCode operations, allowing Set instances to be compared meaningfully even if their implementation types differ.

## HashSet

A HashSet implements Set and is backed by a HashMap. It:

- Guarantees no ordering when iterating
- Allows one null value
- Allows fast insertion and traversal
- Does not maintain order in which you insert elements

## TreeSet

A TreeSet is a Set whose elements maintain sorted order when inserted. Internally, it is backed by a Sorted Tree. Insertion and removal of elements is slow because the elements must maintain sorted order. It cannot contain any null values since null cannot be compared to any object.

The methods declared by Set are summarized as follows:

### `add()`
Adds an object to the collection.

The `add()` method adds an object to the collection if it is not already present. It returns `true` if the element was added successfully, and `false` if the element was already present.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        
        // Adding elements to the set
        System.out.println("Add 'apple': " + set.add("apple")); // true
        System.out.println("Add 'banana': " + set.add("banana")); // true
        System.out.println("Add 'apple' again: " + set.add("apple")); // false (duplicate)
        
        System.out.println(set); // Output: [apple, banana]
    }
}
```

### `clear()`
Removes all objects from the collection.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        
        System.out.println("Before clear: " + set); // Output: [apple, banana]
        
        // Clearing the set
        set.clear();
        
        System.out.println("After clear: " + set); // Output: []
    }
}
```

### `contains()`
Returns `true` if a specified object is an element within the collection.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        
        // Checking if the set contains a certain element
        System.out.println("Contains 'apple': " + set.contains("apple")); // true
        System.out.println("Contains 'orange': " + set.contains("orange")); // false
    }
}
```

### `isEmpty()`
Checks if the set contains no elements. Returns `true` if the collection has no elements.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        
        System.out.println("Is the set empty? " + set.isEmpty()); // true
        
        set.add("apple");
        
        System.out.println("Is the set empty? " + set.isEmpty()); // false
    }
}
```

### `iterator()`
Returns an Iterator object for the collection, which may be used to retrieve an object.

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        
        // Getting the iterator for the set
        Iterator<String> iterator = set.iterator();
        
        // Iterating over the set elements
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

### `remove()`
Removes a specified object from the collection.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        
        System.out.println("Before removal: " + set); // Output: [apple, banana]
        
        // Removing an element from the set
        set.remove("apple");
        
        System.out.println("After removal: " + set); // Output: [banana]
    }
}
```

### `size()`
Returns the number of elements in the collection.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        
        // Adding elements to the set
        set.add("apple");
        set.add("banana");
        
        // Getting the size of the set
        System.out.println("Size of the set: " + set.size()); // 2
        
        // Adding another element
        set.add("orange");
        
        System.out.println("Size of the set after adding orange: " + set.size()); // 3
    }
}
```

---

# Summary of Method Outputs:
- **add()**: Adds an element if it is not already in the set, and returns `true` if the element is added, otherwise `false`.
- **clear()**: Removes all elements from the set.
- **contains()**: Returns `true` if the element is in the set, otherwise `false`.
- **isEmpty()**: Returns `true` if the set is empty, otherwise `false`.
- **iterator()**: Returns an iterator to iterate through the elements.
- **remove()**: Removes a specified element from the set.
- **size()**: Returns the number of elements in the set.

The `Set` interface has implementations in various classes like `HashSet`, `TreeSet`, and `LinkedHashSet`. Below is an example to explain `Set` functionality:

---

# Set Example in Java

```java
import java.util.*;

public class SetDemo {
    public static void main(String args[]) { 
        int count[] = {34, 22, 10, 60, 30, 22};
        Set<Integer> set = new HashSet<Integer>();

        try {
            for (int i = 0; i < 5; i++) {
                set.add(count[i]);
            }
            System.out.println(set);

            TreeSet<Integer> sortedSet = new TreeSet<Integer>(set);
            System.out.println("The sorted list is:");
            System.out.println(sortedSet);

            System.out.println("The First element of the set is: " + sortedSet.first());
            System.out.println("The last element of the set is: " + sortedSet.last());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Output:
```
[34, 22, 10, 60, 30]
The sorted list is:
[10, 22, 30, 34, 60]
The First element of the set is: 10
The last element of the set is: 60
```

---

# Operations on the Set Interface

The `Set` interface allows users to perform basic set operations. Let’s use two sets of numbers to understand these operations:

```
Set 1: [1, 3, 2, 4, 8, 9, 0]
Set 2: [1, 3, 7, 5, 4, 0, 7, 5]
```

- **Intersection**: Returns all common elements from both sets.
  ```
  Intersection = [0, 1, 3, 4]
  ```
- **Union**: Combines all elements from both sets.
  ```
  Union = [0, 1, 2, 3, 4, 5, 7, 8, 9]
  ```
- **Difference**: Removes all values in one set from the other.
  ```
  Difference = [2, 8, 9]
  ```

---

# Summary of `HashSet` and `TreeSet` in Java

## 1. **HashSet**
- **Purpose**: A collection that stores unique elements with no guarantee of order.
- **Implementation**: Uses a **hash table** (`HashMap`) internally.
- **Key Features**:
  - **Fast Operations**: Average time complexity for add, remove, and check operations is **O(1)**.
  - **No Order**: Elements are stored arbitrarily.
  - **Allows Null**: Can store a single `null` element.
  - **Not Synchronized**: Requires external synchronization for thread-safe operations.
  
- **Real-World Applications**:
  1. Storing unique items (e.g., usernames, email addresses).
  2. Removing duplicates from a dataset.
  3. Fast existence checks (e.g., is a value present?).

---

## 2. **TreeSet**
- **Purpose**: Stores unique elements in **sorted order**.
- **Implementation**: Uses a **red-black tree** (self-balancing BST).
- **Key Features**:
  - **Sorted Order**: Maintains elements in ascending order.
  - **Custom Ordering**: Supports custom comparators.
  - **Moderate Performance**: Time complexity for operations is **O(log n)**.
  - **Does Not Allow Null**: Throws `NullPointerException` if `null` is added.
  - **NavigableSet**: Supports `headSet()`, `tailSet()`, and `subSet()`.

- **Real-World Applications**:
  1. Storing sorted data (timestamps, scores, names).
  2. Range-based queries (fetch elements between two values).
  3. Maintaining a collection where order matters.

---

## Comparison of `HashSet` and `TreeSet`

| Feature                  | HashSet                  | TreeSet                   |
|--------------------------|--------------------------|---------------------------|
| **Underlying Structure** | Hash table (`HashMap`)   | Red-black tree            |
| **Order**                | Unordered                | Sorted                    |
| **Performance**          | O(1) for add/remove      | O(log n) for add/remove   |
| **Null Handling**        | Allows one `null`        | Does not allow `null`     |
| **Use Case**             | Fast lookups, uniqueness | Sorted data, range queries|

---

# Examples of `HashSet` and `TreeSet`

## 1. **HashSet Example**

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> set = new HashSet<>();

        // Add elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate, won't be added

        // Display elements in HashSet (order is not guaranteed)
        System.out.println("HashSet: " + set);

        // Check if an element exists
        System.out.println("Contains 'Apple'? " + set.contains("Apple"));

        // Remove an element
        set.remove("Banana");
        System.out.println("After removing 'Banana': " + set);

        // Get the size of the HashSet
        System.out.println("Size: " + set.size());

        // Clear all elements
        set.clear();
        System.out.println("Is HashSet empty? " + set.isEmpty());
    }
}
```

### **Output:**
```
HashSet: [Apple, Cherry, Banana]
Contains 'Apple'? true
After removing 'Banana': [Apple, Cherry]
Size: 2
Is HashSet empty? true
```

---

## 2. **TreeSet Example**

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Add elements to the TreeSet
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(5); // Duplicate, won't be added

        // Display elements in sorted order
        System.out.println("TreeSet: " + treeSet);

        // Access the first and last elements
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());

        // Remove an element
        treeSet.remove(3);
        System.out.println("After removing '3': " + treeSet);

        // Subset: Get elements less than 4
        System.out.println("HeadSet (<4): " + treeSet.headSet(4));

        // Subset: Get elements between 2 and 5
        System.out.println("SubSet (2 to 5): " + treeSet.subSet(2, 5));
    }
}
```

### **Output:**
```
TreeSet: [1, 2, 3, 5]
First element: 1
Last element: 5
After removing '3': [1, 2, 5]
HeadSet (<4): [1, 2]
SubSet (2 to 5): [2]
```

---

# Key Differences Demonstrated

- **HashSet**: Does not maintain any order, making it suitable for fast lookups and uniqueness checks.
- **TreeSet**: Maintains elements in ascending order and supports range queries (e.g., subsets).

---

## HashSets vs. Hash Tables

### 1. Hash Table:
   - A hash table is a data structure used to store key-value pairs.
   - It uses a hashing function to compute the index at which the value associated with a specific key will be stored.
   - Hash tables are the foundation of many data structures, including `HashMap` and `HashSet`.

### 2. HashSet:
   - A HashSet is a specific collection class in Java.
   - It internally uses a 'HashMap' (which relies on a hash table) to store its elements.
   - Unlike hash tables, a 'HashSet' does not deal with key-value pairs; it only stores unique values.
   - The uniqueness and fast lookup of elements in a `HashSet` are achieved through hashing.

---

## Why Does the Real-World Application Mention Hash Tables?

When discussing real-world applications, it's common to focus on the underlying data structure (in this case, hash tables) rather than the specific implementation (like `HashSet`). This is because:
1. The **HashSet** internally relies on a hash table (`HashMap` in Java).
2. The applications of a `HashSet` (e.g., ensuring unique elements, fast lookup) are direct benefits of the hashing mechanism provided by the hash table.

---

## What Are Real-World Applications of HashSet?

If you are specifically studying `HashSet`, the following applications are more appropriate:

### 1. Ensuring Uniqueness:
   - Storing unique items like usernames, product IDs, or email addresses.
   - Removing duplicates from a collection (e.g., a list of integers or strings).

### 2. Fast Lookup:
   - Checking whether an element exists in a dataset (e.g., validating user access).
   - Maintaining a set of visited nodes in graph traversal.

### 3. Set Operations:
   - Efficiently performing set operations like union, intersection, and difference.

---

## Applications of TreeSet

The listed applications for trees are accurate but generic. If discussing `TreeSet` specifically, you can focus on:

### 1. Sorted Data:
   - Storing items like timestamps, scores, or names where sorted order is crucial.

### 2. Range Queries:
   - Fetching subsets of data within a specific range, such as dates in a calendar.

### 3. Custom Sorting:
   - Using a custom comparator to maintain specific ordering of elements.

---

## Conclusion

The real-world applications of `HashSet` provided in the text seem to discuss hash tables more broadly rather than the specific use cases of `HashSet`. For clarity:
- If you're discussing `HashSet`, emphasize its use for uniqueness, fast lookup, and set operations.
- If you're discussing hash tables, the broader applications listed are relevant.

---

## LinkedHashSet

- It is implemented as a hash table with a linked list running through it.
- It preserves the insertion order of elements.
- Like HashSet, it does not allow duplicate elements, but unlike HashSet, it maintains the order in which elements were added.