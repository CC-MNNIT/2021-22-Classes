# C Class 5

[.. Previous Page](..)

## Class recording: [Here](https://drive.google.com/file/d/1tLSr8mXOPS2xe8nNoC3uc62BYzqofVXY/view?usp=sharing)
## PPT: [Part 1](../2022_02_06_CClass-5/CC_FirstYe_Class5.pdf) and [Part 2](CC_FirstYe_Class6.pdf)

February 12th, 2022

<div align="center"><img src="../C_logo.png" alt="C language logo" height=150/></div>

<hr>

**[Scroll to the bottom of this page to discuss stuff].**

## Tasks

## Functions

1. Write a program (WAP) to accept two numbers in input and display all numbers from the first number to the second number using a function that accepts the two numbers as arguments.
2. WAP to accept a number from the user and display all prime numbers between 1 and that number using a for loop and function that accepts a number as an argument and returns alphabet ‘P’ if it is a prime number and ‘N’ if it is not a prime number.
3. WAP to accept a number from the user and display the multiplication tables of all numbers from 1 to that number using a function that accepts a number as an argument and prints the multiplication table of that number.
4. WAP to input two numbers from the user and calculate [nCr](https://en.wikipedia.org/wiki/Combination) using a function that accepts an integer as an argument and returns the factorial of that number.

## Header file

1. Write the 3rd program above by creating a header file `utility.h containing the required table printing function.

## Variable scope

- Find the output of the following code:

    ```C
    #include <stdio.h>
    int main()
    {
        int x = 1, y = 2, z = 3;
        printf(" x = %d, y = %d, z = %d \n", x, y, z);
        {
            int x = 10;
            float y = 20;
            printf(" x = %d, y = %f, z = %d \n", x, y, z);
            {
                int z = 100;
                printf(" x = %d, y = %f, z = %d \n", x, y, z);
            }
        }
        return 0;
    }
    ```

    Options:

    1)
        ```
        x = 1, y = 2, z = 3
        x = 10, y = 20.000000, z = 3
        x = 1, y = 2, z = 100
        ```
    2) 
        ```
        x = 1, y = 2, z = 3
        x = 10, y = 20.000000, z = 3
        x = 10, y = 20.000000, z = 100 
        ```
    3) Compilation Error
    4)
        ```
        x = 1, y = 2, z = 3
        x = 1, y = 2, z = 3
        x = 1, y = 2, z = 3
        ```

    <details><summary>Click here for answer</summary>Answer: (B). For explanation, <a href="https://www.geeksforgeeks.org/scope-rules-in-c/" target="_blank">read this article</a>.</details>

- Attempt [this worksheet](https://www.sanfoundry.com/c-programming-quiz-scope-variable/) on variable scoping. You should read about `extern` keyword (see below) before attempting this.

<br>

## Reading

1. Read about `extern` keyword. You can use [this](https://www.geeksforgeeks.org/understanding-extern-keyword-in-c/).
2. Read about recursion in C, which will help in easy understanding of the next class. You can use [this](https://www.tutorialspoint.com/cprogramming/c_recursion.htm).

{% include disqus.html %}
