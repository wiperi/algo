package _50_Data_Structure;

/**
 * LDUR_Traverse_Technique
 */
public class LDUR_Traverse_Technique {

    static int row;
    static int col;

    public static void main(String[] args) {
        row = 100;
        col = 100;
        int[][] grid = new int[row][col];
        
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    if (validate(newRow, newCol)) {
                        grid[newRow][newCol] = 666;
                        // modify the neighbor here, in any way you want
                    }
                }
            }
        }
    }

    private static boolean validate(int r, int c) {
        if (r == 0 || c == 0 || r >= row || c >= col) return false;
        return true;
    }
}