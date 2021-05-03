# Java Class - IV (Abstract classes, Interfaces and Multithreading)

#### April 30, 2021

## Get the Java Class - IV recording: [Here](https://drive.google.com/file/d/1m5yhM9lhtO9PeU81xOg0v1zDgdZ06wxR/view?usp=sharing)

<div align="center"><img src="../Java.png" alt="Java logo" height=150/></div>

<hr>

# Abstract Classes

As we move up the inheritance hierarchy, classes become more general and probably more abstract. At some point, the ancestor class becomes so general that you think of it more as a basis for other classes than a class that you want to instantiate. 

Consider for example car, in real life, we can have different implementation of car, like **TeslaCar**, **AudiCar** etc. It is good to create a more general **Car** class and to put all the general methods and instance variables in that class because the basic prototype for every car is the same. All that changes is how a particular manufacturer implements those basic functionalities.

A point to look at is that the existence of the **Car** object doesn't make any sense, all that matter is the existence of those that implemented it. In our case **TeslaCar** and **AudiCar**.

This is where **Abstract Classes** comes into play. When you make a class **abstract** then you are ensuring that no one can create an object of that class. Along with **Abstract Classes** we have **Abstract Methods**. By marking a method **abstract** we are ensuring that we are just providing method declaration and no definition.

Whenever we add an **abstract** method in a class then we must also declare that class **abstract**. But the vice versa is not true if a class is **abstract** then it may or may not have **abstract** methods. Many programmers think that **Abstract Classes** are house to **Abstract Methods**, no they are so much more !!. Along with abstract methods they can have instance variables as well as concrete methods.

**Abstract Methods** act as a placeholder for methods that are implemented in subclasses. When we extend an **Abstract Class** we have two choices either to define all the **Abstract Methods** and make a **Concrete SubClass** or to leave some (or all) of the **Abstract Methods** undeclared and mark the subclass **abstract** as well.

**Note:** By Concrete Class I mean the class which can be instantiated, ie. The class whose objects can be created. 

A very interesting thing to note about **Abstract Classes** is that, although we can not instantiate them we still can create object references of **Abstract Class**. These object references must refer to an object of a **Concrete SubClass**. For example,

```java
Car c = new TeslaCar("Model S", 4, 250.0);
```

I hope by now, the differences between object and object references must have been clear.

Now let us define our **Abstract Class** Car about which we were discussing so long.

```java

/**
 * This program demonstrate Abstract Class.
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

import java.util.Calendar;
import java.util.Date;

public abstract class Car {

	// Abstract Class can also have instance variables .....

	private String modelName;
	private int passengerCapacity;
	private double topSpeed;
	private Date manufacturingDate;

	// Abstract Class can have constructor just like other classes ....

	public Car(String modelName, int passengerCapacity, double topSpeed) {
		this.modelName = modelName;
		this.passengerCapacity = passengerCapacity;
		this.topSpeed = topSpeed;
		this.manufacturingDate = Calendar.getInstance().getTime();
	}

	// Abstract Methods

	public abstract void accelerate();

	public abstract void brake();

	public abstract String getDescription();

	// Accessor Methods (See Abstract Class can also have concrete methods)

	public String getModelName() {
		return this.modelName;
	}

	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

	public double getTopSpeed() {
		return this.topSpeed;
	}

	public Date getManufacturingDate() {
		return this.manufacturingDate;
	}

	// Mutator Methods

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setPassengerCapcity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}
}
```

Now let's define our concrete subclasses namely **TeslaCar** and **AudiCar**

```java
/**
 * This program demonstrates Concrete SubClasses of the Car Abstract Class.
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

class TeslaCar extends Car {

	public TeslaCar(String modelName, int passengerCapacity, double topSpeed) {
		super(modelName, passengerCapacity, topSpeed);
	}

	// Overriding Abstract methods

	public void accelerate() {
		System.out.println("Tesla's specialized acceleration system");
	}

	public void brake() {
		System.out.println("Tesla's specialized braking system");
	}

	public String getDescription() {
		return "Tesla Car, Model Name: " + this.getModelName() + ", Top Speed: " + this.getTopSpeed();
	}
}

class AudiCar extends Car {

	public AudiCar(String modelName, int passengerCapacity, double topSpeed) {
		super(modelName, passengerCapacity, topSpeed);
	}

	// Overriding Abstract methods

	public void accelerate() {
		System.out.println("Audi's specialized acceleration system");
	}

	public void brake() {
		System.out.println("Audi's specialized braking system");
	}

	public String getDescription() {
		return "Audi Car, Model Name: " + this.getModelName() + ", Top Speed: " + this.getTopSpeed();
	}
}
```

