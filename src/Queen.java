public class Queen extends Piece {
    public Queen(Board board, int color, int xCord, int yCord){
        super(board, color, xCord, yCord);
    }
    public boolean queenMoves(int x, int y){
        if( straightMove(x, y) || diagonalMove(x,y)){
            return true;
        }
        return false;
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        if(canMove(xPosition,yPosition)){
            return queenMoves(xPosition, yPosition);
        }
        return false;
    }
}
