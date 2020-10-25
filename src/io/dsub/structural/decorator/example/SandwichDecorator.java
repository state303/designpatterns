package io.dsub.structural.decorator.example;


// decorator should be treated as an object.
public abstract class SandwichDecorator implements Sandwich {
    protected Sandwich customSandwich;

    // here, this enables us to use make() implementation from either a concrete class or another decorator!
    public SandwichDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    // see? we do not know how customSandwich implemented make method but it works as intended.
    public String make() {
        return customSandwich.make();
    }
}
