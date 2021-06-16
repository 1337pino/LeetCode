/** 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

package Problems.Medium;

public class _33_SearchInRotatedSortedArray {
    /**
     * Given a rotated array, returns the index of the target number.
     * 
     * @param nums Array of unique values that were sorted before being rotated. Has a length 
     * between 1 and 5000, inclusively. -10^4 <= nums[i] <= 10^4
     * @param target -10^4 <= target <= 10^4
     * @return Returns the index of the target number (0-indexed) or -1 if the target does not 
     * exist in the array.
     */
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    /**
     * Searches a given array between the provided bounds, inclusively.
     * @param nums Array of unique values that were sorted before being rotated. Has a length 
     * between 1 and 5000, inclusively. -10^4 <= nums[i] <= 10^4
     * @param target -10^4 <= target <= 10^4
     * @param lowerBound 0 <= lowerBound <= nums.length
     * @param upperBound 0 <= upperBound <= nums.length
     * @return  Returns the index of the target number (0-indexed) or -1 if the target does not 
     * exist in the array.
     */
    private int search(int[] nums, int target, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return (nums[lowerBound] == target) ? lowerBound : -1;
        }
        
        int middle = ((upperBound - lowerBound) / 2) + lowerBound;
        
        if (target == nums[lowerBound]) {
            return lowerBound;
        } else if (target == nums[middle]) {
            return middle;
        }
        
        if (nums[middle] > nums[lowerBound]) {
            if (target < nums[lowerBound] || target > nums[middle]) {
                return search(nums, target, middle + 1, upperBound);
            } else {
                return search(nums, target, lowerBound + 1, middle - 1);
            }
        } else {
            if (target < nums[lowerBound] && target > nums[middle]) {
                return search(nums, target, middle + 1, upperBound);
            } else {
                return search(nums, target, lowerBound + 1, middle - 1);
            }
        }
    }
}
