import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ChessPanel extends JPanel {
    private Board chessBoard;
    public void setChessBoard(Board board){
        chessBoard = board;
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        boolean white = true;
        for (int y = 0; y < 8; y++) {
            if(y == 1|| y ==3|| y ==5 || y ==7){
                white = false;
            } else if (y==2 || y == 4|| y ==6){
                white = true;
            }
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
                if(chessBoard.Occupied(x,y ) != null) {
                    if (chessBoard.Occupied(x, y).getColor() == 1) { // if white
                        if (chessBoard.Occupied(x, y) instanceof Knight) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/wKnight.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Bishop) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/wBishop.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Rook) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/wRook.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Queen) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/wQueen.png")), x * 90, y * 90, this);
                                System.out.println("Queen: " + x + " " + y );
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Pawn) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/wPawn.png")), x * 90, y * 90, this);
                                System.out.println("Pawn: " + x + " " + y );
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof King) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/wKing.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        if (chessBoard.Occupied(x, y) instanceof Knight) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/bKnight.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Bishop) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/bBishop.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Rook) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/bRook.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Queen) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/bQueen.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof Pawn) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/bPawn.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (chessBoard.Occupied(x, y) instanceof King) {
                            try {
                                g.drawImage(ImageIO.read(new File("src/images/bKing.png")), x * 90, y * 90, this);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }

            }
        }
    }
}
