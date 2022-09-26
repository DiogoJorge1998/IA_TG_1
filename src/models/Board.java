package models;

class Board implements Ilayout, Cloneable {
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
        String str = " ";
        for(int i = 0; i < dim; i++)
            for(int j = 0; i < dim; j++)
            {
                str = (this.board[i][j]+"\t"+this.board[i][j+1]);
                if(i == dim && j == dim) str = (this.board[i][j]+"\n");
            }
        return str;
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
        
        return 0;
    }
}
