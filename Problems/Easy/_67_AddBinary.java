/** 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 */

package Problems.Easy;

public class _67_AddBinary {
    /**
     * Given two binary strings a and b, returns their sum as a binary string.
     * @param a String of only binary digits.
     * @param b String of only binary digits.
     * @return String representing the binary sum of the two input strings.
     */
    public String addBinary(String a, String b) {
        int carryover = 0, i = 0;
        StringBuilder strBuilder = new StringBuilder();
        
        while (i < a.length() || i < b.length()) {
            int aVal = (a.length() > i) ? 
                    Character.getNumericValue(a.charAt(a.length() - (1 + i))) : 0;
            int bVal = (b.length() > i) ? 
                    Character.getNumericValue(b.charAt(b.length() - (1 + i))) : 0;
            
            int sum = aVal + bVal + carryover;
            carryover = 0;
            if (sum > 1) carryover = 1;
            strBuilder.append(sum % 2);
            
            i++;
        }
        
        // Handle edge case where result string has more binary digits than either input strings
        if (carryover > 0) strBuilder.append(Integer.toString(carryover));
        
        strBuilder.reverse();

        return strBuilder.toString();
    }
}
