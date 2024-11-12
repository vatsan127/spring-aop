# Aspect-Oriented Programming (AOP)

Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation
of cross-cutting concerns (e.g., logging, security, transaction management). In the Spring Framework, AOP enables the
definition and configuration of these concerns separately from the main business logic.

## Core Concepts in Spring AOP

### Aspect

An Aspect is a module that contains cross-cutting concerns such as logging, transaction management, or security. In
Spring, aspects are implemented using classes annotated with `@Aspect`.

### Join Point

A Join Point is a point during the execution of a program, such as method execution, where an aspect can be applied. In
Spring AOP, join points are limited to method executions only.

### Advice

Advice defines the "what" and "when" of the aspect, i.e., what action to take at the join point and when to apply it.
Spring supports several types of advice:

- **Before Advice**: Executed before the join point.
- **After Advice**: Executed after the join point (regardless of the outcome).
- **After Returning Advice**: Executed after the join point completes normally.
- **After Throwing Advice**: Executed if the method throws an exception.
- **Around Advice**: Executed before and after the join point, and allows manual control over whether the join point
  should proceed.