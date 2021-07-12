/** 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

package Problems.Easy;

import Helper.ListNode;

public class _83_RemoveDuplicatesFromSortedList {
    /**
     * Removes the duplicate values stored in a sorted linked list.  List size can be between 0 and 
     * 300, inclusively. Stored values can be between -100 and 100, inclusively.
     * 
     * @param head Head node in a linked list
     * @return Head node of the linked list after removal of the duplicates.
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode walker = head;

        while (walker != null) {
            ListNode nextNode = walker.next;
            
            while (nextNode != null) {
                if (nextNode.val == walker.val) {
                    nextNode = nextNode.next;
                } else break;
            }
            
            walker.next = nextNode;
            walker = nextNode;
        }
        
        return head;
    }
}
