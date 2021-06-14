/** 181. Employees Earning More Than Their Managers
 * https://leetcode.com/problems/employees-earning-more-than-their-managers/
 */

-- Write your MySQL query statement below
SELECT e1.Name AS Employee
FROM Employee e1
INNER JOIN Employee e2 ON e1.ManagerId = e2.Id
WHERE e1.Salary > e2.Salary;