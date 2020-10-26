package io.dsub.lambda.validator;

public class PlayingWithValidator {
    public static void main(String[] args) {

        // instances to be validated
        Person sarah = new Person("Sarah", 29);
        Person james = new Person(null, 29);
        Person mary = new Person("Mary", -10);
        Person john = new Person("John", 1_000);
        Person linda = new Person(null, 1_000);

        sarah =
        Validator.validate(
                p -> p.getName() != null, "The name should not be null") // validate method returns validator
                .on(sarah) // returns a sort of supplier but with validator
                .validate(); // returns normally a person, a structure of supplier
        System.out.println("sarah = " + sarah);

        linda = Validator.validate(
                p -> p.getName() != null, "The name should not be null")
                .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150")
                .on(linda)
                .validate();
        System.out.println("linda = " + linda);

        mary = Validator.validate(
                p -> p.getName() != null, "The name should not be null")
                .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150")
                        .on(mary)
                        .validate();
        System.out.println("mary = " + mary);


        james = Validator.validate(
                p -> p.getName() != null, "The name should not be null")
                .on(james)
                .validate();
        System.out.println("james = " + james);
    }
}
