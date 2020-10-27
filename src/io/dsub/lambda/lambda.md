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

This can be modeled by a supplier, and it also supports the extra functionality to be naturally added into the interface which inherits the super class.
```java
/**
 * As Supplier interface comes from JDK, we cannot directly modify it.
 * Instead, we extend it then add desired functionality into it.
 * 
 * It is important to note that we are instantiating the Factory<T> by static methods, 
 * naturally separates the construction and behavial access.
 */
@FunctionalInterface
public interface Factory<T> extends Supplier<T> {
    
    // this makes a factory for no-args constructor to supply an object
    // think of it as using nature of supplier as it has no parameter to accept
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        // now, by using the supplier, we can get a T instance
        T singleton = supplier.get();
        // returns the Supplier<T> as a Factory<T>
        return () -> singleton;
    }
    
    // we can freely add a constructor with parameter as a Function, then supply a 
    // value to be inserted.
    static <T, R> Factory<T> createFactory(Function<R, T> constructor, R r) {
        // constructor: a constructor takes type R and returns an instance of type T
        // r: the parameter type of R that being consumed by the constructor
        // by using function as a constructor, consumes (R r)
        return () -> constructor.apply(r);
    }

    // creates new instance
    default T newInstance() {
        return get();
    }
    
    default List<T> create5Circles() {
        return IntStream.range(0, 5)
                .mapToObj(index -> newInstance())
                .collect(Collectors.toList());
    }
}
```

### Registry

Registry is basically same as factory method as it creates and delivers an object.
However, the key difference is that it uses a key value to determine which one to make.

It is easy to understand and implement, however you need to know the valid key values at compile time.
Or, you may even utilize an enum to resolve such issue.
Even further, you can make it dynamic.

Adding elements dynamically to a registry. This can be achieved with a Builder Pattern.
1. add elements to the registry
2. build the registry and seal it

Designing an APi to create Registry need considerations close to following scenario.

```java
// create a builder object
Stream.Builder<String> builder = Stream.builder();

// add elements to the builder
builder.add("one");
builder.add("two");
builder.add("three");

// build the stream. now we cannot add any method as its sealed.
Stream<String> stream = builder.build();
stream.forEach(System.out::println);
```

There are several problems in above example.
1. The builder is still available even after the build phase.
2. The builder has to know the factory (the object that is going to be created)

When you call the builder.build method, it returns a stream so the builder has to know the stream.
This is really weird in this pattern.
The builder is the object used to configure another object, but in fact, it has to know the subject once it is created;
which is really not logical.

The following code is will resolve the issue, as supplier prevents from taking extra parameters.

```java
import java.util.function.Supplier;

public class Builder<T> {
    public void add(String label, Supplier<T> supplier) {
        // the builder can be made independent of the factory
        // important: think of supplier as a factory
    }
}
```

The registry below will be created using a factory method, which is static.
The factory method will have to take the builder as a parameter in one way or another.
This is a pattern to state the relationship between the builder and the registry.

##### Builder
```java
@FunctionalInterface
public interface Builder<T> {
    // builder receives Factory<T> as a parameter, and its label by type String
    void register(String label, Factory<T> factory);
}
```

##### Registry
```java
@FunctionalInterface
public interface Registry<T> {
    Factory<? extends T> buildFactory(String label);

    // class method that generates a Registry<T> instance.
    static <T> Registry<T> createRegistry(
            Consumer<Builder<T>> consumer, Function<String, Factory<T>> errFunc) {

        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = map::put;
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errFunc);
    }
}
```
##### Example Code
```java
public class PlayWithRegistryBuilder {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        // registration - registers a builder with key and constructor
        Consumer<Builder<Shape>> consumer1 =
                builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 =
                builder -> builder.register("triangle", Triangle::new);
        Consumer<Builder<Shape>> consumer3 =
                builder -> builder.register("square", Square::new);
        
        // combine the consumers as initializer
        Consumer<Builder<Shape>> initializer = consumer1.andThen(consumer2).andThen(consumer3);

        // create registry with the initializer and error handling function
        Registry<Shape> shapeRegistry = Registry.createRegistry(initializer, s -> {
            throw new IllegalArgumentException("Unknown shape " + s);
        });

        // get factory from the registry then test each by creating new instances.
        Factory<Rectangle> buildRectangleFactory = (Factory<Rectangle>) shapeRegistry.buildFactory("rectangle");
        Rectangle rectangle = buildRectangleFactory.newInstance();

        Factory<Triangle> buildTriangleFactory = (Factory<Triangle>) shapeRegistry.buildFactory("triangle");
        Triangle triangle = buildTriangleFactory.newInstance();

        Factory<Square> buildSquareFactory = (Factory<Square>) shapeRegistry.buildFactory("square");
        Square square = buildSquareFactory.newInstance();

        System.out.println("Rectangle = " + rectangle);
        System.out.println("Triangle = " + triangle);
        System.out.println("Square = " + square);
    }
}
```

