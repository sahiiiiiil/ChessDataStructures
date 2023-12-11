public class Bishop extends Piece {
    public Bishop(Board board, int color, int xCord, int yCord){
        super(board, color, xCord, yCord);
    }
    private boolean bishopMoves(int xPosition, int yPosition){
        return diagonalMove(xPosition, yPosition);
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        if(canMove(xPosition,yPosition)){
            return bishopMoves(xPosition, yPosition);
        }
        return false;
    }
}
