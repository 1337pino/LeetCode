/** 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 */

package Problems.Medium;

public class _36_ValidSudoku {
    /**
     * Determines if a board is a valid sudoku arrangement.  Does not confirm if the board is 
     * solved or solveable.
     * 
     * @param board Multidimensional array of characters representing a 9x9 sudoko board.  Valid 
     * characters are the digits 1-9 and '.' for empty boardspaces.
     * @return True if there are no duplicate digits in each row, column, and 3x3 sub-box.
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (isValidSudokuRow(board, i) == false) return false;
            if (isValidSudokuColumn(board, i) == false) return false;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValidSudokuBlock(board, (i * 3 + 1), (j * 3 + 1)) == false) return false;
            }
        }
        
        return true;
    }
    
    /**
     * Determines if a given 3x3 block within a 9x9 sudoku board is a valid sudoku arrangement. 
     * Does not confirm if the block is solved.
     * 
     * @param board Multidimensional array of characters representing a 9x9 sudoko board.  Valid 
     * characters are the digits 1-9 and '.' for empty boardspaces.
     * @param row Row number for the centermost tile in the 3x3 block.
     * @param col Column number for the centermost tile in the 3x3 block.
     * @return True if there are no duplicate values in the 3x3 block.
     */
    private boolean isValidSudokuBlock(char[][] board, int row, int col) {
        int[] nums = new int[10];
        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                char num = board[row + i][col + j];
                
                if (num != '.') {
                    nums[Character.getNumericValue(num)]++;
                }
            }
        }
        
        return hasNoDuplicates(nums);
    }
    
    /**
     * Determines if a given row within a 9x9 sudoku board is a valid sudoku arrangement. Does not 
     * confirm if the row is solved.
     * 
     * @param board Multidimensional array of characters representing a 9x9 sudoko board.  Valid 
     * characters are the digits 1-9 and '.' for empty boardspaces.
     * @param row Row number for validation.
     * @return True if there are no duplicate values in the row.
     */
    private boolean isValidSudokuRow(char[][] board, int row) {
        int[] nums = new int[10];
        
        for (int i = 0; i < 9; i++) {
            char num = board[row][i];
            
            if (num != '.') {
                nums[Character.getNumericValue(num)]++;
            }
        }
        
        return hasNoDuplicates(nums);
    }
    
    /**
     * Determines if a given column within a 9x9 sudoku board is a valid sudoku arrangement. Does 
     * not confirm if the column is solved.
     * 
     * @param board Multidimensional array of characters representing a 9x9 sudoko board.  Valid 
     * characters are the digits 1-9 and '.' for empty boardspaces.
     * @param col Column number for validation.
     * @return True if there are no duplicate values in the column.
     */
    private boolean isValidSudokuColumn(char[][] board, int col) {
        int[] nums = new int[10];
        
        for (int i = 0; i < 9; i++) {
            char num = board[i][col];
            
            if (num != '.') {
                nums[Character.getNumericValue(num)]++;
            }
        }
        
        return hasNoDuplicates(nums);
    }
    
    /**
     * Determines if a given integer counts from a sudoku row, column, or 3x3 block contain any 
     * counts greater than one.
     * 
     * @param numberCharacterCounts Integer array with counts from a row, column, or 3x3 block.
     * @return True if all of the counts are equal to or less than one (indicating no duplicates)
     */
    private boolean hasNoDuplicates(int[] numberCharacterCounts) {
        for (int i = 1; i < 10; i++) {
            if (numberCharacterCounts[i] > 1) return false;
        }
        
        return true;
    }
}
