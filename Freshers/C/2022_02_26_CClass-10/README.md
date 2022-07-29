# C Class 10-11

[.. Previous Page](..)

## Class recordings: [Day 1](https://drive.google.com/file/d/1ESVNSq7B49HDw4KBcs74hnzNczrtu2YV/view?usp=sharing) and [Day 2](https://drive.google.com/file/d/1VNTvd2ghUE7vnP4D31CtFJmhxK2o04_d/view?usp=sharing)

## PPT: [Here](./CC_FirstYe_Class10.pdf)

February 26th, 2022

<div align="center"><img src="../C_logo.png" alt="C language logo" height=150/></div>

<hr>

**[Scroll to the bottom of [this page](https://cc-mnnit.github.io/2021-22-Classes/Freshers/C/2022_02_26_CClass-10/) to discuss stuff].**

## Tasks:

1. Write a program (WAP) to input a number from user and make a dynamic array of that size. Assign that array with random numbers. Now ask user to enter a number and resize the array to that size using realloc function. Now again ask user to enter a number and print the array elements which are greater than that number.
2. WAP to accept roll no, name, class, section and percentage of 15 students in a structure array. Now print the students who got more than 50% marks.
3. WAP to accept first name, middle name, last name, age, address, phone number, email id of 10 students in a **Nested** structure array (make separate structure for storing name). Now print the students who are older than 19 years.
4. *(This is an extension of [Q6 from 2D-Arrays in C-Class-7](https://github.com/CC-MNNIT/2021-22-Classes/tree/main/Freshers/C/2022_02_19_CClass-8#2d-arrays))*.

    There are 5 subjects and each subject can have any number of students in it.

    WAP to input the marks of each student in each subject. Now print the average marks of each subject.
    
    *Hint:* you should use [jagged arrays](https://www.geeksforgeeks.org/jagged-array-or-array-of-arrays-in-c-with-examples/).

    Basically it's a 2D array with a variable number of rows and columns. You must use dynamic memory allocation to create such data structure.
    eg.,

    ```
    { {12, 56, 86},
    {23, 45, 67, 56},
    {34, 56},
    {45, 67, 89},
    {56, 78, 90} }
    ```
5. Implement a store which sells books and clothes using union in C. You can take help of [this article](https://www.javatpoint.com/c-union).

## Learning:

- [GeeksforGeeks Structure](https://www.geeksforgeeks.org/structures-c/)
- [Javatpoint Union](https://www.javatpoint.com/c-union), good example present here.
- [Javatpoint Structure padding](https://www.javatpoint.com/structure-padding-in-c)
- [Designated Inits](https://gcc.gnu.org/onlinedocs/gcc/Designated-Inits.html)
- [File Handling](https://www.javatpoint.com/file-handling-in-c)
- [Enum](https://www.geeksforgeeks.org/enumeration-enum-c/)
- [Scaler Topics Structures in C](https://www.scaler.com/topics/c/structures-c/)

- ### [GeeksforGeeks collection of everything C](https://www.geeksforgeeks.org/c-programming-language/)
    - good for interview preparation.

<hr>

This is a reminder to keep practicing questions from CodeForces/ CodeChef/ HackerRank/ HackerEarth.

<hr>

{% include disqus.html %}
