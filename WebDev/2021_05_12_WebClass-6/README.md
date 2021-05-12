# Web Development Class - VI

#### May 12, 2021

<div align="center"><h3>Polling App in Django</h3></div>

### Prerequisite
* Make sure that you've set up a Django Project as demonstrated in previous class. If not, you can take help from [here](https://cc-mnnit.github.io/2021-22-Classes/WebDev/2021_05_10_WebClass-5/).

### What is polling app?
* It is an app (or web app) where some questions will be present.
* Each questions will have multiple options.
* For each question, visitors can vote on any one of the options.
* On the Index page of web app, there will a list of all the questions.
* For each question, there will be two options - **detail** and **results**.
* By clicking on **detail** link, visitor will be able to see all the options and will be able to vote.
* By clicking on **result** link, visitor will be able to see the results of voting for that question.

### Creating a new app
* We will create a new app by the name **polls**.
* Run the following command in PyCharm's terminal

```
python manage.py startapp polls
```
* Now you'll notice that a new folder **polls** has been created. It has some python files in it -  
	* **views.py file** - Here the views (Python functions) will be written.
	* **models.py file** - Here the models (tables) required for this app will be created.
* Notice that **urls.py** file is missing from this folder. *What to do now?*
* *It's simple, we will create it ourselves.* Create a new file **urls.py** in **polls** folder.
* Last but not the least, we will have to add this app in the **INSTALLED_APPS** list of **settings.py** file.

```python
# In project1/settings.py file
INSTALLED_APPS = [
	'polls.apps.PollsConfig',

	# Below are the pre-installed apps which were already present
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
]
```

* **Note** - If you app's name was `foo`, you'd have added `foo.apps.FooConfig` in **INSTALLED_APPS** list.

### Writing our first view
* So, respecting the tradition, the very first view which we'll write, will print **Hello World!** in our website's main page.
* Open **views.py** file and write the following code

```python
# In project1/polls/views.py file
def hello_world(request):
	print("This is my first view! Hello World!")
	return HTTP_RESPONSE("Hello World!")
```

* So, our very first view is ready. *What do we need to do now? Any Guesses?*.

### Mapping view with URL
* For a view to get executed, we need to map/attach a URL to that view.
* Now, when there will be a request on that URL, our view will be called.
* **Reminder** - View is just a Python Function. It must be **called** so that it can perform the task which was expected from it.
* We want **Hello World!** to be displayed on the main page of our website (i.e. `http://127.0.0.1:8000/`).
* Go to **project1/urls.py** file and add the following line in the **URL_PATTERNS** list
```python
# In project1/urls.py file
from django.urls import path, include
path("/", include("polls.urls")),
``` 

* The **URL_PATTERNS** should look like

```python
# In project1/urls.py file
URL_PATTERNS = [
	path("/", include("polls.urls")),
	path("admin/", admin.site.urls),
]
```

* Now open **project1/polls/urls.py** and add following code

```python
# In project1/polls/urls.py file
from django.urls import path
from polls import views

URL_PATTERNS = [
	path("/", views.hello_world),
]
```

### Testing our first view
* Run the server by running following command in **PyCharm's terminal**.

```
python manage.py runserver
```

* Now visit `http://127.0.0.1:8000/` on your browser and you must see **Hello World!** there.
* Also, see in PyCharm's terminal, you'll see `This is my first view! Hello World!` printed there. ***WHY?***

### Desiging database for polls app
* After this short success of running our first view, we will now move on to desiging the database for our app.
* We have already listed all the **functionalities and requirements** of our app at the beginning.
* Have a look at them and ***think*** what tables need to be made for our app?
* What **columns** should these tables have?
* Also think of **Primary Keys** and **Foreign Keys**. 
* *THINK YOURSELF FIRST! DO NOT SCROLL DOWN!*

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<div align="center"><img src="./images/warning.png" height="500" /></div>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

* We will design a simple database for this demo polling app.
* We will create a Table called **Questions**. It will have following attributes/columns
    * **question_id** *Integer* (Primary Key)
    * **question_text** *String*
    * **publication_date** *Date*
* We will also create a Table called **Choices**. It will have the following attributes/columns
    * **choice_id** *Integer* (Primary Key)
    * **choice_text** *String*
    * **number_of_votes** *Integer*
    * **question** (Foreign Key References Questions Table)

### Recap: Django Models
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

### Creating models for our app
* Based on above decided design, we will now make models in **project1/polls/models.py** file.
* For **Questions** Table, write the following code

```python
# In project1/polls/models.py
class Question(models.Model):  # Model class from models module is inherited in class Question.
    
    question_text = models.CharField(max_length=1000, verbose_name="Text")

    publication_date = models.DateField(verbose_name="Publication Date")

    def __str__(self):  #  A method is declared so that in admin panel Text of Question is displayed.
        return self.question_text

```

* Note that we have not added **question_id** field. *Why?* This is because for each model, **Django creates a Primary Key by default**. It's name is **id** or **pk**.

* For **Choices** Table, write the following code

