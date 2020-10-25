# Adapter

### Summary

- Simple solution
- Easy to implement
- Integrate with Legacy
- Can provide multiple adapters

### Concept

- Plug adapter
- Convert interface into another interface
- Legacy
- Translates requests
- Client, Adapter, Adaptee
- Example:
  - Arrays -> Lists (converts array to list)
  - Streams

### Design

```plantuml
class Client
class LegacyProduct
interface Adapter

Adapter <|-- LegacyProduct
Client <|-- Adapter

LegacyProduct : +doThat()
Adapter : +doThis()
Client : +doSomething()
```

- Client centric
- Integrate new with old
- interface, but not required
- Adaptee can be the implementation

### Pitfalls

- Not a lot!
- Don't complicate
- Multiple Adapters
- Don't add functionality

### Contrast

| Adapter                     | Bridge                              |
|:----------------------------|:------------------------------------|
| Legacy                      | Designed upfront                    |
| Retrofitted                 | Abstraction and implementation vary |
| Provides diferent interface | Built in advance                    |
|                             | Both adapt multiple systems         |

