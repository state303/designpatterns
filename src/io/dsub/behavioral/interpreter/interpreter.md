# Interpreter

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

