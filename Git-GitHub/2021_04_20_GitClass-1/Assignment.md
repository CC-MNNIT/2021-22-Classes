# Git Assignment - 1

**Note:** this is for your own practice and need not be submitted anywhere. If you encounter any problem or error, please consider asking us in the next class or message us directly.

## Perform the following steps in sequence and try to understand the output

1. Create a new folder *(working directory)* somewhere on your system.

2. Open that folder. Then open *Git Bash/Terminal* in that folder.

3. Initialise a git repository in that folder using:
    ```bash
    git init
    ```
4. Check status using:
    ```bash
    git status
    ```
5. Copy any file in that folder and then check status again.

6. Add the *untracked* files to staging area using:
	`git add <filename>` *or* `git add .`

7. Commit the file using:
	```bash
	git commit -m "First Commit"
	```

8. Check status again using:
	```bash
	git status
	```

9. Repeat Step 5 to Step 8 by copying a different file.

10. Modify contents of any file and check status again.

11. Add *modified* files to staging area using:
 	```bash
 	git add <filename>
 	```
 	*or*
 	```bash
 	git add .
 	```

12. Commit the file using:
	```bash
	git commit -m "Modified <filename>"
	```

13. Check log of all your commits using:
	```bash
	git log
	```
