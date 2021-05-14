# Web Development Class - VII

#### May 14, 2021

<div align="center"><h3>Polling App in Django (Continued)</h3></div>

### Recap: Steps involed in Making/Editing a Table/Model in Django
* **Step 1 (Declaration)** - We **declare/edit** models in **models.py** file.
* **Step 2 (Activation)** - We run `python manage.py makemigrations` command. Migrated files are created. These files contains queries written by Django in selected Database Engine in a **.py** file.
* **Step 3 (Migration)** - We run `python manage.py migrate` command. Actual Tables/Database is created.
* **Step 4** - Register the models in **admin.py** and visit **Django Admin Panel** to interact with the database.

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
        >>> new_ques = Question(question_text="Which is better, GUI or CLI?", publication_date=timezone.now())
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
new_ques = Question.objects.create(question_text="New Question", publication_date=timezone.now())
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

* **What is QuerySet?** - 
    * It is a **list of objects** of a given Model.
    * QuerySets allow us to read the data from the database, filter it and order it, etc.

### Creating Choices for questions
* Till now we have only added **Questions**. Now we will create **Choices** for these **Questions**.

```python
>>> choice1 = Choice(choice_text="GUI", number_of_votes=0, question=new_ques)
>>> choice1.save()
>>> choice2 = Choice.objects.create(choice_text="CLI", number_of_votes=0, question=new_ques)
```

* Here you might notice that initially, **number_of_votes** will always be zero. 
* So for this we can specify a **default** value while declaring **models**.

```python
# In polls/models.py
class Choice(models.Model):
	...
	number_of_votes = models.IntegerField(default=0, verbose_name="Number of Votes")
	...
```

* If you've done above change, make sure to run **migrations** and **migrate** command for this change to actually reflect in database.

### Main Page of Polls App
* So finally, now we will make the main page of our web app.
* As we have already discussed, it will contain the **list of all the questions** and two links (**details** and **result**) with each question. *Think what we need to do now?*
* We will have to **create a view** which - 
	* **fetches** list of questions from database, 
	* **fits** it in the HTML page, and 
	* **returns** it back to the browser.
* Also this view will be **mapped/attached to a URL** i.e. it will get called when this particular URL will be entered in browser.
* Let's choose this URL to be `http://127.0.0.1/polls`.
* Make sure **urlspattern** of **project1/urls.py** file looks like this.

```python
# In project1/urls.py

urlpatterns = [
	path("polls/", include("polls.urls")),
	path("admin/", admin.site.urls),
]
```

* Now we will map this view with the decided URL.

```python
# In polls/urls.py
from polls import views

urlpatterns = [
	path('', views.main_page, name="Main Page"),
	# Eg: http://127.0.0.1:8000/polls

	path('<int:ques_id>/details/', views.details, name="Details"),
	# Eg: http://127.0.0.1:8000/polls/1/details	, where ques_id=1

	path('<int:ques_id>/results/', views.results, name="Results"),	
	# Eg: http://127.0.0.1:8000/polls/1/results , where ques_id=1

	path('<int:ques_id>/vote/', views.vote, name="Vote"),	
	# Eg: http://127.0.0.1:8000/polls/1/vote , where ques_id=1

]
```

* *What is `<int:ques_id>` in above URLs?*. It is a part of URL which will be **passed by Django** to the **attached view as a parameter** while calling it.
* Here it is used to uniqely identify a **Question**.
* So, let's move on to **polls/views.py** and create our view.

```python
# In polls/views.py file
from django.shortcuts import HttpResponse
from polls.models import Question

def main_page(request):

	response = "This page will show list of all questions"

	return HttpResponse(response)


def details(request, ques_id):

	response = "This page will show Details of question with id=" + str(ques_id)
	return HttpResponse(response)


def results(request, ques_id):

	response = "This page will show Results of voting on question with id=" + str(ques_id)
	return HttpResponse(response)


def vote(request, ques_id):
	print("Voting on question with id=" + str(ques_id))
	pass
```

