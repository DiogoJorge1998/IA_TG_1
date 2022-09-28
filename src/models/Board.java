package models;

import java.lang.Math;
import services.Ilayout;
import java.util.List;

public class Board implements Ilayout, Cloneable {
    private static int dim;
    private int board[][];

    //Construtor//
    public Board(String str) throws IllegalStateException {
        double size = str.length();

        if (Math.sqrt(size) % 1 == 0) { //Checks if it is possible to make a matrix from the input
            dim = (int)(Math.sqrt(size));
        } else {throw new IllegalStateException("Wrong size");};

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

    

    //FOR LATER
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
        
        return 0;
    }
}
