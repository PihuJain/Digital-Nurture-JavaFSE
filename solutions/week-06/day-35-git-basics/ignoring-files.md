# git file 2 - gitignore

task: make a `.log` file and a `log` folder, then get git to ignore both

## before

```
$ echo "app started at 09:14" > debug.log
$ mkdir log && echo "rotated output" > log/output.txt

$ git status --short
?? debug.log
?? log/
```

both showing as untracked, git wants to track them

## the gitignore

```
# ignore any log file and the whole log folder
*.log
log/
```

`*.log` catches any file with that extension anywhere. `log/` with the trailing
slash means the folder specifically - without the slash it would also match a
plain file called `log`, which isnt what we want here

## after

```
$ git status --short
?? .gitignore
```

debug.log and log/ are both gone from the output. the only untracked thing left
is .gitignore itself, which does get committed - it has to, otherwise nobody else
cloning this gets the same rules

proving which rule did it rather than just trusting it:

```
$ git check-ignore -v debug.log log/output.txt
.gitignore:2:*.log	debug.log
.gitignore:3:log/	log/output.txt
```

line 2 caught the log file, line 3 caught the folder. `check-ignore -v` is handy,
tells you exactly which line of which ignore file matched

```
$ git add .gitignore
$ git commit -m "add gitignore for log files and log folder"
[master 245a338] add gitignore for log files and log folder
 1 file changed, 3 insertions(+)

$ git ls-files
.gitignore
welcome.txt
```

`git ls-files` at the end confirms it - only the two files git is actually
tracking, debug.log and log/output.txt never made it in

one thing worth knowing that the handout doesnt mention: gitignore only works on
files git isnt already tracking. if youd committed debug.log first and added the
rule after, it would keep getting tracked, youd need `git rm --cached` to get it
out
