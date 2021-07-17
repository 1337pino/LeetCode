/** 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

package Problems.Medium;

import java.util.*;
import Helper.TreeNode;

public class _94_BinaryTreeInorderTraversal {
    /**
     * Creates a list of values stored in a binary tree based on an inorder traversal using an 
     * iterative approach.
     * 
     * @param root Root of the binary tree.
     * @return List of all of the trees node values in inorder traversal ordering.
     */
    public List<Integer> inorderTraversalITERATIVE(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> traversal = new ArrayList<Integer>();
        TreeNode currentNode = root;
        
        while (currentNode != null || nodeStack.empty() == false) {
            if (currentNode == null) {
                currentNode = nodeStack.pop();
                traversal.add(currentNode.val);
                currentNode = currentNode.right;
            } else {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
        }
        
        return traversal;
    }

    /**
     * Creates a list of values stored in a binary tree based on an inorder traversal using a 
     * recursive approach.
     * 
     * @param root Root of the binary tree.
     * @return List of all of the trees node values in inorder traversal ordering.
     */
    public List<Integer> inorderTraversalRECURSIVE(TreeNode root) {
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
