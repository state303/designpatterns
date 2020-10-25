# Proxy

### Summary

- Great utilities built into Java API
- Only one instance per object you want to apply proxy
- Used by DIJ/IOC Frameworks

### Concepts

- Interface by wrapping
- Can add functionality
- Security, Simplicity, Remote, Cost
- Proxy called to access real object
- Examples:
  - java.lang.reflect.Proxy
  - java.rmi.*

### Design

- Interface based
- Interface and Implementation Class
- java.lang.reflect.InvocationHandler
- java.lang.reflect.Proxy
- Client, Interface, Invocation, Proxy Implementation

```plantuml
Class Client
Subject : doAction()
Proxy : doAction()
RealSubject : doAction()

Client -right[dashed]--> Subject

Proxy -up--|> Subject
RealSubject -up--|> Subject
Proxy -right--> RealSubject
```

### Pitfalls

- Only one proxy (we can have only one proxy on one instance of
  something we want to put in)
- Another Abstraction
- Similar to other patterns (adapter, decorator)

### Contrast

| Proxy                                           | Decorator                        |
|:------------------------------------------------|:---------------------------------|
| Can add functionality, but not its main purpose | Dynamically add functionality    |
| Can only have one                               | Chained                          |
| Compile time                                    | Decorator points to its own type |

