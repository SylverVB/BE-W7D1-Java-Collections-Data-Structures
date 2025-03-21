package MapLab;

import java.util.Map;

public class Application {
    /**
     * This class contains a main method to manually test Map operations.
     * The tests verify key functionalities such as adding, retrieving, updating, and deleting key-value pairs.
     * 
     * No changes made here affect automated test cases; manual verification is recommended.
     * All core implementation logic is in the Lab class.
     */
    public static void main(String[] args) {
        Lab mapLab = new Lab();
        System.out.println("Was the map properly instantiated? this will print '{}' if yes, null if no");
        Map<Integer, String> myMap = mapLab.createMap();
        System.out.println(myMap);

        System.out.println("If we're able to add a key/value pair to the map, then we should be able to retrieve the value from the key");
        mapLab.addKeyValuePair(myMap, 1, "apple");
        System.out.println("The value for key 1 should be 'apple':");
        String value1 = mapLab.getValueFromKey(myMap, 1);
        System.out.println(value1);

        System.out.println("The size of the map should now be 1. Current size should be 1:");
        int size1 = mapLab.getSize(myMap);
        System.out.println(size1);

        System.out.println("Let's change the value of the item at key 1 to 'banana'. Current value:");
        mapLab.overwriteValue(myMap, 1, "banana");
        String value2 = mapLab.getValueFromKey(myMap, 1);
        System.out.println(value2);

        System.out.println("Let's remove the key/value pay at key 1. Current size should be 0: ");
        mapLab.removeKeyValuePair(myMap, 1);
        int size2 = mapLab.getSize(myMap);
        System.out.println(size2);
    }
}