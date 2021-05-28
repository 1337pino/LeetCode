/** 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 */

package Problems.Hard;

import java.util.*;

public class _32_LongestValidParentheses {
    /**
     * Finds the length of the longest valid (well-formed) parentheses substring.
     * 
     * @param s String containing just the characters '(' and ')'. 0 <= s.length <= 3 * 10^4
     * @return Length of the longest substring as an integer.
     */
    public int longestValidParentheses(String s) {
        Stack<Character> parenthesesStack = new Stack<Character>();
        Stack<Integer> WellFormedSubqueueSizes = new Stack<Integer>();
        int largest = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char parenthesis = s.charAt(i);
            
            if (parenthesis == '(' || parenthesesStack.empty()) {
                parenthesesStack.push(parenthesis);
            } else {
                char lastChar = parenthesesStack.peek();

                if (lastChar == '(') {
                    parenthesesStack.pop();
                    parenthesesStack.push('|');
                    WellFormedSubqueueSizes.push(2);
                } else if (lastChar =='|') {
                    int numPops = 0;

                    for (int j = parenthesesStack.size(); j > 0; j--) {
                        lastChar = parenthesesStack.pop();

                        if (lastChar == '|') {
                            numPops++;
                        } else if (lastChar == '(') {
                            WellFormedSubqueueSizes.push(2);
                            numPops++;
                            parenthesesStack.push('|');
                            break;
                        } else {
                            parenthesesStack.push(lastChar);
                            parenthesesStack.push('|');
                            parenthesesStack.push(parenthesis);
                            break;
                        }
                    }

                    // (Edge Case)
                    if (parenthesesStack.empty() && numPops > 0) {
                        parenthesesStack.push('|');
                        parenthesesStack.push(parenthesis);
                    }

                    int newSize = 0;
                    for (int j = 0; j < numPops; j++) {
                        newSize += WellFormedSubqueueSizes.pop();
                    }
                    WellFormedSubqueueSizes.push(newSize);
                } else {
                    parenthesesStack.push(parenthesis);
                }
            }
        }

        int subSize = 0;
        while (!WellFormedSubqueueSizes.empty()) {
            char pStackChar = parenthesesStack.pop();

            if (pStackChar == '|') {
                subSize += WellFormedSubqueueSizes.pop();
                largest = Math.max(largest, subSize);
            } else {
                largest = Math.max(largest, subSize);
                subSize = 0;
            }
        }
        
        return largest;
    }
}
