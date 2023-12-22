import java.awt.*;

public class Main {
    public static Game chess;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        chess = new Game();
        chess.initializeGamePaint();
        chess.Run();
        System.out.println(1);
    }
}