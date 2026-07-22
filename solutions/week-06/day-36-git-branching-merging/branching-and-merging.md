# git file 3 - branching and merging

carried the same ~/gitdemo repo forward from day 35

## branching

```
$ git branch GitNewBranch
$ git branch -a
  GitNewBranch
* master
  remotes/origin/master
```

the `*` is the branch youre currently on. `-a` includes remote tracking branches,
which is why origin/master shows up too

```
$ git switch GitNewBranch
Switched to branch 'GitNewBranch'

$ git add feature-notes.txt
$ git commit -m "add feature notes on GitNewBranch"
[GitNewBranch a58c47a] add feature notes on GitNewBranch
 1 file changed, 2 insertions(+)

$ git status
On branch GitNewBranch
nothing to commit, working tree clean
```

handout uses `git checkout` to switch. used `git switch` instead - checkout does
about four unrelated jobs and switch was added specifically to be the obvious one
for changing branch. checkout still works, switch just reads clearer

## merging

```
$ git switch master

$ git diff master GitNewBranch
diff --git a/feature-notes.txt b/feature-notes.txt
new file mode 100644
index 0000000..738008e
--- /dev/null
+++ b/feature-notes.txt
@@ -0,0 +1,2 @@
+notes added on the branch
+second line

$ git diff --stat master GitNewBranch
 feature-notes.txt | 2 ++
 1 file changed, 2 insertions(+)
```

`/dev/null` on the left side means the file doesnt exist at all on master, its
not a modification its an addition

```
$ git merge GitNewBranch
Updating 245a338..a58c47a
Fast-forward
 feature-notes.txt | 2 ++
 1 file changed, 2 insertions(+)
 create mode 100644 feature-notes.txt
```

fast-forward, not a merge commit. master hadnt moved since the branch was made
so git just slid the pointer along instead of making a merge commit. no diamond
in the graph:

```
$ git log --oneline --graph --decorate
* a58c47a (HEAD -> master, GitNewBranch) add feature notes on GitNewBranch
* 245a338 (origin/master) add gitignore for log files and log folder
* e650114 add welcome.txt
```

both branch names sitting on the same commit there

```
$ git branch -d GitNewBranch
Deleted branch GitNewBranch (was a58c47a).
```

lowercase `-d` refuses if the branch isnt merged yet, which is the safe one.
`-D` forces it. no reason to use -D here

handout wants P4Merge for the visual diff. windows only. the mac equivalent that
ships with the xcode command line tools is opendiff (FileMerge), wired up with
`git difftool --tool=opendiff`. didnt bother launching it for a two line diff
though, the cli output says everything
