# Optimal way to implement NQueens problem using recursion
from typing import List
class Solution:
    def solve(self, col, board, ans, leftrow, upperDiagonal, lowerDiagonal, n):
        if col == n:
            ans.append(board[:])
            return

        for row in range(n):
            if leftrow[row] == 0 and lowerDiagonal[row + col] == 0 and upperDiagonal[n - 1 + col - row] == 0:
                board[row] = board[row][:col] + 'Q' + board[row][col + 1:]
                leftrow[row] = 1
                lowerDiagonal[row + col] = 1
                upperDiagonal[n - 1 + col - row] = 1
                self.solve(col + 1, board, ans, leftrow, upperDiagonal, lowerDiagonal, n)
                board[row] = board[row][:col] + '.' + board[row][col + 1:]
                leftrow[row] = 0
                lowerDiagonal[row + col] = 0
                upperDiagonal[n - 1 + col - row] = 0

    def solveNQueens(self, n: int) -> List[List[str]]:
        ans = []
        board = ['.' * n for _ in range(n)]
        leftrow = [0] * n
        upperDiagonal = [0] * (2 * n - 1)
        lowerDiagonal = [0] * (2 * n - 1)
        self.solve(0, board, ans, leftrow, upperDiagonal, lowerDiagonal, n)
        return ans

if __name__ == "__main__":
    n = int(input("Enter the number of queens: "))
    solution = Solution()
    result = solution.solveNQueens(n)
    print("Solutions for N-Queens:")
    for solution in result:
        for row in solution:
            print(row)
        print()
