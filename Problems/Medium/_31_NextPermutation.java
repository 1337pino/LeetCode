/** 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 */

package Problems.Medium;

import java.util.*;

public class _31_NextPermutation {
    /**
     * Rearranges numbers into the lexicographically next greater permutation of numbers.
     * @param nums Array of integers. 1 <= nums.length <= 100. 0 <= nums[i] <= 100
     */
    public void nextPermutation(int[] nums) {
        int pivotIndex = nums.length - 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            
            if (num < nums[pivotIndex]) {
                int swapIndex = nums.length - 1;
                for (int j = nums.length - 1; j >= pivotIndex; j--) {
                    if (num < nums[swapIndex]) {
                        break;
                    }
                    
                    swapIndex = j;
                }
                
                nums[i] = nums[swapIndex];
                nums[swapIndex] = num;
                break;
            }
            
            pivotIndex = i;
        }
        
        Arrays.sort(nums, pivotIndex, nums.length);
    }
}
