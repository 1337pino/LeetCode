/** 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

package Problems.Medium;

import java.util.*;
import Helper.TreeNode;

public class _94_BinaryTreeInorderTraversal {
    /**
     * Creates a list of values stored in a binary tree based on an inorder traversal.
     * 
     * @param root Root of the binary tree.
     * @return List of all of the trees node values in inorder traversal ordering.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orderedTreeNodes = new ArrayList<Integer>();
                
        traverseInOrder(root, orderedTreeNodes);
        
        return orderedTreeNodes;
    }
    
    /**
     * Recursive approach to inorder traversal.
     * 
     * @param node Current node to traverse in the tree.
     * @param list List for storing traversed node values.
     */
    private void traverseInOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            // Process left childpath
            traverseInOrder(node.left, list);

            // Add node's value to list
            list.add(node.val);

            // Process right childpath
            traverseInOrder(node.right, list);
        }
    }
}
