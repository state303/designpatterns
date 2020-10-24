# Factory Method

Factory method is in someways the opposite of the singleton pattern.

Also, it is second most used pattern.

### Summary

- Parameter driven
- Solves complex creation
- A little complex
- Opposite of the Singleton

### Concepts

- Doesn't expose instantiation(creation) logic
- Defer to subclasses
- Common interface
- Specific by architecture, implemented by user
- Examples:
  - Calendar
  - ResourceBundle
  - NumberFormat

### Design

```plantuml
Factory <|-- ConcreteObject
Factory : +factoryMethod() : Object
ConcreteObject : +factoryMethod() : Object
```

- Factory is responsible for lifecycle
- Common Interface
- Concrete Classes
- Parameterized create method


### Contrast

| Singleton                        | Factory                   |
|:---------------------------------|:--------------------------|
| Returns same instance            | Returns various instances |
| One constructor method - no args | Multiple constructors     |
| No Interface                     | Interface driven          |
| No Subclasses                    | Subclasses                |
