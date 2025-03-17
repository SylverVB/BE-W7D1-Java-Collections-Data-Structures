package GenericsLab;

public class Main {
    public static void main(String[] args) {
        // Test with Integer type
        GenericsLab<Integer> geInt = new GenericsLab<>();
        System.out.println("Datatype Integer...");
        System.out.println("Setting value 3 to variable 'data'.");
        geInt.loadGenericItem(3);

        System.out.println("calling 'returnGenericItem' method.");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + geInt.returnGenericItem());

        // Test with String type
        GenericsLab<String> geString = new GenericsLab<>();
        System.out.println("\n\nDatatype String...");
        System.out.println("Setting value 'Revature' to variable 'data'.");
        geString.loadGenericItem("Revature");

        System.out.println("calling 'returnGenericItem' method.");
        System.out.println("Expected Output: 'Revature'");
        System.out.println("Actual Output: " + geString.returnGenericItem());

        // Test with custom Person class type
        GenericsLab<Person> gePerson = new GenericsLab<>();
        System.out.println("\n\nDatatype Person...");
        gePerson.loadGenericItem(new Person("Alice", 30));

        System.out.println("calling 'returnGenericItem' method.");
        System.out.println("Expected Output: Person{name='Alice', age=30}");
        System.out.println("Actual Output: " + gePerson.returnGenericItem());
    }
}

// Example custom class for demonstration
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}