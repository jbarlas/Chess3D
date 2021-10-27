package sol;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends AbsPiece {

    public Queen(Boolean white, Point pos){
        super(white, pos);
    }

    @Override
    public void move(Point p) {
        this.pos = p;
    }

    @Override
    public void updateLegalMoves(Board b) {
        ArrayList<Point> legalMove = new ArrayList<Point>();
        int i = pos.x + 1;
        int j = pos.y + 1;
        while (i < 8 ){
            if (b.gameState.get(pos.y).get(i) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(pos.y).get(i))) {
                legalMove.add(new Point(i, pos.y));
            }
            i++;
        }
        while (j < 8) {
            if (b.gameState.get(j).get(pos.x) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(j).get(pos.x))) {
                legalMove.add(new Point(pos.x, j));
            }
            j++;
        }
        i = pos.x - 1;
        j = pos.y - 1;
        while (i >= 0) {
            if (b.gameState.get(pos.y).get(i) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(pos.y).get(i))) {
                legalMove.add(new Point(i, pos.y));
            }
            i--;
        }
        while (j >= 0) {
            if (b.gameState.get(j).get(pos.x) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(j).get(pos.x))) {
                legalMove.add(new Point(pos.x, j));
            }
            j--;
        }
        i = pos.x + 1;
        j = pos.y + 1;
        while (i < 8 & j < 8) {
            if (b.gameState.get(j).get(i) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(j).get(i))) {
                legalMove.add(new Point(i, j));
            }
            i++;
            j++;
        }
        i = pos.x + 1;
        j = pos.y - 1;
        while (i < 8 & j >= 0) {
            if (b.gameState.get(j).get(i) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(j).get(i))) {
                legalMove.add(new Point(i, j));
            }
            i++;
            j--;
        }
        i = pos.x - 1;
        j = pos.y + 1;
        while (i >= 0 & j < 8) {
            if (b.gameState.get(j).get(i) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(j).get(i))) {
                legalMove.add(new Point(i, j));
            }
            i--;
            j++;
        }
        i = pos.x - 1;
        j = pos.y - 1;
        while (i >= 0 & j >= 0) {
            if (b.gameState.get(j).get(i) instanceof EmptySquare |
                    this.canCapture(b.gameState.get(j).get(i))) {
                legalMove.add(new Point(i, j));
            }
            i--;
            j--;
        }
        this.legalMoves = legalMove;
    }
}
