# Valid Sudoku
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        tableN = 9

        # valid rows & cols
        for i in range(tableN):
            row_set = set()
            col_set = set()
            for j in range(tableN):
                r = board[i][j]
                c = board[j][i]

                if r in row_set or c in col_set:
                    return False
                else:
                    if r != ".":
                     row_set.add(r)
                    if c != ".":
                     col_set.add(c)

        start_r, start_c = 0, 0

        for n in range(tableN):

            s = set()

            for i in range(start_r, start_r+3):
                for j in range(start_c, start_c+3):
                    el = board[i][j]
                    if el in s:
                        return False
                    else:
                        if el != ".":
                         s.add(el)

            start_c += 3
            start_r += int(start_c/tableN) * 3
            start_c %= tableN

        return True

