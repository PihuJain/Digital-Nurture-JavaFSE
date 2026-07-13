day 27 - react components + props + state
july 13

two files today, both mandatory. file 2 wants a class component, file 3 wants
a function component with props and some css. schedule calls this whole day
"components + props + state" and these two files line up with that fine, no
mismatch like some of the later react days had

studentapp: three class components, Home/About/Contact, each just a welcome
message string, all called one after another from App.jsx. no state involved
here at all really, its purely about the class syntax and being able to wire
multiple components together

scorecalculatorapp: function component CalculateScore taking name, school,
total and goal as props, works out an average and displays it. the handout
wording around "goal" was kind of vague, took it to mean number of subjects
the total was scored across so average = total / goal. added a small css
module (mystyle.css) for the score card look since file 3 also wants some
styling applied

verified both properly. studentapp: npm run build then grepped the bundle
for all three welcome strings, all there. scorecalculatorapp needed a bit
more since the average is computed from props at runtime, not something you
can grep for in a static bundle - rendered CalculateScore server side with
react-dom/server using the same sample props app.jsx passes in (432 total,
5 subjects) and got back average score: 86.40, checks out against 432/5 by
hand too

both stripped down from the vite react boilerplate the same way day 26 did -
no demo hero image, no counter button, no vite/react logos, just the actual
components the exercise asked for. port kept at 3000 to match the handout
