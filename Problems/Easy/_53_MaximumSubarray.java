/** 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */

package Problems.Easy;

public class _53_MaximumSubarray {
    /**
     * Finds the contiguous subarray (containing at least one number) which has the largest sum and 
     * return its sum.
     * @param nums Integer array of numbers. Must have a length between 1 and 3 * 10^4, inclusively.
     * Limited to values between -10^5 and 10^5, inclusively.
     * @return The largest sum as an integer value.
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            runningSum += num;
            if (runningSum > maxSum) maxSum = runningSum;

            if (num < 0 && (runningSum <= 0)) {
                runningSum = 0;
            }
        }

        return maxSum;
    }
}
