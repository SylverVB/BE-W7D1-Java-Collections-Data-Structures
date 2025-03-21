// Map Interface: Map does not implement the Collection interface, however it is considered to be part of the Collections framework. It is used to identify a value by a key, and each entry in a map is a key-value pair.

// Because it does not implement Iterable, Maps cannot be iterated over directly. Instead, one must either:
//   • Use the entrySet() method to iterate over the set of Map.Entry
//   • Use the keySet() method to iterate over the set of keys
//   • Use the values() method to return a Collection of values which can then be iterated over

// Implementations of Map include:

// • HashMap

// HashMap is a Map which:

//   • Stores elements in key-value pairs
//   • Insertion/Retrieval of element by key is fast
//   • Tradeoff is that it does not maintain the order of insertion
//   • Permits one null key and null values

// • TreeMap

// TreeMap is a Map whose:

//  • Keys are stored in a Sorted Tree structure
//  • Main benefit is that keys are always in a sorted order
//  • Insertion/Retrieval are slow
//  • Cannot contain null keys as null cannot be compared for sorting

// • HashTable

// HashTable is an older, thread-safe implementation of a HashMap. It does not allow null keys or null values.

// Exercise

// Successfully execute a Java program that uses the Map interface to parse a String input and count the frequency of each letter of the alphabet in the String.

package MapLab.MapExercise;

import java.util.Map;
import java.util.HashMap;

public class LetterFrequency {
    public static void main(String[] args) {
        // Sample input string
        String input = "hello world";

        // Create a Map to store the frequency of each character
        Map<Character, Integer> letterCount = new HashMap<>();

        // Convert input string to a char array
        for (char c : input.toCharArray()) {
            // Skip spaces
            if (c != ' ') {
                // If the character is already in the map, increment its count
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }

        // Output the frequency of each letter
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}