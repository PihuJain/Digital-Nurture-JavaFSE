-- cursors - scenario 3
-- new interest policy, walk every loan and adjust the rate
-- the policy i went with: loans under 50k drop half a percent, bigger ones go up a quarter
-- the exact numbers are made up, the point of the exercise was doing it through a cursor

SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_loans IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans;

    v_id Loans.LoanID%TYPE;
    v_amount Loans.LoanAmount%TYPE;
    v_rate Loans.InterestRate%TYPE;
    v_new_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_id, v_amount, v_rate;
        EXIT WHEN c_loans%NOTFOUND;

        IF v_amount < 50000 THEN
            v_new_rate := v_rate - 0.5;
        ELSE
            v_new_rate := v_rate + 0.25;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_id;

        DBMS_OUTPUT.PUT_LINE('loan ' || v_id || ': ' || v_rate || ' -> ' || v_new_rate);
    END LOOP;
    CLOSE c_loans;
    COMMIT;
END;
/
