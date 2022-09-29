package models;

import services.Ilayout;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Board implements Ilayout, Cloneable {
    private static final int dim = 3;
    private int[][] board;

    public Board() {
        board = new int[dim][dim];
    }

    //Construtor//
    public Board(String str) throws IllegalStateException {
        if (str.length() != dim * dim) throw new IllegalStateException("Invalid arg in Board constructor");
        board = new int[dim][dim];
        int si = 0;
        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++)
                board[i][j] = Character.getNumericValue(str.charAt(si++));
    }

    public int[][] getBoard() {
        return board;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Board.dim; i++) {
            for (int j = 0; j < Board.dim; j++) {
                if (board[i][j] == 0) str.append(" ");
                else str.append(this.board[i][j]);
            }
            str.append(System.lineSeparator());
            //str.append("\n");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board1 = (Board) o;
        return Arrays.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> finalList = new ArrayList<Ilayout>();// init list to return
        String original = this.toString();
        original = original.replace(" ","0");
        original = original.replaceAll("(\\r|\\n)", "");
        int spaceIndex = (int)original.indexOf('0');

        if (spaceIndex + 3 <= 9 && spaceIndex + 3 >= 0) { //down swap

            char[] charOriginal = original.toCharArray();
            charOriginal[spaceIndex] = charOriginal[spaceIndex+3];
            charOriginal[spaceIndex+3] = '0';
            String newChildString = String.valueOf(charOriginal);
            Board newChild = new Board(newChildString);
            finalList.add(newChild);
        }
        if (spaceIndex - 3 <= 9 && spaceIndex - 3 >= 0) { //up swap

            char[] charOriginal = original.toCharArray();
            charOriginal[spaceIndex] = charOriginal[spaceIndex-3];
            charOriginal[spaceIndex-3] = '0';
            String newChildString = String.valueOf(charOriginal);
            Board newChild = new Board(newChildString);
            finalList.add(newChild);
        }
        if (spaceIndex != 2 && spaceIndex != 5 && spaceIndex != 8) { //right swap

            char[] charOriginal = original.toCharArray();
            charOriginal[spaceIndex] = charOriginal[spaceIndex+1];
            charOriginal[spaceIndex+1] = '0';
            String newChildString = String.valueOf(charOriginal);
            Board newChild = new Board(newChildString);
            finalList.add(newChild);
        }
        if (spaceIndex != 0 && spaceIndex != 3 && spaceIndex != 6) { //left swap

            char[] charOriginal = original.toCharArray();
            charOriginal[spaceIndex] = charOriginal[spaceIndex-1];
            charOriginal[spaceIndex-1] = '0';
            String newChildString = String.valueOf(charOriginal);
            Board newChild = new Board(newChildString);
            finalList.add(newChild);
        }

        return finalList;
    }

    /**
     * Check is passed stated is the goal state.
     * This function is called only from BestFirst.solve(Ilayout l, Ilayout goal) where l and goal are board objects.
     * @param l board object
     * @return Boolean represeting if goal as been reached.
     */
    @Override
    public boolean isGoal(Ilayout l) {
        // Type casting to board object
        Board o = (Board) l;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (this.board[i][j] != o.board[i][j]) return false;
            }
        }
        return true;
    }


    @Override
    public double getG() {
        return 1;
    }
}
