# Spring AOP (Aspect-Oriented Programming)

Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation
of cross-cutting concerns (e.g., logging, security, transaction management). In the Spring Framework, AOP enables the
definition and configuration of these concerns separately from the main business logic.

---

## Core Concepts in Spring AOP

1. **Aspect**

- An **Aspect** is a module that contains cross-cutting concerns such as logging, transaction management, or security.
- In Spring, aspects are implemented using classes annotated with `@Aspect`.

2. **Join Point**

- A **Join Point** is a point during the execution of a program, such as method execution, where an aspect can be
  applied.
- In Spring AOP, join points are limited to method executions only.

3. **Advice**

- **Advice** defines the "what" and "when" of the aspect, i.e., what action to take at the join point and when to apply
  it.

#### Types of Advice in Detail

| Advice Type         | Description                                                      |
|---------------------|------------------------------------------------------------------|
| **Before Advice**   | Runs before the method execution.                                |
| **After Returning** | Runs after the method completes successfully.                    |
| **After Throwing**  | Runs if the method throws an exception.                          |
| **After Advice**    | Runs after the method execution, regardless of the outcome.      |
| **Around Advice**   | Runs before and after the method execution, giving full control. |

---

4. **Pointcut**

- A **Pointcut** defines a set of join points (i.e., methods) where advice should be applied.
- Pointcuts are usually specified by expressions that match method signatures or annotations, using the `@Pointcut`
  annotation.

5. **Target Object**

- The **Target Object** is the object on which the aspect is applied. Also known as the advised object.

6. **AOP Proxy**

- An **AOP Proxy** is the proxy object that Spring AOP creates around the target object to implement the aspect's
  functionality.
- Spring uses **JDK dynamic proxies** or **CGLIB proxies** for creating proxy objects.

7. **Weaving**

- **Weaving** is the process of linking aspects with the target objects to create an advised object.
- In Spring, weaving is done at runtime, creating the proxy dynamically.

---

### Limitations

1. #### Self-invocation bypasses the AOP proxy:

- If a method is called from within the same class, it will not go through
  the Spring AOP proxy and the advice will not be triggered.
- This limitation applies to all types of Advice.
- To trigger AOP advice, ensure that the method is called via the Spring context (i.e., through a Spring-managed
  proxy). This is typically done by calling the method from another bean or service managed by Spring.
