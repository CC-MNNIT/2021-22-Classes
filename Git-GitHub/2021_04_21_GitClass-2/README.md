# Git Class - II

## Git Class - II recording: [Here](https://drive.google.com/file/d/10KTk8KhKek4jACYvAzyljW0EjwsSt-8j/view?usp=sharing)

April 21st, 2021

<i>"No matter how many mistakes you make or how slow you progress, you are still way ahead of everyone who isn't trying."</i> - Tony Robbins

<div align="center"><img src="../Git-Logo-1788C.png" alt="git logo" height=100/></div>

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

     <img src="img/01.svg" alt="Branches" height=400/>

     *  Create a branch: `git branch "<branch-name>"`<br>
     Eg: `git branch "little-feature"`

     *  Switching branches: `git checkout branch-name`

     *  Creating a new branch and switching to it: `git checkout -b "<branch-name>"`<br>
     eg: `git checkout -b "little-feature"` creates a new branch _litte-feature_ and switches to it, in short it is a combination of above two commands.

     For a detailed discussion, refer [this](https://www.atlassian.com/git/tutorials/using-branches)

     ### HEAD

     * The branch name that we define for our branches is actually an alias of a pointer to the last commit in that branch.
     * `HEAD` is a special pointer to a commit just like name of any branch. But it is special because it is the `"HEAD"` pointer (and **not** the currently checked out branch) which decides the state of your current Working Directory. 
     Eg: You can make your `"HEAD"` pointer point to some previous commit in the same branch, so the state of your Working Directory will change to that commit which is pointed by `"HEAD"` and NOT to the commit to which `"branch name"` pointer is pointing i.e. the last commit in this branch.

     * `git checkout <commit_hash>` is used to make your `"HEAD"` point to a specific commit.

     ### DETACHED HEAD vs ATTACHED HEAD

     * In simple terms whenever your `"HEAD"` is not linked with any Branch it is called **DETACHED HEAD** and vice-versa.
     * `"HEAD"` being linked with a branch simply means whatever progess(commits) you make from your current state of project, `"HEAD"` as well as `"branch-name"` pointer will move to the latest commit together.
     * When  `"HEAD"` is not linked to any of the branch (i.e. DETACHED HEAD State), then only the `"HEAD"` pointer will move to the latest commit not the `"branch-name"` pointer. Git will not make this change as part of any branch because there is no branch which is linked to `"HEAD"` pointer.
     * In a nutshell, whenever we make a commit, it is the `"HEAD"` pointer that moves to this newly created commit and if `"HEAD"` is linked to a branch, then the `"branch-name"` pointer will also move along with `"HEAD"`.
     <br>

     ### 2 Ways of using git checkout <branch-name/commit-hash> command

     * `git checkout <commit-hash>` is used to make your `"HEAD"` point to a specified commit. Using this way will always make your `"HEAD"` **DETACHED** regardless whether any branch starts from (or ends at) that commit. Also this will make your current working directory state to reach at that specified commit (version).
     * `git checkout <branch-name>` is used to make your `"HEAD"` point to **last commit** in the branch `"branch-name"`. Using this will always make your `"HEAD"` **ATTACHED/LINKED** to branch `"branch-name"`
     <br>

     For a detailed discussion, refer [this](https://www.youtube.com/watch?v=FyAAIHHClqI)


*    ### Resources for further study
     *    [Class Presentation](Lecture-2.pdf)
     *    [Git Practice Resources](https://try.github.io/)
     *    [Git Cheat Sheet](https://about.gitlab.com/images/press/git-cheat-sheet.pdf)
     *    [Progit Book](https://git-scm.com/book/en/v2)
     *    [Udacity Course: How to Use Git and GitHub?](https://classroom.udacity.com/courses/ud775-india)
     *    [Git Internals](https://www.freecodecamp.org/news/git-internals-objects-branches-create-repo/)
     *    [Git Visualised using animations](https://dev.to/lydiahallie/cs-visualized-useful-git-commands-37p1)

*    ### A meme

     <img src="img/meme.png" alt="Meme" height=400/>
