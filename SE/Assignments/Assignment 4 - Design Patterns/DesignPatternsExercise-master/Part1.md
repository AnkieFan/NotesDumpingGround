Group 77
i6272224 Ankie Fan
i6285725 Yaonan Hu
# Part 1:

## 1: The Factory Methods
Make all products follow the 'block' interface. A creator will have a factory method, which is a method about how to produce 'block'. Then there'll be a set of creators subclasses that will overwrite the factory method, to produce specific blocks.

### Bridge:
*We think Bridge is also a reasonable pattern for this case.*
First, there's an abstract class 'block'. Then we have an interface containing the methods to build a 'block'. Create concrete implementation classes that all follow the implementation interface. Each class will contain its own methods to produce a specific block.

## 2: Decorator
+ Create a concrete robot class and define the base behavior (navigate a maze) in it.
+ Create a base decorator class. It should have a field for storing a reference to the robot. The field should be declared with the component interface type to allow linking to concrete components as well as decorators. The base decorator must delegate all work to the original robot.
+ Create concrete decorators (Like speed, weapons, and shields) by extending them from the base decorator. A concrete decorator must execute its behavior before or after the call to the parent method.
+ Creating decorators and composing them when the robot is playing the game.


## 3: Observer
+ UIs are the observers
+ The model will get user inputs from UIs and deal with them.
+ After dealing with that, it will respond to UI
+ The model does not need to know what UI is like

## 4: Strategy
+ Have a strategy interface to decide if the file should be accepted or rejected.
+ **Iterator** can be used in the searching part.
+ Implement interface on searching part to be a filter.