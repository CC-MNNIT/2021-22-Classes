# C Class 8

[.. Previous Page](..)

## Class recording: [Here](https://drive.google.com/file/d/1hz0D-Af4TKWnAE4K7Co5hivAO8Net3u2/view?usp=sharing)

## PPT: [Here](./CC_FirstYe_Class8.pdf)

February 19th, 2022

<div align="center"><img src="../C_logo.png" alt="C language logo" height=150/></div>

<hr>

**[Scroll to the bottom of [this page](https://cc-mnnit.github.io/2021-22-Classes/Freshers/C/2022_02_19_CClass-8/) to discuss stuff].**

## Tasks:

### 1D-Arrays

1. WAP (Write a program) to accept 15 numbers from the user, store them in an array and print the smallest and largest number from the array.
2. WAP to accept 15 numbers from the user, store them in an array and print the sum of all the numbers present at even positions.
3. WAP to accept a number N from user and take N numbers in ascending order input from the user into an array. Now take another number as input and place this number into the array such that the arrays remains sorted in ascending order.
(for this you'll have to make the array larger than the number of elements you are taking input and then shift the numbers from the position where you are inserting the new number).
4. WAP to accept N numbers into array A and M numbers into array B. Now combine the two arrays into one array C and print it.
5. WAP to accept N numbers into array A and M numbers into array B. Now combine the two arrays into one array C such that the elements at odd positions are from array A and even positions are from array B.

### 2D-Arrays

1. WAP to input a 2D array of size 3x3 and print it.
2. WAP to input a 2D array of size NxM (input N and M from user) and then print the sum of the border elements of the array.
    eg, if the array is:

    ```
    1 2 3
    4 5 6
    7 8 9
    ```

    then the sum of the border elements are: 1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 = 40
3. WAP to accept a 2D array of size NxM (input N and M from user) and then print the sum of the elements of the array present at the main diagonal (from top left to bottom right).
4. WAP to accept a 2D array of size NxM (input N and M from user) and another 2D-array of size MxT (input T from user) and then print the matrix multiplication of the two matrices.
6. There are 4 schools with 5 subjects each and each subject has 20 students.
    WAP to input the marks of each student in each subject of each school. Now print the average marks of each school.

    *Hint:* You need to use a 3D array here.
7. There are 5 subjects and each subject can have any number of students in it.

    WAP to input the marks of each student in each subject. Now print the average marks of each subject.
    
    *Hint:* you **may** need to use [jagged arrays](https://www.geeksforgeeks.org/jagged-array-or-array-of-arrays-in-c-with-examples/) (just read definition from here, we'll learn about pointers tomorrow. This question can be solved without jagged arrays too, just keep the rows sufficiently large and fill them with 0).

    Basically it's a 2D array with a variable number of rows and columns.
    eg.,

    ```
    { {12, 56, 86},
    {23, 45, 67, 56},
    {34, 56},
    {45, 67, 89},
    {56, 78, 90} }
    ```


### Strings

1. WAP to accept full name (or a sentence) from user and print it 20 times.
2. WAP to accept a sentence from user and print the number of words in the sentence.
3. WAP to accept a sentence from user and print the number of vowels in the sentence.
4. WAP to accept a sentence from user and print the reverse of the sentence.
5. WAP to accept a sentence from user and print the sentence in upper case.
6. WAP to accept a sentence from user and print the sentence with each word reversed.

    eg., if the sentence is: "I am a student" then the output should be: "I ma a tneduts".
7. WAP to accept a sentence from user and print the sentence in reverse.

    eg., if the sentence is: "I am a student" then the output should be: "student a am I"

<hr>

{% include disqus.html %}
