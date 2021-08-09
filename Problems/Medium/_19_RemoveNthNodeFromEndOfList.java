/** 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

package Problems.Medium;

import java.util.*;
import Helper.ListNode;

public class _19_RemoveNthNodeFromEndOfList {
    /**
     * Remove the nth node from the end of the linked list of ListNode objects and return its head.
     * @param head Root of the linked list.
     * @param n Location, from the back of the list, to remove.
     * @return The root of the linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> nodeStack = new Stack<ListNode>();
        ListNode walker = head;
        
        // Store all of the nodes into a stack
        while (walker != null) {
            nodeStack.push(walker);
            walker = walker.next;
        }
        
        ListNode nPlus1 = null;
        
        // Pop nodes off of the stack until the top of the stack is the nth node
        for (int i = 1; i < n; i++) {
            nPlus1 = nodeStack.pop();
        }
        
        // Get rid of the nth node
        nodeStack.pop();
        
        // If the root node was the nth node
        if (nodeStack.size() == 0) return nPlus1;
        
        ListNode nMinus1 = nodeStack.pop();
        nMinus1.next = nPlus1;
        
        return head;
    }
}
