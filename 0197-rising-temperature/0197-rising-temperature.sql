# Write your MySQL query statement below
select t.id from weather t
join weather p on
datediff(t.recordDate , p.recordDate) = 1 
where t.temperature > p.temperature