import java.util.*;
public class SS{
	public static void main(String[] args) {
		int[][] sudoku = {
			{7, 9, 6, 8, 5, 4, 3, 2, 1},
			{2, 4, 3, 1, 7, 6, 9, 8, 5},
			{8, 5, 1, 2, 3, 9, 4, 7, 6},
			{0, 0, 7, 0, 6, 5, 8, 4, 2},
			{0, 2, 5, 4, 1, 8, 7, 6, 3},
			{4, 0, 8, 0, 2, 3, 5, 1, 9},
			{6, 1, 4, 5, 9, 7, 2, 3, 8},
			{5, 8, 2, 3, 4, 1, 6, 9, 7},
			{3, 7, 9, 6, 8, 2, 1, 5, 4}
		}; solve(sudoku);
		String sudokuStr = "";
		for (int[] row : sudoku) {
			sudokuStr += Arrays.toString(row) + "\n";
		} System.out.println(sudokuStr);
	}

	public static void solve(int[][] sudoku){
		solve(sudoku, 0, 0);
	}

	public static boolean solve(int[][] sudoku, int r, int c) {
		if (c >= sudoku[r].length) {r+=1; c=0;} // wrap to next line
		if (r < sudoku.length) { // if still inside the board run
			if (sudoku[r][c] == 0) { // if empty
				for (int n = 1; n <= 9; n++) { // try every number
					sudoku[r][c] = n;
					if (validRow(sudoku, r, c) && validCol(sudoku, r, c) && validBox(sudoku, r, c)) {
						if (solve(sudoku, r, c+1)) {
							return true;
						}
					}
				} return false;
			} else {solve(sudoku, r, c+1);}
		} return true;
	}

	private static boolean validRow(int[][] sudoku, int r, int c) {
		for (int i = 0; i < sudoku[r].length; i++) {
			if (sudoku[r][i] == sudoku[r][c] && i != c) {
				return false;
			}
		} return true;
	}
	private static boolean validCol(int[][] sudoku, int r, int c) {
		for (int i = 0; i < sudoku.length; i++) {
			if (sudoku[i][c] == sudoku[r][c] && i != r) {
				return false;
			}
		} return true;
	}
	private static boolean validBox(int[][] sudoku, int r, int c) {
		//System.out.println("r = " + r + "; c = " + c);
		int boxR = r - (r%3); int boxC = c - (c%3);
		for (int i = boxR; i < boxR+3; i++) {
			for (int j = boxC; j < boxC+3; j++) {
				if (sudoku[i][j] == sudoku[r][c] && i != r && j != c) {
					return false;
				}
			}
		} return true;
	}

}
