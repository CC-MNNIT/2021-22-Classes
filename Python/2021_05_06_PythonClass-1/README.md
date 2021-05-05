# Python Class - I

#### May 06, 2021

<div align="center"><img src="../python.png" alt="python" height="150" /></div>

<hr>

### Variables and Printing in Python


```python
print("Hello World!")
print("I like typing this.")
print("_-"*40)

string0 ='Welcome to first class of python'
string1 ="Welcome to first class of python"
string2 = """Welcome to first
class
of
python"""

print(string0)
print("_-"*40)
print(string1)
print("_-"*40)
print(string2)
```

    Hello World!
    I like typing this.
    _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
    Welcome to first class of python
    _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
    Welcome to first class of python
    _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
    Welcome to first
    class
    of
    python


### end and sep parameters in print()
**end** - 
* The **end** parameter is used to append any string at the end of the output of the print statement in python.
* By default, the print method ends with a **newline** (**'\n'**). 
    
**sep** - 
* It is used to add a **separator** between strings to be printed.
* The default value for sep is **whitespace**.


```python
print("Hello Again!", end="")
print("I like typing this.")

print("\n", "_-"*40, '\n')

# Printing multiple strings using single print statement
print("CC", "classes")
print("CC", "classes", sep = ' & ')

print("\n", "_-"*40, '\n')

print("End","and","sep","together","in", sep = " _ ", end=" _print")
```

    Hello Again!I like typing this.
    
     _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- 
    
    CC classes
    CC & classes
    
     _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_- 
    
    End _ and _ sep _ together _ in _print

### Variables and Datatypes
* Python is **Dynamically Typed Language** i.e. the type of variable is checked during **run-time**.
* Some of the datatypes in python are - 
    * str
    * int
    * float
    * bool


```python
# Integer - str
a = 10
print(a, type(a))

# String - str
b = "Computer Coding Club"
print(b, type(b))

# Float - float
num = 3.244
print(num, type(num))

# Boolean - bool
flag = False
print(flag, type(flag))
```

    10 <class 'int'>
    Computer Coding Club <class 'str'>
    3.244 <class 'float'>
    False <class 'bool'>


### Python Arithmetic Operators
* Addition Operator (**+**)
* Substraction Operator (**-**)
* Multiplication Operator (__*__)
* Division Operator (**/**)
* Modulus Operator (**%**)
* Exponentiation Operator (__**__)
* Floor Division (**//**)


```python
print("Addition: ", 2 + 3, ",", 3.4 + 5.677)

print("Substraction: ", 2 - 3, ",", 10 - 2.43)

print("Multiplication", 3 * 4, ",", 4.3 * 5.1)

print("Division: ", 12 / 5, ",", 10 / 2)

print("Modulus: ", 20 % 10, ",", 23 % 6)

print("Exponentiation: ", 5**3, ",", 2**4)

print("Floor Division: ", 12 // 5, ",", 10 // 2)
```

    Addition:  5 , 9.077
    Substraction:  -1 , 7.57
    Multiplication 12 , 21.929999999999996
    Division:  2.4 , 5.0
    Modulus:  0 , 5
    Exponentiation:  125 , 16
    Floor Division:  2 , 5


### Comments in Python
* **#** is used for single line comment.
* **""" ... """** is used for multi-line comment.


```python
# Comments in python
# Comment  -> 
# This is a comment

"""
multiple comment
print("Python" + "Class")
"""
```

### Data Structures in Python
We will talk about 4 basic data structures.
1. **List** - 
    * A list in Python is a **heterogeneous container** for items.
    * It is **mutable** - it is possible to reassign and delete individual items as well.
    * **[** and **]** are used to define list.


```python
# List of strings
prog_langs = ["C++", "C", "Python", "JS"]
hetero_list = ["Foo", 23, True, 3.46, "Is this possible?"]

# Printing List
print(prog_langs)
print(hetero_list)

# Accessing single item from list (indexing)

# Positive Indexing
lang1 = prog_langs[0] 
lang2 = prog_langs[2]
print("Lang1: ", lang1)
print("Lang2: ", lang2)

# Negative Indexing
lang3 = prog_langs[-1]
lang4 = prog_langs[-2]
print("Lang3: ", lang3)
print("Lang4: ", lang4)

# Lists are mutable
prog_langs[0] = "Java"
print(prog_langs)

# Adding an element to existing list
prog_langs.append("C#")
print("After appending: ", prog_langs)

# Length of list
print("Length: ", len(prog_langs))

# Deleting an element from list
del prog_langs[1] # Deleting 'C'
print("After deleting: ", prog_langs)
```

    ['C++', 'C', 'Python', 'JS']
    ['Foo', 23, True, 3.46, 'Is this possible?']
    Lang1:  C++
    Lang2:  Python
    Lang3:  JS
    Lang4:  Python
    ['Java', 'C', 'Python', 'JS']
    After appending:  ['Java', 'C', 'Python', 'JS', 'C#']
    Length:  5
    After deleting:  ['Java', 'Python', 'JS', 'C#']

<div align="center"><img src="./images/lists_indexing_splitting.png" height="300" /></div>

<br/>

2. **Tuple** - 
    * A tuple in Python is a **heterogeneous container** for items.
    * It is **unmutable** - it NOT is possible to reassign and delete individual items as well.
    * **(** and **)** are used to define tuple.


```python
# Tuple of Strings
colors = ("Red", "Blue", "Green")
print(colors)
# Heterogenous tuple
hetero_tuple = ("Possible?", 2.3, 4, True, [1, "Again"], (2, 5.67, "CC Classes"))
print(hetero_tuple)

print("Positive Indexing: ", hetero_tuple[2])
print("Negative Indexing: ", hetero_tuple[-1])
```

    ('Red', 'Blue', 'Green')
    ('Possible?', 2.3, 4, True, [1, 'Again'], (2, 5.67, 'CC Classes'))
    Positive Indexing:  4
    Negative Indexing:  (2, 5.67, 'CC Classes')



```python
# Tuple is Immuatable - trying to reassign
colors[0] = "Purple" # This will give error
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-23-036b598c976c> in <module>
          1 # Tuple is Immuatable
    ----> 2 colors[0] = "Purple" # This will give error
    

    TypeError: 'tuple' object does not support item assignment



```python
# Tuple is Immutable - trying to delete
del colors[2] # Again error
```


    ---------------------------------------------------------------------------

    TypeError                                 Traceback (most recent call last)

    <ipython-input-24-2fe37e6741af> in <module>
          1 # Tuple is Immutable - trying to delete
    ----> 2 del colors[2] # Again error
    

    TypeError: 'tuple' object doesn't support item deletion

### Content Contributors

* [Kshitiz Srivastava](https://github.com/pirateksh/)