* The **ques_id** parameter being passed in **details()** and **results()** view is the same parameter which is coming from the URL attached to these views.
* Now start the server and visit 
	* `http://127.0.0.1/polls` - Main Page having Question List
	* `http://127.0.0.1/polls/1/details` - Details of Question with question_id = 1
	* `http://127.0.0.1/polls/2/results` - Results of Question with question_id = 2

### Django templates
* It's time to make our own HTML files.
* **Recap: Templates** - 
	* It is basically a HTML document which is returned as a response to the browser.
	* A view, fits in required data into the template (HTML file) and then returns the template.
	* HTML files are kept in a directory called **templates** in each app.
	* **Django Template Language (DTL)** is used inside templates or HTML files.
* Create a new folder **templates** in **polls** app.
* Now create another folder **polls** inside **templates** folder.
* Now create an HTML file **main_page.html** inside **polls/templates/polls** folder.
* Now we need to **return** this HTML page from our **view**. *How do we do that?*
* Modify **main_page()** view as following.

```python
# In polls/views.py file
from django.shortcuts import render, HttpResponse
from polls.models import Question

def main_page(request):

	# Fetching list of all questions
	all_questions_qs = Question.objects.all()

	print("Question List successfully fetched!")

	return render(request, "polls/main_page.html", context={})
```

* Now start the server and visit `http://127.0.0.1/polls`.

* **Syntax of `render()`** - 

```python
render(request, address_of_template, context)
```

* *Now how do we pass the question list which we have fetched from the database in the view to our main_page.html?*
* **Context** - 
	* **Dynamic** things to display which change when page changes or variable in the URL changes.
	* It is a **Python Dictionary**.
	* **Key** of Context - It represents the **DTL variable name** using which the value will be accessed.
* If we want some data to be displayed in any template, we pass it through context from the view which will return that template.
* **Context** can be thought of as a **link between View and Templates**.
* **Rendering** - **Template** and **Context** are **rendered** together and returned as **response**.

```python
# In polls/views.py file
from django.shortcuts import render, HttpResponse
from polls.models import Question

def main_page(request):

	# Fetching list of all questions
	all_questions_qs = Question.objects.all()

	print("Question List successfully fetched!")

	context = {
		'question_list': all_questions_qs,
	}

	return render(request, "polls/main_page.html", context=context)
```

* In **main_page.html** inside the `<body>` tag, add the following line.

```dtl
{{ question_list }}
```

* Now start the server and visit `http://127.0.0.1/polls`. *Finally we are able to pass data from view to template.*

### Django Template Language (DTL)
* It is used inside HTML page to handle the data passed from views effectively and display them on the page easily.
* **Components of STL** - 
	* **Variables** - 
		* `{{  }}` Double Curly braces are used to signify DTL variables inside HTML.
		* **Keys** of **Context** passed from **view** becomes DTL variable inside the templates.
		* **Example** - `{{ question_list }}`
	* **Tags** - 
		* `{% %}` is used to define DTL tags.
		* Logic like **Control Statements**, **Loops**, etc are given in DTL tags.
		* **Example** - `{% if <condition> %}`, `{% elif <condition> %}`, `{% else %}`, `{% endif %}`, `{% for i in arr %} <h1>{{ i }}</h1> {% endfor %}`, etc.
	* **Comments** - 
		* `{% comment %}....{% endcomment %}`.
	* **Filters** - 
		* Data can be transformed using filters.
		* Pipe **|** symbol is used.
		* **Example** - `{{ question.publication_date|timesince }}` (here **timesince** is a filter), `{{ var1|date:"y-m-d" }}`, etc. *Explore filters according to your need*.

```html
<!-- In main_page.html file -->
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<h1>Question List</h1>
	<ul>
		{% for question in question_list %}
			<li>
				{{ question.question_text }} 
				(pub: {{ question.publication_date }})

				<a href="http://127.0.0.1:8000/polls/{{ question.pk }}/details">Details</a>
				<a href="http://127.0.0.1:8000/polls/{{ question.pk }}/results">Results</a>
			</li>
		{% endfor %}
	</ul>
</body>
</html>
``` 

