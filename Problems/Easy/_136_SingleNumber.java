/** 136. Single Number
 * https://leetcode.com/problems/single-number/
 */

package Problems.Easy;

import java.util.*;

public class _136_SingleNumber {
    /**
     * Identifies the only element of nums that does not have a duplicate.
     * 
     * @param nums Array of numbers. Length is between 1 and 3 * 10^4, inclusively. Elements are 
     * between -3 * 10^4 and 3 * 10^4, inclusively.
     * @return The integer value of the only non-duplicate element.
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0, j = 1; j < nums.length; i += 2, j += 2) {
            if (nums[i] != nums[j]) return nums[i];
        }
        
        return nums[nums.length - 1];
    }
}
