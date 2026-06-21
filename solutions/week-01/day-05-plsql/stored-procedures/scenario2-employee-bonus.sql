-- stored procedures - scenario 2
-- UpdateEmployeeBonus adds a bonus percentage to salaries in a given department

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_pct  IN NUMBER
) IS
    v_rows_updated NUMBER;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_pct / 100)
    WHERE Department = p_department;

    -- SQL%ROWCOUNT tells you how many rows the last DML touched
    v_rows_updated := SQL%ROWCOUNT;

    IF v_rows_updated = 0 THEN
        DBMS_OUTPUT.PUT_LINE('no employees found in department ' || p_department);
    ELSE
        DBMS_OUTPUT.PUT_LINE(v_rows_updated || ' employees in ' || p_department || ' received a ' || p_bonus_pct || '% bonus');
    END IF;

    COMMIT;
END UpdateEmployeeBonus;
/

-- EXEC UpdateEmployeeBonus('IT', 10);
