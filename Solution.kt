
import kotlin.math.max

class Solution {

    private companion object {
        val moves = arrayOf(
            intArrayOf(-1, -1), intArrayOf(-1, 1), intArrayOf(1, -1), intArrayOf(1, 1),
            intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(1, 0)
        )
    }

    fun largestLocal(matrix: Array<IntArray>): Array<IntArray> {
        val rows = matrix.size
        val columns = matrix[0].size
        val largestLocalValuesIn3x3Matrix = Array<IntArray>(rows - 2) { IntArray(columns - 2) }

        for (row in 1..<rows - 1) {
            for (column in 1..<columns - 1) {
                largestLocalValuesIn3x3Matrix[row - 1][column - 1] = findLocalMaxIn3x3Matrix(matrix, row, column)
            }
        }
        return largestLocalValuesIn3x3Matrix
    }

    private fun findLocalMaxIn3x3Matrix(matrix: Array<IntArray>, row: Int, column: Int): Int {
        var localMax = matrix[row][column]
        for (move in moves) {
            val nextRow = row + move[0]
            val nextColumn = column + move[1]
            localMax = max(localMax, matrix[nextRow][nextColumn])
        }
        return localMax
    }
}
