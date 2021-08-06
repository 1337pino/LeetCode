/** 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */

package Problems.Easy;

import Helper.ListNode;

public class _237_DeleteNodeInALinkedList {
    /**
     * Removes a node from a singly-linked list without knowing the head of the linked list.
     * @param node Node for removal.
     */
    public void deleteNode(ListNode node) {
        ListNode walker = node;
        while (walker.next != null) {
            walker.val = walker.next.val;
            
            if (walker.next.next == null) {
                walker.next = null;
            } else {
                walker = walker.next;
            }
        }
    }
}
