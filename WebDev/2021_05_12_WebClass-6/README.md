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
* **Note** - If you apps name was `foo`, you'd have added `foo.apps.FooConfig` in **INSTALLED_APPS** list.

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

### Content Contributors
    
* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials

* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=UmljXZIypDc&list=PL-osiE80TeTtoQCKZ03TU5fNfx2UY6U4p) (English)
* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=5BDgKJFZMl8&list=PLu0W_9lII9ah7DDtYtflgwMwpT3xmjXY9) (Hindi)
* [Python Resources](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Python)