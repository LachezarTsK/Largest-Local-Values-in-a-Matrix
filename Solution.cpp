
#include <span>
#include <array>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static constexpr array<array<int, 2>, 8> moves{ { {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
                                                    {0, 1}, {0, -1}, {-1, 0}, {1, 0} } };

public:
    vector<vector<int>> largestLocal(const vector<vector<int>>& matrix) const {
        size_t rows = matrix.size();
        size_t columns = matrix[0].size();
        vector<vector<int>> largestLocalValuesIn3x3Matrix(rows - 2, vector<int>(columns - 2));

        for (size_t row = 1; row < rows - 1; ++row) {
            for (size_t column = 1; column < columns - 1; ++column) {
                largestLocalValuesIn3x3Matrix[row - 1][column - 1] = findLocalMaxIn3x3Matrix(matrix, row, column);
            }
        }
        return largestLocalValuesIn3x3Matrix;
    }

private:
    int findLocalMaxIn3x3Matrix(span<const vector<int>> matrix, size_t row, size_t column) const {
        int localMax = matrix[row][column];
        for (const auto& move : moves) {
            size_t nextRow = row + move[0];
            size_t nextColumn = column + move[1];
            localMax = max(localMax, matrix[nextRow][nextColumn]);
        }
        return localMax;
    }
};
