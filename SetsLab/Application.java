package SetsLab;

import java.util.Set;

public class Application {
    /**
     * Contains the main method to manually test the Set operations.
     * Changes made here do not affect automated test case results, which must still be run and passed separately.
     * Implementation code for the Set operations should be written in the Lab class.
     *
     * The Lab class should handle all Set-related operations.
     */
    public static void main(String[] args) {
        Lab setLab = new Lab();
        System.out.println("Was the set properly instantiated? this will print '[]' if yes, null if no");
        Set<Integer> mySet = setLab.createSet();
        System.out.println(mySet);

        System.out.println("If we're able to add an item to the set, it should be present in the set (return true)");
        setLab.addUniqueItem(mySet, 5);
        System.out.println(mySet.contains(5));

        System.out.println("The set should not contain items not in the set (return false)");
        System.out.println(mySet.contains(7));

        System.out.println("After adding the item of the set, it should have a size of 1. Current size:");
        int size1 = setLab.getSize(mySet);
        System.out.println(size1);

        System.out.println("After removing the item of the set, it should have a size of 0. Current size:");
        setLab.removeItem(mySet, 5);
        int size2 = setLab.getSize(mySet);
        System.out.println(size2);
    }
}
