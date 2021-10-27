package sol;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbsPiece implements IPiece {
    boolean isWhite;
    boolean isCaptured;
    Point pos;
    ArrayList<Point> legalMoves;

    public AbsPiece(boolean white, Point pos){
        this.isWhite = white;
        this.isCaptured = false;
        this.pos = pos;
        this.legalMoves = new ArrayList<Point>();
    }

    public boolean isWhite(){
        return this.isWhite;
    }

    public boolean canCapture(IPiece p){
        return p.isWhite() ^ this.isWhite(); // ^ is XOR operator
    }

    public boolean isCaptured(){
        return this.isCaptured;
    }

    public void captured(){
        this.isCaptured = true;
    }

    public Point pos(){
        return this.pos;
    }

    public ArrayList<Point> legalMoves(){
        return this.legalMoves;
    }

    public boolean isLegal(Point p){
        return this.legalMoves.contains(p);
    }

    public boolean canMove(){
        return this.legalMoves.size() > 0;
    }
}
