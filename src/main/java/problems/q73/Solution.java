package problems.q73;


import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    rowSet.add(row);
                    columnSet.add(column);
                }
            }
        }
        for (int row : rowSet) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for (int column : columnSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }
}