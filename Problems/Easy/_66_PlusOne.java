/** 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */

package Problems.Easy;

public class _66_PlusOne {
    /**
     * Returns an array of decimal digits representing 1 value greater than the given array.
     * @param digits Non-empty array of digits representing a single integer value.
     * @return An integer array similar to the input, but with an overall integer value of 1 more.
     */
    public int[] plusOne(int[] digits) {
        int[] increasedDigits = new int[digits.length];
        int carryover = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carryover + digits[i];

            if (sum > 9) {
                sum = 0;
            } else {
                carryover = 0;
            }

            increasedDigits[i] = sum;
        }

        if (carryover != 0) {
            increasedDigits = new int[digits.length + 1];
            increasedDigits[0] = 1;
        }
        
        return increasedDigits;
    }
}
