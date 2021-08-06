/** 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 */

package Problems.Easy;

public class _191_NumberOf1Bits {
    /**
     * Returns the number of '1' bits a signed integer number has.
     * @param n Signed integer number.
     * @return
     */
    public int hammingWeight(int n) {
        String binaryNString = Integer.toBinaryString(n);
        int ones = 0;
        
        for (int i = 0; i < binaryNString.length(); i++) {
            if (binaryNString.charAt(i) == '1') ones++;
        }
        
        return ones;
    }
}
