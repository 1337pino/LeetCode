/** 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */

package Problems.Medium;

public class _11_ContainerWithMostWater {
    /**
     * Finds the maximum area that can be created by the the provided array where in the array 
     * values represent vertical lines and the difference in indexes represents horizontal distance.
     * @param height N non-negative integers
     * @return integer value for the greatest possible area
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] * (height.length - 1) > maxArea) {
                for (int j = i + 1; j < height.length; j++) {
                    int left = height[i], right = height[j];
                    int tempArea = Math.min(left, right) * (j - i);
                    
                    if (tempArea > maxArea) maxArea = tempArea;
                }
            }
        }
        
        return maxArea;
    }
}
