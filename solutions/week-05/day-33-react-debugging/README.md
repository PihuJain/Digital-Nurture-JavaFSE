day 33 - debugging react in the browser
july 19

module 10 starts. no hands-on file for this one, schedule says use my own react
projects and debug them with devtools, so this is notes not code

installed the react developer tools extension, thats the bit that actually
matters. plain chrome devtools shows you the rendered dom, which for react is
kind of useless on its own - you see a pile of divs, not components. the
extension adds Components and Profiler tabs and suddenly you can see the actual
tree with the names i wrote

went through a few of the apps from this week rather than making something new

counterapp (day 29) was the easiest one to poke at. selected CountPeople in the
Components tab and the right panel shows state as entryCount / exitCount live.
clicked login a few times and watched both the number and the rendered text
change together. you can also edit state right there in the panel without
touching code, bumped entryCount to 50 by hand just to see the net count
recalculate. thats genuinely useful, no need to click a button 50 times

employeethemeapp was the more interesting one because of context. selecting
EmployeeCard shows a "context" section in the panel with the theme value in it,
separate from props. and EmployeeCard has no theme prop at all, which is exactly
the point of what i did on day 32, but its nice seeing the tooling confirm it -
the value is coming from the provider not from its parent

the thing that actually confused me for a while was fetchuserapp. put a
breakpoint in componentDidMount through the Sources panel and it hit twice. i
assumed id wired the fetch up wrong or double mounted something. its StrictMode.
in dev react intentionally mounts, unmounts and remounts components to shake out
effects that arent safe to run more than once, so componentDidMount runs twice
and randomuser.me gets hit twice. doesnt happen in a production build. took me
way too long to land on that, kept re-reading my own code first

sources panel stuff: breakpoints work fine on the .jsx directly because vite
ships source maps in dev, so youre stepping through the code you actually wrote
not the compiled bundle. call stack panel on a click handler is worth looking at
once, you can see react's own dispatch machinery underneath your handler which
makes the synthetic event thing from day 31 make a lot more sense

didnt bother with the Profiler tab properly, none of these apps are slow enough
for it to say anything interesting
