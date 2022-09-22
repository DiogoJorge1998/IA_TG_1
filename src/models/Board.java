package models;

public class Board {

    private final int n; // number of rows/cols 
    private final int[][] board;

    public Board(String boardValues) {
        this.n = (int) Math.sqrt(boardValues.length()); // Assuming given input will be dividable by three.
        this.board = generateMatrix(boardValues);
    }

    public int[][] generateMatrix(String board) {
        int[][] result = new int[n][n];
        int i = 0;
        while (i <= n) {
            for (int j = 0; j < n; j++)
                result[i][j] = board.charAt(i + j);
            i += n;
        }
        return result;
    }


}
