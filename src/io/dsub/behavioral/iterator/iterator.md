# Iterator

### Summary
- Efficient way to traverse
- Hides algorithm
- Simplify client
- Foreach

### Concepts
- Traverse a container
- Doesn't expose underlying structure
- Decouples algorithms
- Sequential
  - java.util.iterator
  - java.util.Enumeration

### Design
- Interface based
- Factory method based
- Independent but fail fast
- Enumerators are failsafe
- Iterator, ConcreteIterator

```plantuml
object Client

List : iterator()
Collection : iterator()
Iterator : hasNext()
Iterator : next()
ListIterator : hasNext()
ListIterator : next()

Client -> List
List -up-> Collection
List -> ListIterator
ListIterator -up-> Iterator

note "iterator() is a factory method to create an iterator" AS note1
note1 -up- List
```

### Pitfalls
- Access to index of any sort
- Directional
- Speed / Efficient

### Constrast
| Iterator                | For Loop                             |
|:------------------------|:-------------------------------------|
| Interface based         | Traversal in client                  |
| Algorithm is removed    | Exposes an index                     |
| No index                | Doesn't change underlying object     |
| Concurrent modification | foreach syntax                       |
|                         | It is typically slower than iterator |
