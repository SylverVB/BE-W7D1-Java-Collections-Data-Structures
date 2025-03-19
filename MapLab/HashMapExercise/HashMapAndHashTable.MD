# HashMap vs HashTable in Java

## **HashTable**

The `Hashtable` class implements a hash table, mapping keys to values. 

### Key Features:
- **Thread Safety**: `Hashtable` is synchronized, making it thread-safe for use in concurrent applications.
- **Key-Value Pair Storage**: It stores key/value pairs in a hash table. The key is hashed, and the resulting hash code is used as the index for storing the value.
- **Null Handling**: Does not allow `null` keys or values.
- **Legacy Class**: Introduced in JDK 1.0 and considered outdated compared to `HashMap`.

### Example Usage:
```java
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "One");
        table.put(2, "Two");
        table.put(3, "Three");

        System.out.println("Mappings: " + table);
    }
}
```

### Real-World Applications:
- Programming language implementations
- File systems
- Pattern search
- Cryptography
- Distributed key-value storage

---

## **HashMap**

`HashMap` is a hash table-based implementation of the `Map` interface. It extends `AbstractMap`.

### Key Features:
- **Efficiency**: Designed for fast key-based lookups.
- **Null Handling**: Allows one `null` key and multiple `null` values.
- **Order**: Does not guarantee the order of keys or values.
- **Concurrency**: Not thread-safe unless explicitly synchronized.
- **Modern Class**: Introduced in JDK 1.2 as part of the Java Collections Framework.

### Example Usage:
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        System.out.println("Mappings: " + map);
    }
}
```

### Real-World Applications:
- Populating dropdown lists in forms
- Implementing phone books (e.g., Name → Number)
- Creating dictionary applications (e.g., Word → Meaning)
- Dijkstra's algorithm and topological sorting
- Priority queues

---

## **Comparison: HashMap vs HashTable**

| **Feature**          | **HashMap**                                                            | **Hashtable**                                   |
|----------------------|------------------------------------------------------------------------|-------------------------------------------------|
| **Thread Safety**    | Not synchronized. Requires explicit synchronization for thread safety. | Synchronized. Thread-safe by default.           |
| **Performance**      | Faster due to lack of synchronization.                                 | Slower due to synchronization overhead.         |
| **Null Keys/Values** | Allows one `null` key and multiple `null` values.                      | Does not allow `null` keys or values.           |
| **Legacy/Modern**    | Modern class, introduced in JDK 1.2.                                   | Legacy class, introduced in JDK 1.0.            |
| **Iteration Order**  | Does not guarantee any specific order.                                 | Does not guarantee any specific order.          |
| **Usage**            | Preferred for most applications.                                       | Suitable for legacy multithreaded applications. |

---

## **Alternatives for Order Guarantee**

### **LinkedHashMap**
- Maintains insertion order.
- Example:
```java
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        System.out.println("Mappings: " + map); // Output: {3=C, 1=A, 2=B}
    }
}
```

### **TreeMap**
- Maintains elements in sorted order (natural or custom).
- Example:
```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        System.out.println("Mappings: " + map); // Output: {1=A, 2=B, 3=C}
    }
}
```

---

## **Performing Operations**

### **HashMap Example**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
map.put("Bob", 30);
System.out.println(map.containsKey("Alice")); // true
System.out.println(map.get("Alice"));         // 25
```

### **Hashtable Example**
```java
Hashtable<Integer, String> table = new Hashtable<>();
table.put(1, "One");
table.put(2, "Two");
System.out.println(table.containsKey(1)); // true
System.out.println(table.get(1));         // "One"
```

To add multiple values for the same key in a `Hashtable` or `HashMap`, you have a few different strategies, since a key in these collections can only hold a **single value**. However, you can associate multiple values with a key by using a collection type (like a `List`, `Set`, or `ArrayList`) as the value.

### Approach 1: Using a `List` or `Set` as the Value
You can store a `List` (or `Set`) of values for each key. Here's how to do it:

