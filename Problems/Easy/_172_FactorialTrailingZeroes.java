/** 172. Factorial Trailing Zeroes
 *https://leetcode.com/problems/factorial-trailing-zeroes/
 */

package Problems.Easy;

public class _172_FactorialTrailingZeroes {
    /**
     * Returns the number of trailing zeroes for the factorial of a given number, n.
     * 
     * @param n Number for factorialization. Can be between 0 and 10000, inclusively.
     * @return Number of trailing zeroes only.  Does not count intermixed zeroes to the left of any 
     * non-zero number in the factorial.
     */
    public int trailingZeroes(int n) {
        int[] fivesAndTwos = new int[6];
        
        for (int i = 2; i <= n; i++) {
            countFivesAndTwosFactors(i, fivesAndTwos);
        }
        
        return Math.min(fivesAndTwos[2], fivesAndTwos[5]);
    }
    
    /**
     * Updates a count for all the factors of two and five for a given number.
     * 
     * @param n Given number, n.
     * @param count Array that holds the overall counts for all the 2's and 5's factors.
     */
    private void countFivesAndTwosFactors(int n, int[] count) {
        if (n % 2 == 0) {
            count[2]++;
            countFivesAndTwosFactors(n / 2, count);
        } else if (n % 5 == 0) {
            count[5]++;
            countFivesAndTwosFactors(n / 5, count);
        }
    }
}
