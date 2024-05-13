
using System;

public class Solution
{
    private static readonly int[][] moves = {
        new int[]{-1, -1}, new int[]{-1, 1}, new int[]{1, -1}, new int[]{1, 1},
        new int[]{0, 1}, new int[]{0, -1}, new int[]{-1, 0}, new int[]{1, 0}};

    public int[][] LargestLocal(int[][] matrix)
    {
        int rows = matrix.Length;
        int columns = matrix[0].Length;
        int[][] largestLocalValuesIn3x3Matrix = new int[rows - 2][];

        for (int row = 1; row < rows - 1; ++row)
        {
            largestLocalValuesIn3x3Matrix[row - 1] = new int[columns - 2];

            for (int column = 1; column < columns - 1; ++column)
            {
                largestLocalValuesIn3x3Matrix[row - 1][column - 1] = FindLocalMaxIn3x3Matrix(matrix, row, column);
            }
        }
        return largestLocalValuesIn3x3Matrix;
    }

    private int FindLocalMaxIn3x3Matrix(int[][] matrix, int row, int column)
    {
        int localMax = matrix[row][column];
        foreach (int[] move in moves)
        {
            int nextRow = row + move[0];
            int nextColumn = column + move[1];
            localMax = Math.Max(localMax, matrix[nextRow][nextColumn]);
        }
        return localMax;
    }
}
