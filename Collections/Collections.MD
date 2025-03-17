# **Collections Framework**  

The Collections Framework in Java is a set of classes and interfaces that implement commonly used data structures. A collection is a single object that acts as a container for other objects. The Collections API is organized in a class hierarchy shown in the simplified version below:  

## **Collection API Class Hierarchy**  

The important interfaces in the Collections API are:  

- **Iterable** - guarantees the collection can be iterated over  
- **List** - an ordered collection  
- **Set** - a collection that does not contain duplicates  
- **Queue** - a collection that operates on a first-in-first-out (FIFO) basis  
- **Map** - contains key/value pairs. Does not extend `Iterable`  

## **Collection Interface**  

- The basic interface of the collections framework is the `Collection` interface, which is the root interface of all collections in the API.  
- It is placed at the top of the collection hierarchy in Java. It provides the basic operations for adding and removing elements in the collection.  
- `List`, `Queue`, and `Set` are three interfaces that extend the `Collection` interface.  
- An important note is that the `Map` interface does not extend the `Collection` interface, though it is considered part of the Java Collection API.  
- Another important note is that the `Collection` interface extends the `Iterable` interface. The `Iterable` interface has only one method called `iterator()`. The function of the `iterator` method is to return the iterator object. Using this iterator object, we can iterate over the elements of the collection.  

---

## **List Interface**  

- This interface represents a collection of elements whose elements are arranged in a sequential order.  
- A list retains the order in which we add elements using indexes.  
- This same sequence is used to retrieve elements.  
- With lists, a developer can insert elements into the list at any location.  
- The list allows storing duplicate elements in Java.  
- `ArrayList`, `Vector`, and `LinkedList` are three concrete subclasses that implement the list interface.  

---

## **Set Interface**  

- This interface represents a collection of elements that contains unique elements.  
- The `Set` interface does not maintain any order while storing elements.  
- When retrieving elements, elements are not guaranteed to be retrieved in the same order as they were added to the collection.  
- A set does not allow any duplicate elements.  
- The `HashSet`, `LinkedHashSet`, and `TreeSet` classes implement the `Set` interface. `TreeSet` also implements the `SortedSet` interface which extends the `Set` interface.  
- A set can be iterated by using an iterator, but it cannot be iterated using a list iterator.  

---

## **SortedSet Interface**  

- This interface extends a set whose iterator traverses its elements according to their natural ordering.  
- `TreeSet` implements the `SortedSet` interface.  

---

## **Queue Interface**  

- A queue is an ordered collection in which new elements are added at one end (the rear) and removed from the other end (the front). Just like a queue in a supermarket.  
- This interface represents a special type of list whose elements are removed only from the head.  
- `LinkedList`, `PriorityQueue`, `ArrayQueue`, `PriorityBlockingQueue`, and `LinkedBlockingQueue` are the concrete subclasses that implement the `Queue` interface.  

---

## **Deque Interface**  

- A deque (double-ended queue) is a sub-interface of the `Queue` interface.  
- This interface was added to the collection framework in Java SE 6.  
- The `Deque` interface extends the `Queue` interface and uses its method to implement deque.  
- A deque is a linear collection of elements in which elements can be inserted and removed from either end.  
- `LinkedList` and `ArrayDeque` classes implement the `Deque` interface.  

---

## **Map Interface**  

- The `Map` interface is not inherited by the `Collection` interface. It represents an object that stores and retrieves elements in the form of key/value pairs, and their location within the map is determined by a key.  
- Maps utilize hashing techniques to manage key-value pairs.  
- Maps do not allow for duplicate keys; however, duplicate values are allowed.  
- The `HashMap`, `HashTable`, `LinkedHashMap`, and `TreeMap` classes implement the `Map` interface.  

---

## **SortedMap Interface**  

- This interface represents a map whose elements are stored in their natural ordering. It extends the `Map` interface, which in turn is implemented by `TreeMap` classes.  

---

## **Methods of the Collection Interface**  

