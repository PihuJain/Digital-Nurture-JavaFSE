day 7 - junit5 basics
june 23

week 2 starts, all testing this week

todays thing was getting junit going + playing w/ assertions. first time w/ maven too, days
1-6 i just javac'd stuff by hand but you cant pull junit in without a build tool so

setup (ex 1)
maven project (junit-basics), pom + teh src/main src/test split.
handout gives you junit 4 (4.13.2) but the modules literally called junit5 so went w/ jupiter
instead, the newer one. junit-jupiter pulls the api & the engine in together, and surefire 3.x
just finds the tests, no extra config which was nice
took me a sec - test code goes under src/test/java and the junit dep is scope test, so its only
on the classpath for tests not the actual build. makes sense once you see it

assertions (ex 3)
handout wanted the different assertion types so AssertionsTest has the basic lot, assertEquals
assertTrue assertFalse assertNull assertNotNull. bit pointless on their own (2+3 == 5 doesnt
really prove anything) so i made a small Calculator & tested that properly instead

new one was assertThrows. takes the exception type + a lambda for the bit thats meant to throw
-> hands the exception back so you can check the msg too. used on divide by zero, needed a
lambda which i dodge everywhere else but thats just how it works

decent start to the week