Finally, let's create our AbstractTest Class which will act as a driver class and will illustrate all the concepts discussed till now.

```java
/**
 * This program demonstrate AbstractTest driver class
 * 
 * @version 1.01- 17-08-2018
 * @author Abhey Rana
 */

public class AbstractTest {

	public static void main(String args[]) {

		Car[] showroom = new Car[3];

		showroom[0] = new TeslaCar("Model S", 4, 250.0);
		showroom[1] = new AudiCar("Audi A3", 4, 240.0);
		showroom[2] = new TeslaCar("Model X", 4, 210.0);

		for (Car c : showroom)
			System.out.println(c.getDescription());

	}
}
```

### Why make methods of Car class abstract? Can we not just leave their method definition empty? Will it not serve the same purpose?

Yeah, we can leave the method definition of those abstract method empty and surely it will serve the purpose in the current scenario. But by making a method **abstract** we are ensuring that every **Concrete SubClass** that extends **Car** class will override these methods which will further ensure that none of those classes is using the default implementation of any of the **abstract** methods of Car class.

# Interface

Interfaces in Java are a way of describing **what** classes should do without specifying **how** they should do it. In the Java programming language, an interface is not a class but a set of **requirements** that the implementing classes must conform to. 

Typically, the supplier of some service states:

> If your class conforms to a particular interface, then I will perform the service

In layman terms, you can think of an interface as a contract, which once you sign then you have to abide by its terms and conditions. And the terms and conditions in the case of the Java interface are to override all the methods of the interface.

In Java Interface all the methods are by default **public** and **abstract**. Even if you mark a method as **public abstract** then also Java compiler won't complain. But if you try to make method **private** or **protected** then the Java compiler will raise an error.

Just like Abstract Classes, Interfaces can't be instantiated but they can have still have Object References which will refer to objects of implementing classes.

A major difference between Java Interfaces and Abstract Classes is that interfaces can't have instance members and concrete methods(like constructors, accessor methods, mutator methods, etc.).

Now let's create an interface Repairable of our own which will act as a contract for RepairingGuy class. If any class implements this Repairable interface then the ReairingGuy will repair objects of that class.

```java
public interface Repairable {
	boolean isRepairable();

	void repair();
}
```

Now if we want to give the functionality of Repairing to TeslaCar then we must implement this interface. So now our TeslaCar will look something like this

```java
import java.util.Calendar;
import java.util.Date;

class TeslaCar extends Car implements Repairable{

	/*
		Previous code in TeslaCar class will remain the same.
		All we have to do is to override the methods of the Repairable interface.
	*/

	public boolean isRepairable() {
		// Tesla Car has a warranty time and can be repaired during that time only ....
		Date currentDate = Calendar.getInstance().getTime();
		if (currentDate.getTime() - this.getManufacturingDate().getTime() > 100000)
			return false;
		return true;
	}

	public void repair() {
		System.out.println("Procedure for repairing Tesla Car");
	}
}
```

### Why create a new interface with these two abstract methods? Can't we just include those abstract methods in the Car Abstract class?

Yes, you can but again that will not be a good design practice. Because TeslaCar or AudiCar are not the only things that can be repaired. Let say we have another completely unrelated class Music Player then how will you provide the functionality of repairing it.

Let's see how the Repairable interface provides the functionality of repairing to a SonyMusicPlayer.

```java
public class SonyMusicPlayer implements Repairable {

	// Some code for Music Player .....

	public boolean isRepairable() {
		// Let's assume that our music player comes with lifetime warranty :P
		return true;
	}

	public void repair() {
		System.out.println("Procedure for repairing Sony Music Player");
	}
}
```

Now let's see the implementation of RepairingGuy class the generic class responsible for all repair related operations.

