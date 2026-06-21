-- control structures - scenario 3
-- prints a reminder for every loan thats due within the next 30 days

BEGIN
    FOR rec IN (
        SELECT l.LoanID,
               l.EndDate,
               c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('reminder: dear ' || rec.Name || ' your loan ' || rec.LoanID || ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
