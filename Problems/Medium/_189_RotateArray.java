/** 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 */

package Problems.Medium;

import java.util.*;

public class _189_RotateArray {
    /**
     * Rotates the given array to the right by k steps.
     * @param nums Array of integers. -2^31 <= nums[i] <= 2^31 - 1. 1 <= nums.length <= 10^5.
     * @param k Number of rotation steps. 0 <= k <= 10^5.
     */
    public void rotate(int[] nums, int k) {
        Queue<Integer> rotatedSubarray = new LinkedList<Integer>();
        
        // Rotating more than the length of the array is excessive work
        int normalizedK = k % nums.length;
        
        // Identify and enqueue the values that will be rotated to the front
        for (int i = 1; i <= normalizedK; i++) {
            rotatedSubarray.add(nums[nums.length -  i]);
        }
        
        // Shift the remaining array values back to the end of the array
        for (int i = nums.length - 1; i >= normalizedK; i--) {
            nums[i] = nums[i - normalizedK];
        }
        
        // Dequeue the rotated values and assign them to the front of the array
        for (int i = normalizedK - 1; i >= 0; i--) {
            nums[i] = rotatedSubarray.remove();
        }
    }
}
