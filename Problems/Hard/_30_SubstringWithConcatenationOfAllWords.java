/** 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

package Problems.Hard;

import java.util.*;

public class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> startingIndexes = new ArrayList<Integer>();
        int wordLength = words[0].length();
        int slidingWindowLength = words.length * wordLength;
        Arrays.sort(words);
        
        if (slidingWindowLength <= s.length()) {
            
            // Count how many of each letter is in words
            int[] wordsLetterCount = new int[26];
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < wordLength; j++) {
                    int letter = words[i].charAt(j) - 97;
                    wordsLetterCount[letter] += 1;
                }
            }
            
            // Get the letter count for the current window
            int[] windowLetterCount = new int[26];
            for (int i = 0; i < slidingWindowLength; i++) {
                int letter = s.charAt(i) - 97;
                windowLetterCount[letter] += 1;
            }
            
            for (int i = 0; i + slidingWindowLength <= s.length(); i++) {
                
                // Update windowLetterCount
                if (i != 0) {
                    int oldLetter = s.charAt(i - 1) - 97;
                    int newLetter = s.charAt(i - 1 + slidingWindowLength) - 97;
                    windowLetterCount[oldLetter] -= 1;
                    windowLetterCount[newLetter] += 1;
                }
                
                // If the letter counts aren't the same we can't have a full concatenation
                if (Arrays.equals(wordsLetterCount, windowLetterCount)) {
                    boolean isConcatenation = false;
                    int j = i;
                    
                    boolean[] wordMatched = new boolean[words.length];
                    
                    while (j < i + slidingWindowLength) {
                        isConcatenation = false;
                        String tempWord = s.substring(j, j + wordLength);
                        
                        for (int k = 0; k < words.length; k++) {
                            int lexVal = tempWord.compareTo(words[k]);
                            
                            if (lexVal == 0 && wordMatched[k] == false) {
                                wordMatched[k] = true;
                                isConcatenation = true;
                                break;
                            } else if (lexVal < 0) {
                                break;
                            }
                        }
                        
                        if (isConcatenation == false) break;
                        
                        j += wordLength;
                    }
                    
                    if (isConcatenation) {
                        startingIndexes.add(i);
                    }
                }
            }
        }
        
        return startingIndexes;
    }
}
