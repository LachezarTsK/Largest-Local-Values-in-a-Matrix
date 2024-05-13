
package main

import (
	"fmt"
	"math"
)

var moves [8][2]int = [8][2]int{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}}

func largestLocal(matrix [][]int) [][]int {
	var rows = len(matrix)
	var columns = len(matrix[0])

	largestLocalValuesIn3x3Matrix := make([][]int, rows-2)
	for row := 0; row < rows-2; row++ {
		largestLocalValuesIn3x3Matrix[row] = make([]int, columns-2)
	}

	for row := 1; row < rows-1; row++ {
		for column := 1; column < columns-1; column++ {
			largestLocalValuesIn3x3Matrix[row-1][column-1] = findLocalMaxIn3x3Matrix(matrix, row, column)
		}
	}
	return largestLocalValuesIn3x3Matrix
}

func findLocalMaxIn3x3Matrix(matrix [][]int, row int, column int) int {
	var localMax = matrix[row][column]
	for _, move := range moves {
		var nextRow = row + move[0]
		var nextColumn = column + move[1]
		localMax = int(math.Max(float64(localMax), float64(matrix[nextRow][nextColumn])))
	}
	return localMax
}
