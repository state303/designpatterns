package io.dsub.lambda.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

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
            return previousConsumer().andThen(visitorBuilder -> visitorBuilder.register(type(), function));
        }
    }
}
