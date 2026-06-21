-- schema for the plsql banking exercises
-- run this once before executing any of the exercise scripts

CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    DOB          DATE,
    Balance      NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerID   NUMBER,
    AccountType  VARCHAR2(20),
    Balance      NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID   NUMBER PRIMARY KEY,
    AccountID       NUMBER,
    TransactionDate DATE,
    Amount          NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER,
    LoanAmount   NUMBER,
    InterestRate NUMBER,
    StartDate    DATE,
    EndDate      DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name       VARCHAR2(100),
    Position   VARCHAR2(50),
    Salary     NUMBER,
    Department VARCHAR2(50),
    HireDate   DATE
);

-- john is 70 so he qualifies for the senior discount in scenario 1
-- bob is 75 and also qualifies
-- jane is 35 so she doesnt
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 12000, SYSDATE);
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 8000, SYSDATE);
INSERT INTO Customers VALUES (3, 'Bob Wilson', TO_DATE('1950-03-10', 'YYYY-MM-DD'), 15000, SYSDATE);

INSERT INTO Accounts VALUES (1, 1, 'Savings', 12000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 8000, SYSDATE);
INSERT INTO Accounts VALUES (3, 3, 'Savings', 15000, SYSDATE);

-- loans 1 and 3 end within 30 days so they show up in the reminders scenario
INSERT INTO Loans VALUES (1, 1, 50000, 8.5, SYSDATE, SYSDATE + 25);
INSERT INTO Loans VALUES (2, 2, 30000, 7.0, SYSDATE, SYSDATE + 45);
INSERT INTO Loans VALUES (3, 3, 20000, 9.0, SYSDATE, SYSDATE + 15);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (3, 'Carol Davis', 'Analyst', 55000, 'IT', TO_DATE('2019-08-01', 'YYYY-MM-DD'));

COMMIT;
