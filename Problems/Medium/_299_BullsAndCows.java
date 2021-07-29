/** 299. Bulls and Cows
 * https://leetcode.com/problems/bulls-and-cows/
 */

package Problems.Medium;

public class _299_BullsAndCows {
    public static String getHint(String secret, String guess) {
        int[] letterCounts = new int[10];
        int cows = 0, bulls = 0;
        
        for (int i = 0; i < secret.length(); i++) {
            letterCounts[secret.charAt(i) - 48]++;
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) letterCounts[guess.charAt(i) - 48]--;
        }
        
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (letterCounts[guess.charAt(i) - 48] > 0) {
                    letterCounts[guess.charAt(i) - 48]--;
                    cows++;
                }
            } else bulls++;
        }
        
        return bulls + "A" + cows + "B";
    }
}
