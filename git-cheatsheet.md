Git Notes
=========

Installation Configuration
--------------------------

    git config --global user.name "your-full-name"
    git config --global user.email your-email-address
    git config --global core.editor vim


Repo Creation
-------------

    git init

Checking Current Repo State
---------------------------

    git status

Staging Area
------------

    git add [filename]
    git add .           # to add all
    git add -A          # to include deleted files
    git rm [filename]   # to include a delete file

Committing Changes
------------------

    git commit 
    git commit -m "Fix authorization bug"

[General Guidelines](http://chris.beams.io/posts/git-commit/) by Chris Beams

* Use the imperative mood in the subject line ("Add feature" not "added feature")

* Limit the subject line to 50 characters. If you want more detail, do so after a blank line

* Capitalize the subject line

* Do not end the subject line with a period

* Wrap the body at 72 characters

* Use the body to explain what and why vs. how

Commit History
--------------

    git log [--oneline]

This will give a list of the sequence of commits: who made what changes and when. HEAD refers to the most recent commit. The `--oneline` option gives a compact version. Each commit is identified by an SHA-1 hash.

Branching
---------

__List current branches__

    git branch
    git branch -a

__Create local branch__

    git branch [local_branch]

_This will be assigned the latest commit._

__Switch local branch__ 

    git checkout [local_branch]

_This changes the HEAD to refer to the latest commit of the target branch._

__Create and switch local branch at once__

    git checkout -b [local_branch]

__Delete local branch__

    git branch -d [local_branch]

__Force delete without checking merged__

    git branch -D [local_branch]

__Delete remote branch__

    git push origin --delete [remote_branch]

Merging
-------

    git merge [other_branch] --no-edit

This will merge `other_branch` into the current branch. `--no-edit` tells git to use the default commit message.

`git rebase` is similar but does not create a new merge commit -- it simply attaches the commits to the other branch. Avoid rebasing because it makes branching history unclear.

Merge Conflicts
---------------

1. Use `git status` to see which files have merge conflicts

2. Choose/change code accordingly

3. `git add` and `git commit --no-edit`

Using Branches
--------------

* Industry commonly uses the [git flow model](http://nvie.com/posts/a-successful-git-branching-model/)

* Use a separate branch for each feature

* `master` branch always contains production-level code: valid, completely working code that could be deployed

* Development occurs on _feature branches_ and is eventually merged back to `master`

Undoing Changes
---------------

__Commit early, commit often__

_Why? Git can only go back to changes that have been commited. If you don't commit, git can't help._

__Find SHA-1 hash of commit__

    git log --oneline

__Replace current `[filename]` with the version in `[commit_hash_number]`__

    git checkout [commit_hash_number] [filename]

__Use `--` to refer to the HEAD (the most recent commit)__

    git checkout -- [filename]

__Replace entire project directory__

    git checkout -b [local_branch] [commit_hash_number]

_This will check out that commit as a new branch. You can make further changes and merge it back into your development branch._

_If you don't create a new branch when checking out an old commit, you'll enter detached HEAD state. You can't commit from here, because there is no branch for that commit to be attached to.  Use `git checkout master` to get back to the last saved commit, though you will lose any changes made in that state._

__Reverse changes from a commit__

    git revert [commit_hash_number] --no-edit

_This creates a new commit and applies the opposite changes made by the given commit number. Do not use `reset`._

Remotes, Pushing and Pulling
----------------------------
`origin` is the remote repo on GitHub's servers.

__Create a new repo__ 

    git clone [url]

__Pushing to remote servers__

    git push -u [remote] [branch]
    git push -u origin master

_Pushes the current branch to the `origin` remote's `master` branch. `-u` tracks the remote branch. This shows further information in `git status` and lets you use `git push` alone._

__Import remote branches shown in `git branch -a`__

    git fetch

_This will download the commits for those branches, but are still listed as separate branches that need to be merged._

__Pull from remote and merge into current branch__

    git pull [remote] [branch]

__Change the remote's URL__

    git remote set-url [remote] [URL]
