/** 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */

package Problems.Medium;

import java.util.*;

public class _15_3Sum {
    /**
     * Processes a array of integers and returns all triplets that add up to 0 (without duplicate 
     * triplets).
     * @param nums array of integers (inclusively between -10^5 and 10^5)
     * @return list of 3-integer lists whose sum each add up to 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> numsCount = new HashMap<Integer, Integer>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            numsCount.merge(nums[i], 1, Integer::sum);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int numNeeded = 0 - (nums[i] + nums[j]);
                
                if (numsCount.containsKey(numNeeded) && numNeeded >= nums[j]) {
                    if (numNeeded == 0 && nums[j] == 0 && (numsCount.get(numNeeded) < 3)) {
                        continue;
                    } else if (nums[j] == numNeeded && (numsCount.get(numNeeded) < 2)) {
                        continue;
                    }
                    List<Integer> newSequence = new ArrayList<Integer>(3);
                    newSequence.add(nums[i]);
                    newSequence.add(nums[j]);
                    newSequence.add(numNeeded);
                    answer.add(newSequence);

                    if (numNeeded == 0 && nums[j] == 0) {
                        numsCount.replace(0, 1);
                    }
                }
            }
        }

        return answer;
    }
}
