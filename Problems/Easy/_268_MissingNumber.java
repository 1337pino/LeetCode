/** 268. Missing Number
 * https://leetcode.com/problems/add-strings/
 */

package Problems.Easy;

public class _268_MissingNumber {
    /**
     * Finds the only missing number in a collection of unique numbers.
     * 
     * @param nums Array of distinct numbers.  Length, N, is between 1 and 10^4, inclusively.
     * @return The only missing number between 0 and N, inclusively.
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return (nums[0] == 1) ? 0 : 1;
        }
        
        int sum = 0, arithmeticSum = ((nums.length * (nums.length - 1)) / 2);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        return nums.length - (sum - arithmeticSum);
    }
}
