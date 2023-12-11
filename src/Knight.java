public class Knight extends Piece{
    public Knight(Board board, int color, int xCord, int yCord){
        super(board, color, xCord, yCord);
    }
    private boolean knightMoves(int x, int y){
        if(Math.abs(getXCord() - x) == 2 && Math.abs(getYCord() - y) == 1){
            return true;
        } else if (Math.abs(getXCord() - x) == 1 && Math.abs(getYCord() - y) == 2){
            return true;

        }
        return false;
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        if(canMove(xPosition,yPosition)){
            return knightMoves(xPosition, yPosition);
        }
        return false;
    }
}
