package models;

import services.BestFirst;
import services.BestFirst.State;
import services.Ilayout;

import java.util.List;

public class Board implements Ilayout, Cloneable {
    private static final int dim = 3;
    private int[][] board;

    public Board() {
        board = new int[dim][dim];
    }

    //Construtor//
    public Board(String str) throws IllegalStateException {
        if (str.length() != dim * dim)
            throw new IllegalStateException("Invalid arg in Board constructor");
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
        for(int i = 0; i < Board.dim; i++) {
            for (int j = 0; j < Board.dim; j++) {
                if (board[i][j] == 0) str.append(" ");
                else str.append(this.board[i][j]);
            }
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public List<Ilayout> children() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Check is passed stated is the goal state.
     * This function is called only from BestFirst.solve(Ilayout l, Ilayout goal) where l and goal are board objects.
     * NAO SEI SE ESTA CERTO MAS FODA SE
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
