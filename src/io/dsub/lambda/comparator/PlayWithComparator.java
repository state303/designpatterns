package io.dsub.lambda.comparator;

public class PlayWithComparator {
    public static void main(String[] args) {
        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);


        Comparator<Person> cmp =
                Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge);

        System.out.println("Mary > John : " + (cmp.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmp.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmp.compare(linda, john) > 0));
    }
}
