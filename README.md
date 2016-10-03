Git Practice Notes
==================

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

    git add filename

or

    git add .

Committing Changes
------------------

    git commit

or

    git commit -m "some message"

[General Guidelines](http://chris.beams.io/posts/git-commit/) by Chris Beams

* Use the imperative mood in the subject line ("Add feature" not "added feature")

* Limit the subject line to 50 characters. If you want more detail, do so after a blank line.

* Capitalize the subject line

* Do not end the subject line with a period

* Wrap the body at 72 characters

* Use the body to explain what and why vs. how

Commit History
--------------

    git log [--oneline]

This will give a list of the sequence of commits: who made what changes and when. HEAD refers to the most recent commit. The `--oneline` option gives a compact version. Each commit is identified by an SHA-1 hash.