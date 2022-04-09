public class PickyPuupuu {
    public static void main(String[] args) {
        int[][] grid = {{7, 7, 7}, {7, 7,7}, {7, 7, 7}}; 
        System.out.println(magicSquare(grid));
    }

    public static boolean magicSquare(int[][] grid) {
        for (int r = 0; r <= grid.length-3; r++) {
            for (int c = 0; c <= grid[r].length-3; c++) {
                if (checkSquare(grid, r, c)) {return true;}
            }
        } return false;
    }

    public static boolean checkSquare(int[][] grid, int r, int c) {
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        
	for (int i = 0; i < 3; i++) { // check rows
            if (grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != sum) {return false;} 
        }
        
        for (int i = 0; i < 3; i++) { // check columns
            if (grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != sum) {return false;} 
        }
        
        // check diagonals
        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != sum) {return false;} 
        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum) {return false;} 
        
        return true;
    }
}