#### Example using `HashMap` with a `List` as the value:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap where the value is a List of Strings
        HashMap<String, List<String>> map = new HashMap<>();
        
        // Add values to the same key
        map.put("Alex", new ArrayList<>(Arrays.asList("25", "New York"))); // First entry for Alex
        map.put("Cynthia", new ArrayList<>(Arrays.asList("30", "Los Angeles"))); // First entry for Cynthia

        // Add additional values to the same key
        map.get("Alex").add("Chicago");  // Adding another value for Alex
        map.get("Cynthia").add("San Francisco"); // Adding another value for Cynthia
        
        // Print the map
        System.out.println(map); // Output: {Alex=[25, New York, Chicago], Cynthia=[30, Los Angeles, San Francisco]}
    }
}
```

#### Explanation:
- We use `ArrayList` to store multiple values for a single key.
- When adding a new value to the existing key (e.g., `Alex` or `Cynthia`), you retrieve the existing list using `map.get("key")` and add new elements to it.

#### Example using `HashMap` with a `Set` as the value:
You can also use a `Set` instead of a `List` if you want to ensure there are no duplicate values:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap where the value is a Set of Strings
        HashMap<String, Set<String>> map = new HashMap<>();
        
        // Add values to the same key
        map.put("Alex", new HashSet<>(Arrays.asList("25", "New York"))); // First entry for Alex
        map.put("Cynthia", new HashSet<>(Arrays.asList("30", "Los Angeles"))); // First entry for Cynthia
        
        // Add additional values to the same key
        map.get("Alex").add("Chicago");  // Adding another value for Alex
        map.get("Cynthia").add("San Francisco"); // Adding another value for Cynthia
        
        // Print the map
        System.out.println(map); // Output: {Alex=[New York, 25, Chicago], Cynthia=[San Francisco, Los Angeles, 30]}
    }
}
```

---

### Approach 2: Using a Custom Object for Complex Values
If you need more structured data (e.g., a pair of values or different types), you can use a custom class to store multiple values for a single key.

#### Example using a custom object:

```java
import java.util.*;

class Person {
    String age;
    String city;

    Person(String age, String city) {
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return age + ", " + city;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a HashMap where the value is a List of Person objects
        HashMap<String, List<Person>> map = new HashMap<>();
        
        // Add values to the same key
        map.put("Alex", new ArrayList<>(Arrays.asList(new Person("25", "New York"))));
        map.put("Cynthia", new ArrayList<>(Arrays.asList(new Person("30", "Los Angeles"))));
        
        // Add additional values to the same key
        map.get("Alex").add(new Person("26", "Chicago"));  // Adding another Person for Alex
        map.get("Cynthia").add(new Person("31", "San Francisco")); // Adding another Person for Cynthia
        
        // Print the map
        System.out.println(map); 
        // Output: {Alex=[25, New York, 26, Chicago], Cynthia=[30, Los Angeles, 31, San Francisco]}
    }
}
```

#### Explanation:
- A `Person` class stores both `age` and `city`.
- You use `List<Person>` to store multiple `Person` objects under a single key.

---

### Summary:
1. **List or Set Approach**: Store multiple values for a key by using a `List` (or `Set`) as the value.
   - Example: `HashMap<String, List<String>>`
2. **Custom Object Approach**: Use a custom class to structure the data and store more complex information for each key.

Both approaches allow you to associate multiple values with a single key in a `HashMap` or `Hashtable`.

## **Recommendation**

- Use **HashMap** for most modern applications where thread safety is not a concern.
- Use **Hashtable** only in legacy applications or when built-in thread safety is necessary. For better performance in multithreaded environments, consider using `ConcurrentHashMap`.

---

## **Summary**

- Hashing is a way to store data in a data structure such that the basic operations (insertion, deletion, and searching) can be performed in O(1) time.
- In `Hashtable`, we specify an object used as a key and the value associated with that key. 
  - The key is hashed, and the resulting hash code is used as the index for storing the value within the table.
- The `HashMap` is a hashtable-based implementation that extends the `AbstractMap` class and implements the `Map` interface. 
  - A `HashMap` works on the principle of hashing.
  - This `Map` implementation usually acts as a bucketed hash table, but when buckets get too large, they are transformed into `TreeNodes`, each structured similarly to those in `TreeMap`.