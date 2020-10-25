# Bridge

### Summary
- Design for uncertainty
- Can be complex
- Provides flexibility
- More than composition

### Concepts

- Decouple Abstraction and Implementation
- Encapsulation, Composition, Inheritance
- Changes in Abstraction won't affect client
- Details won't be right
- Examples:
  - Driver
  - JDBC

### Design

- Interfaces and Abstract classes
- Composition over Inheritance
- More than Composition
- Expect change from both sides
- Abstraction, Implementor, Refined Abstraction, Concrete Implementor

```plantuml
Implementor <|-- ConcreteImplementorA
Implementor <|-- ConcreteImplementorB

Abstraction <|-[dashed]- Implementor
Abstraction <|-- RefinedAbstraction

interface RefinedAbstraction
interface Abstraction

abstract Implementor
class ConcreteImplementorA
class ConcreteImplementorB

Abstraction : operation()
Implementor : operationImpl()
ConcreteImplementorA : operationImpl()
ConcreteImplementorB : operationImpl()
```

### Pitfalls

- Increases complexity
- Conceptually difficult to plan
- More than just OO
- What goes where is not super clear at first glance

### Contrast
| Bridge                              | Adapter                      |
|:------------------------------------|:-----------------------------|
| Designed upfront                    | Works after code is designed |
| Abstraction and implementation vary | Legacy                       |
| Built in advance                    | Retrofitted                  |
| Complex                             | Provides different interface |
