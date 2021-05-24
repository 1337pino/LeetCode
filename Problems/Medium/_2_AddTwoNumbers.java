/** 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */

package Problems.Medium;

public class _2_AddTwoNumbers {
    /**
     * Adds two non-empty linked lists representing two non-negative integers and returns the sum 
     * as a new linked list. The digits are stored in reverse order, and each of their nodes 
     * contains a single digit.
     * @param l1 Non-empty linked lists representing a non-negative integer.
     * @param l2 Non-empty linked lists representing a non-negative integer.
     * @return Non-empty linked list representing a non-negative integer sum of l1 and l2.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(), l1Walker = l1, l2Walker = l2, walker = sum, prev = walker;
        int remainder = 0;
        
        while (l1Walker != null || l2Walker != null) {
            int tempSum = remainder;
            
            if (l1Walker != null) {
                tempSum += l1Walker.val;
                l1Walker = l1Walker.next;
            }
            if (l2Walker != null) {
                tempSum += l2Walker.val;
                l2Walker = l2Walker.next;
            }
            
            if (tempSum < 10) {
                walker.val = tempSum;
                remainder = 0;
            } else {
                walker.val = tempSum - 10;
                remainder = 1;
            }
            
            walker.next = new ListNode();
            prev = walker;
            walker = walker.next;
        }
        
        if (remainder != 0) {
            walker.val = remainder;
        } else {
            prev.next = null;
        }
        
        return sum;
    }
}