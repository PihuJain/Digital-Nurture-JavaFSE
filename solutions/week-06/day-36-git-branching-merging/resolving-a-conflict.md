# git file 4 - making a conflict and resolving it

the point here is to deliberately break it. both branches touch the same file in
the same place so git cant work out which one wins

## setting it up

```
$ git switch -c GitWork
Switched to a new branch 'GitWork'
```

`-c` creates and switches in one go

hello.xml on GitWork:

```xml
<greeting>
  <message>hello from the GitWork branch</message>
</greeting>
```

then back on master, a different hello.xml:

```xml
<greeting>
  <message>hello from master</message>
  <author>pihu</author>
</greeting>
```

```
$ git log --oneline --graph --decorate --all
* 4dc5625 (GitWork) add hello.xml on GitWork branch
| * f677bd2 (HEAD -> master) add hello.xml on master with different content
|/  
* a58c47a add feature notes on GitNewBranch
```

`--all` is what makes both branches show. the `|/` is the two lines of history
splitting off the same parent - thats the divergence, and thats what causes the
conflict

## the conflict

```
$ git merge GitWork
Auto-merging hello.xml
CONFLICT (add/add): Merge conflict in hello.xml
Automatic merge failed; fix conflicts and then commit the result.

$ git status --short
AA hello.xml
```

`AA` = added on both sides. not `UU` (modified both sides) which is the more
common one, because neither branch inherited this file, they each created it

```xml
<?xml version="1.0"?>
<greeting>
<<<<<<< HEAD
  <message>hello from master</message>
  <author>pihu</author>
=======
  <message>hello from the GitWork branch</message>
>>>>>>> GitWork
</greeting>
```

everything between `<<<<<<<` and `=======` is what HEAD (master) has, everything
between `=======` and `>>>>>>>` is what the incoming branch has

the bit i didnt know: git is holding both versions in the index while youre
mid-conflict and you can pull either out without touching the marked up file

```
$ git ls-files -u hello.xml
100644 2404799... 2	hello.xml
100644 169f106... 3	hello.xml

$ git show :2:hello.xml     # stage 2 = ours / master
$ git show :3:hello.xml     # stage 3 = theirs / GitWork
```

normally theres a stage 1 too, the common ancestor, which is what makes it a
*three* way merge. theres no stage 1 here - add/add means there is no ancestor
version of this file, both sides invented it. so this particular conflict is
really only a two way one

## resolving

deleted the markers and kept both ideas rather than picking a winner:

```xml
<greeting>
  <message>hello from master and the GitWork branch</message>
  <author>pihu</author>
</greeting>
```

```
$ git add hello.xml
$ git commit -m "merge GitWork into master, resolved hello.xml conflict"
[master 91faafc] merge GitWork into master, resolved hello.xml conflict
```

`git add` on a conflicted file is how you tell git its sorted, theres no separate
"resolve" command

for an actual 3 way gui, `git mergetool --tool=opendiff` works on mac (FileMerge,
comes with the xcode cli tools) since P4Merge from the handout is windows. four
lines of xml didnt need it

## cleanup

merge tools leave `.orig` backups lying around, handout says get those ignored

```
$ git status --short
?? hello.xml.orig

# appended to .gitignore:
*.orig

$ git status --short
(nothing)

$ git branch -d GitWork
Deleted branch GitWork (was 4dc5625).
```

```
$ git log --oneline --graph --decorate
* 1db11f8 (HEAD -> master) ignore .orig backup files left by merge tools
*   91faafc merge GitWork into master, resolved hello.xml conflict
|\  
| * 4dc5625 add hello.xml on GitWork branch
* | f677bd2 add hello.xml on master with different content
|/  
* a58c47a add feature notes on GitNewBranch
* 245a338 (origin/master) add gitignore for log files and log folder
* e650114 add welcome.txt
```

thats the actual diamond. compare against the fast-forward from file 3 where the
history stayed one straight line - a real merge commit (91faafc) has two parents
and you can see both sides going into it
