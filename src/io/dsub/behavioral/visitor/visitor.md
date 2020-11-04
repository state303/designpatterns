# Visitor

### Concepts

- Separate Algorithm from Object
- Adding new features
- Maintain Open/Closed principle
- Visitor changes
- Example:
  - java.lang.model.element.Element
  - java.lang.model.element.ElementVisitor

### Design
- Interface based
- Visitor and Element
- Elements have visit method
- Visitor knows every Element
- Visitor, ConcreteVisitor, Element, ConcreteElement

```plantuml
@startuml
object Client

interface Visitor
Visitor : +visit(ConcreteElement)

class ConcreteVisitor
ConcreteVisitor : +visit(ConcreteElement)

interface Element
Element : +accept(Visitor)

class ConcreteElement
ConcreteElement : +accept(Visitor)

Client -left> Visitor
Client -down-> Element

ConcreteVisitor -up-|>Visitor
ConcreteElement -up-|>Element
@enduml
```