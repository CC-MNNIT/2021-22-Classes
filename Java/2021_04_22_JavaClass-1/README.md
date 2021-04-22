# Java Class - I

## Get the Presentation used in class: [Here](Java_Class-1.pdf)

## Get the Java Class - I recording: [Here](https://drive.google.com/file/d/1iVqzpW_bpTvXt7hc1P-_cDtWuAM-Uw3A/view?usp=sharing)

#### April 22, 2021

<div align="center"><img src="../Java.png" alt="Java logo" height=150/></div>

<hr>


## Class Content:

### Class:
- Class defines a new data type. Once defined, this new type can be used to create objects of that type. Thus, a class is a template for an object, and an object is an instance of a class.
- When you define a class, you declare its exact form and nature. You do this by specifying the data that it contains and the code that operates on that data. While very simple classes may contain only code or only data, most real-world classes contain both.
- A class is declared by use of the class keyword.
#### **[1.java](1.java)**
```java
class Box {
    double width;
    double height;
    double depth;
}
```
- The data, or variables, defined within a class are called instance variables. The code is contained within methods. Collectively, the methods and variables defined within a class are called members of the class.
- Class is just a design(architecture) of a real world entity. It occupies no memory.
- For a better understanding, refer to this [article](https://medium.com/s/javaforhumans_1509490998109/java-for-humans-classes-objects-95be77501e5c).

### Object :-
- Class declaration only creates a template. It does not create an actual object.
- Objects are the variable of the class. Thus, it will have “physical” reality(memory).
- Each time you create an instance of a class, you are creating an object that contains its own copy of each instance variable defined by the class.
- In general, you use the dot operator to access both the instance variables and the methods within an object.
- For a better understanding about method and dot operator, refer to this [article](https://medium.com/s/javaforhumans_1509490998109/java-for-humans-methods-dot-notation-51077bab55e1).

#### **[2.java](2.java)**
```java
// This program uses a parameterized method.

class Box {
  double width;
  double height;
  double depth;

  // compute and return volume
  double volume() {
    return width * height * depth;
  }

  // sets dimensions of box
  void setDim(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }
}
  
class BoxDemo {
  public static void main(String args[]) {
    Box mybox1 = new Box();
    Box mybox2 = new Box();
    double vol;

    // initialize each box
    mybox1.setDim(10, 20, 15);
    mybox2.setDim(3, 6, 9);    

    // get volume of first box
    vol = mybox1.volume();
    System.out.println("Volume is " + vol);

    // get volume of second box
    vol = mybox2.volume();
    System.out.println("Volume is " + vol);
  }
}
```

- Each object has its own copies of the instance variables. Changes to the instance variables of one object have no effect on the instance variables of another.
- Obtaining objects of a class is a two-step process.
    - First, you must declare a variable of the class type. This variable does not define an object. Instead, it is simply a variable that can refer to an object.(Reference Variable)
    - Second, you must acquire an actual, physical copy of the object and assign it to that variable. You can do this using the new operator. The new operator dynamically allocates (that is, allocates at run time) memory for an object and returns a reference to it. This reference is, more or less, the address in memory of the object allocated by new. This reference is then stored in the variable.

### Constructor :-

- A constructor initializes an object immediately upon creation. It has the same name as the class in which it resides and is syntactically similar to a method. 
- The constructor is automatically called when the object is created, before the new operator completes.
- They have no return type, not even **void**.

#### **[3.java](3.java)**
```java
/* Here, Box uses a parameterized constructor to
   initialize the dimensions of a box.
*/
class Box {
    double width;
    double height;
    double depth;

    // This is the constructor for Box.
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // compute and return volume
    double volume() {
        System.out.println(this.width);
        return width * height * depth;
    }
}
  
class BoxDemo {
    public static void main(String args[]) {
        // declare, allocate, and initialize Box objects
        Box mybox1 = new Box(10, 20, 15); 
        // Box b1 = new Box(); This will cause error because of no default constructor.
        Box mybox2 = new Box(3, 6, 9);

        double vol;

        // get volume of first box
        vol = mybox1.volume();
        System.out.println("Volume is " + vol);

        // get volume of second box
        vol = mybox2.volume();
        System.out.println("Volume is " + vol);
    }
}
```

### this Keyword :-

- Sometimes a method will need to refer to the object that invoked it. To allow this, Java defines the this keyword. this can be used inside any method to refer to the current object.
- This is always a reference to the object on which the method was invoked. You can use this anywhere a reference to an object of the current class’ type is permitted.

#### **[4.java](4.java)**
```java
// Use this to resolve name-space collisions.
Box(double width, double height, double depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
}
```

# Further readings (topics not covered in 1st class)

### Overloading

- In Java, it is possible to define two or more methods within the same class that share the same name, as long as their parameter declarations are different. When this is the case, the methods are said to be overloaded, and the process is referred to as method overloading.
- Method overloading is one of the ways that Java supports polymorphism.
- When Java encounters a call to an overloaded method, it simply executes the version of the method whose parameters match the arguments used in the call.

#### **[5.java](5.java)**
```java
// Demonstrate method overloading.
class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

    // Overload test for one integer parameter.
    void test(int a) {
        System.out.println("a: " + a);
    }

    // Overload test for two integer parameters.
    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    // overload test for a double parameter
    double test(double a) {
        System.out.println("double a: " + a);
        return a*a;
    }
}
  
class Overload {
    public static void main(String args[]) {
        OverloadDemo ob = new OverloadDemo();
        double result;

        // call all versions of test()
        ob.test(); 
        ob.test(10);
        ob.test(10, 20);
        result = ob.test(123.25);
        System.out.println("Result of ob.test(123.25): " + result);
    }
}
```

- In addition to overloading normal methods, you can also overload constructor methods.

#### **[6.java](6.java)**
```java
// Automatic type conversions apply to overloading.
class OverloadDemo {
    void test() {
        System.out.println("No parameters");
    }

    // Overload test for two integer parameters.
    void test(int a, int b) {
        System.out.println("a and b: " + a + " " + b);
    }

    // overload test for a double parameter and return type
    void test(double a) {
        System.out.println("Inside test(double) a: " + a);
    }
}
  
class Overload {
    public static void main(String args[]) {
        OverloadDemo ob = new OverloadDemo();
        int i = 88;

        ob.test(); 
        ob.test(10, 20);

        ob.test(i); // this will invoke test(double)
        ob.test(123.2); // this will invoke test(double)
    }
}
```

### Access Control
- You can control what parts of a program can access the members of a class. By controlling access, you can prevent misuse.
- When a member of a class is modified by public, then that member can be accessed by any other code.
- When a member of a class is specified as private, then that member can only be accessed by other members of its class.

#### **[7.java](7.java)**
```java
/* This program demonstrates the difference between
   public and private.
*/
class Test {
    int a; // default access
    public int b; // public access
    private int c; // private access

    // methods to access c
    void setc(int i) { // set c's value
        c = i;
    }
    int getc() { // get c's value
        return c;
    }
}
  
class AccessTest {
    public static void main(String args[]) {
        Test ob = new Test();

        // These are OK, a and b may be accessed directly
        ob.a = 10;
        ob.b = 20;

        // This is not OK and will cause an error
        //  ob.c = 100; // Error!

        // You must access c through its methods
        ob.setc(100); // OK
    
        System.out.println("a, b, and c: " + ob.a + " " +
                        ob.b + " " + ob.getc());
    }
}
```
