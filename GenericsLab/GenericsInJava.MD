# Generics in Java

Generics are constructs introduced in Java 5 which enforce compile-time safety by allowing you to use parameterized types. They are covered here because they are frequently and heavily used with collections. Generics can be declared on a class (generic types), method parameters (generic methods), or return types.

Before Java 5, you had to write something like this and hope other developers understood to only put Strings inside:

```java
List names = new ArrayList();
names.add("Alice"); // good use
names.add(new Object()); // uh oh - we want to prevent this from happening
```

With generics, you can restrict a class to only accept objects of a given type, and the compiler will prevent you from using any other type:

```java
List<String> names = new ArrayList<>(); // using a List of Strings only
names.add("Alice"); // nice!
names.add(new Object()); // now we get a compilation error to stop this - generics saves the day!
```

## Generic Classes

To make a class (or interface) generic, use the angle brackets when declaring it, and use an arbitrary "generic type" which is determined by the invoking code. The generic type can then be reused throughout the class to enforce type safety.

```java
public class MyGenericClass<T> {
  private T instance;
  
  // simple generic setter method
  public void setObject(T object) {
    this.instance = object;
  }
}
```

## Naming Convention for Generics

Technically, type parameters can be named anything you want. The convention is to use single, uppercase letters to make it obvious that they are not real class names.

- **`E`** => Element
- **`K`** => Map Key
- **`V`** => Map Value
- **`N`** => Number
- **`T`** => Generic data type
- **`S, U, V`**, and so on => For multiple generic data types

### 1. **`E` (Element)**
- **Convention**: Used in classes or methods that represent a **collection of elements** (such as lists, sets, etc.).
- **Example**: `List<E>`, `Set<E>`, `Queue<E>`
- **Use**: Represents the type of the element that the collection holds.
- **Example usage**:

```java
public class Box<E> {
    private E item;
    public void setItem(E item) {
        this.item = item;
    }
    public E getItem() {
        return item;
    }
}
```

### 2. **`K` (Key)**
- **Convention**: Used in **map-like** structures, where there is a key-value pair.
- **Example**: `Map<K, V>`
- **Use**: Represents the type of **key** in the map.
- **Example usage**:

```java
Map<K, V> map = new HashMap<>();
map.put("key", "value");  // Here, K = String, V = String
```

### 3. **`V` (Value)**
- **Convention**: Represents the **value** in key-value pairs.
- **Example**: `Map<K, V>`
- **Use**: Represents the type of **value** in the map.
- **Example usage**:

```java
Map<String, Integer> map = new HashMap<>();
map.put("age", 30);  // Here, K = String, V = Integer
```

### 4. **`N` (Number)**
- **Convention**: Used when the generic type is restricted to **numeric types** like `Integer`, `Double`, `Float`, etc.
- **Example**: `Number` class and its subclasses.
- **Use**: Represents numeric types in situations where the data needs to be a number.
- **Example usage**:

```java
public <N extends Number> void addNumbers(N num1, N num2) {
    System.out.println(num1.doubleValue() + num2.doubleValue());
}
```

### 5. **`T` (Generic Data Type)**
- **Convention**: The most commonly used **generic placeholder** for any type.
- **Example**: `List<T>`, `Pair<T, T>`
- **Use**: Represents the **type** of data in a generic class or method.
- **Example usage**:

```java
public class Box<T> {
    private T value;
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
```

### 6. **`S, U, V`, etc. (Multiple Generic Data Types)**
- **Convention**: Used when more than one generic type is needed in the class or method.
- **Use**: Represents additional **generic data types**.
- **Example usage**:

```java
public class Pair<S, T> {
    private S first;
    private T second;
    public Pair(S first, T second) {
        this.first = first;
        this.second = second;
    }
    public S getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
}
```

In this example, `S` represents the type of the first element, and `T` represents the type of the second element.

---

### **Summary of Usage**
- **`E`**: Common for **element** types in collections (e.g., `List<E>`, `Set<E>`).
- **`K`**: Common for **keys** in maps.
- **`V`**: Common for **values** in maps.
- **`N`**: Used for **numeric** types or numbers.
- **`T`**: A general placeholder for any type, widely used.
- **`S, U, V`, etc.**: Used for **multiple type parameters** when a class or method needs more than one generic type.

---

### **Notes**
- The **convention** is to use single uppercase letters, and each letter has a specific meaning depending on the context.
- The naming of generics is **not mandatory**, but using the conventions helps make the code more readable and maintainable.