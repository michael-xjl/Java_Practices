package gof.structural.bridge;

/**
 * @author Michael Liu
 *The Bridge pattern is an application of the old advice, "prefer composition over
 * inheritance".
 *
 * When:
 *
 *         A
 *      /     \
 *     Aa      Ab
 *    / \     /  \
 *  Aa1 Aa2  Ab1 Ab2
 * Refactor to:
 *
 *      A         N
 *   /     \     / \
 * Aa(N) Ab(N)  1   2
 *
 *
 * When:
 *
 *                    ----Shape---
 *                   /            \
 *          Rectangle              Circle
 *         /         \            /      \
 * BlueRectangle  RedRectangle BlueCircle RedCircle
 * Refactor to:
 *
 *           ----Shape---                        Color
 *          /            \                       /   \
 * Rectangle(Color)   Circle(Color)           Blue   Red
 *
 *
 * Bridge vs Adapter
 * At first sight, the Bridge pattern looks a lot like the Adapter pattern in that a class is
 * used to convert one kind of interface to another. However, the intent of the Adapter pattern
 * is to make one or more classes' interfaces look the same as that of a particular class.
 * The Bridge pattern is designed to separate a class's interface from its implementation
 * so you can vary or replace the implementation without changing the client code.
 *
 *
 * Proxy, Decorator, Adapter, and Bridge
 * Proxy, Decorator, Adapter, and Bridge are all variations on "wrapping" a class. But their uses are different.
 *
 * Proxy could be used when you want to lazy-instantiate an object, or hide the fact that you're calling a remote service, or control access to the object.
 *
 * Decorator is also called "Smart Proxy." This is used when you want to add functionality to an object, but not by extending that object's type. This allows you to do so at runtime.
 *
 * Adapter is used when you have an abstract interface, and you want to map that interface to another object which has similar functional role, but a different interface.
 *
 * Bridge is very similar to Adapter, but we call it Bridge when you define both the abstract interface and the underlying implementation. I.e. you're not adapting to some legacy or third-party code, you're the designer of all the code but you need to be able to swap out different implementations.
 *
 * Facade is a higher-level (read: simpler) interface to a subsystem of one or more classes. Suppose you have a complex concept that requires multiple objects to represent. Making changes to that set of objects is confusing, because you don't always know which object has the method you need to call. That's the time to write a Facade that provides high-level methods for all the complex operations you can do to the collection of objects. Example: a Domain Model for a school section, with methods like countStudents(), reportAttendance(), assignSubstituteTeacher(), and so on.


Proxy and Decorator both have the same interface as their wrapped types, but the proxy creates an instance under the hood, whereas the decorator takes an instance in the constructor.

Adapter and Facade both have a different interface than what they wrap. But the adapter derives from an existing interface, whereas the facade creates a new interface.

Bridge and Adapter both point at an existing type. But the bridge will point at an abstract type, and the adapter might point to a concrete type. The bridge will allow you to pair the implementation at runtime, whereas the adapter usually won't.



A classic example of the Bridge pattern is used in the definition of shapes in an UI environment (see the Bridge pattern Wikipedia entry). The Bridge pattern is a composite of the Template and Strategy patterns.

 */
public class Bridge
{
}
