/** 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 */

package Problems.Medium;

public class _48_RotateImage {
    /**
     * Rotates a square matrix of integers 90 degrees clockwise.
     * 
     * @param matrix Square matrix of numbers. The width is between 1 and 20, inclusively.
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length, halfN = n / 2;
        
        for (int i = 0; i < halfN; i++) {
            for (int k = i, j = 0; k < n - (i + 1); k++, j++) {
                int row = i, col = k, x = (n - (1 + 2 * i)) - j;
                
                int temp = matrix[row][col];
                
                matrix[row][col] = matrix[row + x][col - j];
                row += x;
                col -= j;
                
                matrix[row][col] = matrix[row + j][col + x];
                row += j;
                col += x;
                
                matrix[row][col] = matrix[row - x][col + j];
                row -= x;
                col += j;
                
                matrix[row][col] = temp;
            }
        }
    }
}