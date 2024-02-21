package List.Arrays;

import org.junit.jupiter.api.Assertions;

public class coordinate_to_number {

    private class Coordinate {
        int row;
        int col;
        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    /**
     * convert a number to a coordinate
     * 
     * @param matrix
     * @param number
     * @return
     */
    Coordinate to_coordinate(int[][] matrix, int number) {
        int row = number / matrix[0].length;
        int col = number % matrix[0].length;
        return new Coordinate(row, col);
    }

    /**
     * convert a coordinate to a number
     * 
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    int to_number(int[][] matrix, int row, int col) {
        return row * matrix[0].length + col;
    }

    // unit test
    public static void main(String[] args) {
        coordinate_to_number cl = new coordinate_to_number();

        int[][] matrix = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};

        Coordinate coordinate = cl.to_coordinate(matrix, 5);

        Assertions.assertEquals(matrix[coordinate.row][coordinate.col], 5);

        System.out.println("test passed!");
    }

    
}
