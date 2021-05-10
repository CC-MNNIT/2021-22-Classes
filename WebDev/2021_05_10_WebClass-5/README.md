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

### Setting up Django Project
* **Step 1** - Install Python 3.
* **Step 2** - Run `python --version` or `python3 --version` in your command prompt or terminal to check whether Python is successfully installed or not.
* **Step 3** - Go to directory where you want to create the project.
* **Step 4** - Make a new folder named **Django_Projects**.
* **Step 5** - Right Click in that directory and open command prompt or terminal.
* **Step 6** - Run the following command to create a **virtual environment**.
	```
	python -m venv djenv
	```
* **Step 7** - Activate the environment.
	* In **Windows** run the following command - 
	
	```
	djenv\scripts\activate
	``` 
	
	* In **Linux/Mac** run the following command - 

	```
	source djenv/bin/activate
	```

	* After this step you should see environment name besides the command line as shown below.

	<div align="center"><img src="./images/env.png" /></div>

* **Step 8** - Download and install Django
	
	```
	python -m pip install --upgrade pip
	pip install django
	```

	* This will download and install necessary files.
	* To verify the installation type following command - 

	```
	python
	>>> import django
	>>> django.VERSION
	```

	* If output matches with the following output, then django is properly installed. Your django version might be different from the one shown in this image.

	<div align="center"><img src="./images/dj_ins.png" /></div>

* **Step 9** - Starting a project in Django.
	
	```
	django-admin startproject project1
	```

	* **project1** is just the project name.

* **Step 10** - Open **PyCharm Professional IDE**. Open **project1** in PyCharm.

* **Step 11** - Setting Virtual environment for project in PyCharm
	* After opening **project1** in PyCharm go to **File** and open **Settings**.
	* Click on **Project:project1** and then select **Project Interpreter**.
	* Click on **Settings icon**, then click on **Add** and then select **Existing Environment**.
	* Select **djenv/Scripts/python3.exe** or **djenv/bin/python3.exe** from Interpreter dropdown and click **OK**.
	* Click **OK** again.
	* Now open the terminal in Pycharm and you'll se `(djenv)` written in it just like Step 7.

### Content Contributors
    
* [Ankit Sangwan](https://github.com/ankitsangwan1999)
* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials
