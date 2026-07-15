day 29 - lists, keys + forms
july 15

label mismatch again, same story as yesterday. schedule says lists/.map()
and forms, files 6, 7, 8. actual content: file 6 is react router (nav,
routes, useParams), file 7 is props with a Cart/OnlineShopping class setup,
file 8 is state with a counter. only file 7 genuinely overlaps with "lists"
since OnlineShopping loops an array with .map(), none of the three are forms
at all. did all three anyway since the schedule marks all three as do-all
(mandatory 6+7, optional 8, "do all three")

trainersapp (file 6): Trainer class in trainer.js, TrainersMock.js holds 3
fake trainers. TrainersList maps over the trainer array and renders each
name as a Link - this bit is the actual lists+keys work even inside a router
exercise. Home is just a landing page. TrainerDetail pulls id out of the url
with useParams and looks the trainer up in the mock array. App wires
BrowserRouter/Routes/Route/Link together, / goes to Home, /trainers to the
list, /trainers/:id to the detail page

shoppingapp (file 7): Cart.js is itemName + price, nothing else. OnlineShopping
is a class component holding an array of 5 Cart instances built in the
constructor, then maps over them in render. used array index as the key here
since Cart has no id field and the list never reorders in this demo, not
ideal in general but fine for this

counterapp (file 8, optional): CountPeople is a class component again
(constructor + this.state, not useState, matches what the handout asks for
specifically), entryCount and exitCount in state, login button bumps entry,
exit button bumps exit, displays the net count too since it was trivial to
add and made testing it easier

verified all three build clean. trainersapp also got its preview server hit
on /, /trainers and /trainers/2 directly, all 200 (client side routing means
the actual page content only really shows up after js runs, but the routes
resolving and serving is the part that can be checked without a browser).
shoppingapp - grepped the built js for the actual item names (notebook,
backpack, calculator) to confirm the array survived the build. counterapp
got the most thorough check since its the only file with real interactive
state - rendered it in jsdom, dispatched two clicks on login and one on exit,
came back with entry count 2, exit count 1, net 1, matches what the button
logic should do
