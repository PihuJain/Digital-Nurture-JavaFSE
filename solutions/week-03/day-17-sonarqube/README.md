day 17 - sonarqube
july 3

no hands on repo file for this one, its an awareness + setup day rather than an exercise

installed sonarqube community edition locally and got it running against one of the
maven projects from earlier in the week just to see the dashboard, not committing that
project here since its not really "my" code, just a demo run

what stuck: sonarqube isnt running my tests for me, its a static analyzer, it reads the
code without executing it and flags bugs, code smells, duplicated blocks, security
hotspots. thats different from what junit does. quality gate is the pass/fail line, if
new code goes under some coverage % or has too many issues the gate fails and (in a real
pipeline) the build would be blocked

"clean as you code" was the other thing worth remembering, dont go fix every old issue
in the codebase, just dont introduce new ones on the code you touch. more realistic than
trying to get a legacy project spotless overnight
