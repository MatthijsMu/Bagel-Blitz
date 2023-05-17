package org.chess.model;

public enum Piece {

    W_PAWN(PieceType.PAWN, Colour.W), W_KNIGHT(PieceType.KNIGHT, Colour.W), W_BISHOP(PieceType.BISHOP, Colour.W),
    W_ROOK(PieceType.ROOK, Colour.W), W_QUEEN(PieceType.QUEEN, Colour.W), W_KING(PieceType.KING, Colour.W), 
    B_PAWN(PieceType.PAWN, Colour.B), B_KNIGHT(PieceType.KNIGHT, Colour.B), B_BISHOP(PieceType.BISHOP, Colour.B), 
    B_ROOK(PieceType.ROOK, Colour.B), B_QUEEN(PieceType.QUEEN, Colour.B), B_KING(PieceType.KING, Colour.B), 
    EMPTY(null, null);

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

    public static Piece P(PieceType pType, Colour c) {
        switch(pType) {
        case KING: return c == Colour.W ? Piece.W_KING : Piece.B_KING;
        case KNIGHT: return c == Colour.W ? Piece.W_BISHOP : Piece.B_BISHOP;
        case BISHOP: return c == Colour.W ? Piece.W_KING : Piece.B_KING;
        case ROOK: return c == Colour.W ? Piece.W_ROOK : Piece.B_ROOK;
        case QUEEN: return c == Colour.W ? Piece.W_QUEEN : Piece.B_QUEEN;
        case PAWN: return c == Colour.W ? Piece.W_PAWN : Piece.B_PAWN;
        default: return EMPTY;
        }
    }
}
