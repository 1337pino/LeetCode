/** 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 */

package Problems.Medium;

import java.util.*;

public class _49_GroupAnagrams {
    /**
     * Groups all of the anagrams from an array of strings
     * 
     * @param strs Array of strings. The array is contains 1 to 10^4 strings, inclusively.  Each 
     * string has a length between 0 and 100, inclusively.
     * @return All anagrams grouped into separate lists.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<String, List<String>>();
        List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
        
        for (int i = 0; i < strs.length; i++) {
            int strLength = strs[i].length();
            char[] strLetters = new char[strLength];
            
            for (int j = 0; j < strLength; j++) {
                strLetters[j] = strs[i].charAt(j);
            }
            
            Arrays.sort(strLetters);
            
            String sortedWord = String.valueOf(strLetters);
            
            if (anagrams.get(sortedWord) == null) {
                anagrams.put(sortedWord, new ArrayList<String>());
            }
            anagrams.get(sortedWord).add(strs[i]);
        }
        
        for (Map.Entry<String, List<String>> entry : anagrams.entrySet()) {
            groupedAnagrams.add(entry.getValue());
        }
        
        return groupedAnagrams;
    }
}
