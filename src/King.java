public class King extends Piece {
    public King(Board board, int color, int xCord, int yCord){
        super(board, color, xCord, yCord);
    }
    public boolean kingMoves(int x, int y){
        if(Math.abs(getXCord()-x) <= 1 && Math.abs(getYCord()-y) <= 1){ // checks all the 8 squares around the king
            return true;
        }
        return false;
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        if(canMove(xPosition,yPosition)){
            return kingMoves(xPosition, yPosition);
        }
        return false;
    }
}
