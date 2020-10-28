# Mediator

### Summary
- Loose coupling
- Simplified communication
- Mediator complexity
- Use with Command

### Concepts
- Loose coupling
- Well-defined, but complex
- Reusable components
- Hub / Router
- Examples:
  - java.util.Timer
  - java.lang.reflect.Method#invoke()

### Design
- Interface based
- Concrete class
- Minimizes inheritance
- Mediator knows about colleagues
- Mediator, ConcreteMediator

```plantuml
Colleague -left-> Mediator
ConcreteMediator -up-|> Mediator
ConcreteColleague2 <|-- ConcreteMediator
ConcreteColleague1 <|-- ConcreteMediator
ConcreteColleague1 -up-|> Colleague
ConcreteColleague2 -up-|> Colleague
```

### Pitfall
- Must careful not to create deity object
- Limits subclassing
- Over or with Command

### Contrast
| Mediator                                               | Observer          |
|:-------------------------------------------------------|:------------------|
| Defines Interaction                                    | One-to-Many       |
| Object decoupling                                      | Object decoupling |
| More specific (Additional Commands -> Modify Mediator) | More generic      |
