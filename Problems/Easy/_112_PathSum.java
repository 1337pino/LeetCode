/** 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 */

package Problems.Easy;

import Helper.TreeNode;

public class _112_PathSum {
    /**
     * Decides if a given binary tree has a path from the root node to a leaf where the sum is 
     * equal to the target sum.
     * 
     * @param root Root of the binary tree
     * @param targetSum Target sum
     * @return True if there exists a root-to-leaf path.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        int adjustedTarget = targetSum - root.val;
        
        if (adjustedTarget == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            if (root.left != null && hasPathSum(root.left, adjustedTarget)) {
                return true;
            } else if (root.right != null && hasPathSum(root.right, adjustedTarget)) {
                return true;
            }
        }
        
        return false;
    }
}
