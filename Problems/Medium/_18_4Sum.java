/** 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */

package Problems.Medium;

import java.util.*;

public class _18_4Sum {
    /**
     * Finds all the unique quadruplets within array 'nums' that add up to the given target number.
     * @param nums Array of n integers. 1 <= nums.length <= 200. -10^9 <= nums[i] <= 10^9
     * @param target Target sum for any quadruplets. -10^9 <= target <= 10^9
     * @return All possible quadruplets as a list of lists.
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);

        return nSum(nums, target, 4, 0);
    }
    
    /**
     * Finds all the unique n-lets within a subarray of 'nums' that add up to the given target 
     * number. The subarray starts from a given index to the end of nums.
     * @param nums Array of n integers. 1 <= nums.length <= 200. -10^9 <= nums[i] <= 10^9
     * @param target Target sum for any quadruplets. -10^9 <= target <= 10^9
     * @param n Size of the n-lets. (For example: 4 means a quadruplet and 3 means a triplet)
     * @param startingIndex Start of the subarray to search within.
     * @return All possible n-lets as a list of lists.
     */
    public List<List<Integer>> nSum(int[] nums, int target, int n, int startingIndex) {
        List<List<Integer>> nSumIntegers = new ArrayList<List<Integer>>();

        if (n == 1) {
            for (int i = startingIndex; i < nums.length && nums[i] <= target; i++) {
                if (nums[i] == target) {
                    List<Integer> intlet = new ArrayList<Integer>();
                    intlet.add(nums[i]);
                    nSumIntegers.add(intlet);
                    return nSumIntegers;
                }
            }
        } else {
            for (int i = startingIndex; i < nums.length - 1; i++) {
                if (i != startingIndex && nums[i] == nums[i - 1]) continue;
                
                List<List<Integer>> nMinus1SumIntegers = nSum(nums, target - nums[i], n - 1, i + 1);

                for (int j = 0; j < nMinus1SumIntegers.size(); j++) {
                    nMinus1SumIntegers.get(j).add(nums[i]);
                }

                if (!nMinus1SumIntegers.isEmpty()) {
                    nSumIntegers.addAll(nMinus1SumIntegers);
                }
            }
        }

        return nSumIntegers;
    }
}