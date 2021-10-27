package sol;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends AbsPiece {

    public Pawn (Boolean white, Point pos){
        super(white, pos);
    }


    @Override
    public void move(Point p) {
        this.pos = p;
    }

    @Override
    public void updateLegalMoves(Board b) {
        ArrayList<Point> legalMove = new ArrayList<Point>();
        if (this.isWhite){ //white legal pawn moves
            //first move
            if (this.pos.y == 1) {
                if (b.gameState.get(pos.y + 2).get(pos.x) instanceof EmptySquare) {
                    legalMove.add(new Point(pos.x, pos.y + 2));
                }// can move two spaces on first move
            }
            // capturing
            if (pos.x + 1 < 8 & pos.y + 1 < 8) {
                IPiece p = b.gameState.get(pos.y + 1).get(pos.x + 1);
                if (!(p instanceof EmptySquare) & this.canCapture(p)) {
                    legalMove.add(new Point(pos.x + 1, pos.y + 1));
                }
            }
            if (pos.x - 1 >= 0 & pos.y + 1< 8) {
                IPiece p = b.gameState.get(pos.y + 1).get(pos.x - 1);
                if (!(p instanceof EmptySquare) & this.canCapture(p)) {
                    legalMove.add(new Point(pos.x - 1, pos.y + 1));
                }
            }
            // move one ahead
            if (pos.y + 1 < 8){
                if (b.gameState.get(pos.y + 1).get(pos.x) instanceof EmptySquare) {
                    legalMove.add(new Point(pos.x, pos.y + 1)); // can always move one up
                }
            }
        } else {
            if (this.pos.y == 6) { // can move two spaces on first move
                if (b.gameState.get(pos.y - 2).get(pos.x) instanceof EmptySquare){
                    legalMove.add(new Point(pos.x, pos.y - 2));
                }
            }
            // capturing
            if (pos.x + 1 < 8 & pos.y - 1 >= 0) {
                IPiece p = b.gameState.get(pos.y - 1).get(pos.x + 1);
                if (!(p instanceof EmptySquare) & this.canCapture(p)) {
                    legalMove.add(new Point(pos.x + 1, pos.y - 1));
                }
            }
            if (pos.x - 1 >= 0 & pos.y - 1 >= 0) {
                IPiece p = b.gameState.get(pos.y - 1).get(pos.x - 1);
                if (!(p instanceof EmptySquare) & this.canCapture(p)) {
                    legalMove.add(new Point(pos.x - 1, pos.y - 1));
                }
            }
            // move one ahead
            if (pos.y - 1 >= 0) {
                if (b.gameState.get(pos.y - 1).get(pos.x) instanceof EmptySquare) {
                    legalMove.add(new Point(pos.x, pos.y - 1)); // can always move one up
                }
            }
        }
        this.legalMoves = legalMove;
    }
}
