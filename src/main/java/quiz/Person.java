package quiz;

public class Person {
    {
        personCount = 10; // init #1
    }
    static {
        personCount = 20; // static #1
    }
    private static int personCount = 1000; // static #2
    {
        personCount = 30; // init #2
    }
    static {
        personCount = 40; // static #3
    }
    public static void main(String[] args) { // main method kick-off
        // 1. Person class loaded -> static personCount variable is available(default 0)
        System.out.println(Person.personCount); // static #3
        Person p = new Person(); // instantiated object -> init block #2
        System.out.println(Person.personCount);
        Person.personCount = 100; // changed
        p = new Person(); // but initialized again, so init #2
        System.out.println(Person.personCount);
    }
}
