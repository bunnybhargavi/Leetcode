# Write your MySQL query statement below
select dep.name as Department , emp.name as Employee , emp.salary as Salary from
Employee emp join Department dep on emp.departmentId = dep.id
WHERE emp.salary = (
    SELECT MAX(emp2.salary)
    FROM Employee emp2
    WHERE emp2.departmentId = emp.departmentId
);