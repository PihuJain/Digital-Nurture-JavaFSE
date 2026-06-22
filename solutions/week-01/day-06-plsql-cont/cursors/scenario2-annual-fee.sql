-- cursors - scenario 2
-- charge a flat annual maintenance fee against every account
-- straightforward, fetch each account and drop its balance by the fee

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance FROM Accounts;

    v_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee NUMBER := 100;
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_id;

        DBMS_OUTPUT.PUT_LINE('account ' || v_id || ' charged ' || v_fee || ', balance now ' || (v_balance - v_fee));
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
END;
/
