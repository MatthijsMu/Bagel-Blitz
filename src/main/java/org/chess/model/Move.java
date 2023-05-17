package org.chess.model;

import org.chess.model.Board;
import org.chess.model.Colour;

public interface Move {
    public boolean isLegal(Colour as, Board on);

    public void applyTo(Colour as, Board b);

    public void retake(Colour as, Board b);
}
