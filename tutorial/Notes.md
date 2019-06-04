# Notes

Zdroj:
https://confluence.atlassian.com/bbkb/how-to-restore-a-deleted-branch-765757540.html
if you accidentally deleted a branch in your Git repository.  
If you don't know the 'sha' off the top of your head, you can:  

Find the 'sha' for the commit at the tip of your deleted branch using:  

`git reflog`  

To restore the branch, use:  

`git checkout -b <branch> <sha>`


Zdroj:
https://stackoverflow.com/questions/1992364/git-recover-deleted-remote-branch  
**_just two commands save my life_**

This will list down all previous HEADs

`git reflog`  

This will revert the HEAD to commit that you deleted.

`git reset --hard <your deleted commit>`  
`ex. git reset --hard b4b2c02`
