package org.chess.model;

public class OrdinaryMove implements Move {
    private Field from;
    private Field to;
    private Piece movingPiece;

    private Piece capturedPiece; //can be EMPTY

    public OrdinaryMove(Piece movingPiece, Field from, Field to, Piece capturedPiece) {
        this.from = from;
        this.to = to;
        this.movingPiece = movingPiece;
        this.capturedPiece = capturedPiece;
    }

    public OrdinaryMove(Piece movingPiece, Field from, Field to) {
        this.from = from;
        this.to = to;
        this.movingPiece = movingPiece;
        this.capturedPiece = Piece.EMPTY;
    }

    public Field getTo() {
        return to;
    }

    @Override
    public boolean isLegal(Colour as, Board on) {
        applyTo(as, on);
        boolean legal = !Util.inCheck(as, on);
        retake(as, on);
        return legal;
    }

    @Override
    public void applyTo(Colour as, Board b) {
        b.set(to, movingPiece);
        b.set(from, Piece.EMPTY);
    }

    @Override
    public void retake(Colour as, Board b) {
        b.set(to, capturedPiece);
        b.set(from, movingPiece);
    }

    

    
}
