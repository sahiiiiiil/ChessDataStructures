import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel {
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
        int oldX = piece.getXCord();
        int oldY = piece.getYCord();


        if(InBounds(oldX,oldY)){
            chessBoard[oldX][oldY] = null;
            piece.setXCord(-1);
        }

    }
    public void place(Piece chessPiece, int x, int y){
        if (InBounds(x,y)) {
            chessBoard[x][y] = chessPiece;
        }
    }
    public void placeMove(Piece chessPiece, int x, int y) {
        if (InBounds(x,y)) {
            chessBoard[x][y] = chessPiece;
            Main.chess.game.chessPanel.repaint();
        }
    }
    public double evaluate(){ // heuristic based evaluation method, evaluates which person on the board has more points/ pieces/ better pieces
        double eval = 0;
        for(int i = 0; i <chessBoard.length;i++){
            for(int j = 0; j < chessBoard[0].length; j++){
               if (chessBoard[j][i] instanceof Pawn){
                   if (Occupied(j, i).getColor() == 0){
                       if(3<=j&&j<=5 && (i ==3|| i==4)){
                           eval -= 1.2; // center pawn is stronger
                       } else {
                           eval--;
                       }
                   } else{
                       if(3<=j&&j<=5 && (i ==3|| i==4)){
                           eval += 1.2; // center pawn is stronger
                       } else {
                           eval++;
                       }
                   }
               }
               if (chessBoard[j][i] instanceof Knight){
                    if (Occupied(j, i).getColor() == 0){
                        eval-= 3;
                    } else{
                        eval+= 3;
                    }
               }
               if (chessBoard[j][i] instanceof Bishop){
                    if (Occupied(j, i).getColor() == 0){
                        eval-= 3.1; //bishop slightly better than knight
                    } else{
                        eval+=3.1;
                    }
               }
                if (chessBoard[j][i] instanceof Rook){
                    if (Occupied(j, i).getColor() == 0){
                        eval-= 5;
                    } else{
                        eval+= 5;
                    }
                }
                if (chessBoard[j][i] instanceof Queen){
                    if (Occupied(j, i).getColor() == 0){
                        eval-= 9;
                    } else{
                        eval+= 9;
                    }
                }
                if (chessBoard[j][i] instanceof King){
                    if (Occupied(j, i).getColor() == 0){
                        eval-= 200;
                    } else{
                        eval+= 200;
                    }
                }
            }
        }
        return eval;
    }





    public int getXLen(){
        return chessBoard[0].length;
    }

    public int getYLen(){
        return chessBoard.length;
    }

}
