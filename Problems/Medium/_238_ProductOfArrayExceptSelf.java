/** 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 */

package Problems.Medium;

public class _238_ProductOfArrayExceptSelf {
    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the 
     * product of all the elements of nums except nums[i].
     * @param nums Integer array. Nums length at least 2 and no greater than 10^5.  No value store 
     * in Nums is less than -30 and greater than 30
     * @return Integer array of the products of all of the elements of nums except for nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        long maxProduct = 1;
        int numOfZeros = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxProduct *= nums[i];
            if (nums[i] == 0) numOfZeros++;
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (numOfZeros > 1) {
                answer[i] = 0;
            } else if (nums[i] == 0) {
                answer[i] = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) answer[i] *= nums[j];
                }
            } else {
                answer[i] = (int) maxProduct / nums[i];
            }
        }
        
        return answer;
    }
}
