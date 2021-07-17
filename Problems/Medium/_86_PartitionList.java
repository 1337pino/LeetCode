/** 86. Partition List
 * https://leetcode.com/problems/partition-list/
 */

package Problems.Medium;

public class _86_PartitionList {
    /**
     * Partitions the linked list based on the value X.  All nodes with a stored value less than X 
     * will be shifted in front of the first node with a stored value that is equal to or greater 
     * than X.  Relative order of partitioned nodes should be preserved.
     * 
     * @param head The head of a linked list.  The number of nodes in the list is between 0 and 
     * 200, inclusively. Node values are between -100 and 100, inclusively.
     * @param x Value X to base a partition on. X is between -200 and 200, inclusively.
     * @return The head of the newly partitioned linked list.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode anchorNode = head;
        boolean needNewHead = false;
        
        // Special case for empty list or a list of a single node
        if (head == null || head.next == null) return head;
        
        if (head.val >= x) needNewHead = true;
        
        while (needNewHead == false && anchorNode.next != null) {
            if (anchorNode.next.val >= x) break;
            anchorNode = anchorNode.next;
        }
        
        // Search for all nodes beyond the anchorNode that need to be moved
        ListNode walker = anchorNode.next;
        if (needNewHead) walker = anchorNode;
        while (walker != null && walker.next != null) {
            if (walker.next.val < x) {
                ListNode temp = walker.next;
                walker.next = walker.next.next;
                
                if (needNewHead == true) {
                    temp.next = head;
                    anchorNode = temp;
                    head = temp;
                    needNewHead = false;
                } else {
                    temp.next = anchorNode.next;
                    anchorNode.next = temp;
                    anchorNode = temp;
                }
            } else {
                walker = walker.next;
            }
        }
        
        return head;
    }
}
