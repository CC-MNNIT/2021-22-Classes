# Python Class - II

#### May 08, 2021

<div align="center"><img src="../python.png" alt="python" height="150" /></div>

<hr>

### Functions (continued)

```python
#keyword argument
def func(n, m):
    print("n = " + str(n))
    print("m = " + str(m))

func(5, 10)
print('\n')

# We can mess with the default order of arguments while calling the funciton if we use keyword arguments
func(m=5, n=10) 
```

    n = 5
    m = 10
    
    
    n = 10
    m = 5


### Recursion (factorial)


```python
def factorial(num):
    if num == 1:      #base case
        return 1
    return num * factorial(num - 1)

print(factorial(5))
```

    120


### args and kwargs
* **args** - It is used to pass variable number of arguments to a function.
* **kwargs** - It is used to pass variable number of keyword arguments to a function.


```python
# variable no. of arguments (*args)
def func(*args):
    # args is tuple with the argument
    for i in args:
        print(i)
func('hello', 'to', 'python', 'class', 'for', 'first', 'years')

print()

def my_print(*not_necessarily_args):
    for i in not_necessarily_args:
        print(i)
        
my_print('hello', 'my', 'name', 'is', 'bin'+'bash')
```

    hello
    to
    python
    class
    for
    first
    years
    
    hello
    my
    name
    is
    binbash



```python
# variable no. of keyword arguments (**kwargs)
def func(**kwargs):
    for key, values in kwargs.items():
        print(key, values)

func(hello='to', python='class', year='first')

print("-"*40)

def kw_args_func(**not_necessarily_kwargs):
    for key, value in not_necessarily_kwargs.items():
        print('key:', key, ' ', 'value:', value)
        
kw_args_func(sep='/', end='*', name='bin')
```

    hello to
    python class
    year first
    ----------------------------------------
    key: sep   value: /
    key: end   value: *
    key: name   value: bin



```python
# This will give a error
def ff(*args, **kwargs, name):
    for arg in args:
        print(args)
    for key,value in kwargs.item():
        print(key, ": ", value)
    print("Name: ", name)
    
ff(10, "Hello", ran=20, "Foo Bar")
```


      File "<ipython-input-39-938320840b18>", line 2
        def ff(*args, **kwargs, name):
                                   ^
    SyntaxError: invalid syntax



### Lambda Function

* Syntax of Lambda Function in python

> ```lambda arguments: expression```

* Lambda functions can have any number of arguments but only one expression. 
* The expression is evaluated and returned. 
* Lambda functions can be used wherever function objects are required.
* We use lambda functions when we require a **nameless function** for a short period of time.
* In Python, we generally use it as an argument to a higher-order function (a function that takes in other functions as arguments). 
* Lambda functions are used along with built-in functions like **filter(), map()** etc.


```python
# Program to show the use of lambda functions

double = lambda x: x * 2

# Output: 10
print(double(5))
```

    10



```python
# Program to filter out only the even items from a list using filter()

my_list = [1, 5, 4, 6, 8, 11, 3, 12]

new_list = list(filter(lambda x: (x%2 == 0) , my_list))

# Output: [4, 6, 8, 12]
print(new_list)
```

    [4, 6, 8, 12]



```python
# Program to double each item in a list using map()

my_list = [1, 5, 4, 6, 8, 11, 3, 12]

new_list = list(map(lambda x: x * 2 , my_list))

# Output: [2, 10, 8, 12, 16, 22, 6, 24]
print(new_list)
```

    [2, 10, 8, 12, 16, 22, 6, 24]

### Content Contributors

* [Kshitiz Srivastava](https://github.com/pirateksh/)

### Materials

* [W3Schools Python Tutorial](https://www.w3schools.com/python/)
* [Learn Python in 1 Video](https://www.youtube.com/watch?v=qHJjMvHLJdg) (Hindi)
* [Python Tutorials for Beginners Video Playlist](https://www.youtube.com/watch?v=YYXdXT2l-Gg&list=PL-osiE80TeTskrapNbzXhwoFUiLCjGgY7) (English)
* For those of you who prefer reading books - [Python for Absolute beginners](https://drive.google.com/file/d/1_zCsrSLewaIHb0hQOnenexVLukbGw1xn/view?usp=sharing)