/** 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

package Problems.Medium;

import java.util.*;

public class _17_LetterCombinationsOfAPhoneNumber {
    /**
     * Creates every possible permutation of letters from a given string of digits such that the 
     * letters fit telephone button mapping values:
     * 2 = (a,b,c);
     * 3 = (d,e,f);
     * 4 = (g,h,i);
     * 5 = (j,k,l);
     * 6 = (m,n,o);
     * 7 = (p,q,r,s);
     * 8 = (t,u,v);
     * 9 = (w,x,y,z);
     * @param digits String of digits. Digits are all between 2 and 9, inclusively. The string has 
     * a length between 0 and 4, inclusively.
     * @return List of all valid permutations.
     */
    public List<String> letterCombinations(String digits) {
        List<String> permutations = new ArrayList<String>();

        if (!digits.isEmpty()) {
            letterPermutations(digits, 0, new StringBuilder(), permutations);
        }

        return permutations;
    }

    /**
     * Recursively identifies the valid permutations for a given string of digits.  Once a string 
     * is identified, the list "permutations" is updated.
     * @param digits String of digits. Digits are all between 2 and 9, inclusively. The string has 
     * a length between 0 and 4, inclusively.
     * @param index Current index of the String digits to process.
     * @param strBuilder The current string of letters made for the permutation.
     * @param permutations List of all identified, valid permutations.
     */
    private void letterPermutations (String digits, int index, StringBuilder strBuilder, 
            List<String> permutations) {
        int number = Character.getNumericValue(digits.charAt(index));
        int letterCount = (number == 7 || number == 9) ? 4 : 3;

        for (int i = 0; i < letterCount; i++) {
            int charValue = (((number - 2) * 3) + (97 + i));
            if (number >= 8) charValue++;
            strBuilder.append((char) charValue);

            if (index < digits.length() - 1) {
                letterPermutations(digits, index + 1, strBuilder, permutations);
            } else {
                permutations.add(strBuilder.toString());
            }

            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
    }
}
