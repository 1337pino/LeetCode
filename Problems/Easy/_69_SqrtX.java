/** 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 */

package Problems.Easy;

public class _69_SqrtX {
    /**
     * Calculates the square root of a given integer value without using buil-in functions.
     * 
     * @param x Given integer value X. 0 <= x <= 2^31 - 1
     * @return The square root as an integer (results will be truncated)
     */
    public int mySqrt(int x) {
        long sqrt = 1;
        
        while (sqrt * sqrt <= x) {
            sqrt++;
        }
        
        if (sqrt * sqrt > x) sqrt--;
        
        return (int)sqrt;
    }
}
