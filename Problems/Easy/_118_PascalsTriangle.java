/** 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */

package Problems.Easy;

import java.util.*;

public class _118_PascalsTriangle {
    /**
     * Generates a given number of rows for Pascal's triangle
     * @param numRows Number of rows to generate.
     * @return The rows as a list of lists.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalRows = new ArrayList<List<Integer>>();
        
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        pascalRows.add(firstRow);
        
        if (numRows >= 2) {
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<Integer>();
                List<Integer> previousRow = pascalRows.get(pascalRows.size() - 1);
                
                row.add(1);
                
                for (int j = 1; j < i; j++) {
                    row.add(previousRow.get(j) + previousRow.get(j - 1));
                }
                    
                row.add(1);

                pascalRows.add(row);
            }
        }
        
        return pascalRows;
    }
}
