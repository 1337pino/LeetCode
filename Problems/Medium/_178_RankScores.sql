/** 178. Rank Scores
 * https://leetcode.com/problems/rank-scores/
 */

-- Write your MySQL query statement below
SELECT score, dense_rank() OVER (ORDER BY Score Desc) AS `Rank`
FROM Scores;