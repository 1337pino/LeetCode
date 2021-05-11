/** 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

package Problems.Hard;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _23_MergeKSortedLists {
    /**
     * Merges an array of k linked-lists lists.  Each linked-list is sorted in ascending order.
     * 
     * @param lists Array of k linked-lists lists.  Each linked-list is sorted in ascending order.
     * @return Sorted linked-list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int nonEmptyListCount = 0, indexOfFirstNonEmpty = -1, indexOfAnotherNonEmpty = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (indexOfFirstNonEmpty == -1) indexOfFirstNonEmpty = i;
                nonEmptyListCount++;
                indexOfAnotherNonEmpty = i;
            }
        }

        if (nonEmptyListCount == 0) {
            return null;
        } else if (nonEmptyListCount == 1) {
            return lists[indexOfFirstNonEmpty];
        } else {
            ListNode sorted = new ListNode(), sortedWalker;
            int indexOfLowest, indexOfSecondLowest;

            ListNode[] heads = new ListNode[lists.length];
            for (int i = 0; i < lists.length; i++) {
                heads[i] = new ListNode();
                heads[i].next = lists[i];
            }

            // Jump start selecting the lowest and second lowest node values
            if (lists[indexOfFirstNonEmpty].val < lists[indexOfAnotherNonEmpty].val) {
                indexOfLowest = indexOfFirstNonEmpty;
                indexOfSecondLowest = indexOfAnotherNonEmpty;
            } else {
                indexOfLowest = indexOfAnotherNonEmpty;
                indexOfSecondLowest = indexOfFirstNonEmpty;
            }

            // Scan through the remaining root nodes to find the actual lowest and second lowest
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null 
                        && i != indexOfLowest 
                        && lists[i].val < lists[indexOfSecondLowest].val) {
                    if (lists[i].val < lists[indexOfLowest].val) {
                        indexOfSecondLowest = indexOfLowest;
                        indexOfLowest = i;
                    } else {
                        indexOfSecondLowest = i;
                    }
                }
            }
            
            sortedWalker = sorted;

            while (true) {
                if (heads[indexOfSecondLowest].next == null) {
                    while (heads[indexOfLowest].next != null) {
                        ListNode nextNode = new ListNode(heads[indexOfLowest].next.val);
                        heads[indexOfLowest].next = heads[indexOfLowest].next.next;
                        sortedWalker.next = nextNode;
                        sortedWalker = nextNode;
                    }

                    break;
                }
                while (heads[indexOfLowest].next != null
                        && (heads[indexOfLowest].next.val <= heads[indexOfSecondLowest].next.val)) {
                    ListNode nextNode = new ListNode(heads[indexOfLowest].next.val);
                    heads[indexOfLowest].next = heads[indexOfLowest].next.next;
                    sortedWalker.next = nextNode;
                    sortedWalker = nextNode;
                }

                int tempIndex = indexOfLowest;
                indexOfLowest = indexOfSecondLowest;
                indexOfSecondLowest = -1;
                for (int i = 0; i < heads.length; i++) {
                    if (heads[i].next != null && i != indexOfLowest) {
                        if (indexOfSecondLowest == -1) {
                            indexOfSecondLowest = i;
                        } else if (heads[i].next.val < heads[indexOfSecondLowest].next.val) {
                            indexOfSecondLowest = i;
                        }
                    }
                } 
                if (indexOfSecondLowest == -1) {
                    indexOfSecondLowest = tempIndex;
                }
            }

            return sorted.next;
        }
    }
}
