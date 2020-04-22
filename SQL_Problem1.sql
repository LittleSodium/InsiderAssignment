CREATE SCHEMA EmployeeData 

CREATE TABLE Employee(
    EmpID INT NOT NULL PRIMARY KEY, 
    EmpName VARCHAR(25), 
    DoB DATE
);
    
INSERT INTO Employee(EmpID, EmpName, DoB)
VALUES	(001, 'Monica', '1990-02-20'),
		(002, 'Niharika', '1994-06-11'),
		(003, 'Vishal', '1994-02-20'),
		(004, 'Amitabh', '1984-02-20'),
		(005, 'Vivek', '1988-06-11'),
		(006, 'Vipul', '1989-06-11'),
		(007, 'Satish', '1995-01-20'),
		(008, 'Geetika', '1992-04-11');
    
CREATE TABLE EmployeeSalary(
    EmpID INT, 
    Salary INT
);
    
INSERT INTO EmployeeSalary (EmpID, Salary)
VALUES	(001, 900000),
		(002, 800000),
		(003, 550000),
		(004, 550000),
		(005, 650000),
		(006, 950000),
		(007, 950000),
		(008, 850000);

/* Returns nth largest salary with employee name */
SELECT TOP 1 Salary, EmpName FROM
(SELECT DISTINCT TOP 1 Salary, EmpName
 FROM Employee, EmployeeSalary
 WHERE EmployeeSalary.EmpID = Employee.EmpID
 ORDER BY Salary DESC)
 Result
ORDER BY Salary;

/* Updates salary of employees to 5000 whose age is 30+ */
UPDATE EmployeeSalary
SET EmployeeSalary.Salary = 5000
WHERE EmpID IN (
SELECT EmpID
FROM Employee
WHERE (FLOOR(DATEDIFF(day, Employee.DoB, GETDATE()) / 365.242) > 30))
SELECT EmpName, Salary, Age = FLOOR(DATEDIFF(day, Employee.DoB, GETDATE()) / 365.242)
FROM EmployeeSalary, Employee
WHERE EmployeeSalary.EmpID = Employee.EmpID;