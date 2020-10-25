package io.dsub.lambda.predicate;

public class PlayWithPredicates {
    public static void main(String[] args) {

        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> s.isEmpty();

        Predicate<String> p3 = p1.and(p2.negate());

        System.out.println(p3.test("Hello")); // should return true
        System.out.println(p3.test("")); // should return false
        System.out.println(p3.test(null)); // should return false
    }
}
