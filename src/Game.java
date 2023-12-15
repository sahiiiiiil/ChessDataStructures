import java.awt.*;
import java.util.*;
public class Game { //the way the board is layed out the 0 coordinate for y starts at the top to bottom and x goes right to left
    private int player;
    private LinkedList<Piece> blackPieces;
    private LinkedList<Piece> whitePieces;
    private King blackKing;
    private Board chessBoard;
    private King whiteKing;
    private Queen blackQueen;
    private Queen whiteQueen;
    private Rook blackRookL;
    private Rook blackRookR;
    private Rook whiteRookL;
    private Rook whiteRookR;
    private Bishop whiteBishopL;
    private Bishop whiteBishopR;
    private Bishop blackBishopL;
    private Bishop blackBishopR;
    private Knight blackKnightL;
    private Knight blackKnightR;
    private Knight whiteKnightL;
    private Knight whiteKnightR;
    private Pawn blackPawn1;
    private Pawn blackPawn2;
    private Pawn blackPawn3;
    private Pawn blackPawn4;
    private Pawn blackPawn5;
    private Pawn blackPawn6;
    private Pawn blackPawn7;
    private Pawn blackPawn8;
    private Pawn whitePawn1;
    private Pawn whitePawn2;
    private Pawn whitePawn3;
    private Pawn whitePawn4;
    private Pawn whitePawn5;
    private Pawn whitePawn6;
    private Pawn whitePawn7;
    private Pawn whitePawn8;
    Scanner userInput = new Scanner(System.in);
    public Game(){
        chessBoard = new Board(8,8);
        blackPieces = new LinkedList<Piece>();
        whitePieces = new LinkedList<Piece>();
        GamePaint game = new GamePaint();
        blackKing = new King(chessBoard, 0, 4, 7);

        whiteKing = new King(chessBoard, 1, 4, 0);

        blackQueen = new Queen(chessBoard, 0, 3, 7);

        whiteQueen = new Queen(chessBoard, 1, 3, 0);

        blackRookL = new Rook(chessBoard, 0, 0, 7);
        blackRookR = new Rook(chessBoard, 0, 7, 7);

        whiteRookL = new Rook(chessBoard, 1, 0, 0); //left side rook
        whiteRookR = new Rook(chessBoard, 1, 7, 0);// right side rook

        whiteBishopL = new Bishop(chessBoard, 1, 2, 0); //left side bishop
        whiteBishopR = new Bishop(chessBoard, 1, 5, 0);// right side bishop

        blackBishopL = new Bishop(chessBoard, 0, 2, 7); //left side bishop
        blackBishopR = new Bishop(chessBoard, 0, 5, 7);// right side bishop

        blackKnightL = new Knight(chessBoard, 0, 1, 7); //left side knight
        blackKnightR = new Knight(chessBoard, 0, 6, 7);// right side knight

        whiteKnightL = new Knight(chessBoard, 1, 1, 0); //left side knight
        whiteKnightR = new Knight(chessBoard, 1, 6, 0);// right side knight

        blackPawn1 = new Pawn(chessBoard, 0, 0, 6);
        blackPawn2 = new Pawn(chessBoard, 0, 1, 6);
        blackPawn3 = new Pawn(chessBoard, 0, 2, 6);
        blackPawn4 = new Pawn(chessBoard, 0, 3, 6);
        blackPawn5 = new Pawn(chessBoard, 0, 4, 6);
        blackPawn6 = new Pawn(chessBoard, 0, 5, 6);
        blackPawn7 = new Pawn(chessBoard, 0, 6, 6);
        blackPawn8 = new Pawn(chessBoard, 0, 7, 6);

        whitePawn1 = new Pawn(chessBoard, 1, 0, 1);
        whitePawn2 = new Pawn(chessBoard, 1, 1, 1);
        whitePawn3 = new Pawn(chessBoard, 1, 2, 1);
        whitePawn4 = new Pawn(chessBoard, 1, 3, 1);
        whitePawn5 = new Pawn(chessBoard, 1, 4, 1);
        whitePawn6 = new Pawn(chessBoard, 1, 5, 1);
        whitePawn7 = new Pawn(chessBoard, 1, 6, 1);
        whitePawn8 = new Pawn(chessBoard, 1, 7, 1);

        blackPieces.add(blackKing);
        blackPieces.add(blackQueen);
        whitePieces.add(whiteQueen);
        whitePieces.add(whiteKing);

        blackPieces.add(blackRookL);
        blackPieces.add(blackRookR);

        whitePieces.add(whiteRookR);
        whitePieces.add(whiteRookL);

        blackPieces.add(blackBishopR);
        blackPieces.add(blackBishopL);
        whitePieces.add(whiteBishopR);
        whitePieces.add(whiteBishopL);

        whitePieces.add(whiteKnightR);
        whitePieces.add(whiteKnightL);
        blackPieces.add(blackKnightR);
        blackPieces.add(blackKnightL);
    }
    public void Run(){

        System.out.println(staleMate(player));
        System.out.println(checkMate(player));
        player = 1;
        while (!gameFinished(player)){
            System.out.println(player + ": 1 is white 0 is black");

            System.out.print("Which piece to move? X-loc: ");
            int nextX = userInput.nextInt();
            System.out.print("Y-loc: ");
            int nextY = userInput.nextInt();

            Piece target = chessBoard.Occupied(nextX, nextY);
            if (target == null){
                System.out.println("That location is invalid try again. X-loc:");
            }
            else if (target.getColor() != player){
                System.out.println("That is not your piece");
            }
            else {
                System.out.print("Where to move this piece? x-loc: ");
                nextX = userInput.nextInt();
                System.out.print("Y-loc: ");
                nextY = userInput.nextInt();
                System.out.println(target);
                if (target.canMoveTo(nextX, nextY)){
                    System.out.println("nextY:" + nextY);
                    target.Move(nextX, nextY);
                    for(int i = 0; i<8;i++){
                        for(int j =0; j <8;j++){
                            if(chessBoard.Occupied(j, i) == null){
                                System.out.print("-");
                            }
                            if(chessBoard.Occupied(j, i) instanceof Pawn){
                                System.out.print("p");
                            }if(chessBoard.Occupied(j, i) instanceof Knight){
                                System.out.print("n");
                            }if(chessBoard.Occupied(j, i) instanceof Bishop){
                                System.out.print("b");
                            }if(chessBoard.Occupied(j, i) instanceof Queen){
                                System.out.print("q");
                            }if(chessBoard.Occupied(j, i) instanceof King){
                                System.out.print("k");
                            }if(chessBoard.Occupied(j, i) instanceof Rook){
                                System.out.print("r");
                            }
                        }
                        System.out.println();
                    }
                }
                else {
                    System.out.println("Cannot move there");
                }
                if(player == 1){
                    player = 0;
                } else{
                    player = 1;
                }
                System.out.println("new x:" + target.getXCord());
                System.out.println("new y: " + target.getYCord());
            }
        }

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
            attackers = blackPieces;
            king1 = blackKing;
        } else{
            attackers = whitePieces;
            king1 = whiteKing;
        }
        for (Piece attacker: attackers){
            System.out.println(attacker.getYCord());
            if (attacker.canMoveTo(king1.getXCord(), king1.getYCord())){
                System.out.println(attacker.getYCord());
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
        return false;
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
