/** 989. Add to Array-Form of Integer
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */

package Problems.Easy;

import java.util.*;

public class _989_AddToArrayFormOfInteger {
    /**
     * Calculates the sum of integer num and integer k.
     * @param num Array-form of integer num provided as an int array. 1 <= num.length <= 10^4
     * @param k Integer k. 1 <= k <= 10^4
     * @return Sum as an array-form in a List
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        String kString = Integer.toString(k);
        int i = 0, kStringLength = kString.length(), numLength = num.length, carryover = 0;
        List<Integer> sum = new ArrayList<Integer>();
        
        while (i < numLength || i < kString.length()) {
            int ithDigit = 0, indexFromBack = 1 + i;
            
            ithDigit += carryover;
            
            if (i < numLength) ithDigit += num[numLength - indexFromBack];
            
            if (i < kStringLength) ithDigit 
                    += Character.getNumericValue(kString.charAt(kStringLength - indexFromBack));
            
            if (ithDigit > 9) {
                carryover = 1;
                ithDigit -= 10;
            } else {
                carryover = 0;
            }
            
            sum.add(ithDigit);
            i++;
        }
        
        if (carryover != 0) sum.add(carryover);

        Collections.reverse(sum);
        
        return sum;
    }
}
