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
        if (chessBoard.Occupied(xLocation, yLocation) == this){
            chessBoard.remove(this);
        }
        chessBoard.place(this, xLocation, yLocation);
        moved = true;
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
        boolean flag = true;

        if (currentX == moveX){ // if current X is the same as moveX that means that you would check for movement along the row
            if (moveY >= currentY){ // if moving right
                int frontY = currentY;
                while (moveY > frontY && chessBoard.InBounds(moveX, frontY)){
                    if (!canMove(currentX, frontY) && chessBoard.InBounds(moveX, frontY)){
                        return false;
                    }
                    frontY++;
                }

            }
            if (moveY <= currentY){ // if moving left
                int frontY = currentY;
                while (frontY >= moveY){
                    if (!canMove(currentX, frontY)){
                        return false;
                    }
                    frontY--;
                }

            }
        }
        if (currentY == moveY){ //check for movement along the column
            int behindX = currentX;
            if (moveX >= currentX && chessBoard.InBounds(behindX, currentY)){ //upward
                while (moveX > behindX){
                    if (!canMove(behindX, currentY)){
                        return false;
                    }
                    behindX++;
                }

            }
            if (moveX < currentX){ //downward
                while (moveX <= behindX && chessBoard.InBounds(behindX, currentY)){
                    if (!canMove(behindX, currentY)){
                        return false;
                    }
                    behindX--;
                }

            }
        }
        return flag;
    }
    public boolean diagonalMove(int moveX, int moveY){
        int currentX = this.getXCord();
        int currentY = this.getYCord();
        boolean flag = true;

        //Check if movement is diagonal
        int xTotal = Math.abs(moveX - this.getXCord());
        int yTotal = Math.abs(moveY - this.getYCord());
        if(xTotal != yTotal){
            return false;
        } // because of the way double arrays are indexed the x value is actually the y value and y the x value

        if (moveX > currentX && moveY > currentY){ // top right diagonals
            int rightX = currentX;
            int topY = currentY;
            while(moveX >= rightX && moveY >= topY){
                if (!canMove(rightX, topY)){
                    return false;
                }
                topY++;
                rightX++;
            }
        }
        if (moveX < currentX && moveY < currentY){ // bottom left diagonals
            int leftX = currentX;
            int bottomY = currentY;
            while(moveX <= leftX && moveY <= bottomY && chessBoard.InBounds(moveX, bottomY)){
                if (!canMove(leftX, bottomY)){
                    return false;
                }
                bottomY--;
                leftX--;
            }
        }
        if (moveX < currentX && moveY > currentY){ // bottom left diagonals
            int leftX = currentX;
            int topY = currentY;
            while(moveX <= leftX && moveY >= topY && chessBoard.InBounds(moveX, topY)){
                if (!canMove(leftX, topY)){
                    return false;
                }
                topY++;
                leftX--;
            }
        }
        if (moveX > currentX && moveY < currentY){ // top right diagonals
            int rightX = currentX;
            int bottomY = currentY;
            while(moveX >= rightX && moveY <= bottomY && chessBoard.InBounds(rightX, bottomY)){
                if (!canMove(rightX, bottomY)){
                    return false;
                }
                bottomY--;
                rightX++;
            }
        }
        return flag;
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
