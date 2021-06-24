/** 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 */

package Problems.Easy;

public class _541_ReverseStringII {
    /**
     * Reverses every K substrings of s.
     * 
     * @param s String s consisting of only lowercase English letters and has a length between 1 
     * and 10^4, inclusively
     * @param k Subtring size for reversal; will reverse subtrings and strings that are shorter 
     * than k. k is between 1 and 10^4, inclusively
     * @return A new string with every K substring reversed.
     */
    public String reverseStr(String s, int k) {
        int backEnd = k - 1, frontEnd = 0;
        char[] characters = s.toCharArray();
        
        while (backEnd < s.length()) {
            reverseSubarray(characters, frontEnd, backEnd);
            
            backEnd += 2 * k;
            frontEnd += 2 * k;
        }
        
        if (frontEnd < s.length()) {
            reverseSubarray(characters, frontEnd, s.length() - 1);
        }
        
        return new String(characters);
    }
    
    /**
     * Reverses a subarray of a given character array.
     * 
     * @param chars Char array
     * @param index1 First index of the subarray
     * @param index2 Last index of the subarray
     */
    private void reverseSubarray(char[] chars, int index1, int index2) {
        for (int i = index1, j = index2; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
