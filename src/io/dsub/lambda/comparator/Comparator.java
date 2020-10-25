package io.dsub.lambda.comparator;

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