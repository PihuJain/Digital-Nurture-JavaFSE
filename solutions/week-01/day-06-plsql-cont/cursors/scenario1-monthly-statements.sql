-- cursors - scenario 1
-- monthly statements, one printed line per transaction in the current month
-- the exercise wanted an explicit cursor this time, so OPEN FETCH CLOSE by hand
-- (on day 5 i just used FOR rec IN (select ...) and let oracle do the open and close)

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_statements IS
        SELECT c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    -- %TYPE so these match the column types without me guessing number vs varchar2
    v_name Customers.Name%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN c_statements;
    LOOP
        FETCH c_statements INTO v_name, v_date, v_amount, v_type;
        EXIT WHEN c_statements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(v_name || ' | ' || TO_CHAR(v_date, 'DD-MON') || ' | ' || v_type || ' | ' || v_amount);
    END LOOP;
    CLOSE c_statements;
END;
/
