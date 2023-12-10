public class Board {
    private Piece[][] chessBoard;
    public Board(int x, int y){
        chessBoard = new Piece[x][y];
    }
    public boolean InBounds(int xPosition, int yPosition){
        if (xPosition < getXLen() && xPosition >= 0 && yPosition < getYLen() && yPosition >= 0) { //checks coordinates of piece are inbounds
            return true;
        }
        return false;
    }
    public Piece Occupied(int x, int y){ //checks theres a piece at a certain square
        if (InBounds(x, y)){
            return chessBoard[x][y];
        } else {
            return null;
        }
    }
    public void remove(Piece piece){ //removes piece from square on chessboard array
        int oldX = Piece.getXCord(); 
        int oldY = Piece.getYCord();
        if(InBounds(oldX,oldY)){
            chessBoard[oldX][oldY] = null;
        }

    }
    public void place(Piece chessPiece, int x, int y){
        if (InBounds(x,y)) {
            chessBoard[x][y] = chessPiece;
        }
    }

    public int getXLen(){
        return chessBoard[0].length;
    }

    public int getYLen(){
        return chessBoard.length;
    }

}
