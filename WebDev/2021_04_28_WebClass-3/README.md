# Web Development Class - III

#### April 28, 2021

<div align="center"><img src="./images/frontend.jpg" alt="Frontend" height=150/></div>

<hr>


<div align="center"><h2>JavaScript</h2></div>

*	### What is JS?
	* JavaScript is a **Scripting Language**, used to make web pages dynamic.
	* If HTML is the *BONES*, then JS is the *MUSCLES* of a webpage.

*	### Scripting Language
	* Basically, all scripting languages are programming languages.
	* Scripting languages are interpreted e.g. JS, PHP, Python. Suitable for purposes where changes in code are more frequent.
	* Programming languages are compiled e.g. Java, C, C++. Suitable for purposes where changes in code are less frequent.
	* But Technically, Scripting languages are not fully interpreted theses days, they are compiled JIT(Just In Time).
	* JIT Compilation -> Byte Code(Intermediate-level Non-Runnable Code) -> Interpretor -> Machine Code(Binary) -> CPU Execution.
	* **Types** - Server-side scripting languages(JS, Python, PHP) and client-side scripting languages(JS).

*   ### JS Engine
	* As per wiki:- "A Computer Program that executes JS code. The first JavaScript engines were mere interpreters, but all relevant modern engines use **just-in-time compilation** for improved performance."
	* **Example** - Google's V8 Engine (Used in Google Chrome, NodeJS runtime environment).

*   ### Where to put JS inside HTML file?
	* Using **script** tag:
		```html
		<script>
			console.log("Hello World!");
		</script>
		```
	* Using **src** attribute of **script** tag:
		Put JavaScript code in a separate _**.js**_ file and include it inside html file.
		```html
		<script src="js_file.js"></script>
		```
	
*   ### Async and Defer Boolean attributes of script tag.
	* **Without *async* or *defer*** -  
		* JavaScript files are fetched (downloaded) and executed in order of their presence in html file.
	* **With *defer*** - 
		* The file gets downloaded **asynchronously** along with HTML Parsing, but executed only when the document parsing is completed. 
		* They are executed in order of their presence in html file.
	* **With *async*** - 
		* The file gets downloaded asynchronously along with HTML Parsing but executed as soon as it’s downloaded. 
		* So, the order of execution is not fixed.
		<div align="center"><img src="./images/async_defer" alt="Async_Defer" height=150/></div>

*   ### Important JS Primitive Data-types
	* number
	* boolean
	* string
	* undefined
	* null


*   ### JS Objects
	* An object is a collection of properties or key-value pairs. 
	* value can be a primitive value, an other object, a function etc.
	* **dot-notation** is used to access property of an object -  
	```javascript
	objectName.propertyName
	```
	* Unassigned properties of an object are *undefined*.
	* **for-in** loop can be used to access all key-value pairs of an object.


*	### Scope in JS
	* Scope tell the visibility/accessibility of an entity(variable, function, object etc.)
	* **Global Scope** - 
		* Variables which can be accessed using window object. 
		* Entities (variables, functions, objects) defined in this scope can be accessed inside any block or fucntion of the script.
	* **Block Scope** - 
		* Statements written inside a set of {} makes a block. 
		* Variables defined using **let** and **const** are block scoped i.e. they are visible only inside the block where they are defined.
	* **Local Scope** - Variables defined inside a function are visible only inside the function i.e. they are local to that function.

### Material

* [W3Schools JS Basics Tutorial](https://www.w3schools.com/js/default.asp).
* [W3Schools JS HTML DOM Tutorial](https://www.w3schools.com/js/js_htmldom.asp). 
* [JS Video Tutorial Playlist](https://www.youtube.com/watch?v=cvvwkgp4HBg&list=PLu0W_9lII9ajyk081To1Cbt2eI5913SsL) (Hindi)
* [JS Video Tutorial Playlist](https://www.youtube.com/watch?v=hdI2bqOjy3c&list=PLillGF-RfqbbnEGy3ROiLWk7JMCuSyQtX) (English)
* [Bulb On Off Example](./bulb_on_off)