/** 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 */

package Problems.Easy;

import java.util.*;

public class _217_ContainsDuplicate {
    /**
     * Checks if any integer value appears twice in a given array.
     * @param nums Array of integers. 1 <= nums.length <= 10^5. -10^9 <= nums[i] <= 10^9.
     * @return True if there are duplicates of any value in the array. False if every value is 
     * distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsElements = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numsElements.add(nums[i]) == false) return true;
        }
        
        return false;
    }
}