package org.chess.model;

import org.chess.model.*;

public class PromotionMove extends OrdinaryMove {
    private Piece promotionPiece;

    

    public PromotionMove(Piece movingPiece, Field from, Field to, Piece capturedPiece, Piece promotionPiece) {
        super(movingPiece, from, to, capturedPiece);
        this.promotionPiece = promotionPiece;
    }



    public PromotionMove(Piece movingPiece, Field from, Field to, Piece promotionPiece) {
        super(movingPiece, from, to);
        this.promotionPiece = promotionPiece;
    }



    @Override
    public void applyTo(Colour as, Board b) {
        super.applyTo(as, b);
        b.set(super.getTo(), promotionPiece);
    }



    @Override
    public boolean isLegal(Colour as, Board on) {
        return super.isLegal(as, on);
    }



    @Override
    public void retake(Colour as, Board b) {
        super.retake(as, b);
    }
}
