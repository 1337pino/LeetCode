/** 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 */

package Problems.Medium;

import java.util.*;

public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int bestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                        bestSum = sum;
                    }

                    if (bestSum == target) return bestSum;
                }
            }
        }

        return bestSum;
    }
}
