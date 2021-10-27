package sol;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends AbsPiece {

    public Knight(Boolean white, Point pos) {
        super(white, pos);
    }


    @Override
    public void move(Point p) {
        this.pos = p;
    }

    @Override
    public void updateLegalMoves(Board b) {
        // todo: make sure can capture and isn't same color
        ArrayList<Point> legalMove = new ArrayList<Point>();
        if ((pos.y + 2 < 8) & (pos.x - 1 >= 0)) {
            legalMove.add(new Point(pos.x - 1, pos.y + 2));
        }
        if ((pos.y + 2 < 8) & (pos.x + 1 < 8)) {
            legalMove.add(new Point(pos.x + 1, pos.y + 2));
        }
        if ((pos.y + 1 < 8) & (pos.x - 2 >= 0)) {
            legalMove.add(new Point(pos.x - 2, pos.y + 1));
        }
        if ((pos.y + 1 < 8) & (pos.x + 2 < 8)) {
            legalMove.add(new Point(pos.x + 2, pos.y + 1));
        }
        if ((pos.y - 2 >= 0) & (pos.x - 1 >= 0)) {
            legalMove.add(new Point(pos.x - 1, pos.y - 2));
        }
        if ((pos.y - 2 >= 0) & (pos.x + 1 < 8)) {
            legalMove.add(new Point(pos.x + 1, pos.y - 2));
        }
        if ((pos.y - 1 >= 0) & (pos.x + 2 < 8)) {
            legalMove.add(new Point(pos.x + 2, pos.y - 1));
        }
        if ((pos.y - 1 >= 0) & (pos.x - 2 >= 0)) {
            legalMove.add(new Point(pos.x - 2, pos.y - 1));
        }
        this.legalMoves = legalMove;
    }
}
