/** 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */

package Problems.Easy;

public class _26_RemoveDuplicatesfromSortedArray {
    /**
     * Removes the duplicates values of a given, sorted integer array in-place such that each 
     * element appears only once. Returns the new length.
     * @param nums Sorted integer array.
     * @return The length of the new array.
     */
    public int removeDuplicates(int[] nums) {
        int originalSize = nums.length, newSize = originalSize;
        int lookAhead = 0;
        
        for (int i = 1; i < originalSize; i++) {
            if (i + lookAhead >= originalSize) {
                break;
            }
            
            if (nums[i - 1] == nums[i + lookAhead]) {
                newSize--;
                lookAhead++;
                i--;
            } else {
                nums[i] = nums[i + lookAhead];
            }
        }
        
        return newSize;
    }
}
