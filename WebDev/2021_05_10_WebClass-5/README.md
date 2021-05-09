# Web Development Class - V

#### May 10, 2021

<div align="center"><img src="./images/django.png" alt="django" height="220" /></div>

<hr>

<div align="center"><h2>Django Web Framework</h2></div>

### What is Django?
* Django is a **web development framework**.
* It helps in **building** and **maintaining** quality web applications.
* Django helps **eliminate repetitive tasks** making the development process an easy and time saving experience.

### Library vs Framework
* When we use a library, **we are in charge of the application flow**. 
* We choose when and where to call the library. 
* When you use a framework, the **framework is in charge of the flow**. 
* It provides you with a few places to plug in your code, but it calls the code you plugged in as needed.

<div align="center"><img src="./images/lib_vs_framework.png" height="270" /></div>

### Django Apps
* A Django Project is collection of multiple apps.
* These apps are **standalone** components.
* One app can be used in different projects and one project can have multiple apps.
* It promotes **DRY (Do Not Repeat Yourself)** principle.

### Django MVT
* MVT stands for **Model View Template**.
* Django is based on MVT Pattern.
* It has **four** core components - 
	* **URLs** -
		* Request sent by users' browsers come here.
		* Each **URL** is mapped with some **view**.
		* This mapping of URL and view is written is written in **urls.py** file.
	* **Views** - 
		* A view is a python function written inside **views.py** file.
		* Each view is mapped/attached with a URL.
		* Whenever a request comes on a URL, view (function) mapped/attached to that URL is called.
		* A view interacts with tables (models) in database to fetch/store required data.
		* Finally, a view **returns the response** to user in form of **templates**.
	* **Templates** - 
		* It is basically a HTML document which is returned as a response to the browser.
		* A view, fits in required data into the template (HTML file) and then returns the template.
		* HTML files are kept in a directory called **templates** in each app.
	* **Models** - 
		* Models define the **tables** in the database with help of **Object Oriented Programming**.
		* These models are basically **Python classes**, which represent a Table in Database.
		* These classes are defined in **models.py** file.
		* **Class Variables** of Model (Class) represent **Attributes/Columns** of Table.
		* **Instances/Objects** of Model (Class) represent **Rows/Tuple** in Table.

		* | Object Oriented Programming | Database |
		  | ----- | -------- |
		  | Class | Table    |
		  | Class Variables | Columns |
		  | Instances/Objects of Class | Rows/Tuple in table |

* Generally, each app in a Django project has it's own **urls**, **views**, **models**, and **templates**.
* This promotes **de-coupling** and helps in making an app a standalone component.

### A Real World Analogy
* Here, we will try to understand a real - world scenario.
* Later we will relate this real world scenario with Django to better understand components of Django.

<div align="center"><img src="./images/real_world.png" /></div>

### Relating real-world analogy with Django

<div align="center"><img src="./images/relating.png" /></div>

### Content Contributors
    
* [Ankit Sangwan](https://github.com/ankitsangwan1999)
* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials
