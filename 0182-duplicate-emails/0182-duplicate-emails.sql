# Write your MySQL query statement below
select email from
(select email , count(*) as dup from Person group by email having dup > 1) 
as Email