# git file 5 - cleanup and push back to remote

shortest file of the five. no new code, its the tidy up pass after the conflict
work in file 4. same ~/gitdemo repo

## is everything actually finished

```
$ git status
On branch master
nothing to commit, working tree clean

$ git branch -a
* master
  remotes/origin/master
```

clean tree, and GitWork is gone since it got deleted at the end of file 4. only
master left locally

## what hasnt been pushed yet

```
$ git log --oneline origin/master..master
1db11f8 ignore .orig backup files left by merge tools
91faafc merge GitWork into master, resolved hello.xml conflict
f677bd2 add hello.xml on master with different content
4dc5625 add hello.xml on GitWork branch
a58c47a add feature notes on GitNewBranch
```

the `origin/master..master` range is the useful one - everything on master that
origin hasnt got. five commits behind, all of yesterdays branching and conflict
work

## pull then push

```
$ git pull origin master
From ~/GitDemo-remote
 * branch            master     -> FETCH_HEAD
Already up to date.

$ git push origin master
To ~/GitDemo-remote.git
   245a338..1db11f8  master -> master
```

pull first even though nothing was going to come back - nobody else is working in
this repo. still the right habit, if someone had pushed in between then push
would have been rejected and pulling first is what avoids that

`245a338..1db11f8` is the range that moved, not a `[new branch]` like the first
push in day 35

## did it actually land

```
$ git log --oneline origin/master..master
(nothing)
```

zero commits ahead, so local and remote agree. handout says "observe if the
changes are reflected in the remote repository" and with a real gitlab/github
remote youd just look at the web page. cant do that with a bare repo so cloned
it somewhere else instead, which is a better check anyway:

```
$ git clone ~/GitDemo-remote.git verify-clone
Cloning into 'verify-clone'...
done.

$ ls -a verify-clone
.gitignore  feature-notes.txt  hello.xml  welcome.txt

$ git log --oneline
1db11f8 ignore .orig backup files left by merge tools
91faafc merge GitWork into master, resolved hello.xml conflict
f677bd2 add hello.xml on master with different content
4dc5625 add hello.xml on GitWork branch
a58c47a add feature notes on GitNewBranch
245a338 add gitignore for log files and log folder
e650114 add welcome.txt

$ cat verify-clone/hello.xml
<?xml version="1.0"?>
<greeting>
  <message>hello from master and the GitWork branch</message>
  <author>pihu</author>
</greeting>
```

full history including the merge commit, and hello.xml has the resolved content
not either original side. a fresh clone proves it properly - that content only
exists because the push actually worked
