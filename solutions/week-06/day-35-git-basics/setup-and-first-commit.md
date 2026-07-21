# git file 1 - config, first commit, remote

commands run and what actually came back. working dir was ~/gitdemo

## checking the client is there

```
$ git --version
git version 2.54.0
```

## user level config

handout does this globally, i set it on the repo instead (`--local`) because this
machine already has a global identity configured and i didnt want to stomp it

```
$ git config user.name "Pihu Jain"
$ git config user.email "pihuitarsi@gmail.com"
$ git config core.editor "code --wait"

$ git config --local --list
core.repositoryformatversion=0
core.filemode=true
core.bare=false
core.logallrefupdates=true
core.ignorecase=true
core.precomposeunicode=true
core.editor=code --wait
user.name=Pihu Jain
user.email=pihuitarsi@gmail.com
```

handout wants notepad++ as the editor with a whole windows PATH walkthrough.
not on mac. used `code --wait` instead, the `--wait` matters - without it vs code
returns straight away and git thinks you saved an empty message

## init and first file

```
$ git init -b master
Initialized empty Git repository in ~/gitdemo/.git/

$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	welcome.txt

nothing added to commit but untracked files present (use "git add" to track)
```

untracked = git can see it but isnt looking after it yet

```
$ git add welcome.txt
$ git status
On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
	new file:   welcome.txt
```

now its staged. this is the middle bit between working directory and the repo,
the thing that confused me at first - add doesnt save it, it just marks what
goes into the next save

```
$ git commit -m "..."
[master (root-commit) e650114] add welcome.txt
 1 file changed, 2 insertions(+)
 create mode 100644 welcome.txt

$ git status
On branch master
nothing to commit, working tree clean
```

## remote

handout says sign up for gitlab and make a GitDemo project there. didnt want a
throwaway public repo sitting on my account just for a lab, so pointed origin at
a local bare repo instead. push and pull behave identically, a bare repo is what
a remote actually is

```
$ git init --bare ~/GitDemo-remote.git
$ git remote add origin ~/GitDemo-remote.git

$ git remote -v
origin	~/GitDemo-remote.git (fetch)
origin	~/GitDemo-remote.git (push)

$ git push origin master
To ~/GitDemo-remote.git
 * [new branch]      master -> master

$ git pull origin master
From ~/GitDemo-remote
 * branch            master     -> FETCH_HEAD
Already up to date.
```
