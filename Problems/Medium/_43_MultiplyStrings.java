/** 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/
 */

package Problems.Medium;

import java.util.*;

public class _43_MultiplyStrings {
    /**
     * Multiply two numbers represented in string form without using BigInteger libraries or 
     * directly converting the strings into integers.
     * 
     * @param num1 First number. Contains digits only and no leading zeroes. Length is between 1 
     * and 200, inclusively.
     * @param num2 Second number. Contains digits only and no leading zeroes. Length is between 1 
     * and 200, inclusively.
     * @return The product in string form.
     */
    public String multiply(String num1, String num2) {
        int remainder = 0, longestString = 0;
        List<StringBuilder> partialProducts = new ArrayList<StringBuilder>();
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();

            for (int k = num1.length() - 1; k > i; k--) {
                sb.append("0");
            }

            for (int j = num2.length() - 1; j >= 0; j--) {
                int subproduct = Character.getNumericValue(num1.charAt(i)) 
                        * Character.getNumericValue(num2.charAt(j));
                subproduct += remainder;
                remainder = subproduct / 10;
                subproduct %= 10;
                
                sb.append(subproduct);
            }
            
            sb.append(remainder);
            remainder = 0;
            partialProducts.add(sb);
            
            if (longestString < sb.length()) longestString = sb.length();
        }
        
        int[] tempdigits = new int[longestString];
        
        for (StringBuilder partialProduct : partialProducts) {
            for (int i = 0; i < partialProduct.length(); i++) {
                tempdigits[i] += Character.getNumericValue(partialProduct.charAt(i));
            }
        }
        
        remainder = 0;
        StringBuilder finalProduct = new StringBuilder();
        for (int i = 0; i < tempdigits.length; i++) {
            int digit = tempdigits[i];
            digit += remainder;
            remainder = digit / 10;
            digit %= 10;
            
            finalProduct.append(digit);
        }
        
        StringBuilder finalRemainder = new StringBuilder();
        finalRemainder.append(remainder);
        finalRemainder.reverse();
        
        finalProduct.append(finalRemainder);
        
        return processStringBuilder(finalProduct);
    }

    /**
     * Strips the sb builder object of all trailing zeroes (unless the object is all zeroes) before 
     * reversing it and then converting it to a string.
     * 
     * @param sb StringBuilder object holding the final product value.
     * @return Official and final form of the final product value.
     */
    private String processStringBuilder(StringBuilder sb) {
        int i = sb.length() - 1;
        while(sb.length() != 0 && sb.charAt(i) == '0') {
            sb.deleteCharAt(i);
            i--;
        }

        return (sb.length() == 0) ? "0" : sb.reverse().toString();
    }
}
