/** 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

package Problems.Easy;

public class _144_BinaryTreePreorderTraversal {
    /**
     * Creates a list of the integer values stored in the tree and in a preorder traversal ordering.
     * @param root Root of the tree.
     * @return A list of Integer values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        List<Integer> traversal = new ArrayList<Integer>();
        TreeNode currentNode = root;
        
        while (currentNode != null) {
            if (currentNode.right != null) nodeStack.push(currentNode.right);
            
            traversal.add(currentNode.val);
            
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else if (nodeStack.isEmpty() == false) {
                currentNode = nodeStack.pop();
            } else {
                currentNode = null;
            }
        }
        
        return traversal;
    }
}
