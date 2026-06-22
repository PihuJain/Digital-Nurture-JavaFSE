day 6 - pl/sql cont.
june 22

second sql day & last of week 1. cursors & triggers. pushed the whole week up at the end too

cursors (cursors/)
exercise wanted explicit cursors this time so its the full longhand - DECLARE the cursor, OPEN
it, FETCH into vars in a loop, EXIT WHEN %NOTFOUND, CLOSE. day 5 i just did FOR rec IN
(select ...) & let oracle handle the open/close. doing it by hand once was worth it tbh, you
can actually see what that FOR loop was doing for me
3 scenarios - monthly statements grabs this months transactions & prints a line each, annual
fee walks every account & takes a flat 100 off, the loan one reads each loan & shifts the rate
up or down by amount. used %TYPE on the fetch vars so they just match the column types

triggers (triggers/)
these were new. a trigger fires on its own on an insert/update/delete, you never call it
yourself, felt a bit weird at first
last modified one - BEFORE UPDATE on Customers, sets :NEW.LastModified to SYSDATE. :NEW is the
row abt to be saved so editing it before the write is what makes it stick
audit one - AFTER INSERT on Transactions, copies the new row into AuditLog. had to make
AuditLog first, isnt in the day 5 schema
rules one was the interesting bit. BEFORE INSERT on Transactions, blocks a deposit thats not
positive & a withdrawal bigger than the balance, throws it back w/ RAISE_APPLICATION_ERROR so
the bad row never gets in

BEFORE vs AFTER took a sec to get straight. BEFORE if you wanna change or reject the row,
AFTER if you just wanna react to one thats already in. last modified & the rule checks have to
be BEFORE, audit log is fine as AFTER

thats week 1 done. patterns, dsa & pl/sql all up
