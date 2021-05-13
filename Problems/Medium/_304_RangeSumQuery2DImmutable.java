/** 304. Range Sum Query 2D - Immutable
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */

package Problems.Medium;

public class _304_RangeSumQuery2DImmutable {
    private int[][] numMatrix;
    
    public _304_RangeSumQuery2DImmutable(int[][] matrix) {
        numMatrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += numMatrix[i][j];
            }
        }
        
        return sum;
    }
}
