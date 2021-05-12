# Web Development Class - VI

## Web Development Class - VI recording: [Here](https://drive.google.com/file/d/1Q7uyvy33VvwXyYMrRw1fApWKk5ikiKUC/view?usp=sharing)

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
from django.shortcuts import render, HttpResponse

def hello_world(request):
	print("This is my first view! Hello World!")
	return HttpResponse("Hello World!")
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

    question = models.ForeignKey(Question, on_delete=models.CASCADE())

    def __str__(self):
        return self.choice_text
```

* **models.CASCADE()** - **Cascade** means that if a table is deleted, then all it's related from in other tables is also deleted. **Example** - In this case when a **Question** is deleted from database, **Choices** corresponding to that question will also be deleted.

* **models.DO_NOTHING()** - In this case on deleting a **Question**, **Choices** related to that question won't be deleted.

* **models.RESTRICT()** - This will **not allow** any **Question** to be deleted as long as there is a **Choice** present for that question. If we want to delete the **Question**, firstly we will have to delete all the **Choices** related to that question.

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

### Interacting with database using CLI
* We have already seen how to interact with database using **GUI (Graphical User Interface)** i.e. by using **Django Admin Panel**.
* Now we will see how we can get similar things done by Python code using **CLI (Command Line Interface)**.
* Django provides **APIs** for facilitating **CRUD (Create, Read, Update, Delete)** operations on the database.
* There is **no need** to write SQL Queries for this. *Another advantage of mighty Django!*
* Run following command in **PyCharm's terminal** to open **Python console** where we'll be typing our commands to interact with database.

```
python manage.py shell
```

* Now we will perform CRUD on database using CLI
    * **C (CREATE)** - Adding a new question from CLI
        ```python
        # In Python console
        >>> from polls.models import Question, Choice
        >>> from django.utils import timezone
        >>> new_ques = Question(question_text="Which is better, GUI or CLI?", publication_date=timezone.now)
        ```
        * Here we have created an **object** or **instance** of **Question** class.
        * Open another terminal and start server. Now check from **Admin Panel** whether this new question has been added or not?
        * We have just created an object of Question class. To save it to database, we will need to call **save()** method.
        ```python
        >>> new_ques.save()
        ```
        * Now again check the **Admin Panel**. You'll **a new row** has appeared in **Questions** table.
    * **U (UPDATE)** - Updating Question Text of the question we just created.
        ```python
        >>> new_ques.question_text = "Which is better, GUI (Graphical User Interface) or CLI (Command Line Interface)?"
        >>> new_ques.save()
        ```
        * **Do not forget** to use `save()` method after **creation** and **updation**.
    * **R (READ)** - Reading/Fetching all the questions saved in database till now.
        ```python
        >>> all_questions = Question.objects.all()
        >>> print(all_questions)
        ``` 
        * Reading/Fetching question with **id = 1**. **get** returns only 1 record.
        ```python
        >>> ques = Question.objects.get(id=1)
        >>> ques = Question.objects.filter(id=1)
        ```
        *OR*
        ```python
        >>> ques = Question.objects.get(pk=1)
        >>> ques = Question.objects.filter(pk=1)
        ```
        * Reading/Fetching all questions which start with word **How**.
        ```python
        >>> ques_how = Question.objects.filter(question_text__startswith="How")
        ```
    * **D (DELETE)** - Deleting ques with **id = 1** from database.
        ```python
        >>> ques = Question.objects.get(id=1)
        >>> ques.delete()
        # OR
        >>> Question.objects.get(id=1).delete()
        ```

* **Some useful methods** - 
* **all()** - 
    * It is used to fetch all the records present in any table.
    * It returns a **QuerySet**.
* **get()** - 
    * It returns a single matching object from the table based on any condition.
    * It will **raise an exception** in case the record matching the given condition is not present.
* **filter()** - 
    * In this a **QuerySet** of records matching the specified condition is returned.
    * In case, there is no record matching the given condition, it returns **Null QuerySet** and **does not raise exception**.
    * Many time we use **filter** instead of **get** like this.

```python
ques_qs = Question.objects.filter(id=1)
if ques_qs:
    ques_obj = ques_qs[0]  # ques_qs.first()

# OR
ques_obj = Question.objects.filter(id=1)[0]

# OR
ques_obj = Question.objects.filter(id=1).first()
```
    
* **create()** - 
    * It is used to **create an object** and **save** it at the same time to the database.
    * We do not need to call **save()** method if we use **create()**.
    * **Example** -

```python
new_ques = Question.objects.create(question_text="New Question", publication_date=timezone.now)
``` 

* **save()** - 
    * It is used to save changes to the database after **creating a new object** (without using **create()**) or after **updating any existing object**.

* **order_by()** - 
    * Used to Order the records in **Ascending** or **Descending** order based on any attribute.
    * **Example** - Ordering Questions by Publication Date.

```python
ordered_ques = Question.objects.order_by('publication_date')

# Reversing order

reverse_ordered_ques = Question.objects.order_by('-publication_date')
```

* **exclude()** - Used to exclude some objects based on some condition. *EXPLORE ON YOUR OWN!*

* **QuerySet** - 
    * It is a **list of objects** of a given Model.
    * QuerySets allow us to read the data from the database, filter it and order it, etc.

### Content Contributors
    
* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials

* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=UmljXZIypDc&list=PL-osiE80TeTtoQCKZ03TU5fNfx2UY6U4p) (English)
* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=5BDgKJFZMl8&list=PLu0W_9lII9ah7DDtYtflgwMwpT3xmjXY9) (Hindi)
* [Django Models Field Types](https://docs.djangoproject.com/en/3.2/ref/models/fields/#field-types)
* [Python Resources](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Python)
