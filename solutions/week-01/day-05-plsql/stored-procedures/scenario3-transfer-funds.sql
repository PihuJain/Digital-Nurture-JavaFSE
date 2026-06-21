-- stored procedures - scenario 3
-- TransferFunds moves an amount from one account to another
-- checks source balance before making any changes

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    SELECT Balance INTO v_source_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('transfer failed: account ' || p_from_account || ' balance is ' || v_source_balance || ' which is less than ' || p_amount);
        RETURN;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('transferred ' || p_amount || ' from account ' || p_from_account || ' to account ' || p_to_account);
END TransferFunds;
/

-- EXEC TransferFunds(1, 2, 500);
