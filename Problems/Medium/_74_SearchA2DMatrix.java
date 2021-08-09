/** 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 */

package Problems.Medium;

public class _74_SearchA2DMatrix {
    /**
     * Efficiently searches (log(n) time complexity) a multidimensional array for a given target.
     * 
     * @param matrix Sorted, multidimensional array. 1 <= m, n <= 100
     * @param target -10^4 <= target <= 10^4
     * @return True if the array has at least 1 value equal to the target.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, (matrix.length * matrix[0].length - 1));
    }
    
    /**
     * Efficiently searches (log(n) time complexity) a multidimensional subarray for a given target.
     * 
     * @param matrix Sorted, multidimensional array. 1 <= m, n <= 100
     * @param target -10^4 <= target <= 10^4
     * @param minIndex Minimum subarray index to look at.
     * @param maxIndex Maximum subarray index to look at.
     * @return True if the subarray has at least 1 value equal to the target.
     */
    private boolean searchMatrix(int[][] matrix, int target, int minIndex, int maxIndex) {
        if (maxIndex < minIndex) {
            return false;
        } else if (maxIndex == minIndex) {
            return (matrix[maxIndex / matrix[0].length][maxIndex % matrix[0].length] == target) ? true : false;
        } else {
            int mid = minIndex + ((maxIndex - minIndex) / 2);
            
            if (matrix[mid / matrix[0].length][mid % matrix[0].length] == target) {
                return true;
            } else if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target) {
                return searchMatrix(matrix, target, mid + 1, maxIndex);
            } else {
                return searchMatrix(matrix, target, minIndex, mid - 1);
            }
        }
    }
}