```python
# In project1/polls/models.py
class Choice(models.Model):

    choice_text = models.CharField(max_length=200, verbose_name="Choice Text")

    number_of_votes = models.IntegerField(verbose_name="Number of Votes")

    question = models.ForeignKey(Question, verbose_name="Question")

    def __str__(self):
        return self.choice_text
```

* Now can you relate and see the similarities b/w these **Python classes** and **Database's Tables**?
* Visit this link to see all possible **Field Types** - [Django Models Field Types](https://docs.djangoproject.com/en/3.2/ref/models/fields/#field-types)
* So, are these tables created in the database? *Answer is Not Yet*. 
* This is just the Python Code from which Django will create the tables when we order it to.
* Two remaining steps are - **makemigrations** and **migrate**.
* **makemigrations** - This command orders Django to **write queries for our models** in selected database engine in a python file. In other words, **migration file is created**.
    * Still these tables are **NOT** created in the database.
    * Django has just written the SQL queries for creating the databases in a Python file present under **Migrations** folder.
* **migrate** - This command orders Django to **actually create the tables** in database by running the queries that it created in **makemigrations** step. 
* Now there's one more thing, Django comes with some **preinstalled apps**. Those apps also have some models of thieir own.
* When we install Django, we are already provided with migrations for these Tables. We just need to **migrate** them.
* So, we will follow the following steps
    * Firstly we will create tables for preinstalled Django Apps.
    
    ```
    python manage.py migrate
    ```
    
    * Then we will create migration files for our models defined in **polls** app.
    
    ```
    python manage.py makemigrations polls
    ```
    
    *OR*

    ```
    python manage.py makemigrations
    ```
        
    * Go check in **Migrations** folder of **polls** app, you'll find a file like **0001_initial.py**. *Don't be afraid, you can open that file and see what's inside!*
    * Now finally we will again **migrate**. This will create the Tables Questions and Choices.
    
    ```
    python manage.py migrate
    ```
    
    * To see **migration** i.e. **queries made in migration**, run following command in PyCharm's terminal
    
    ```
    python manage.py sqlmigrate polls 0001_initial
    ```

* So, finally, our tables have been created. *But where's the proof? How do we see the tables?*

### Django Admin Panel
* So now we'll introduce you to one of the most famous feature of Django, the **Django Admin Panel**.
* It is somewhat like **PHPMyAdmin** with better UI and features to manage our database.
* Generally, with other Web Frameworks, developers need to create their own Administration Panel, but Django provides us with inbuilt Admin Panel.
* Start the server

```
python manage.py runserver

```
* Visit `http://127.0.0.1:8000/admin`. A page will open asking for **username** and **password**.
* *What to enter here? We've not created any account yet! Why is it asking for Password?*
* It's because Django does not want **unauthorised visitors** to mess with your tables and databases as it can be catastrophic.
* *So How will you enter into the Admin Panel?* Turn into a **superuser** and Django won't stop you.
* We need to create a **superuser** which can access the Admin Panel without any restrictions. 
* Press `Ctrl + C` to stop the server and run the following command in **PyCharm's terminal**.

```
python manage.py createsuperuser
```

* Enter following details
```
Username: admin
Email: admin@admin.com
Password: 
Password (again):
```
* Now **superuser** have been created successfully. 
* Start the server again and visit `http://127.0.0.1:8000/admin`. Use the credentials of **superuser** to enter into Admin Panel.
* *Do you see Questions and Choices tables? Have you been betrayed?* The answer is **NO**.
* For our tables to appear on Admin Panel, we first need to register them from **admin.py** file.
* Write following code in **project1/polls/admin.py**

```python
# In project1/polls/admin.py file
from .models import Question, Choice

admin.site.register(Question)
admin.site.register(Choice)
```

* Now, after the server restarts, you'll see that **Questions** and **Choices** table appear in the Admin Panel.
* *Go ahead and add some questions and choices*

### Users Table
* Are you wondering, from where did the **Users** table appear in Django's Admin Panel?
* *Did we create it and forgot?* The answer is obviously **NO**.
* This table was provided to us by Django and was created when we ran the very first **migrate** command.
* I am sure now you're **beginning to realise the power of Django** - you don't even need to create **Users** table for your website, it's already there.
* We will see later how we can save data of users using this **Users** table *(if time permits)*.

### Recap: Steps involed in Making/Editing a Table/Model in Django
* **Step 1 (Declaration)** - We **declare/edit** models in **models.py** file.
* **Step 2 (Activation)** - We run `python manage.py makemigrations` command. Migrated files are created. These files contains queries written by Django in selected Database Engine in a **.py** file.
* **Step 3 (Migration)** - We run `python manage.py migrate` command. Actual Tables/Database is created.
* **Step 4** - Visit **Django Admin Panel** to interact with the database.

### Content Contributors
    
* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials

* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=UmljXZIypDc&list=PL-osiE80TeTtoQCKZ03TU5fNfx2UY6U4p) (English)
* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=5BDgKJFZMl8&list=PLu0W_9lII9ah7DDtYtflgwMwpT3xmjXY9) (Hindi)
* [Django Models Field Types](https://docs.djangoproject.com/en/3.2/ref/models/fields/#field-types)
* [Python Resources](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Python)
