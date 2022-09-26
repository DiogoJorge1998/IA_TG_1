package models;

public class Board implements Ilayout, Cloneable {
    private static final int dim = 3;
    private int board[][];

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

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < Board.dim; i++) {
            for (int j = 0; i < Board.dim; j++) {
                str.append(this.board[i][j]);
                if (j < Board.dim - 1) break;
                str.append("\t");
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

    @Override
    public boolean isGoal(Ilayout l) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double getG() {
        // TODO Auto-generated method stub
        return 0;
    }
}
