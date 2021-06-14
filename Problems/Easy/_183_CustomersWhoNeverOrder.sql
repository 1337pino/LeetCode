/** 183. Customers Who Never Order
 * https://leetcode.com/problems/customers-who-never-order/
 */

-- Write your MySQL query statement below
SELECT c.Name as Customers
FROM Customers c
LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.Id IS NULL;