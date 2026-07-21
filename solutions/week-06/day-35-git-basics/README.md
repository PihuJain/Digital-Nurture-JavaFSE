day 35 - git basics
july 21

week 6, module 11. both files mandatory. first day in the whole schedule where
the deliverable isnt code, its commands, so this folder has transcripts instead
of source files - the actual commands i ran with the real output pasted under
them, plus the two files that survived the exercise (welcome.txt and .gitignore)
in gitdemo/

file 1 is setup and a first commit, file 2 is gitignore. see
setup-and-first-commit.md and ignoring-files.md

two things in the handout dont apply on this machine and got swapped out, both
noted in the transcripts:

notepad++ as the default editor. handout has a whole walkthrough of adding it to
the windows PATH through control panel. im on mac, used `code --wait` instead.
the --wait flag is the bit that matters, without it vs code hands control back
immediately and git sees an empty commit message

gitlab for the remote. handout says sign up and make a GitDemo project. i didnt
want an extra throwaway public repo on my account for a lab exercise, so origin
points at a local bare repo instead. push and pull work exactly the same against
it, a bare repo is what sits behind a remote url anyway - only difference is
theres no web ui to look at afterwards

the staging area was the thing that took a minute to click. i kept thinking of
add as "save this" but it isnt, it just marks what should go into the next
commit. three places a file can be - working directory, staging, committed - and
git status describes all three at once which is why the output reads oddly until
you know what youre looking at

also learned gitignore is not retroactive. it only hides files git isnt already
tracking. commit something by accident first and adding a rule later does
nothing, you need git rm --cached to untrack it. relevant to me specifically
because this solutions repo has a gitignore that got edited partway through
