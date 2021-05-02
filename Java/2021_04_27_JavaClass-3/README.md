# Java Class - III (Java GUI Class - I)

#### April 27, 2021

## Get the Java Class - III recording: [Here](https://drive.google.com/file/d/15f4Jlyz7oUaicB82MQQfE8ZeGKO6FtbW/view?usp=sharing)

## Get the Calculator project made during the class: [Here](TestCalculator)

<div align="center"><img src="./img/JavaFX_Logo.png" alt="Java logo" height=100/></div>

<hr>

## Class content:

-   [Installation instructions](https://docs.google.com/document/d/1MrsuUJ05V6GazqPcjNPifAi3UjLHhCnU4QiN-4fvJyc/edit?usp=sharing)
-   Installation of Java 8
-   Installation of IntelliJ IDEA
-   Installation of Scene Builder + JFoenix
-   Why Java 8 why not the newer java version?

    For answer: [Click here](https://dzone.com/articles/a-guide-to-java-versions-and-features)

-   Why JavaFx?: [Click here](https://medium.com/@shanekhantsoemoe98/why-should-i-use-javafx-42e41d485178)
    1.  JavaFX can be styled with CSS, whereas Swing cannot be. If we want to style Swing GUIs with CSS, we will need to use third party sources like [flying-saucer](https://code.google.com/archive/p/flying-saucer/). Being able to implement CSS is a unique functionality of JavaFX, and that alone lets programmers easily and swiftly create cool designs in applications.
    2.  JavaFX makes programmers’ life easy by offering [“JavaFX scene builder”](http://www.oracle.com/technetwork/java/javase/downloads/sb2download-2177776.html) with which programmers can create GUI controls like buttons via drag and drop.
    3.  JavaFX supports [Java Lambda expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) in action-triggering events unlike Swing. Using Lambda expressions, JavaFX promotes code readability and just needs fewer lines of code than Swing.
    4.  JavaFX has built-in data visualization such as 2D charts
    5.  JavaFX 3D API is an awesome API to create 3D objects in creating games or customizing charts in JavaFX.
    6.  JavaFX is a good alternative GUI for Android and iOS, meaning JavaFX is portable now. Though JavaFX is not as good as native GUIs, it still performs smoothly on both Android and iOS platforms by using [Gluon](http://gluonhq.com/javafx-3d-now-available-android-ios/).

-   Why Desktop Application Development?

    For answer: [Click here](https://www.noodle.com/articles/how-to-become-a-desktop-developer-desktop-is-not-dead).

-   What is JavaFx?
    
    Answer: [Click here](http://tutorials.jenkov.com/javafx/overview.html)

    1.  Stage
    2.  Scenes
    3.  Layouts
    4.  Controls

-   FXML and Controller classes

    1.  Controller classes are only for writing logic of the UI components.
    2.  Other classes may be used for other purposes like fetching data from APIs or connecting to a socket.
    
-   Nomenclature: [Click here](https://www.javatpoint.com/java-naming-conventions)
    1.  Class
    2.  Methods
    3.  Variables

-   Folder Structure
    -   <projectdir>/src/main/java/ - Contains all your java code
    -   <projectdir>/src/main/resources/ - Contains your css, images, and fxml files

-   What is Maven?
    A build automation tool or a package manager 
    Dependencies repository : (https://mvnrepository.com/) 

-   Add following line in pom.xml
    ```xml
    <packaging>jar</packaging>
    ```
-   Class outcome:

    <img src="./img/Screenshot_Calc.png" alt="Calculator in IntelliJ Idea" height=250/>

-   Further readings:
    1. [JavaFX 8 docs](https://docs.oracle.com/javase/8/javafx/api/toc.htm)
    2. [Last year JavaFX class resources](https://github.com/CC-MNNIT/2020-21-Classes/tree/master/Java/2020_10_05_Java-Class-9)
    3. [Getting started by JavaFX 8 by Oracle](https://drive.google.com/file/d/1-uDCPiW9WYFVsJBq4V7e-S3gDPNWxgnq/view?usp=sharing)

-   Content contributors:
    1. [Aritra Chatterjee](https://github.com/Arc29)
    2. [Manish Kumar](https://github.com/thisismanishkumar)
