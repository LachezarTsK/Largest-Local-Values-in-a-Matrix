
public class Solution {

    private static final int[][] moves = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                                          {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int[][] largestLocal(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] largestLocalValuesIn3x3Matrix = new int[rows - 2][columns - 2];

        for (int row = 1; row < rows - 1; ++row) {
            for (int column = 1; column < columns - 1; ++column) {
                largestLocalValuesIn3x3Matrix[row - 1][column - 1] = findLocalMaxIn3x3Matrix(matrix, row, column);
            }
        }
        return largestLocalValuesIn3x3Matrix;
    }

    private int findLocalMaxIn3x3Matrix(int[][] matrix, int row, int column) {
        int localMax = matrix[row][column];
        for (int[] move : moves) {
            int nextRow = row + move[0];
            int nextColumn = column + move[1];
            localMax = Math.max(localMax, matrix[nextRow][nextColumn]);
        }
        return localMax;
    }
}
