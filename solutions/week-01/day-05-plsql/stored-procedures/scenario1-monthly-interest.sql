-- stored procedures - scenario 1
-- ProcessMonthlyInterest adds 1% to the balance of every savings account

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('account ' || rec.AccountID || ' updated. new balance: ' || ROUND(rec.Balance * 1.01, 2));
    END LOOP;

    COMMIT;
END ProcessMonthlyInterest;
/

-- EXEC ProcessMonthlyInterest;
