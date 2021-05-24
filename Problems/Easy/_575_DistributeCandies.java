/** 575. Distribute Candies
 * https://leetcode.com/problems/distribute-candies/
 */

package Problems.Easy;

import java.util.*;

public class _575_DistributeCandies {
    /**
     * Calculates the maximum number of unique candy types that can be eaten if you only eat half 
     * of the collection of candy.
     * @param candyType Collection of candy. Each index represents an individual piece of candy and 
     * each value represents a type.
     * @return Max number of unique candy types as an integer in a sample size of half the 
     * collection.
     */
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        
        int lastType = candyType[0], numOfTypes = 1;
        
        for (int i = 1; i < candyType.length; i++) {
            int candy = candyType[i];
            
            if (candy != lastType) {
                numOfTypes++;
                lastType = candy;
            }
        }
        
        return (candyType.length / 2 < numOfTypes) ? (candyType.length / 2) : numOfTypes;
    }
}
