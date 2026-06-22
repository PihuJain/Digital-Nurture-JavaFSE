-- triggers - scenario 3
-- guard rail that runs before a transaction goes in
-- deposits have to be positive, and a withdrawal cant pull more than the account holds
-- BEFORE INSERT so a bad row gets rejected before it ever lands in the table

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'deposit amount has to be positive');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'withdrawal exceeds the available balance');
        END IF;
    END IF;
END;
/
