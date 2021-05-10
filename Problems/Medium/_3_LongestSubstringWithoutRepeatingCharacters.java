/** 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

package Problems.Medium;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    /**
     * Finds the length of the longest substring without repeating characters for a given string.
     * @param s String s consisting of English letters, digits, symbols, and spaces. 
     * 0 <= s.length <= 5 * 10^4
     * @return Length of the longest substring as an integer value.
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] characters = new int[127];
        int longestSubstringLength = 0, subarrayStart = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int characterValue = (int) s.charAt(i);
            if (characters[characterValue] != 0 && characters[characterValue] > subarrayStart) {
                subarrayStart = characters[characterValue];
            }

            characters[characterValue] = i + 1;

            int currentSubarrayLength = (i - subarrayStart) + 1;
            if (currentSubarrayLength > longestSubstringLength) {
                longestSubstringLength = currentSubarrayLength;
            }
        }
        
        return longestSubstringLength;
    }

    public static void main(String[] args){
        
        //Scanner in = new Scanner(System.in);
        //int elements = Integer.parseInt(in.nextLine());
        //int[] testInput = new int[elements];

        //for (int i = 0; i < elements; i++) {
        //    testInput[i] = Integer.parseInt(in.nextLine());
        //}

        int answer = lengthOfLongestSubstring("3453kjb78hgb43t67438524234678676978sdfgkdsjfghsdferjgeufgdbibtf675sdfsdg dfyugds if6t34 i8g dv8sfv 78gf87dv 98sdf7v");
        //[-2,-2,-2,-2,-2,-2,-123,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0]

        /*String output = ""; 
        for (int j = 0; j < answer.size(); j++) {
            output += answer.get(j)+ " ";
        }*/

        System.out.println(answer);

        //in.close();
    }
}
