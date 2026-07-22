day 36 - branching, merging, conflicts
july 22

both mandatory. file 3 is branch and merge cleanly, file 4 is deliberately cause
a conflict and dig yourself back out. transcripts in branching-and-merging.md and
resolving-a-conflict.md, gitdemo/ has the files as they ended up

same ~/gitdemo repo carried forward from yesterday rather than starting fresh, so
the history builds up across both days. same pattern as orm-learn and spring-learn
got carried day to day earlier in the schedule

the useful bit today was seeing the difference between the two merges side by
side. file 3s merge said "Fast-forward" and the graph stayed a straight line -
master hadnt moved since the branch came off it so git just moved the pointer
forward, no merge commit at all. file 4s merge actually made a commit with two
parents and the log graph draws the diamond. i dont think id have noticed that
distinction if the two exercises hadnt been back to back

conflict markers made more sense once i stopped reading them as junk and read
them as three labelled sections. HEAD block is what you have, the other block is
whats coming in, and you delete the markers and write whatever the right answer
actually is - it doesnt have to be either side, i folded both messages together

the thing i genuinely didnt know: while youre mid conflict git is still holding
both original versions in the index, stage 2 is yours and stage 3 is theirs, and
`git show :2:file` pulls one out clean. so if you mangle the marked up file you
havent lost anything. normally theres a stage 1 as well which is the common
ancestor, and thats the third input that makes it a three way merge, but this
conflict was add/add - both branches created hello.xml independently, no shared
ancestor version - so stage 1 doesnt exist here

two windows things swapped again, both noted in the transcripts. P4Merge for the
visual diff isnt on mac, opendiff (FileMerge, comes with the xcode cli tools) is
the same idea and hooks up through git difftool/mergetool. and used git switch
over git checkout, checkout does too many different jobs to be readable
