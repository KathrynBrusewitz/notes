# Git Notes

Commands I hate forgetting:

```
git log --oneline --decorate --all --graph
```

```
git add -p
git reset -p

  go through each change to stage or un-stage them; avoid doing git add .
```

```
git merge <branch>
git merge --abort

  pretend that nothing happened
```

```
git rebase
  make history linear

git rebase -i
  note: this is a little different
  can reorder commits, fix mistakes in commits, and squash commits together
```

```
git diff --staged
  what am i about to inflict upon the world

git diff HEAD
```

```
git log -p
```

```
git show
  show tags
```

## About .git

```
branches  description  hooks  info  objects      refs
config    HEAD         index  logs  packed-refs
```

```
.git/refs
  where branches live; pointers to commits

.git/HEAD
  symbolic reference
```