### Removing Hard-coded URLs
* Hardcoding the URLs in Django would be a bad choice. *What if we want to change a URL? We'll have to change it everywhere we have used*.
* **url** tag of **DTL** comes to our rescue. 
* We can specify a URL just by using **url** tag and the **name** which we provided in **urls.py** file.
* **Syntax** - `{% url "name_of_url_from_path" varibales_passed_in_url %}`.

```html
<!-- In main_page.html file -->
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<h1>Question List</h1>
	<ul>
		{% for question in question_list %}
			<li>
				{{ question.question_text }} 
				(pub: {{ question.publication_date }})

				<a href="{% url "Details" question.pk %}">Details</a>
				<a href="{% url "Results" question.pk %}">Results</a>
			</li>
		{% endfor %}
	</ul>
</body>
</html>
```

### Creating Details Page
* In details page, we need to show **Question** and its **Choices**.
* Create a HTML file **details.html** inside **polls/templates/polls**.
* From this page, visitor will also be able to vote. First we will create **view** for this page.

```python
# In polls/view.py
from .models import Question, Choice

def details(request, ques_id):

	
	# Fetching quesiton with pk=ques_id
	question_qs = Question.objects.filter(pk=ques_id)
	
	if question_qs:
		question = question_qs[0]
		
		# Fetching choices for this question
		choice_list = Choice.objects.filter(question=question)

		context = {
			"question": question,
			"choice_list": choice_list,
		}

		return render(request, "polls/details.html", context=context)
	else:
		response = "Question with id=" + str(id) + " not found."
		return HttpResponse(response)
```

```html
<!-- Inside details.html -->
<!DOCTYPE html>
<html>
<head>
	<title>Detail of {{ question.pk }}</title>
</head>
<body>
	<h1>Question Detail</h1>

	<h2>{{ question.question_text }}</h2>
	Pub: {{ question.publication_date }}
	<form method="POST" action="">
		{% for choice in choice_list %}
			<input type="radio" name="choice" id=choice_{{ question.pk }} value={{ question.pk }}>
			<label for=choice_{{ question.pk }}>{{ choice.choice_text }}</label>
		{% endfor %}
		<button type="submit">Vote</button>
	</form>
</body>
</html>
```

* Recall that **action** attribute is used to specify the path or URL where we want to submit the data of the form.
* In this case, we want it go to `<int:ques_id>/vote` URL. So specify **action** as following.

```html
<!-- Inside details.html -->
<form method="POST" action="{% url "Vote" question.pk %}">
```

* Now try to submit the form. *What happened?*
* We have to add one more field in inside `<form>` when submitting **POST** data in django.

```html
<!-- Inside details.html -->
<!DOCTYPE html>
<html>
<head>
	<title>Detail of {{ question.pk }}</title>
</head>
<body>
	<h1>Question Detail</h1>

	<h2>{{ question.question_text }}</h2>
	Pub: {{ question.publication_date }}
	<form method="POST" action="">
		{% csrf_token %}
		{% for choice in choice_list %}
			<input type="radio" name="choice" id=choice_{{ question.pk }} value={{ question.pk }}>
			<label for=choice_{{ question.pk }}>{{ choice.choice_text }}</label>
		{% endfor %}
		<button type="submit">Vote</button>
	</form>
</body>
</html>
```

* `{% csrf_token %}` is added to protect from **Cross Site Request Forgery attacks**.

### Handling the Votes
* We are submitting the form at `http://127.0.0.1:8000/polls/<int:ques_id>/vote`.
* Now this URL was attached to **vote()** view. It means that **vote()** will be called after we submit the form.
* So, now, from this function,  we will update the **number_of_votes** in the database for selected choice.
* Modify **vote()** as following.