```java
public class RepairingGuy {

	// Static doRepair method of RepairingGuy ....

	public static void doRepair(Repairable object) {

		if (!object.isRepairable())
			System.out.println("Sorry I can't repair this item. Please contact someone else");
		else {
			object.repair();
			System.out.println("Your item has been successfully repaired.");
		}
	}
}
```

Finally, we have InterfaceTest driver class which will illustrate all the concepts of interface discussed till now.

```java
public class InterfaceTest {

	public static void main(String args[]) {

		Repairable[] item_to_repair = new Repairable[3];

		item_to_repair[0] = new TeslaCar("Model S", 4, 250.0);
		item_to_repair[1] = new SonyMusicPlayer();
		item_to_repair[2] = new TeslaCar("Model X", 4, 210.0);

		for (Repairable item : item_to_repair)
			RepairingGuy.doRepair(item);

	}
}
```

### A more real-world example.

Yayy!! It's festival time in your house and you're busy with all the arrangements.

Now there are a lot of people that are involved in the various chores in the house. These people include the electrician, plumber, painter, cook etc.

As such, every person is given the responsibility to do **his own work** with utmost dedication. Obviously, every person has a job and is not concerned with the job of any other person. 

> Hint: Unrelated entities that we discussed in class.

Therefore, we can think of an interface Workable that has a structure as follows:

```java

public interface Workable {
	void doWork();
}

```

Every person should implement this interface in his own way because **they all do their own work which is not related to the other in any way**.

Coming to the various **Concrete Implementations** :

```java

class Plumber implements Workable {

	/**
		This method is overridden.
	*/
	public void doWork() {
		System.out.println("I am here to fix the toiletries.")
	}

	// Other methods.
}

class Cook implements Workable {

	/**
		This method is overridden.
	*/
	public void doWork() {
		System.out.println("I am here to cook delicious food.")
	}

	// Other methods.
}

class Electrician implements Workable {

	/**
		This method is overridden.
	*/
	public void doWork() {
		System.out.println("I am here to fix all electrical appliances.")
	}

	// Other methods.
}

class Painter implements Workable {

	/**
		This method is overridden.
	*/
	public void doWork() {
		System.out.println("I am here to paint the house with vibrant colours.")
	}

	// Other methods.
}

```
# Multithreading

* [Oracle Java Docs on Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

* [Geeksforgeeks article on Multithreading](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

* [Multithreading in Java using Thread Class [Sample code]](SampleThread.java)

	```java
	class Thread1 extends Thread {

		@Override
		public void run() {
			while (true) {
				System.out.println("I am Thread1.");
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					System.err.println("exception");
				}
			}
		}

	}

	class Thread2 extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("I am Thread2.");
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					System.err.println("exception");
				}
			}
		}

	}

	class SampleThread {
		public static void main(String args[]) throws Exception {

			Thread t1 = new Thread1();
			t1.start();// separate stack memory is allocated, then run gets called
			Thread t2 = new Thread2();
			t2.start();// separate stack memory is allocated, then run gets called

			while (true) {
				System.out.println("I am main thread.");
				Thread.sleep(1000);
			}
		}
	}
	```

* [Multithreading in Java using Runnable Interface [Sample code]](SampleThreadRunnable.java)

	```java
	public class SampleThreadRunnable implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("I am secondary thread.");
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					System.err.println("exception");
				}
			}
		}

		public static void main(String args[]) throws Exception {

			Runnable r = new SampleThreadRunnable();
			Thread t = new Thread(r);
			t.start();// separate stack memory is allocated, then run gets called

			while (true) {
				System.out.println("I am main thread.");
				Thread.sleep(700);
			}

		}

	}
	```

# Note

The raw file of all the codes in this article can be found [here](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Java/2021_04_30_JavaClass-4).

I hope by the above examples you got the gist of interfaces. In case of any doubts, feel free to contact us. We are happy to help. :)

In the above article, we have tried to explain when to use Abstract Classes and when to use Interfaces. For the first timers, many things might not make any sense. It is only after when you read a lot of good code that these things will start making sense. As greatly said-

> To write good code you must read good code.

Interfaces and Abstract Classes are highly confusing concepts, So in case of any doubt feel free to reach any of the CC Club coordinators.

{% include disqus.html %} 
