/** 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */

package Problems.Hard;

public class _42_TrappingRainWater {
    /**
     * Calculates the total volume of water that would be a trapped given an array of elevations.
     * 
     * @param height Array of elevations. Between 0 and 30,000 in length, inclusively. Elevation 
     * values can between 0 and 100,000, inclusively.
     * @return Total volume of water that will be trapped.
     */
    public int trap(int[] height) {
        int waterVolume = 0;
        
        if (height.length > 2) { // Can't have any water with less than 3 positions
            int[][] leftRightMaxes = new int[height.length][2];
            int leftMax = height[0], rightMax = height[height.length - 1]; 

            /* For each position on the map, the water level is dependent on what the maximum 
            heights are to the left and right.  This walks through the height array from the left 
            and the right side to note this information for each position. */
            for (int i = 0, j = height.length - 1; i < height.length; i++, j--) {
                int leftHeight = height[i], rightHeight = height[j];

                leftMax = Math.max(leftMax, leftHeight);
                rightMax = Math.max(rightMax, rightHeight);

                leftRightMaxes[i][0] = leftMax;
                leftRightMaxes[j][1] = rightMax;
            }

            /* Once we have the left and right peaks for each elevation, we can calculate the 
            maximum water level for that point and therefore the amount of water at that point. */
            for (int i = 0; i < height.length; i++) {
                int maxWaterLevel = Math.min(leftRightMaxes[i][0], leftRightMaxes[i][1]);

                waterVolume += (maxWaterLevel - Math.min(maxWaterLevel, height[i]));
            }
        }

        return waterVolume;
    }
}
