package sol;

import java.awt.*;
import java.util.ArrayList;

public class EmptySquare implements IPiece{
    Point pos;
    public EmptySquare(Point pos){
        this.pos = pos;
    }

    public boolean canMove(Point togo) {
        return false;
    }

    @Override
    public void move(Point p) {

    }

    @Override
    public void updateLegalMoves(Board b) {

    }

    @Override
    public boolean isWhite() {
        return false;
    }

    @Override
    public boolean canCapture(IPiece p) {
        return true;
    }

    @Override
    public boolean isCaptured() {
        return false;
    }

    @Override
    public Point pos() {
        return null;
    }

    @Override
    public ArrayList<Point> legalMoves() {
        return null;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public void captured() {

    }

    @Override
    public boolean isLegal(Point p) {
        return false;
    }
}
