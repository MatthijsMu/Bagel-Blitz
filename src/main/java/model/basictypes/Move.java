package model.basictypes;

    /**
     * Move is the class that keeps all the important information for 
     * a move that is passed to Board when doing a move. The only 
     * necessary information is:
     * 
     * - field from which the moving Piece comes
     * - field to which the moving Piece goes
     * - optionally a promotionPiece if moving Piece is a pawn that
     *   reaches the 8th rank.
     */
public class Move {

    /**
     * fromField : field from which the moving Piece comes.
     */
    Field fromField;

    /**
     * toField : field to which the moving Piece goes.
     */
    Field toField;


    /**
     * promotionPiece : piece to which moving Piece promotes.
     * if moveType is not PROMOTION this field can be arbitrary as it won't be used
     */
    Piece promotionPiece;

    public Move(Field fromField, Field toField, Piece promotionPiece) {
        this.fromField = fromField;
        this.toField = toField;
        this.promotionPiece = promotionPiece;
    }

    public Field getFromField() {
        return fromField;
    }

    public Field getToField() {
        return toField;
    }

    public Piece getpromotionPiece() {
        return promotionPiece;
    }
}
