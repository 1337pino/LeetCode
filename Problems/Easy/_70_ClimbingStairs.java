/** 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 */

package Problems.Easy;

public class _70_ClimbingStairs {
    /**
     * Returns the number of distinct step combinations to reach n steps.  Steps made can only be 1 
     * or 2 steps at a time.
     * 
     * @param n Number of steps to the reach. 1 <= n <= 45
     * @return Number of distinct step combinations as an integer value
     */
    public int climbStairs(int n) {
        int[] nSteps = new int[46];
        
        for (int i = 0; i < 46; i++) {
            nSteps[i] = -1;
        }
        nSteps[0] = 0;
        nSteps[1] = 1;
        nSteps[2] = 2;
        
        return climbNStairs(n, nSteps);
    }
    
    /**
     * Returns the number of distinct step combinations to reach n steps.  Steps made can only be 1 
     * or 2 steps at a time.
     * 
     * @param n Number of steps to the reach. 1 <= n <= 45
     * @param nSteps A log of known climbStairs values. A value of -1 is a step that has not been 
     * calculated for yet.
     * @return Number of distinct step combinations as an integer value.
     */
    public int climbNStairs(int n, int[] nSteps) {
        if (nSteps[n] < 0) {
            if (nSteps[n - 1] < 0) nSteps[n - 1] = climbNStairs(n - 1, nSteps);
            if (nSteps[n - 2] < 0) nSteps[n - 2] = climbNStairs(n - 2, nSteps);
            
            return nSteps[n - 1] + nSteps[n - 2];
        } else return nSteps[n];
    }
}
