# Memento

### Concepts

- Restore Object to previous state
- Externalize internal state
- To implement Undo/Rollback
- Shields complex internals
- Examples:
  - java.util.Date
  - java.io.Serializable


### Design
- Class based
  - Originator (creates actual memento)
  - Caretaker (handles memento)
  - Memento
  - Magic Cookie (not an actual object)

```plantuml
title Memento Pattern

note "state is captured in memento object" AS note_m
note "originator can create or set memento object" AS note_o
note "caretaker stores the originator whilst knowing why and when to do so, and how to restore itself" AS note_c

note_m -down-> Memento
note_o -up-> Originator
note_c -up-> Caretaker



Originator : -state
Originator : setMemento()
Originator : createMemento()

Memento : -state
Memento : getState()
Memento : setState()

Originator -right[dashed]-> Memento
Caretaker o-left-> Memento
```
