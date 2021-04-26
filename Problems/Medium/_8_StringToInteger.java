/** 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */

package Problems.Medium;

public class _8_StringToInteger {
    /**
     * Converts a string to a 32-bit signed integer.  Ignores white space at the start of the 
     * string.  String may start with '-' or '+' characters, but must otherwise only have number 
     * characters at the front of the string.  Anything in the string after the first non-number 
     * character will be ignored for the converion.
     * @param s String for conversion
     * @return Integer value of the string.  Returns 0 if no valid integer conversion can occur.  
     * Has a maximum and minimum conversion value of Integer.MAXIMUM and Integer.MINIMUM, 
     * respectively.
     */
    public static int myAtoi(String s) {
        String str = s.trim();
        long strValue = 0, max = (long) Integer.MAX_VALUE + 1;

        if (str.isEmpty()) return 0;
        
        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            char character = str.charAt(i);
            if (Character.isDigit(character)) {
                // Each digit in the string number is a power of ten multiple for the new integer
                strValue += (int)(Math.pow(10,j) * (Character.valueOf(character) - 48));
                if (strValue >= max) {
                    if (i != 0) {
                        strValue = max;
                    } else {
                        strValue = max - 1;
                    }
                }
            } else if (i == 0) {
                if (character == '-') {
                    strValue *= -1;
                } else if (character == '+') {
                    if (strValue == max) strValue -= 1;
                } else {
                    // The first character is invalid (neither '-' or '+')
                    return 0;
                }
            } else {
                strValue = 0;
                j = -1;
            }
            
        }
        
        return (int) strValue;
    }
}
