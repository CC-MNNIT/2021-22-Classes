# C Class 8

[.. Previous Page](..)

## Class recording: [Here](https://drive.google.com/file/d/1Qjp2-FSEh6XllD2g_NdexCbpXzPAWodN/view?usp=sharing)

## PPT: [Here](./CC_FirstYe_Class9.pdf)

February 19th, 2022

<div align="center"><img src="../C_logo.png" alt="C language logo" height=150/></div>

<hr>

**[Scroll to the bottom of [this page](https://cc-mnnit.github.io/2021-22-Classes/Freshers/C/2022_02_19_CClass-8/) to discuss stuff].**

## Tasks:

*[First complete [last class'](../2022_02_19_CClass-8) tasks.*

*Do the following tasks, for more questions you can refer to the book "C in Depth"*.

1. Input two numbers and find their sum using their pointers.

2. As we talked that arrays are a pointer to the first element of the array, write a program to find the sum of the elements of an array using pointers.

3. WAP (write a program) to verify that the following ways of accessing 3rd element of an array are the same:

    - array[2]
    - *(array+2)
    - 2[array]

4. WAP to take an array in input and pass it to a function which reverses the array (without the use of any other array). Then print the reversed array in the `main` function.
    
    Since array is passed by reference, the changes made in the function will be reflected in the original array.

5. WAP to take a number as input and print the cube of that number. This program must use a function with `void` return type which must take a single parameter of type `int *`. The value at the passed address must be changed.

6. What is the output of the following code?

    ```cpp
    #include <stdio.h>
    int f(int x, int *py, int **ppz) {
        int y, z;
        **ppz += 1; 
        z  = **ppz;
        *py += 2;
        y = *py;
        x += 3;
        return x + y + z;
    }
    
    void main() {
        int c, *b, **a;
        c = 4;
        b = &c;
        a = &b; 
        printf( "%d", f(c,b,a));
    }
    ```

    <details><summary>Click to see answer...</summary>19
    
    Hint: it is combination of call by value and call by reference. The value in variable `x` in function `f` is not at same address as that of variable `x` in function `main`.</details>

7. Find the output of the following code snippet:

    ```cpp
    #include<stdio.h>
    int main() {
        int arr[4]={10,20,30,40};   // Assume base address of arr is 5000
        int x=100,*ptr=arr;
        printf("%u %d %d\n", ptr, *ptr, x);
        x=*ptr++;
        printf("%u %d %d\n", ptr, *ptr, x);
        x=*++ptr;
        printf("%u %d %d\n", ptr, *ptr, x);
        x=++*ptr;
        printf("%u %d %d\n" ,ptr, *ptr, x);
        x=(*ptr)++;
        printf("%u %d %d\n", ptr, *ptr, x);
    }
    ```

    <details><summary>Click to see answer...</summary>
    
    ```
    5000 10 100
    5002 20 10
    5004 30 30
    5004 31 31
    5004 32 31
    ```

    </details>

8. What is the output of the following C code? Assume that the address of x is 2000 (in decimal) and an integer requires four bytes of memory.

    ```cpp
    #include <stdio.h>
    int main()
    { 
    unsigned int x[4][3] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12} };
    printf("%u, %u, %u", x+3, *(x+3), *(x+2)+3);
    }
    ```

    <details><summary>Click to see answer...</summary>

    `2036 2036 2036`
    
    **Explanation:**
    
    Given `x = 2000`

    Since `x` is considered as a pointer to an array of 3 integers and an integer takes 4 bytes, value of `x + 3 = 2000 + 3*3*4 = 2036`

    The expression, `*(x + 3)` also prints same address as x is 2D array.

    The expression `*(x + 2) + 3 = 2000 + 2*3*4 + 3*4 = 2036`
    </details>

9. Read about [dynamic memory allocation](https://www.geeksforgeeks.org/dynamic-memory-allocation-in-c-using-malloc-calloc-free-and-realloc/) and [file handling in C](https://www.geeksforgeeks.org/basics-file-handling-c/).

<hr>

This is a reminder to keep practicing questions from CodeForces/ CodeChef/ HackerRank/ HackerEarth.

<hr>

{% include disqus.html %}
