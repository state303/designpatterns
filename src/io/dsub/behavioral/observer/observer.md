# Observer

### Concepts

- Situation where subject has one to many observers
- Decouple objects
- Pub-Sub in asynchronous fashion
- Event Handling
- M-V-C
- Examples:
  - java.util.Observer
  - java.util.EventListener

### Design

Subject (an interface, or an abstract class)
Observer
Observable
Views are Observers

```plantuml
@startuml

note "Can be either abstract,\nor concrete class" AS hello

abstract Subject
Interface Observer

hello -down-> Subject

Subject : attach(Observer)
Subject : detach(Observer)
Subject : notify()

Observer : update()

ConcreteSubject : -state
ConcreteSubject : getState()
ConcreteSubject : setState()

ConcreteObserver : -observerState
ConcreteObserver : update()

Subject -> Observer
ConcreteObserver -up--|> Observer
ConcreteObserver -left--> ConcreteSubject
ConcreteSubject -up--|> Subject

@enduml
```