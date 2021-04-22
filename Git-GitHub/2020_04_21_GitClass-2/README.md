# Git Class - II

## Git Class - II recording: [Here](https://drive.google.com/file/d/10KTk8KhKek4jACYvAzyljW0EjwsSt-8j/view?usp=sharing)

April 21st, 2021

<i>"No matter how many mistakes you make or how slow you progress, you are still way ahead of everyone who isn't trying."</i> - Tony Robbins

<div align="center"><img src="../Git-Logo-1788C.png" height="100"/></div>

<hr>

*    ### Git diff

     `git diff` is a multi-use git command that when executed runs a diff function on git data sources. These data sources can be commits, branches, files and more. The `git diff` command is often used along with `git status` and `git log` to analyze the current state of a git repo.

     *  `git diff`: compares the staging area with working directory.
     *  `git diff --cached` or `git diff --staged`: compares the most recent commit with staging area.
     *  `git diff <commit_hash_1> <commit_hash_2>`: Results in the difference of the two commits.

     #### Reading `git diff` output
     ```bash
     diff --git a/file1 b/file1
     index aba2e68..e024a2a 100644
     --- a/file1
     +++ b/file1
     @@ -2,11 +2,8 @@
     #include<stdlib.h> 
     #include<stdio.h> 
     
     -// Merges two subarrays of arr[]. 
     -// First subarray is arr[l..m] 
     -// Second subarray is arr[m+1..r] 
     -void merge(int arr[], int l, int m, int r) 
     -{ 
     +
     +void merge(int arr[], int l, int m, int r){ 
          int i, j, k; 
          int n1 = m - l + 1; 
          int n2 =  r - m; 
     @@ -24,15 +21,12 @@ void merge(int arr[], int l, int m, int r)
          i = 0; // Initial index of first subarray 
          j = 0; // Initial index of second subarray 
          k = l; // Initial index of merged subarray 
     -    while (i < n1 && j < n2) 
     -    { 
     -        if (L[i] <= R[j]) 
     -        { 
     +    while (i < n1 && j < n2){ 
     +        if (L[i] <= R[j]){ 
               arr[k] = L[i]; 
               i++; 
          } 
     -        else
     -        { 
     +        else{ 
               arr[k] = R[j]; 
               j++; 
          } 
     
     ```

     Above shows the difference between two versions of c++ code.<br>
     You can see multiple differences denoted by **hunks**.<br>
     A hunk example: `@@ -2,11 +2,8 @@` can be broken down into 3 main parts:-<br>
     -/+ :: removal and addition respectively.
     first number :: start line.
     second number :: number of lines after the start line (including it).
     For a detailed discussion, refer [this article](https://medium.com/therobinkim/how-to-read-a-git-diff-6c87a9dc47c5) or [this article](https://stackoverflow.com/questions/2529441/how-to-read-the-output-from-git-diff)


*    ### Branching

     In simple terms, a branch in git is a unique series of code changes with a unique name. Each repo can have one or more branches.<br>
     A branch represents an independent line of development. You can think of them as a way to request a brand new working directory, staging area, and project history.

     In a little advance yet relatively simple term they are labels to your commits.

     <img src="img/01.svg" alt="Branches" height="400"/>

     *  Create a branch: `git branch "<branch-name>"`<br>
     Eg: `git branch "little-feature"`

     *  Switching branches: `git checkout branch-name`

     *  Creating a new branch and switching to it: `git checkout -b "<branch-name>"`<br>
     eg: `git checkout -b "little-feature"` creates a new branch _litte-feature_ and switches to it, in short it is a combination of above two commands.

     For a detailed discussion, refer [this](https://www.atlassian.com/git/tutorials/using-branches)

*    ### Resources for further study
     *    [Class Presentation](Lecture-2.pdf)
     *    [Git Practice Resources](https://try.github.io/)
     *    [Git Cheat Sheet](https://about.gitlab.com/images/press/git-cheat-sheet.pdf)
     *    [Progit Book](https://git-scm.com/book/en/v2)
     *    [Udacity Course: How to Use Git and GitHub?](https://classroom.udacity.com/courses/ud775-india)
     *    [Git Internals](https://www.freecodecamp.org/news/git-internals-objects-branches-create-repo/)
     *    [Git Visualised using animations](https://dev.to/lydiahallie/cs-visualized-useful-git-commands-37p1)

*    ### A meme

     <img src="img/meme.png" alt="Meme" height="500"/>