The `Collection` interface consists of a total of fifteen methods for manipulating elements in the collection. They are as follows:  

### **1. add()**
- This method is used to add or insert an element in the collection.  
- **Syntax:**  
  ```java
  add(Object element): boolean
  ```
- If the element is added to the collection, this method will return `true`. Otherwise, it will return `false` if the element is already present and the collection doesn’t allow duplicates.  

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class AddExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        boolean isAdded = collection.add("Apple");
        System.out.println("Added: " + isAdded); // Output: Added: true
        System.out.println("Collection: " + collection); // Output: Collection: [Apple]
    }
}
```
---

### **2. addAll()**
- This method adds a collection of elements to the collection.  
- **Syntax:**  
  ```java
  addAll(Collection c): boolean
  ```
- Returns `true` if the elements are added; otherwise, it returns `false`.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class AddAllExample {
    public static void main(String[] args) {
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("Apple");
        collection1.add("Banana");

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Cherry");
        collection2.add("Date");

        boolean isAdded = collection1.addAll(collection2);
        System.out.println("Added: " + isAdded); // Output: Added: true
        System.out.println("Collection1: " + collection1); // Output: Collection1: [Apple, Banana, Cherry, Date]
    }
}
```

# **Methods of the Collection Interface**  

The `Collection` interface consists of a total of fifteen methods for manipulating elements in the collection. They are as follows:  

## **1. add()**
- This method is used to add or insert an element in the collection.  
- **Syntax:**  
  ```java
  add(Object element): boolean
  ```
- If the element is added to the collection, this method will return `true`. Otherwise, it will return `false` if the element is already present and the collection doesn’t allow duplicates.  

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class AddExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        boolean isAdded = collection.add("Apple");
        System.out.println("Added: " + isAdded); // Output: Added: true
        System.out.println("Collection: " + collection); // Output: Collection: [Apple]
    }
}
```

---

## **2. addAll()**
- This method adds a collection of elements to the collection.
- Returns `true` if the elements are added; otherwise, returns `false`.  
- **Syntax:**  
  ```java
  addAll(Collection c): boolean
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class AddAllExample {
    public static void main(String[] args) {
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("Apple");
        collection1.add("Banana");

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Cherry");
        collection2.add("Date");

        boolean isAdded = collection1.addAll(collection2);
        System.out.println("Added: " + isAdded); // Output: Added: true
        System.out.println("Collection1: " + collection1); // Output: Collection1: [Apple, Banana, Cherry, Date]
    }
}
```

---

## **3. clear()**
- This method removes all the elements from the collection.
- **Syntax:**  
  ```java
  clear(): void
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class ClearExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");
        collection.clear();
        System.out.println("Collection: " + collection); // Output: Collection: []
    }
}
```

---

## **4. contains()**
- Checks whether an element is present in a collection.
- **Syntax:**  
  ```java
  contains(Object element): boolean
  ```
- Returns `true` if the element is present; otherwise, returns `false`.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class ContainsExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        boolean isPresent = collection.contains("Apple");
        System.out.println("Contains 'Apple': " + isPresent); // Output: Contains 'Apple': true
    }
}
```

---

## **5. containsAll()**
- Checks whether a specified collection of elements is present.
- Returns `true` if the calling collection contains all specified elements; otherwise, returns `false`.
- **Syntax:**  
  ```java
  containsAll(Collection c): boolean
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class ContainsAllExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");

        Collection<String> subCollection = new ArrayList<>();
        subCollection.add("Apple");

        boolean isPresent = collection.containsAll(subCollection);
        System.out.println("Contains All: " + isPresent); // Output: Contains All: true
    }
}
```

---

## **6. equals()**
- Checks for equality with another object.
- **Syntax:**  
  ```java
  equals(Object element): boolean
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class EqualsExample {
    public static void main(String[] args) {
        Collection<String> collection1 = new ArrayList<>();
        collection1.add("Apple");

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Apple");

        boolean isEqual = collection1.equals(collection2);
        System.out.println("Collections are equal: " + isEqual); // Output: Collections are equal: true
    }
}
```

