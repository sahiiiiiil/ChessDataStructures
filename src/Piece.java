public class Piece {
    public static final int Black= 0;
    public static final int White = 1;
    public Board chessBoard;
    private int color;
    public boolean moved;
    private int xCord;
    private int yCord;

    public Piece(Board board, int color){
        this.chessBoard = board;
        this.color = color;
        moved = false;
        xCord=-1;
        yCord = -1;
    }
    public Piece(Board board, int color, int xLocation, int yLocation){
        this.chessBoard = board;
        this.color = color;
        this.moved = false;
        this.xCord = xLocation;
        this.yCord = yLocation;
        chessBoard.place(this, xLocation, yLocation);
    }
    public boolean canMoveTo(int xPosition, int yPosition){
        return canMove(xPosition, yPosition);
    }
    public boolean canMove(int xPosition, int yPosition){
        if (chessBoard.InBounds(xPosition, yPosition)){
            Piece location = chessBoard.Occupied(xPosition, yPosition);
            if (location == null){ return true;}
            else if (location.getColor() != this.color){
                return true;
            }
        }
        return false;
    }
    public void Move(int xLocation, int yLocation){
        chessBoard.remove(this);
        chessBoard.place(this, xLocation, yLocation);
        moved = true;
        xCord = xLocation;
        yCord = yLocation;
    }
    public boolean onBoard(){
        if (chessBoard.InBounds(xCord, yCord)) {
            return true;
        }
        return false;
    }
    public boolean straightMove(int moveX, int moveY){
        int currentX = this.getXCord();
        int currentY = this.getYCord();

        int smallerVal;
        int largerVal;

        // Fixed X Position
        if (currentX == moveX){
            if (currentY > moveY){
                smallerVal = moveY;
                largerVal = currentY;
            }
            else if (moveY> currentY){
                smallerVal = currentY;
                largerVal = moveY;
            }
            else{ return false;}

            // Loop to determine if any piece is between
            // target location and this piece.
            smallerVal++;
            for(; smallerVal < largerVal; smallerVal++){
                if (chessBoard.Occupied(currentX, smallerVal) != null){
                    return false;
                }
            }
            return true;
        }
        // Fixed Y Position
        if (currentY == moveY){
            if (currentX > moveX){
                smallerVal = moveX;
                largerVal = currentX;
            }
            else if (moveX > currentX){
                smallerVal = currentX;
                largerVal = moveX;
            }
            else{ return false;}

            //see if any piece inbetween
            smallerVal++;
            for(; smallerVal < largerVal; smallerVal++){
                if (chessBoard.Occupied(smallerVal, currentY) != null){
                    return false;
                }
            }
            return true;
        }

        return false;
    }
    public boolean diagonalMove(int moveX, int moveY){
        int xStart = 0;
        int yStart = 0;
        int xFinish = 1;
        //Check if movement is diagonal
        int xTotal = Math.abs(moveX - this.getXCord());
        int yTotal = Math.abs(moveY - this.getYCord());

        if (xTotal == yTotal){
            if (moveX < this.getXCord()){
                xStart = moveX;
                xFinish = this.getXCord();
            }
            else if (moveX > this.getXCord()){
                xStart = this.getXCord();
                xFinish = moveX;
            }
            else {
                return false;
            }
            if (moveY < this.getYCord()){
                yStart = moveY;
            }
            else if (moveY > this.getYCord()){
                yStart = this.getYCord();
            }
            else {
                return false;
            }
            xStart++;
            yStart++;
            //check if any piece gets in teh way
            for(;xStart < xFinish; xStart++, yStart++){
                if (chessBoard.Occupied(xStart, yStart) != null){
                    return false;
                }
            }
            return true;
        }

        return false;
    }


    public int getColor(){
        return color;
    }
    public int getXCord(){
        return xCord;
    }
    public int getYCord(){
        return yCord;
    }


}
