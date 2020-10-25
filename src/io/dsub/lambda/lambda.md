# Implementing Design Patterns using Java 8 Lambda

### Adding a default method will allow chaining of consumer

- Default method will help us a lot when it comes to lambda expression
- Fail fast if we do not expect null as below, with meaningful message

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    
    default Consumer<T> andThen(Consumer<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
```

### Combining and Negating Predicates

- Default methods can combine lambdas
- They can modify the behavior of lambdas

```java
@FunctionalInterface
public interface Predicate<T> {
    
    boolean test(T t);
    
    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }
    
    default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
    
}
```

### Chaining and Composing Functions
This is an example of chaining two functions
```java
@FunctionalInterface
public interface Function<T, R> {
    
    R apply(T t);
    
    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }
}
```
This is an example of composing two functions
```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
    
    default <V> Function<V, R> compose(Function<V, T> other) {
        Objects.requireNonNull(other);
        return (V v) -> {
            T t = other.apply(v);
            return this.apply(t);
        };
    }
}
```

### Comparators and how to chaining them
```java
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    /**
     * @param t1 to compare
     * @param t2 to be compared
     * @return if t1 > t2, return 1. if t2 < t1, return -1. if tie, return 0;
     */
    int compare(T t1, T t2);

    // a factory method of comparator
    // it is important to note that Comparable<? super U> is for cases where Comparable is declared
    // toward the super class, and the best example is the Calendar.class
    static <R, U extends Comparable<? super U>> Comparator<R> comparing(Function<R, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);

        return (r1, r2) -> {
            // this would be a mapping
            U u1 = keyExtractor.apply(r1);
            U u2 = keyExtractor.apply(r2);
            // actual function for comparison
            return u1.compareTo(u2);
        };
    }

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (T t1, T t2) -> {
            int compare = this.compare(t1, t2);
            if(compare == 0) {
                return other.compare(t1, t2);
            } else {
                return compare;
            }
        };
    }

    default Comparator<T> reversed() {
        // simply putting - sign into this.compare(t1, t2) won't work!
        return (T t1, T t2) -> this.compare(t2, t1);
    }
}
```

### Factory Pattern in Lambda

In a nutshell, a factory pattern is an object able to create another objects.
Sometimes in applications, we need to create objects in a controlled way, so we
delegate the creation of the objects to a special kind of objects; precisely the factory objects.

This can be modeled by a supplier.