---

## **7. hashCode()**
- Returns the hash code number for the collection.
- **Syntax:**  
  ```java
  hashCode(): int
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class HashCodeExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        int hashCode = collection.hashCode();
        System.out.println("Hash Code: " + hashCode); // Output: Hash Code: (some integer value)
    }
}
```

---

## **8. isEmpty()**
- Returns `true` if a collection is empty.
- **Syntax:**  
  ```java
  isEmpty(): boolean
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class IsEmptyExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        System.out.println("Is Empty: " + collection.isEmpty()); // Output: Is Empty: true
        collection.add("Apple");
        System.out.println("Is Empty: " + collection.isEmpty()); // Output: Is Empty: false
    }
}
```

---

## **9. iterator()**
- Returns an iterator.
- **Syntax:**  
  ```java
  iterator(): Iterator
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Output: Apple Banana
        }
    }
}
```

---

## **10. remove()**
- Removes a specified element from the collection.
- **Syntax:**  
  ```java
  remove(Object element): boolean
  ```
- Returns `true` if the element was removed; otherwise, returns `false`.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class RemoveExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        boolean isRemoved = collection.remove("Apple");
        System.out.println("Removed: " + isRemoved); // Output: Removed: true
        System.out.println("Collection: " + collection); // Output: Collection: []
    }
}
```

---

## **11. removeAll()**  
- Removes all elements in the specified collection from the current collection.  
- **Syntax:**  
  ```java
  removeAll(Collection c): boolean
  ```
- Returns `true` if elements are removed, otherwise `false`.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class RemoveAllExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");

        Collection<String> toRemove = new ArrayList<>();
        toRemove.add("Apple");

        boolean isRemoved = collection.removeAll(toRemove);
        System.out.println("Removed All: " + isRemoved); // Output: Removed All: true
        System.out.println("Collection: " + collection); // Output: Collection: [Banana]
    }
}
```

---

## **12. retainAll()**  
- Retains only the elements that are also in the specified collection.
- **Syntax:**  
  ```java
  retainAll(Collection c): boolean
  ```
- Returns `true` if any elements are removed.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class RetainAllExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");

        Collection<String> toRetain = new ArrayList<>();
        toRetain.add("Apple");

        boolean isRetained = collection.retainAll(toRetain);
        System.out.println("Retained: " + isRetained); // Output: Retained: true
        System.out.println("Collection: " + collection); // Output: Collection: [Apple]
    }
}
```

---

## **13. size()**  
- Returns the total number of elements in the collection.
- **Syntax:**  
  ```java
  size(): int
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class SizeExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        System.out.println("Size: " + collection.size()); // Output: Size: 1
    }
}
```

---

## **14. toArray()**  
- Converts the collection to an array.
- **Syntax:**  
  ```java
  toArray(Object array[]): Object[]
  ```

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;

public class ToArrayExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");

        Object[] array = collection.toArray();
        for (Object obj : array) {
            System.out.println(obj); // Output: Apple Banana
        }
    }
}
```

## **15. spliterator()**  
- Creates a `Spliterator` over the elements in the collection.
- `Spliterator` is used for traversing and partitioning elements, supporting parallel processing.
- **Syntax:**  
  ```java
  spliterator(): Spliterator<T>
  ```
- Returns a `Spliterator` instance that can be used for iterating over elements.

**Example:**
```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("Apple");
        collection.add("Banana");
        collection.add("Cherry");

        Spliterator<String> spliterator = collection.spliterator();
        spliterator.forEachRemaining(System.out::println);
        // Output: 
        // Apple
        // Banana
        // Cherry
    }
}
```

---

## **Collections Class in Java**
The `Collections` class provides useful static operations that can be performed on collections. These operations include finding the minimum and maximum values, sorting, reversing, and more.

For more details, review the Java documentation:  
🔗 [Java Collections API](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)