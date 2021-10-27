package sol;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Board {
    ArrayList<ArrayList<IPiece>> gameState;
    boolean whiteMove;

    public Board(ArrayList<ArrayList<IPiece>> state){
        this.gameState = state;
    }

    public ArrayList<IPiece> initBackRow(Boolean white, int row){
        ArrayList<IPiece> rows = new ArrayList<IPiece>(8);
        Collections.addAll(rows, new Rook(white, new Point(0, row)), new Knight(white, new Point(1, row)),
                new Bishop(white, new Point(2, row)), new Queen(white, new Point(3, row)),
                new King(white, new Point(4, row)), new Bishop(white, new Point(5, row)),
                new Knight(white, new Point(6, row)), new Rook(white, new Point(7, row)));
        return rows;
    }

    public ArrayList<IPiece> initPawn(Boolean white, int row){
        ArrayList<IPiece> rows = new ArrayList<IPiece>(8);
        Collections.addAll(rows, new Pawn(white, new Point(0, row)), new Pawn(white, new Point(1, row)),
                new Pawn(white, new Point(2, row)), new Pawn(white, new Point(3, row)),
                new Pawn(white, new Point(4, row)), new Pawn(white, new Point(5, row)),
                new Pawn(white, new Point(6, row)), new Pawn(white, new Point(7, row)));
        return rows;
    }

    public ArrayList<IPiece> initEmpty(int row){
        ArrayList<IPiece> rows = new ArrayList<IPiece>(8);
        Collections.addAll(rows, new EmptySquare(new Point(0, row)), new EmptySquare(new Point(1, row)),
                new EmptySquare(new Point(2, row)), new EmptySquare(new Point(3, row)),
                new EmptySquare(new Point(4, row)), new EmptySquare(new Point(5, row)),
                new EmptySquare(new Point(6, row)), new EmptySquare(new Point(7, row)));
        return rows;
    }

    public void initBoard(){
        this.gameState.add(initBackRow(true, 0));
        this.gameState.add(initPawn(true, 1));
        this.gameState.add(initEmpty(2));
        this.gameState.add(initEmpty(3));
        this.gameState.add(initEmpty(4));
        this.gameState.add(initEmpty(5));
        this.gameState.add(initPawn(false, 6));
        this.gameState.add(initBackRow(false, 7));
    }

    public static IPiece userSelect(Scanner console, Board b){
        String[] validLet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        List<String> letList = new ArrayList<>(Arrays.asList(validLet));
        String[] validNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        List<String> numList = new ArrayList<>(Arrays.asList(validNum));

        System.out.println("Which piece would you like to move?");
        String p = console.next();
        String[] toMove = p.split("");

        if (toMove.length != 2 || !letList.contains(toMove[0]) || !numList.contains(toMove[1])){
            System.out.println("Please give a piece's position in chess notation");
            userSelect(console, b);
        }
        Point coordToMove = new Point(letList.indexOf(toMove[0]), numList.indexOf(toMove[1]));
        if (b.gameState.get(coordToMove.y).get(coordToMove.x) instanceof EmptySquare) {
            System.out.println("Please select a piece on the board");
            userSelect(console, b);
        }
        return b.gameState.get(coordToMove.y).get(coordToMove.x);
    }

    public static void userMovePiece(Scanner console){

    }

    public void userMove(Scanner console){
        String[] validLet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        List<String> letList = new ArrayList<>(Arrays.asList(validLet));
        String[] validNum = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        List<String> numList = new ArrayList<>(Arrays.asList(validNum));
        System.out.println("Which piece would you like to move?");
        String p = console.next();
        String[] toMove = p.split("");
        if (toMove.length != 2 || !letList.contains(toMove[0]) || !numList.contains(toMove[1])){
            System.out.println("Please give a piece's position in chess notation");
            userMove(console);
        }
        Point coordToMove = new Point(letList.indexOf(toMove[0]), numList.indexOf(toMove[1]));
        if (this.gameState.get(coordToMove.y).get(coordToMove.x) instanceof EmptySquare) {
            System.out.println("Please select a piece on the board");
            userMove(console);
        }
        IPiece piece = this.gameState.get(coordToMove.y).get(coordToMove.x);
        System.out.println("Where would you like to move?");
        String loc = console.next();
        String[] moveTo = loc.split("");
        if (moveTo.length != 2 || !letList.contains(moveTo[0]) || !numList.contains(moveTo[1])){
            System.out.println("That is not a legal move");
            userMove(console);
        }
        Point coordMoveTo = new Point(letList.indexOf(moveTo[0]), numList.indexOf(moveTo[1]));
        if (!piece.isLegal(coordMoveTo)){
            System.out.println("That is not a legal move");
            userMove(console);
        }
        this.gameState.get(coordToMove.y).get(coordToMove.x).move(coordMoveTo);
        IPiece cap = this.gameState.get(piece.pos().y).get(piece.pos().x);
        cap.captured();
        this.gameState.get(coordToMove.y).set(coordToMove.x, new EmptySquare(coordToMove));
        this.gameState.get(piece.pos().y).set(piece.pos().x, piece);
        updatePosition();
        printBoard();
    }

    public IPiece getPiece(Point pos){
        return this.gameState.get(pos.y).get(pos.x);
    }

    public void capture(IPiece p1, IPiece p2){
        if (p1.canCapture(p2)){

        }
    }


    public void updatePosition(){
        for (ArrayList<IPiece> iPieces : gameState) {
            for (IPiece p : iPieces) {
                p.updateLegalMoves(this);
            }
        }
    }

    public void printBoard() {
        int i = 8;
        while (i > 0) {
            System.out.print(i + " |");
            for (IPiece p : gameState.get(i-1)) {
                if (p instanceof Pawn) {
                    if (((Pawn) p).isWhite) {
                        System.out.print(" P ");
                    } else {
                        System.out.print("`P`");
                    }
                } else if (p instanceof Knight) {
                    if (((Knight) p).isWhite) {
                        System.out.print(" N ");
                    } else {
                        System.out.print("`N`");
                    }
                } else if (p instanceof Bishop) {
                    if (((Bishop) p).isWhite) {
                        System.out.print(" B ");
                    } else {
                        System.out.print("`N`");
                    }
                } else if (p instanceof Rook) {
                    if (((Rook) p).isWhite) {
                        System.out.print(" R ");
                    } else {
                        System.out.print("`R`");
                    }
                } else if (p instanceof Queen) {
                    if (((Queen) p).isWhite) {
                        System.out.print(" Q ");
                    } else {
                        System.out.print("`Q`");
                    }
                } else if (p instanceof King) {
                    if (((King) p).isWhite) {
                        System.out.print(" K ");
                    } else {
                        System.out.print("`K`");
                    }
                } else if (p instanceof EmptySquare) {
                    System.out.print(" . ");
                }
            }
            System.out.print("\n");
            i--;
        }
        System.out.println("- + -  -  -  -  -  -  -  -");
        System.out.println("  | a  b  c  d  e  f  g  h ");
    }

    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        Board b = new Board(new ArrayList<ArrayList<IPiece>>());
        b.initBoard();
        b.updatePosition();
        b.printBoard();
        while (true) {
            b.userMove(console);
        }
        // Point p  = b.userPosition(console);
        //System.out.println("Your point was " + p);
    }
}
