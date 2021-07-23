/** 814. Binary Tree Pruning
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */

package Problems.Medium;

import Helper.TreeNode;

public class _814_BinaryTreePruning {
    /**
     * Prunes any subtrees that do not contain a '1'
     * 
     * @param root Root of a tree.
     * @return Root of a tree containing only subtrees of at least one '1'.  Null if no such 
     * subtrees exist.
     */
    public TreeNode pruneTree(TreeNode root) {
        if (containsOne(root) == false) {
            return null;
        } else {
            return root;
        }
    }
    
    /**
     * Recursively walks through tree to determine in a node is part of a valid subtree.
     * 
     * @param node Node of a binary tree.
     * @return True if the node contains a '1' or if it has a subtree that contains a '1'.
     */
    private boolean containsOne(TreeNode node) {
        boolean containsSubtreeWithOne = false;
        
        if (node == null) {
            return false;
        } else if (node.val == 1) {
            containsSubtreeWithOne = true;
        }
        
        // Check left child subarray
        if (containsOne(node.left)) {
            containsSubtreeWithOne = true;
        } else {
            node.left = null;
        }
        
        // Check right child subarray
        if (containsOne(node.right)) {
            containsSubtreeWithOne = true;
        } else {
            node.right = null;
        }
        
        return containsSubtreeWithOne;
    }
}
