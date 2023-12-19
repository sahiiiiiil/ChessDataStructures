import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class GamePaint extends JLabel {

//    private King blackKing;
//    private Board chessBoard;
//    private King whiteKing;
//    private Queen blackQueen;
//    private Queen whiteQueen;
//    private Rook blackRookL;
//    private Rook blackRookR;
//    private Rook whiteRookL;
//    private Rook whiteRookR;
//    private Bishop whiteBishopL;
//    private Bishop whiteBishopR;
//    private Bishop blackBishopL;
//    private Bishop blackBishopR;
//    private Knight blackKnightL;
//    private Knight blackKnightR;
//    private Knight whiteKnightL;
//    private Knight whiteKnightR;
//    private Pawn blackPawn1;
//    private Pawn blackPawn2;
//    private Pawn blackPawn3;
//    private Pawn blackPawn4;
//    private Pawn blackPawn5;
//    private Pawn blackPawn6;
//    private Pawn blackPawn7;
//    private Pawn blackPawn8;
//    private Pawn whitePawn1;
//    private Pawn whitePawn2;
//    private Pawn whitePawn3;
//    private Pawn whitePawn4;
//    private Pawn whitePawn5;
//    private Pawn whitePawn6;
//    private Pawn whitePawn7;
//    private Pawn whitePawn8;

    public GamePaint(Board chessBoard){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 720, 720);
        frame.setUndecorated(true);
        //Board chessBoard = new Board(8,8);
//        blackKing = new King(chessBoard, 0, 4, 7);
//
//        whiteKing = new King(chessBoard, 1, 4, 0);
//
//        blackQueen = new Queen(chessBoard, 0, 3, 7);
//
//        whiteQueen = new Queen(chessBoard, 1, 3, 0);
//
//        blackRookL = new Rook(chessBoard, 0, 0, 7);
//        blackRookR = new Rook(chessBoard, 0, 7, 7);
//
//        whiteRookL = new Rook(chessBoard, 1, 0, 0); //left side rook
//        whiteRookR = new Rook(chessBoard, 1, 7, 0);// right side rook
//
//        whiteBishopL = new Bishop(chessBoard, 1, 2, 0); //left side bishop
//        whiteBishopR = new Bishop(chessBoard, 1, 5, 0);// right side bishop
//
//        blackBishopL = new Bishop(chessBoard, 0, 2, 7); //left side bishop
//        blackBishopR = new Bishop(chessBoard, 0, 5, 7);// right side bishop
//
//        blackKnightL = new Knight(chessBoard, 0, 1, 7); //left side knight
//        blackKnightR = new Knight(chessBoard, 0, 6, 7);// right side knight
//
//        whiteKnightL = new Knight(chessBoard, 1, 1, 0); //left side knight
//        whiteKnightR = new Knight(chessBoard, 1, 6, 0);// right side knight
//
//        blackPawn1 = new Pawn(chessBoard, 0, 0, 6);
//        blackPawn2 = new Pawn(chessBoard, 0, 1, 6);
//        blackPawn3 = new Pawn(chessBoard, 0, 2, 6);
//        blackPawn4 = new Pawn(chessBoard, 0, 3, 6);
//        blackPawn5 = new Pawn(chessBoard, 0, 4, 6);
//        blackPawn6 = new Pawn(chessBoard, 0, 5, 6);
//        blackPawn7 = new Pawn(chessBoard, 0, 6, 6);
//        blackPawn8 = new Pawn(chessBoard, 0, 7, 6);
//
//        whitePawn1 = new Pawn(chessBoard, 1, 0, 1);
//        whitePawn2 = new Pawn(chessBoard, 1, 1, 1);
//        whitePawn3 = new Pawn(chessBoard, 1, 2, 1);
//        whitePawn4 = new Pawn(chessBoard, 1, 3, 1);
//        whitePawn5 = new Pawn(chessBoard, 1, 4, 1);
//        whitePawn6 = new Pawn(chessBoard, 1, 5, 1);
//        whitePawn7 = new Pawn(chessBoard, 1, 6, 1);
//        whitePawn8 = new Pawn(chessBoard, 1, 7, 1);




//        JPanel chessboardPanel = new JPanel() {
//            public void paint(Graphics g){
//                System.out.println("repaint");
//                boolean white = true;
//                for (int y = 0; y < 8; y++) {
//                    if(y == 1|| y ==3|| y ==5 || y ==7){
//                        white = false;
//                    } else if (y==2 || y == 4|| y ==6){
//                        white = true;
//                    }
//                    for (int x = 0; x < 8; x++) {
//
//                        if (white) {
//                            g.setColor(new Color(235, 235, 208));
//                        } else {
//                            g.setColor(new Color(119, 148, 85));
//                        }
//                        g.fillRect(x * 90, y * 90, 90, 90);
//                        white = !white;
//                    }
//
//
//
//                }
//
//                for (int y = 0; y < 8; y++) {
//                    for (int x = 0; x < 8; x++) {
//                        if(chessBoard.Occupied(x,y ) != null) {
//                            if (chessBoard.Occupied(x, y).getColor() == 1) { // if white
//                                if (chessBoard.Occupied(x, y) instanceof Knight) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/wKnight.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Bishop) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/wBishop.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Rook) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/wRook.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Queen) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/wQueen.png")), x * 90, y * 90, this);
//                                        System.out.println("Queen: " + x + " " + y );
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Pawn) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/wPawn.png")), x * 90, y * 90, this);
//                                        System.out.println("Pawn: " + x + " " + y );
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof King) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/wKing.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                            } else {
//                                if (chessBoard.Occupied(x, y) instanceof Knight) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/bKnight.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Bishop) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/bBishop.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Rook) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/bRook.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Queen) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/bQueen.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof Pawn) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/bPawn.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                                if (chessBoard.Occupied(x, y) instanceof King) {
//                                    try {
//                                        g.drawImage(ImageIO.read(new File("src/images/bKing.png")), x * 90, y * 90, this);
//                                    } catch (IOException e) {
//                                        throw new RuntimeException(e);
//                                    }
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//        };
        frame.add(new ChessPanel());
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GamePaint());
    }

}

