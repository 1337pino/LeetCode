/** 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 */

package Problems.Easy;

public class _509_FibonacciNumber {
    /**
     * Calculates F(n) of Fibonacci sequence (where F(n) = F(n - 1) + F(n - 2))
     * @param n 0 <= n <= 30
     * @return F(n) value (positive integer)
     */
    public int fib(int n) {
        int[] fibVal = new int[31];
        fibVal[0] = 0;
        fibVal[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            fibVal[i] = fibVal[i - 1] + fibVal[i - 2];
        }
        
        return fibVal[n];
    }
}
