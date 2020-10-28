# Interpreter

### Summary
- Great for define a grammar
- Rules or Validation
- Special case pattern (where not many changes expected)

### Concepts
- Represents grammar
- Interpret a sentence
- Map a domain
- Abstract Syntax Tree (AST)
- Examples:
  - java.util.Pattern
  - java.text.Format


### Design
- AbstractExpression
- Interpret
- TerminalExpression (Leaf)
- NonTerminalExpression (Compound Expression)
- Context, AbstractExpression, TerminalExpression, NonTerminalExpression, Client

```plantuml
object Client
object Context
abstract AbstractExpression

AbstractExpression : interpret(Context)
NonTerminalExpression : interpret(Context)
TerminalExpression : interpret(Context)

Client -up-> Context

Client -> AbstractExpression

TerminalExpression -up-|> AbstractExpression
NonTerminalExpression -up-|> AbstractExpression
NonTerminalExpression o--> AbstractExpression
```

### Pitfalls
- Complexity
- Class per rule
- Use of other patterns
- Adding new variant
- Specific case

### Contrast
| Interpreter                                    | Visitor                                            |
|:-----------------------------------------------|:---------------------------------------------------|
| Access to properties                           | Needs observer functionality                       |
| Function as methods                            | Functionality found in one place                   |
| Adding new functionality changes every variant | Adding new variant requires changing every visitor |