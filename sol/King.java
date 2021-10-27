package sol;

import java.awt.*;
import java.util.ArrayList;

public class King extends AbsPiece {

    public King(Boolean white, Point pos){
        super(white, pos);
    }

    // TODO: inCheck
    public boolean inCheck(){
        return false;
    }

    @Override
    public void move(Point p) {
        this.pos = p;
    }

    @Override
    public void updateLegalMoves(Board b) {
        ArrayList<Point> legalMove = new ArrayList<Point>();
        // eight possible moves
        if ((pos.y + 1 < 8) & (pos.x - 1 >= 0)) {
            legalMove.add(new Point(pos.x - 1, pos.y + 1));
        }
        if (pos.y + 1 < 8) {
            legalMove.add(new Point(pos.x, pos.y + 1));
        }
        if ((pos.y + 1 < 8) & (pos.x + 1 < 8)) {
            legalMove.add(new Point(pos.x + 1, pos.y + 1));
        }
        if (pos.x - 1 >= 0) {
            legalMove.add(new Point(pos.x - 1, pos.y));
        }
        if (pos.x + 1 < 8) {
            legalMove.add(new Point(pos.x + 1, pos.y));
        }
        if (pos.y - 1 >= 0) {
            legalMove.add(new Point(pos.x, pos.y - 1));
        }
        if ((pos.y - 1 >= 0) & (pos.x - 1 >= 0)) {
            legalMove.add(new Point(pos.x - 1, pos.y - 1));
        }
        if ((pos.y - 1 >= 0) & (pos.x + 1 < 8)) {
            legalMove.add(new Point(pos.x + 1, pos.y - 1));
        }
        // can cap
        int i = 0;
        while (i < legalMove.size()) {
            Point move = legalMove.get(i);
            if (!this.canCapture(b.gameState.get(move.y).get(move.x))) {
                legalMove.remove(move);
            }
            i++;
        }
        
        this.legalMoves = legalMove;
    }
}
