package io.dsub.lambda.consumers;

public class ConsumerExample {

    public static void main(String[] args) {

        // This is not a chaining
        FirstConsumer<String> c1 = s -> System.out.println("c1 = " + s);
        FirstConsumer<String> c2 = s -> System.out.println("c2 = " + s);

        FirstConsumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };
        c3.accept("Hello");

        // We want...
        // Consumer<String> c3 = c1.andThen(c2)
        // How do we do that?
        // We need to write andThen method itself to the Consumer Interface

        // now.. go to Consumer interface we implemented then use it!
        SecondConsumer<String> s1 = s -> System.out.println("s1 = " + s);
        SecondConsumer<String> s2 = s -> System.out.println("s2 = " + s);

        SecondConsumer<String> s3 = s1.andThen(s2);
        s3.accept("Chained!");

        // But now... we allows null value.
        // s3.accept(null);

        ThirdConsumer<String> t1 = s -> System.out.println("t1 = " + s);
        ThirdConsumer<String> t2 = s -> System.out.println("t2 = " + s);

        ThirdConsumer<String> t3 = t1.andThen(t2);
        t3.accept("Hello");
    }
}
