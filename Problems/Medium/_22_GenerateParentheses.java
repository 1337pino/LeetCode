/** 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 */

package Problems.Medium;

import java.util.*;

public class _22_GenerateParentheses {
    /**
     * Generate all combinations of well-formed parentheses given n pairs of parenthesis.
     * @param n Number of parenthesis pairs
     * @return List of string values of all combinations.
     */
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<String>();
        
        parentheses.addAll(generateParenthesis("", n, n));

        return parentheses;
    }
    
    /**
     * Generate all combinations of well-formed parentheses given a leading parenthesis string and 
     * a given amount of remaining left nd right parenthesis.
     * @param leadingStr Previously established first part of a given string of well-formed 
     * parentheses.
     * @param remLeft Number of remaining left parenthesis to use in combination.
     * @param remRight Number of remaining right parenthesis to use in combination.
     * @return List of all combinations that can be made.
     */
    private List<String> generateParenthesis(String leadingStr, int remLeft, int remRight) {
        List<String> parentheses = new ArrayList<String>();
        
        if (remLeft > 0) {
            parentheses.addAll(generateParenthesis(leadingStr + "(", remLeft - 1, remRight));  
        } else if (remRight == 1) {
            parentheses.add(leadingStr + ")");
            remRight--;
        }
        
        if (remLeft < remRight) {
            parentheses.addAll(generateParenthesis(leadingStr + ")", remLeft, remRight - 1));
        }

        return parentheses;
    }
}
