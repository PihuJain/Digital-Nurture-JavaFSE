day 31 - "router, useeffect, usecontext" (still doesnt match)
july 17

fourth react day running with a label mismatch. today says router hook +
useeffect + usecontext, files 11-13. actual content is event handling,
guest/user conditional rendering, and multi-way conditional rendering. no
router, no useeffect, no usecontext anywhere in these three. built the real
thing, same call as the last few days

eventexamplesapp (file 11): CounterEvents is a class component on purpose,
this ones handout specifically calls out "use this keyword" so bound the
handlers in the constructor instead of reaching for arrow function class
properties. increment bumps the counter and fires sayHello in the same
click since the handout wants the increase button invoking multiple things
at once. onpress button handler takes the synthetic event object directly
and calls preventDefault on it, thats the "synthetic event" part of the
exercise. CurrencyConvertor is a form, handleSubmit converts rupees to euro
at a fixed rate (didnt want to fake a live fx api for this)

ticketbookingapp (file 12): plain isLoggedIn boolean in useState, App
renders GuestPage or UserPage off that one flag. GuestPage lists flights and
has the login button, UserPage has the logout button, clicking either
flips the state and swaps the whole page, no separate route just one
component swapped for another

bloggerapp (file 13): three components each demonstrating a different way
to conditionally render, since the handout wants "as many ways as possible".
BookDetails uses a plain if-else with an early return. BlogDetails uses a
ternary straight in the jsx. CourseDetails builds an element variable first
then layers a && check on top of it for a second conditional bit (an
enrolled badge). set blog to null in App.jsx on purpose so the "no blog
post found" branch actually shows up somewhere too, not just the happy path

verified all three with npm run build. eventexamplesapp and ticketbookingapp
also got jsdom runs since they both have real interactive state - dispatched
actual click events on increment/decrement/onpress and confirmed the counter
and message text landed right, same for currency (typed 1000 into the input,
submitted the form, got back 11.00 euro which checks out against the 0.011
rate by hand), and for ticketbooking (clicked login, guest page swapped to
user page). bloggerapp doesnt have any interactivity to click through so a
build + bundle grep for all four conditional outcomes (book found, no blog
found, course found, enrolled badge) was enough to confirm every branch
actually renders
