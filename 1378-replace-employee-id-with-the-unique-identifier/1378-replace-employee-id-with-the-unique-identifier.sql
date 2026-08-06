# Write your MySQL query statement below
select dep.unique_id , emp.name from Employees emp left join EmployeeUNI dep on emp.id = dep.id