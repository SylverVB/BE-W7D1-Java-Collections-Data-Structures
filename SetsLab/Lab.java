package SetsLab;
import java.util.HashSet;
import java.util.Set;

/**
 * Sets are unordered collections of elements that do not allow duplicates. 
 * Unlike lists, sets do not maintain the order of elements, and each element 
 * can only appear once. Sets are highly efficient for storing unique items and 
 * performing operations like membership tests and set operations (union, intersection, etc.).
 */
public class Lab {
    /**
     * Instantiate and return a Set of Integers.
     *
     * Like List, Set is an interface in Java. However, unlike a List, a Set does not allow duplicates and does not 
     * guarantee any specific order of elements. For example, Sets do not have a get method to retrieve an item 
     * by index, as there is no order to the elements in a Set.
     *
     * Common implementations of Set include HashSet (which offers constant-time performance for basic operations) 
     * and TreeSet (which maintains elements in a sorted order).
     * 
     * @return a new Set<Integer> object.
     */
    public Set<Integer> createSet() {
        return new HashSet<>(); // Instantiating a HashSet
    }

    /**
     * Return the size of a set.
     * @param set The set that we will be manipulating.
     * @return the size of set (number of values).
     */
    public int getSize(Set<Integer> set) {
        return set.size(); // Return the number of elements in the set
    }

    /**
     * Add a unique item to the set. Sets only allow unique items, so if the item already exists, it will not be added.
     * 
     * @param set The set to which the item will be added.
     * @param item The item to add to the set.
     * @return No return value. The set is modified directly.
     */
    public void addUniqueItem(Set<Integer> set, int item) {
        set.add(item); // Add the item to the set. If it already exists, nothing happens.
    }

    /**
     * Remove an item from the set. If the item is not present, the set remains unchanged.
     * 
     * @param set The set from which the item will be removed.
     * @param item The item to remove from the set.
     * @return No return value. The set is modified directly.
     */
    public void removeItem(Set<Integer> set, int item) {
        set.remove(item); // Remove the item from the set. If it does not exist, nothing happens.
    }
}