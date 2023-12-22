import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class GamePaint extends JLabel {

    public ChessPanel chessPanel;

    public GamePaint(Board chessBoard){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 720, 720);
        frame.setUndecorated(true);
        chessPanel = new ChessPanel();
        chessPanel.setChessBoard(Main.chess.chessBoard);
        frame.add(chessPanel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GamePaint(new Board(8, 8)));
    }

}

