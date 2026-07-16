day 30 - "react api calls" (files dont match this either)
july 16

third react day in a row where the schedule label and the actual docx dont
line up. today says fetch/axios, files 9 and 10. opened both and neither
touches an api call anywhere - file 9 is es6 fundamentals (map, filter,
destructuring, array merge) and file 10 is jsx syntax + inline css. built
what they actually ask for, same call as day 28/29

cricketapp (file 9): ListOfPlayers holds an array of 11 players (name +
score), maps over it for the full list, then filters anyone scoring below
70 using an arrow function. IndianPlayers does two separate es6 things -
splits the same 11-name squad into odd/even teams purely through array
destructuring (grabbing alternating names straight off one destructure
instead of looping with an index), and merges two smaller arrays
(t20Players, ranjiTrophyPlayers) into one combined squad with spread. App.jsx
picks between the two components with a plain flag boolean and an if-else,
exactly like the handout wants, flag is true right now so ListOfPlayers is
what actually renders

officespacerentalapp (file 10): OfficeSpace component covers all four jsx
asks in one place - a heading element, an img tag pointing at a placeholder
svg (no real building photo was provided so drew a flat gray placeholder),
an office object with name/rent/address, and a second array of office
objects looped with .map() for a full listing. rent text goes red under
60000 and green at or above it via an inline style function, tested with
one listing on each side of that line plus the exact boundary case in mind

verified both with npm run build first. for the actual logic since none of
todays react-side console output is groppable in a built bundle (both apps
compute stuff from data at render time, not static strings), rendered both
components server side with react-dom/server. IndianPlayers came back with
rohit/rahul/jadeja/shami/gill/kuldeep as even team and virat/pant/bumrah/
axar/iyer as odd team, matches picking every other name off the original
squad by hand. OfficeSpace came back with rent 55000 and 48000 both red,
72000 green, dist/office-space.svg also confirmed present after the build so
the img tag isnt pointing at nothing
