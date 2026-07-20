day 34 - debugging from vs code + week 5 wrap
july 20

second half of module 10. yesterday was debugging in the browser, today is
pulling that back into the editor so you dont have to keep switching windows.
no repo file for this one either

the config itself. made a .vscode/launch.json in the eventexamplesapp folder
(day 31, picked it because its the one with the most actual event logic to step
through). kept it local rather than committing it, schedule says no repo file
for today and a .vscode folder isnt really part of the solution:

  {
    "version": "0.2.0",
    "configurations": [
      {
        "type": "chrome",
        "request": "launch",
        "name": "debug eventexamplesapp",
        "url": "http://localhost:3000",
        "webRoot": "${workspaceFolder}"
      }
    ]
  }

port 3000 not 5173 because ive been setting server.port in every vite.config.js
since day 26, so that lines up already

the flow is: npm run dev in a terminal first, then F5. vs code launches its own
chrome window attached to the debugger. tripped on this the first time, hit F5
without the dev server running and just got a blank tab and a connection error,
the launch config doesnt start vite for you

what it gets you over browser devtools: breakpoints live in the actual source
file in the editor, so you set one on the line youre already looking at instead
of hunting for the file again in the Sources panel. variables panel shows local
scope automatically. watch expressions were the bit i hadnt used before - added
this.state.count as a watch on CounterEvents and it just updates every time
execution pauses, rather than me re-inspecting by hand each step

stepped through increment() properly since day 31 has it calling two things in
one click. step into takes you from increment to setState, step over skips past
it, and you can watch the second call to sayHello fire after. that ordering is
much clearer stepping through it than reading it

honestly for react state specifically the react devtools Components tab is still
better, it understands components and hooks in a way vs code doesnt - vs code
shows you javascript, it doesnt know what a component is. where the editor wins
is stepping through plain logic, the currency conversion math in
CurrencyConvertor or the validate() function in mailregisterapp from day 32

week 5 done. days 28-32 were all react hands-on, 33 and 34 debugging on top of
them. one thing that kept coming up all week and is worth writing down: the
schedule labels and the actual docx contents disagreed on basically every react
day from 28 through 31. built what the files said each time and noted it in the
day readme rather than inventing content to match the label
