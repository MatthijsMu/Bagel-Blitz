package model;

public enum Piece {

    W_PAWN(PieceType.PAWN, Colour.WHITE), W_KNIGHT(PieceType.KNIGHT, Colour.WHITE), W_BISHOP(PieceType.BISHOP, Colour.WHITE), 
    W_ROOK(PieceType.ROOK, Colour.WHITE), W_QUEEN(PieceType.QUEEN, Colour.WHITE), W_KING(PieceType.KING, Colour.WHITE), 
    B_PAWN(PieceType.PAWN, Colour.BLACK), B_KNIGHT(PieceType.KNIGHT, Colour.BLACK), B_BISHOP(PieceType.BISHOP, Colour.BLACK), 
    B_ROOK(PieceType.ROOK, Colour.BLACK), B_QUEEN(PieceType.QUEEN, Colour.BLACK), B_KING(PieceType.KING, Colour.BLACK), 
    EMPTY(PieceType.NONE, Colour.NONE), NONE(PieceType.NONE, Colour.NONE); 

    private PieceType pieceType;
    private Colour    colour;

    /**
     * @param pType the type (PieceType) of the piece, as opposed to the actual piece Piece
     */
    private Piece(PieceType pType, Colour c) {
        pieceType = pType;
        colour = c;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Colour getColour() {
        return colour;
    }
}
