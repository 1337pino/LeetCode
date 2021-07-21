/** 838. Push Dominoes
 * https://leetcode.com/problems/push-dominoes/
 */

package Problems.Medium;

public class _838_PushDominoes {
    /**
     * Process an input state of dominoes and returns the final state after all dominoes have moved.
     * Dominoes can be in a state of 'L' (fallen left), 'R' (fallen right), or '.' (standing 
     * veritcally).
     * 
     * @param dominoes String representing the state of n dominoes where n is the length of the 
     * string
     * @return String of the final state.  Will be the same length as the input string.
     */
    public String pushDominoes(String dominoes) {
        int verticalDominoes = 0, fallingRightIndex = 0;
        char[] finalState = new char[dominoes.length()];
        boolean fallingRight = false;
        
        for (int i = 0; i < dominoes.length(); i++) {
            char domino = dominoes.charAt(i);
            
            if (domino == '.') {
                finalState[i] = '.';
                verticalDominoes++;
            } else if (domino == 'L') {
                finalState[i] = 'L';
                if (fallingRight) {
                    int dominoChanges = verticalDominoes / 2;
                    
                    for (int j = i; j >= i - dominoChanges; j--) {
                        finalState[j] = 'L';
                    }
                    
                    for (int k = fallingRightIndex; k <= fallingRightIndex + dominoChanges; k++) {
                        finalState[k] = 'R';
                    }
                    
                    fallingRight = false;
                } else {
                    for (int j = i; j >= i - verticalDominoes; j--) {
                        finalState[j] = 'L';
                    }
                }
                verticalDominoes = 0;
            } else {
                finalState[i] = 'R';
                if (fallingRight) {
                    for (int j = i - 1; j >= i - verticalDominoes; j--) {
                        finalState[j] = 'R';
                    }
                }
                
                fallingRightIndex = i;
                fallingRight = true;
                
                verticalDominoes = 0;
            }
        }
        
        if (fallingRight) {
            for (int j = dominoes.length() - 1; j >= dominoes.length() - 1 - verticalDominoes; j--) {
                finalState[j] = 'R';
            }
        }
        
        return new String(finalState);
    }
}
