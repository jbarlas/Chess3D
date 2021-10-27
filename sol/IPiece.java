package sol;

import java.awt.*;
import java.util.ArrayList;

public interface IPiece {
    public void move(Point p);
    public void updateLegalMoves(Board b);

    boolean isWhite();
    public boolean canCapture(IPiece p);
    public boolean isCaptured();
    public Point pos();
    public ArrayList<Point> legalMoves();
    public boolean canMove();
    public void captured();
    public boolean isLegal(Point p);
}
