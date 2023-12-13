import java.awt.*;
import java.util.*;
public class Game {
    private int Player;
    private LinkedList<Piece> blackPieces;
    private LinkedList<Piece> whitePieces;
    private int currentPlayer;
    private King blackKing;
    private Board chessBoard;
    private King whiteKing;
    public Game(){
        chessBoard = new Board(8,8);
        currentPlayer = 1;
        blackPieces = new LinkedList<Piece>();
        whitePieces = new LinkedList<Piece>();
        blackKing = new King(chessBoard, 0, 7, 4);
        whiteKing = new King(chessBoard, 1, 0, 4);
        blackPieces.add(blackKing);
        whitePieces.add(whiteKing);
    }
    public boolean checkMate(int color){
        King king1;
        if(isCheck(color)){
            if (color == 0){
                king1 = blackKing;
            } else {
                king1 = whiteKing;
            }
            for(int x = 0; x<chessBoard.getXLen(); x++){
                for(int y = 0; y < chessBoard.getYLen(); y++){
                    if (king1.canMoveTo(x,y)){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean isCheck(int color){
        LinkedList<Piece> attackers;
        King king1;
        if (color == 0){
            attackers = whitePieces;
            king1 = blackKing;
        } else{
            attackers = blackPieces;
            king1 = whiteKing;
        }
        for (Piece attacker: attackers){
            if (attacker.canMoveTo(king1.getXCord(), king1.getYCord())){
                return true;
            }
        }
        return false;

    }
    public boolean hasMoves(int color){
        LinkedList<Piece> pieces;
        if(color == 0){
            pieces = blackPieces;
        } else{
            pieces = whitePieces;
        }
        for (Piece piece: pieces ){
            for(int x = 0; x<chessBoard.getXLen(); x++){
                for(int y = 0; y < chessBoard.getYLen(); y++){
                    if (piece.canMoveTo(x,y)){
                        return true;
                    }
                }
            }
        }
    }
    public boolean staleMate(int color){
        if (!(isCheck(color)) && !hasMoves(color)){
            return true;
        }
        return false;
    }
    public boolean gameFinished(int color){
        if (checkMate(color)){
            return true;
        } else if (staleMate(color)){
            return true;
        }
        return false;
    }



}
