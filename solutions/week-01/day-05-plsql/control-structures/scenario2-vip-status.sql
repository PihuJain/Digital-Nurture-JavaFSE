-- control structures - scenario 2
-- sets IsVIP flag to TRUE for customers with balance over 10000

-- IsVIP isnt in the original schema so adding it here
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

DECLARE
    v_count NUMBER := 0;
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            v_count := v_count + 1;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE(v_count || ' customers marked as VIP');
END;
/
