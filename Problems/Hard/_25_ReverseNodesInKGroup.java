/** 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

package Problems.Hard;

import java.util.*;

public class _25_ReverseNodesInKGroup {
    /**
     * Reverse the nodes of a given linked list k at a time and return its modified list.
     * @param head Root node of the linked list.
     * @param k The amount of nodes per reversal intervals.
     * @return Returns a new root node for the newly organized linked list.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> listNodeStack = new Stack<ListNode>(), tailEndStack = new Stack<ListNode>();
        ListNode walker = head, newHead = null, subwalker = null;
        int kCounter = 0;
        
        while (walker != null) {
            if (kCounter == k) {
                for (int i = 0; i < k; i++) {
                    if (newHead == null) {
                        newHead = listNodeStack.pop();
                        subwalker = newHead;
                    } else {
                        subwalker.next = listNodeStack.pop();
                        subwalker = subwalker.next;
                    }
                }

                kCounter = 0;
            }
            
            listNodeStack.push(walker);
            
            walker = walker.next;
            kCounter++;
        }

        if (kCounter == k) {
            while (listNodeStack.isEmpty() == false) {
                if (newHead == null) {
                    newHead = listNodeStack.pop();
                    subwalker = newHead;
                } else {
                    subwalker.next = listNodeStack.pop();
                    subwalker = subwalker.next;
                }
            }
        } else {
            while (listNodeStack.isEmpty() == false) {
                tailEndStack.push(listNodeStack.pop());
            }
            while (tailEndStack.isEmpty() == false) {
                if (newHead == null) {
                    newHead = tailEndStack.pop();
                    subwalker = newHead;
                } else {
                    subwalker.next = tailEndStack.pop();
                    subwalker = subwalker.next;
                }
            }
        }

        subwalker.next = null;
        
        return newHead;
    }
}