```python
# In polls/views.py
def vote(request, ques_id):
	print("Voting on question with id=" + str(ques_id))
	print("\n\n")
	print(request)
	print("\n\n")
	print(request.POST)
	response = "Voted successfully on Question with id=" + str(ques_id)
	return HttpResponse(response)
```

* **request.POST** - 
	* It is a **python dictionary** which contains the data sent from the HTML form.
	* The **name** attribute in **input** tag of HTML form becomes the **key** of dictionary in **views.py**.
	* We can use this dictionary to render the form data into our view and work on that.

* **request.GET** - This will used in the same way as request.POST but when **method="GET"** is specified in `<form>` tag.

* Modifying Vote view to update number_of_votes.

```python
# In polls/views.py
def vote(request, ques_id):
	selected_choice_id = request.POST['choice']

	selected_choice_qs = Choice.objects.filter(pk=selected_choice_id)

	# Checking if choice with id=selected_choice_id exists or not
	if selected_choice_qs:
		selected_choice = selected_choice_qs[0]

		selected_choice.number_of_votes += 1

		selected_choice.save()
	
		response = "Voted successfully on Question with id=" + str(ques_id)
		return HttpResponse(response)
	else:
		response = "Choice with this id is not present."
		return HttpResponse(response)
``` 

* It will better if we after voting, visitor is **redirected to results page**. We will use **HttpResponseRedirect** and **reverse** for this.

* **reverse** - It just fetches the URL for a given view name with it's parameters.
* **HttpResponseRedirect** - It redirects to the URL fetched by **reverse**.

```python
# In polls/views.py
from django.shortcuts import HttpResponse, HttpResponseRedirect, render
from django.urls import reverse

def vote(request, ques_id):
	selected_choice_id = request.POST['choice']

	selected_choice_qs = Choice.objects.filter(pk=selected_choice_id)

	# Checking if choice with id=selected_choice_id exists or not
	if selected_choice_qs:
		selected_choice = selected_choice_qs[0]

		selected_choice.number_of_votes += 1

		selected_choice.save()
	
		return HttpResponseRedirect(reverse('results', kwargs={'ques_id': ques_id}))
	else:
		response = "Choice with this id is not present."
		return HttpResponse(response)
``` 

* **Note** - 
	* Always return an **HttpResponseRedirect** after successfully dealing with **POST** data. 
	* This prevents data from being posted twice if a user hits the Back button.

### Static files in Django
* *Are you wondering that how will we link CSS, JS or images to our templates?*
* Inside **polls**, make a folder **static**, then inside it make a folder **polls**. *It is similar to template namspacing*.
* We can put our **static files (CSS, JS and images)**, inside this **polls/static/polls** directory and Django will serve them for us.
* Now let's see how we'll include this in our templates (HTML file).
* **static** tag of DTL is used for including static files in templates.

```html
<!-- In main_page.html file -->
{% load 'static' %}
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href={% static "css/style.css" %}>
	<script src={% static "js/main.js" %} defer></script>
</head>
<body>
	<img src="{% static 'image.png' %}">
	<h1>Question List</h1>
	<ul>
		{% for question in question_list %}
			<li>
				{{ question.question_text }} 
				(pub: {{ question.publication_date }})

				<a href="{% url "Details" question.pk %}">Details</a>
				<a href="{% url "Results" question.pk %}">Results</a>
			</li>
		{% endfor %}
	</ul>
</body>
</html>
```

### Explore Yourself
* Template Inheritance
* Cross Site Request Forgery

### Content Contributors
    
* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials

* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=UmljXZIypDc&list=PL-osiE80TeTtoQCKZ03TU5fNfx2UY6U4p) (English)
* [Django Video Tutorial Playlist](https://www.youtube.com/watch?v=5BDgKJFZMl8&list=PLu0W_9lII9ah7DDtYtflgwMwpT3xmjXY9) (Hindi)
* [Django Models Field Types](https://docs.djangoproject.com/en/3.2/ref/models/fields/#field-types)
* [Python Resources](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Python)
