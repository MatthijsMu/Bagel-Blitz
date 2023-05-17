package org.chess.model;

public class EPMove implements Move {
    private Field fFrom;
    private Field fTo;

    
    public EPMove(Field fFrom, Field fTo) {
        this.fFrom = fFrom;
        this.fTo = fTo;
    }

    @Override
    public void applyTo(Colour as, Board b) {
        b.swap(fFrom, fTo);
        b.set(as == Colour.W ? fTo.shift(Direction.S) : fTo.shift(Direction.N), Piece.EMPTY);
    }
    @Override
    public boolean isLegal(Colour as, Board on) {
        applyTo(as, on);
        boolean legal = !Util.inCheck(as, on);
        retake(as, on);
        return legal;
    }
    @Override
    public void retake(Colour as, Board b) {
        b.swap(fFrom, fTo);
        b.set(as == Colour.W ? fTo.shift(Direction.S) : fTo.shift(Direction.N), Piece.EMPTY);
    }
    
    
    
}
