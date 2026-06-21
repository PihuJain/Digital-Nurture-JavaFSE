day 5 - pl/sql
june 21

first sql day. two mandatory, control structures & stored procedures. schema.sql sets up the
banking tables, run that first

control structures (control-structures)
3 little scenarios.
sc1 - loop the customers & their loans, age from DOB via MONTHS_BETWEEN over 12, knock 1% off
the rate for anyone over 60. had the MONTHS_BETWEEN args the wrong way round at first which
gave everyone a negative age so it all "passed", took a sec to spot. later date goes first
sc2 - IsVIP isnt in the schema so i alter the table to add it then flag everyone over 10000
balance, counter to print how many got flagged
sc3 - reminders for loans ending in the next 30 days. didnt bother w/ an explicit cursor, just
FOR rec IN (select ...) straight off, way cleaner for a read only loop

stored procedures (stored-procedures)
same kinda thing but these live in the db & take params.
monthly interest just bumps every savings acct by 1%.
the bonus one takes a dept & a percent. i check SQL%ROWCOUNT after the update bc if you typo
the dept name it updates 0 rows & otherwise says nothing
transfer funds reads the source balance w/ SELECT INTO first, & if its short prints a msg &
RETURNs out before touching anything. no exception, just bail early

thing that bit me was SQL%ROWCOUNT only holding the last statements count, so you gotta grab
it right after the update you care abt
