def find_next_empty(puzzle):
    for r in range(9):
        for c in range(9):
            if puzzle[r][c] == -1:
                return r, c

    return None, None


def is_valid(puzzle, guess, row, col):
    row_vals = puzzle[row]
    if guess in row_vals:
        return False

    col_vals = []
    for i in range(9):
        col_vals.append(puzzle[i][col])

    col_vals = [puzzle[i][col] for i in range(9)]
    if guess in col_vals:
        return False

    row_start = (row// 3) * 3
    col_start = (col // 3) * 3

    for r in range(row_start, row_start + 3):
        for c in range(col_start, col_start + 3):
            if puzzle[r][c] == guess:
                return False

    return True


def solve(puzzle):
    # puzzle is a lists of lists 2d

    # Step 1: Choose where to go
    row, col = find_next_empty(puzzle)

    # Step 1.2: Validation Checks
    if row is None:
        return True

    # Step 2
    for guess in range(1,10):
        # Steps 3
        if is_valid(puzzle, guess, row, col):
            # Step 3.1
            puzzle[row][col] = guess

            # Step 4
            if solve(puzzle):
                return True

            # Step 5: Backtrack
            puzzle[row][col] = -1

    # Step 6
    return False


if __name__ == '__main__':
    

    sudoku_board = [
        [4, -1, -1, -1, -1, -1, -1, -1, -1],
        [-1, -1, -1, 2, 1, 8, -1, 7, -1],
        [7, -1, -1, -1, 9, -1, -1, -1, 2],

        [-1, -1, 6, -1, 3, -1, 8, -1, 4],
        [1, -1, -1, -1, -1, -1, -1, 2, -1],
        [-1, -1, 5, -1, -1, 7, -1, -1, -1],

        [-1, 1, -1, -1, 6, -1, -1, -1, -1],
        [-1, 6, -1, -1, 8,  5, -1, -1, -1],
        [-1, -1, 9, -1, -1, -1, -1, -1, 1],
    ]

    print(solve(sudoku_board))
    print(sudoku_board)