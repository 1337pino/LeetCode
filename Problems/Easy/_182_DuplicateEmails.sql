/** 182. Duplicate Emails
 * https://leetcode.com/problems/duplicate-emails/
 */

-- Write your MySQL query statement below
SELECT p.Email 
FROM Person p 
GROUP BY p.Email HAVING COUNT(p.Email) > 1;