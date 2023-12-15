public class Pawn extends Piece {
    public Pawn(Board board, int color, int xCord, int yCord){
        super(board, color, xCord, yCord);
    }
    public boolean pawnMoves(int x, int y){
        int move1;
        int move2;
        Piece other = chessBoard.Occupied(x, y);
        if(getColor() == Black){ // 0 is black
            move1 = -1;
            move2 = -2;
        } else{ // 1 is white
            move1 = 1;
            move2 = 2;
        }
        if(y - this.getYCord() == move1){
            if(x == this.getXCord() && other == null){ //checks there's no other piece occupying the square and that the y cord of the move is the same as the current because pawns can't move diagonally
                return true;
            }
        }
        if(!moved){
            if (y - this.getYCord() == move2){ // because x checks the rows and pawns can only move up rows they can't switch columns
                if (x == this.getXCord() && other == null){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        if(canMove(xPosition,yPosition)){
            return pawnMoves(xPosition, yPosition);
        }
        return false;
    }
}
