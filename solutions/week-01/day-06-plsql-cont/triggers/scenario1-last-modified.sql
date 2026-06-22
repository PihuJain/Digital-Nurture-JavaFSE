-- triggers - scenario 1
-- whenever a customer row gets updated, stamp LastModified with the current date
-- BEFORE UPDATE so the new value is in place before the row actually gets written

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
