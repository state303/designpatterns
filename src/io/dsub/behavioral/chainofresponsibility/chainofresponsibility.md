# Chain of Responsibility

### Summary
- Decouples sender and receiver
- Runtime configuration
- Hierarchical in nature
- Careful with large chains

### Concepts

- Decoupling of sender and receiver
  - send, receive without knowing who sends over
- Receiver contains reference to next receiver
- Promotes loose coupling
- No Handler - OK
- Examples:
  - java.util.logging.Logger#log()
  - javax.servlet.Filter#doFilter()
  - Spring Security Filter Chain

### Design
- Chain of receiver objects
- Handler is interface based
- ConcreteHandler for each implementation
- Each Handler has a reference to the next
- Handler, ConcreteHandler and its successor

```plantuml
@startuml
interface Handler
object Client

Handler : handleRequest()
ConcreteHandler1 : handleRequest()
ConcreteHandler2 : handleRequest()

Client -right[dashed]--|> Handler
Handler <|--down ConcreteHandler1
Handler <|--down ConcreteHandler2
Handler --o ConcreteHandler2

note "Abstraction for all handlers\nor representation of a chain" as n1
n1 .. Handler

note "Handler will pass to the next handler\nif it doesn't know how to process the request" as n2
n2 -down.. ConcreteHandler1

@enduml
```

### Pitfalls
- Handling / Handler guarantee
- Runtime configuration risk
- Chain length / performance issues

### Contrast
| Chain of Responsibility | Command                           |
|:------------------------|:----------------------------------|
| Handler is unique       | Commands are also unique          |
| Successor               | Encapsulates function             |
| Can utilize the Command | Reversible or Trackable in nature |
