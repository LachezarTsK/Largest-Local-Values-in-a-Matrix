
/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var largestLocal = function (matrix) {
    this.moves = [[-1, -1], [-1, 1], [1, -1], [1, 1],
                  [0, 1], [0, -1], [-1, 0], [1, 0]];
    const rows = matrix.length;
    const columns = matrix[0].length;
    const largestLocalValuesIn3x3Matrix = Array.from(new Array(rows - 2), () => new Array(columns - 2).fill(0));

    for (let row = 1; row < rows - 1; ++row) {
        for (let column = 1; column < columns - 1; ++column) {
            largestLocalValuesIn3x3Matrix[row - 1][column - 1] = findLocalMaxIn3x3Matrix(matrix, row, column);
        }
    }
    return largestLocalValuesIn3x3Matrix;
};

/**
 * @param {number[][]} matrix
 * @param {number} row
 * @param {number} column 
 * @return {number}
 */
function findLocalMaxIn3x3Matrix(matrix, row, column) {
    let localMax = matrix[row][column];
    for (let move of this.moves) {
        let nextRow = row + move[0];
        let nextColumn = column + move[1];
        localMax = Math.max(localMax, matrix[nextRow][nextColumn]);
    }
    return localMax;
}
