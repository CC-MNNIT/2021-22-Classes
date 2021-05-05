# STL

#### May 5, 2021

<div align="center"><img src="assets/cpp_Logo.png" alt="C++ Logo" height=150/></div>

## Need of STL

- Covers various data structures so we don't need to rewrite them from scratch.
- Generic in nature so allows flexibilty.
- All in all STL help us code efficiently.

## What is STL
STL stands for **Standard Template Library** which is a libraray consisiting of various template classes which provides us the implementation of some of the common data structures and containers which helps us code efficiently.

## Templates
Templates are C++ tools that helps to accomplish generic programming i.e., using templates we can define a general implementation that would work on every data type.

## Containers
- Containers are nothing but some placeholders to store multiple elements at a time.
- In native C language there is only one such type of container i.e., array.
- But arrays are really limited.
- Limitations of arrays are as follows:
    - Static size. Can't adjust size according to the size of data.
    - Limited functionality (in terms of time and space complexity).

## Data Structures
A Data structure is way of organising data in a manner that makes it efficient for us to interact with the data. eg., storing key value pairs in a hashMap would be way more efficient than storing them in an array.

## Why the name Standard Template Library
All the contaniers and data structures in the STL are in the form of templates i.e., they allow generic programming. Hence the name.

### **Pairs**
A template to store a pair of two elements. Both the elements could be of different data types. The great advantage of pairs is that they have built-in operations to compare themselves. Pairs are compared first-to-second element. If the first elements are not equal, the result will be based on the comparison of the first elements only; the second elements will be compared only if the first ones are equal. The array (or vector) of pairs can easily be sorted by STL internal functions.

```
    eg. pair <int , int> p;
        cin >> p.first >> p.second
```

### **String**
There is a special container to manipulate with strings. The string container has a few differences from ``vector< char >``. Most of the differences come down to string manipulation functions and memory management policy.

```
    eg. string s;
        cin >> s;
        string str = s.substr(0 , 5);
        cout << s.size() << " " << str << "\n";
```

## Containers in STL
The various containers in STL that can help store data efficiently are as follows:


### Sequence Containers

1. **vector** :  Vector is just an array with extended functionality. By the way, vector is the only container that is backward-compatible to native C code – this means that vector actually is the array, but with some additional features
   
   ```
    vector <int> v(10);
    v.push_back(8);
    v.pop_back();
    cout << v.size();
   ```


2. **list** : Linked List implementation under STL.
   
   ```
    list <int> l;
    l.push_back(10);
    l.push_front(11);
    l.sort();
    l.reverse();
    cout << l.front() << " " << l.back();
   ```
   
### Container adaptars

1. **Stack** : A data structure which follows LIFO (Last In First Out) principle.
   
   ```
    stack <int> s;
    s.push(10);
    s.pop();
    if(!s.empty())
        cout << s.top();
   ```
2. **Queue** : A data structure tht follows FIFO (First In First Out) principle.
    ```
    queue <int> q;
    q.push(10);
    q.pop();
    if(!q.empty())
        cout << q.front();
   ```
3. **priority_queue** : An implementation of heap data structure.

    ```
    priority_queue <int> p;
    p.push(10);
    p.pop();
    if(!p.empty())
        cout << p.top();
   ```


### Associative containers

1. **set** : A data structure that internally uses red black trees and is used to store an ordered collection of distinct elements.
   
    ```
    set <int> s;
    s.insert(10);
    s.insert(10);
    cout << *s.begin();
    if(!s.empty())
        cout << s.size();
    ```

2. **multiset** : Same as a set but not necessary for elements to be distinct.
    ```
    multiset <int> s;
    s.insert(10);
    s.insert(10);
    cout << *s.begin();
    if(!s.empty())
        cout << s.size();
    ```

3. **map** : A data structure to store key value pairs.
    ```
    map <int , int> m;
    m[1] = 2;
    if(!m.empty())
        cout << m.begin()->second;
   ```


### Unordered Associative Containers

The unordered counterparts of the associative containers. They have the similar syntax as their ordered counterparts with slight varaitions. However their implementations are completely different.

### **Iterators**
Iterators are objects that are used to reference/access data in STL containers. They are very much like pointers but have better functionality and are limited to the scope of a container thy are defined for unlike a pointer that can point to anything of the same data type.

```
    Syntax : container type :: iterator <name of iterator>;

    eg. set<int>::iterator it = s.begin();
        while(it != s.end()) {
            cout << *it << " ";
            it++;
        }

        it = s.lower_bound(10);     
        it = s.upper_bound(11);
```

### **Commonly Used methods in STL**

- ``lower_bound(start iterator , end iterator , const value)`` : returns the iterator of the smallest element in the container that is greater than or equal to the given value.
- ``upper_bound(start iterator , end iterator , const value)`` : returns the iterator of the smallest element in the container that is greater than the given value.
- ``find(start iterator , end iterator , const value)`` : Returns an iterator pointing to the value if found else returns the end iterator.

### **Comparator and sorting of STL containers**
Since containers comprise of a bunch of elements, therefore it is highly likely we might need to compare them at some point. For example if we want to sort a vector of pairs then there are various ways to do it. We can sort the vector according to the first value or second value or sum of the values etc.. So a custom comparator comes in handy in such situations.

eg. 
```
    bool comp(pair <int , int> x1 , pair <int , int> x2) {
        return x1.first < x2.first;
    }
    int main() {
        vector < pair <int , int> > v(20);
        sort(v.begin() , v.end() , comp);
    }
```

Note the function call for comp doesn't involve ();

Similarly comparators can be used in various other stuff too liek priority_queues etc. Explore them.

{% include disqus.html %}