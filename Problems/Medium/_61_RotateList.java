/** 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 */

package Problems.Medium;

import Helper.ListNode;

public class _61_RotateList {
    /**
     * Rotates a given linked list k times to the right.
     * @param head The original head of the list before rotation.
     * @param k The number of rotations.
     * @return The new head of the list after rotation.
     */
    public ListNode rotateRight(ListNode head, int k) {
        int nodeCount = 0;
        ListNode walker = head, newTail = head, oldTail = head, newHead = head;
        
        if (head == null) return null;
        
        while (walker != null) {
            nodeCount++;
            oldTail = walker;
            walker = walker.next;
        }
        
        for (int i = 1; i < nodeCount - (k % nodeCount); i++) {
            newTail = newTail.next;
        }
        
        oldTail.next = head;
        newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