### Visitor
#### What is visitor pattern?
Visitors represent an operation to be performed on the element of an object structure.
Visitors let us define a new operation without changing the classes of the elements on which it operates.

The important point to note here is that **__we don't have to change the code of the class__** for the visitor to operate. However, the class must be prepared to accept the visitor to operate.

All these classes needs to do is to expose an accept (Visitor) method.

#### How it works?

##### From the model object part...
1. The classes need to be prepared to accept visitors (like accept method)
2. Accept the visitor from where it is needed
```java
public class Car {
    Engine engine = ...;
    Body body = ...;
    Wheel wheel1 = ...;
    
    void accept(Visitor visitor) {
        engine.accept(visitor);
        body.accept(visitor);
        wheel1.accept(visitor);
        
        visitor.visit(this);
    }
}
```
##### From the visitor part...
1. The visitor must declare the parts it is to visit.
2. The visitor object is also itself a callback (like double callbacks from above code example)
```java
public interface Visitor {
    
    void visit(Car car);
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    
}
```

From above examples, we can easily find out that if we need to add a bumper element into our car and let it allow a visitor to visit, we need to change the codes from 2 places at least (Visitor interface and within Bumper class, and Car class)

What if we know that the visitor should visit extra parts of our class, but is not yet determined?

#### Solution
With lambdas, you can define operations on classes without adding them to the class. Since lambda expressions are functions, and they can be stored in variables, we can put them as a parameter. This makes them possible to be handled by a registry, such that registry holding the operation will be able to determine the operation for the given class.

So... to make things simple, the example will show the dynamic visitor to visit classes without accept() method.

```java
@FunctionalInterface
public interface VisitorBuilder<R> {
    // takes the type to visit, and function to be operated.
    // T = incoming type, R = returning type.
    <T> void register(Class<T> type, Function<T, R> function);
}
```

```java
@FunctionalInterface
public interface Visitor<R> {

    R visit(Object o);

    // this needs to create a registry
    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        // this map as a registry, does NOT know which type of object would be a key.
        // value will hold the function where Object becomes to R which is returning type of VisitorBuilder<R>
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();

        // if we use external instance of visitorBuilder, the instance would have no way to understand
        // what type we are about to returning to.
        // hence temporarily instantiating from here to get the proper casting works.
        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {
                // adds casting by function.compose as...
                // function.compose(o -> type.cast(o))
                registry.put(type, function.compose(type::cast));
            }
        };

        consumer.accept(visitorBuilder);

        System.out.println("Registry: " + registry.keySet());

        return o -> registry.get(o.getClass()).apply(o);
    }

    // returns the type of the item but as T of input, R of output
    static <T, R> X<T, R> forType(Class<T> type) {
        return () -> type;
    }

    // T as receiving type, R as returning type
    interface X<T, R> {

        Class<T> type();

        default Y<R> execute(Function<T, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function);
        }
    }


    interface Y<R> extends Consumer<VisitorBuilder<R>> {
        default <T> Z<T, R> forType(Class<T> type) {
            return index -> index == 0 ? this : type;
        }

        default Y<R> andThen(Y<R> after) {
            return t ->  { this.accept(t); after.accept(t); };
        }
    }

    interface Z<T, R> {
        Object get(int index);

        @SuppressWarnings("unchecked")
        default Class<T> type() {
            return (Class<T>)get(1);
        }

        @SuppressWarnings("unchecked")
        default Y<R> previousConsumer() {
            return (Y<R>)get(0);
        }

        default Y<R> execute(Function<T, R> function) {
            return previousConsumer().andThen(
                    visitorBuilder -> visitorBuilder.register(type(), function));
        }
    }
}
```

### Validator
A Validator validates all the fields and then produce a set of exceptions with a message for each faulty field.
Wrapping all the others.

##### implementation
```java
@FunctionalInterface
public interface Validator {

    ValidatorSupplier on(Person p);

    default Validator thenValidate(Predicate<Person> predicate, String errorMessage) {
        return p -> {
            try {
                on(p).validate();
                if (predicate.test(p)) {
                    return () -> p;
                } else {
                    return () -> {
                        ValidationException exception = new ValidationException("The object is not valid");
                        exception.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw exception;
                    };
                }
            } catch (ValidationException validationException) {
                if (!predicate.test(p)) {
                    return () -> {
                        validationException.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw validationException;
                    };
                } else {
                    return () -> {throw validationException;};
                }
            }
        };
    }

    static Validator validate(Predicate<Person> predicate, String errorMessage) {
        return p -> {
            if (predicate.test(p)) {
                return () -> p;
            } else {
                return () -> {
                    ValidationException exception = new ValidationException("The object is not valid");
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw exception;
                };
            }
        };
    }

    interface ValidatorSupplier extends Supplier<Person> {
        default Person validate() {
            return get();
        }
    }

    class ValidationException extends RuntimeException {
        public ValidationException(String errorMessage) {
            super(errorMessage);
        }
    }
}
```