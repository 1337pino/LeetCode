/** 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/
 */

package Problems.Medium;

import java.util.*;

public class _39_CombinationSum {
    /**
     * Finds all of the combinations of values of candidates that add up to the target value. Can 
     * use duplicates of values of candidates.
     * 
     * @param candidates Array of distinct values.
     * @param target Target sum.
     * @return List of combinations.
     */
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        return combinationSum(candidates, target, candidates.length - 1);
    }
    
    /**
     * Finds all of the combinations of values of candidates that add up to the target value. Can 
     * use duplicates of values of candidates.  Values are limited to the subarray from 0 to the 
     * lastIndex.
     * 
     * @param candidates Sorted array of distinct sums.
     * @param target Target sum.
     * @param lastIndex Final index of the subarray of candidates to use for combinations.
     * @return List of combinations, if any.
     */
    private List<List<Integer>> combinationSum(int[] candidates, int target, int lastIndex) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        
        for (int i = lastIndex; i >= 0; i--) {
            int newTarget = target - candidates[i];
            
            if (newTarget == 0) {
                List<Integer> finishedCombo = new ArrayList<Integer>();
                finishedCombo.add(candidates[i]);
                combinations.add(finishedCombo);
            } else if (newTarget > 0) {
                List<List<Integer>> otherCombinations = combinationSum(candidates, newTarget, i);
                
                if (otherCombinations.isEmpty() == false) {
                    for (List<Integer> combos : otherCombinations) {
                        combos.add(candidates[i]);
                        
                        combinations.add(combos);
                    }
                }
            }
        }
        
        return combinations;
    }
}
