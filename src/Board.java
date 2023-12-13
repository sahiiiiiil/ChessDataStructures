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
        }

    }
    public void place(Piece chessPiece, int x, int y){
        if (InBounds(x,y)) {
            chessBoard[x][y] = chessPiece;
        }
    }
    public void paint(Graphics g) throws IOException {
        boolean white = true;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (white) {
                    g.setColor(new Color(235, 235, 208));
                } else {
                    g.setColor(new Color(119, 148, 85));
                }
                g.fillRect(x * 90, y * 90, 90, 90);
                white = !white;
            }


        }
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if(Occupied(x,y).getColor() == 1) { // if white
                    if (chessBoard[x][y] instanceof Knight) {
                        g.drawImage(ImageIO.read(new File("src/wKnight.png")), x * 90, y*90, this);
                    }
                    if (chessBoard[x][y] instanceof Bishop) {
                        g.drawImage(ImageIO.read(new File("src/wBishop.png")), x * 90, y*90, this);
                    }
                    if (chessBoard[x][y] instanceof Rook) {
                        g.drawImage(ImageIO.read(new File("src/wRook.png")), x * 90, y*90, this);
                    }
                    if (chessBoard[x][y] instanceof Queen) {
                        g.drawImage(ImageIO.read(new File("src/wQueen.png")), x * 90, 90, this);
                    }
                    if (chessBoard[x][y] instanceof Pawn) {
                        g.drawImage(ImageIO.read(new File("src/wPawn.png")), x * 90, 90, this);
                    }
                    if (chessBoard[x][y] instanceof King) {
                        g.drawImage(ImageIO.read(new File("src/wKing.png")), x * 90, 90, this);
                    }
                }

            }
        }
    }


    public int getXLen(){
        return chessBoard[0].length;
    }

    public int getYLen(){
        return chessBoard.length;
    }

}
