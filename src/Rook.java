public class Rook extends Piece {
    public Rook(Board board, int color, int xCord, int yCord){
        super(board, color, xCord, yCord);
    }
    private boolean rookMoves(int xPosition, int yPosition){
        return straightMove(xPosition, yPosition);
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        if(canMove(xPosition,yPosition)){
            return rookMoves(xPosition, yPosition);
        }
        return false;
    }
}
