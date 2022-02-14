# C Class 7

[.. Previous Page](..)

## Class recording: [Here](https://drive.google.com/file/d/1-smeo1IPdIi1V3SfSO10Q_MYYsy0B-Gm/view?usp=sharing)

## PPTs:
- static variables and online judges [from here](../2022_02_12_CClass-6/CC_FirstYe_Class6.pdf).
- Recursion [from here](CC_FirstYe_Class7.pdf).

February 13th, 2022

<div align="center"><img src="../C_logo.png" alt="C language logo" height=150/></div>

<hr>

**[Scroll to the bottom of [this page](https://cc-mnnit.github.io/2021-22-Classes/Freshers/C/2022_02_13_CClass-7/) to discuss stuff].**

## Reading

1. Read the [attached presentation](bitwise.pdf) to learn about number system base conversions and **working of bitwise operators** before coming in for the next class.

## Tasks

### Offline practice

#### Recursion

1. Write a program (WAP) to input a number `n` from the user and print the first `n` terms of the [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number) series using recursive function.
2. WAP to input a number `n` and find the sum of first `n` natural numbers using a recursive function.
3. WAP to input a number `n` and find the sum of first `n` **even** numbers using a recursive function.
4. WAP to input a number `n` and find the sum of the digits of the number `n` using a recursive function.
5. WAP to input a number `n` and a number `p` and find the value of `n` raised to the power `p` using a recursive function.
6. WAP to take appropriate values (`a` and `d`) as input and find the sum of an Arithmetic Progression (AP) using recursion.
7. Given a function defined as:

    ```
    f(1) = 3
    f(n) = 2 * f(n - 1) - 1
    ```

    WAP to input an integer `n` and display the sum of first `n` terms of the above series using recursion.

<hr>

#### static keyword

Give the output of the follwoing code:

```cpp
#include <stdio.h>

void print_count()
{
    static int count1 = 1;
    int count2 = 1;
    printf( "Count1 = %d, Count2 = %d\n", count1++, count2++);
}

int main()
{
    print_count();
    print_count();
    print_count();
    return 0;
}
```

<details><summary>Click to reveal answer...</summary>OutPut:
Count1 = 1, Count2 = 1
Count1 = 2, Count2 = 1
Count1 = 3, Count2 = 1
</details>

<hr>

### Online Judge

1. Create [CodeForces](https://codeforces.com/) account if you haven't done so already and solve the following problems:
    - [https://codeforces.com/problemset/problem/546/A](https://codeforces.com/problemset/problem/546/A)
    - [https://codeforces.com/problemset/problem/996/A](https://codeforces.com/problemset/problem/996/A)
    - [https://codeforces.com/problemset/problem/379/A](https://codeforces.com/problemset/problem/379/A)
    - [https://codeforces.com/problemset/problem/492/A](https://codeforces.com/problemset/problem/492/A)
    - [https://codeforces.com/problemset/problem/4/A](https://codeforces.com/problemset/problem/4/A)
    - [https://codeforces.com/problemset/problem/50/A](https://codeforces.com/problemset/problem/50/A)
    - [https://codeforces.com/problemset/problem/617/A](https://codeforces.com/problemset/problem/617/A)
    - [https://codeforces.com/problemset/problem/268/A](https://codeforces.com/problemset/problem/268/A)
    - [https://codeforces.com/problemset/problem/1370/A](https://codeforces.com/problemset/problem/1370/A)
    - [https://codeforces.com/problemset/problem/520/B](https://codeforces.com/problemset/problem/520/B)

2. Create [HackerRank](https://hackerrank.com/) account if you haven't done so already and solve the following problems:
    - [https://www.hackerrank.com/challenges/staircase/problem](https://www.hackerrank.com/challenges/staircase/problem)
    - [https://www.hackerrank.com/challenges/kangaroo/problem](https://www.hackerrank.com/challenges/kangaroo/problem)
    - [https://www.hackerrank.com/challenges/drawing-book/problem](https://www.hackerrank.com/challenges/drawing-book/problem)
    - [https://www.hackerrank.com/challenges/find-digits/problem](https://www.hackerrank.com/challenges/find-digits/problem)
    - [https://www.hackerrank.com/challenges/save-the-prisoner/problem](https://www.hackerrank.com/challenges/save-the-prisoner/problem)

<br>

<hr>

{% include disqus.html %}
