/** 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 */

package Problems.Easy;

public class _415_AddStrings {
    /**
     * Calculates the sum of two non-negative integers, num1 and num2, as a string.
     * @param num1 Non-negative integer as a string. 1 <= num1.length <= 10^4
     * @param num2 Non-negative integer as a string. 1 <= num2.length <= 10^4
     * @return The sum as a string.
     */
    public String addStrings(String num1, String num2) {
        int i = 0, carryover = 0;
        StringBuilder strBuilder = new StringBuilder();
        
        while (i < num1.length() || i < num2.length()) {
            int elementDigit = carryover, indexAdjustment = 1 - i;
            
            if (i < num1.length()) elementDigit 
                    += Character.getNumericValue(num1.charAt(indexAdjustment));
            if (i < num2.length()) elementDigit 
                    += Character.getNumericValue(num2.charAt(indexAdjustment));
            
            if (elementDigit > 9) {
                carryover = 1;
                elementDigit -= 10;
            } else {
                carryover= 0;
            }
            
            strBuilder.append(elementDigit);
            
            i++;
        }
        
        if (carryover !=0 ) strBuilder.append(carryover);
        
        return strBuilder.reverse().toString();
    }
}
