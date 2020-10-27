# Command

### Concepts
- Encapsulates request as an Object
- Object-oriented callback
- Decouple sender from processor
- Often used for "undo" functionality
- Examples:
  - java.lang.Runnable
  - javax.swing.Action

### Design
- Object per command
- Command Interface
- Execute Method (or Function)
- Rollback Method
- Reflection
- Command, Invoker, ConcreteCommand

```plantuml
@startuml

object Client
object Invoker
interface Command
interface Receiver

Command : execute()
ConcreteCommand : state
ConcreteCommand : execute()
Receiver : action()

Invoker o-right--> Command
ConcreteCommand -up-|> Command

Client -> Receiver
Client -left[dashed]--|> ConcreteCommand
ConcreteCommand --> Receiver

@enduml
```
