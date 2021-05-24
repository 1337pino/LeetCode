/** 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */

package Problems.Medium;

import java.util.*;

public class _13_RomanToInteger {
    /**
     * Convert a roman numeral string into an integer.
     * @param s String representation of a roman numeral.
     * @return Integer value of s.
     */
    public int romanToInt(String s) {
        int sVal = 0, rollingVal = 0;
        
        HashMap<Character, Integer> romanValues = new HashMap<Character, Integer>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int indexVal = romanValues.get(s.charAt(i));
            
            if (i != s.length() - 1) {
                if (indexVal >= romanValues.get(s.charAt(i + 1))) {
                    sVal += rollingVal;
                    rollingVal = indexVal;
                } else {
                    rollingVal -= indexVal;
                }
            } else {
                rollingVal = indexVal;
            }
        }
        
        sVal += rollingVal;
        
        return sVal;
    }
}
