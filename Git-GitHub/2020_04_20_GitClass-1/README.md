# Git Class - I

#### April 20th, 2021

*   ##### What is Version Control System(VCS)?
    *   Version Control is a system which records changes to a file or set of files over time so that you can recall specific changes/versions at a later stage.
*   #### Why use VCS?
    *   Ease and ability to revert to a previous version.
    *   For ease of contribution.
    *   To maintain different versions of your project/code.
    *   To maintain multiple development flows simultaneously.
*   #### Types of VCS:
    *   ##### Local VCS:
        *   Many people's version-control method of choice is to copy files into another directory.
        *   This approach is very common because it is so simple, but it is also incredibly error-prone.
        *   To deal with this issue, programmers long ago developed local VCS that had a simple database that kept all the changes to files under revision control ex. RCS.
    *   ##### Centralized VCS:
        *   The next major issue that people encounter is that they need to collaborate with developers on other systems. To deal with this problem, Centralized Version Control Systems (CVCS) was developed.
        *   These systems have a single server that contains all the versioned files, and a number of clients that check out files from that central place ex. CVS, Subversion, Perforce etc.
    *   ##### Decentralized VCS:
        *   Clients don't just check out the latest snapshot of the files; rather, they fully mirror the repository, including its full history. Thus, if any server dies, and these systems were collaborating via that server, any of the client repositories can be copied back up to the server to restore it. Every clone is really a full backup of all the data.

![types of VCS](img/types.png)

#### Basic Terminology:

*   **Git Directory**- is where Git stores the metadata and object database for your project. This is the most important part of Git, and it is what is copied when you clone a repository from another computer. In standard terminology, it is often referred to as _Repository_.
```
.git/
├── branches
├── config --> contains all configs variable (local, global, system)
├── description
├── HEAD
├── index --> staged changes are indexed and stored
├── hooks
├── info
│   └── exclude
├── objects --> stores blobs, trees and commits
│   ├── 01
│   │   └── f788a49f3c242b25865b89e88f374cd948b748
│   ├── ce
│   │   └── cdee5f04fd48bc75c3eea771efa0d479bc1abd
│   ├── ea
│   │   └── 096bf3992571c237e4e8f6d3a481e67bdbf70d
│   ├── info
│   └── pack
└── refs
    ├── heads
    └── tags
```
(PS: only important folder and files are explained. All hashes are either blob(file), tree (directory), commit)

![Commit Tree](img/tree-structure.png)

*   File (blob), Directory (tree), commit
*   The three states: 
    *   **Modified:** Modified means that you have changed the file but have not committed it to your database yet.
    *   **Staged:** Staged means that you have marked a modified file in its current version to go into your next commit snapshot. The staging area(Index) is a file, generally contained in your Git directory, that stores information about what will go into your next commit.
    *   **Committed:** Committed means that the data is safely stored in your local database.
*   **Working Tree:** is a single checkout of one version of the project. These files are pulled out of the compressed database in the Git directory and placed on disk for you to use or modify.
*   **Commit:** Commit holds the current state of the repository. A commit is also named by SHA1 hash. It is the snapshot of a repository at a particular instance.

![Stages-1](img/stages-1.png)
![Stages-2](img/stages-2.png)

#### Basic Workflow:

1. You modify files in your working tree.
2. You selectively stage just those changes you want to be part of your next commit, which adds only those changes to the staging area.
3. You do a commit, which takes the files as they are in the staging area and stores that snapshot permanently to your Git directory.

![Flow-1](img/flow-1.png)
![Flow-2](img/flow-2.png)

#### Basic git configurations:

*   For setting your name:
    ```
    git config --global user.name "Your name"
    ```
*   For setting email: 
    ```
    git config --global user.email "youremail@gmail.com"
    ```
    _The above two configurations are mandatory_
*   For setting git proxy:
    ```
    git config --global http.proxy "http://edcguest:edcguest@172.31.100.29:3128/"
    
    git config --global https.proxy "http://edcguest:edcguest@172.31.100.29:3128/"
    ```
*   For output highlighting:
    ```
    git config --global color.ui auto
    ```
*   For setting default editor:
    *   Linux users: 
        ```
        git config --global core.editor vim
        ```
        In place of *vim*, you can specify *nano, emacs, code* etc.
    *   Windows users: 
        ```
        git config --global core.editor vi
        ```
    * Although different editors like Notepad, Notepad++, Sublime etc can be used, they require some more configurations on *Windows*. Feel free to explore these options


#### Commands:
*   git init
    *   Initialises an empty  git repository
*   git status
    *   Show the working tree status
*   git add
    *   Add file contents to the index
    *   Example:
        *   git add <filename>
        *   git add .<br>("." means whole current folder)
*   git commit
    *   Record changes to the repository
    *   Usage:
        *   git commit
        *   git commit -m "message"
        *   git commit -a -m "message" (if you want to skip the "git add ." command and directly commit)
*   git log
    *   Show commit logs

(PS: you may use the command:
man <command name> 
to further find out more about any of these commands)
#### The .gitignore file
*   If there are some files in your working directory which are untracked and you don't want git to track them and take there snapshot ie. commit them then you put those files in the _.gitignore_ file.
*   Formally it specifies intentionally untracked files to ignore. Files already tracked by Git are not affected.

#### Few Footnotes:
*   Line Feed Error: Most of you today were facing the issue:<br>
        ```
        Warning: LF will be replaced by CRLF in <filename>
        The file will have its original line endings in your working directory
        ```
        <br>It is not an error.<br>
Actually different operating system have different ways to simulate the end of file. Window default line ending is \r\n (CRLF - carriage return and line feed) (these are called escape sequences.) and git bash or cmder or linux uses \n (LF - line feed). Hence when you save/write a file in these environments git warns you that it is changing the line endings.

*   To copy some text from the terminal, select it and use the key combination: CTRL+SHIFT+C. To paste copied text to terminal use the key combination: CTRL+SHIFT+V.


*   ls > list directory contents (on cmder or git bash)
    *   Usage: 
        *   ls [press enter] (list the content)
        *   ls -a [press enter] (list all the files including hidden files in linux)
*   cd > change the shell working directory (on cmder or git bash)
    *   Usage:
        *   cd [path to directory]
        *   example: cd C:\Users\Bucky\Desktop\
*   mkdir > used to make directories.
    *   Usage:
        *   mkdir [path to directory]
        *   example: mkdir C:\Users\Bucky\Desktop\test


#### Further Readings:

*   [Class Presentation](Lecture-1.pdf)
*   [Git Resource](https://try.github.io/)
*   [Git Cheat Sheet](https://training.github.com/downloads/github-git-cheat-sheet/)
