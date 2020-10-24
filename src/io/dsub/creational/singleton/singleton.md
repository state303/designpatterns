# Singleton

Singleton pattern is the single most widely used design pattern as it is
super easy to implement... :)

#### Characteristics of Singleton Pattern

1. Only one instance created
2. Easy to implement
3. Guarantees control of a resource
4. Lazily loaded
5. Examples: Runtime, Logger, Spring Beans, Graphics Managers

#### Design

- Class is responsible for life cycle
- Static in nature
- Needs to be thread safe
- Private instance
- Private constructor
- No parameters required for construction


#### Pitfalls

- Often overused
- Difficult to unit test
- If not careful, not thread-safe
- Sometimes confused for Factory
- java.util.Calendar isNOT a Singleton
  - prototype

#### Singleton VS Factory

| Singleton                       | Factory                              |
|:--------------------------------|:-------------------------------------|
| Returns same instance           | Returns various instances            |
| One constructor method: no args | Multiple constructors                |
| No interface                    | Interface driven                     |
| ...                             | Adaptable to environment more easily |


```java
public class Runtime { 
    private Runtime(){}

    private Runtime runtime = new Runtime();

    public Runtime getRuntime() {
        return runtime;
    }
    
    public static void main(String[] args){
        Runtime singletonRuntime = runtime.getRuntime();

        singletonRuntime.gc();

        System.out.println(singletonRuntime);

        Runtime anotherInstance = runtime.getRuntime();

        System.out.println(anotherInstance);

        if (singletonRuntime == anotherInstance) {
            System.out.println("They are the same instance");
        }
    }
}
```

