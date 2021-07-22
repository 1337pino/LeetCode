/** 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */

package Problems.Easy;

import java.util.*;
import Helper.TreeNode;

public class _100_SameTree {
    /**
     * Compares two binary trees to see if both trees are identical.
     * 
     * @param p Binary tree p.
     * @param q Binary tree q.
     * @return True if the trees are the same size and have identical values.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        Stack<TreeNode> qStack = new Stack<TreeNode>();
        
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        
        pStack.push(p);
        qStack.push(q);
        
        while (pStack.empty() == false && qStack.empty() == false) {
            TreeNode pNode = pStack.pop();
            TreeNode qNode = qStack.pop();
            
            if (pNode.val != qNode.val) return false;
            
            if (pNode.left != null && qNode.left != null) {
                pStack.push(pNode.left);
                qStack.push(qNode.left);
            } else if (pNode.left != null) {
                return false;
            } else if (qNode.left != null) {
                return false;
            }
            
            if (pNode.right != null && qNode.right != null) {
                pStack.push(pNode.right);
                qStack.push(qNode.right);
            } else if (pNode.right != null) {
                return false;
            } else if (qNode.right != null) {
                return false;
            }
        }
        
        if (pStack.empty() == false || qStack.empty() == false) return false;
        
        return true;
    }
}
