package Problems.Hard;

import java.util.regex.*;

public class _10_RegularExpressionMatching {
    
    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with 
     * support for '.' and '*' where: 
     * <p>'.' Matches any single character.​​​​
     * <p>'*' Matches zero or more of the preceding element.
     * <p>The matching should cover the entire input string (not partial).
     * @param s String of only lowercase English letters.  Size is no more than 20 characters
     * @param p Regex string of only lowercase English letters, '*', and '.'
     * @return True if string S fully matches pattern P
     */
    public boolean isMatch(String s, String p) {
        Pattern patternP = Pattern.compile(p);
        Matcher matcherP = patternP.matcher(s);
        
        return matcherP.matches();
    }
}
