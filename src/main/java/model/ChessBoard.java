package model;


public class ChessBoard implements Board {
    public static final int ROW_SIZE = 8;
    public static final int COL_SIZE = ROW_SIZE;

    private Piece[][] board = {
        {W_ROOK, W_KNIGHT, W_BISHOP, W_QUEEN, W_KING, W_BISHOP, W_KNIGHT, W_ROOK},
        {W_PAWN, W_PAWN,   W_PAWN,   W_PAWN,  W_PAWN, W_PAWN,   W_PAWN,   W_PAWN},
        {EMPTY,  EMPTY,    EMPTY,    EMPTY,   EMPTY,  EMPTY,    EMPTY,    EMPTY},
        {EMPTY,  EMPTY,    EMPTY,    EMPTY,   EMPTY,  EMPTY,    EMPTY,    EMPTY},
        {EMPTY,  EMPTY,    EMPTY,    EMPTY,   EMPTY,  EMPTY,    EMPTY,    EMPTY},
        {EMPTY,  EMPTY,    EMPTY,    EMPTY,   EMPTY,  EMPTY,    EMPTY,    EMPTY},
        {B_ROOK, B_KNIGHT, B_BISHOP, B_QUEEN, B_KING, B_BISHOP, B_KNIGHT, B_ROOK},
        {B_PAWN, B_PAWN,   B_PAWN,   B_PAWN,  B_PAWN, B_PAWN,   B_PAWN,   B_PAWN}
    }; 

    private Colour toMove;

    private void set(Field field, Piece piece) {
        board[field.rank][field.file] = piece;
    }

    public Piece get(Field field) {
        return board[field.rank][field.file];
    }

    public void move(Field fromField, Field toField, MoveType moveType, PieceType promotionPiece) {
        switch(moveType) {
            case NORMAL:
                set(toField, get(fromField));
                set(fromField, Piece.EMPTY);
                break;
            case EP_CAPTURE:
                move(fromField, toField, MoveType.NORMAL, promotionPiece);
                set(toField.shift(toMove == WHITE ? Direction.SOUTH : Direction.NORTH), Piece.EMPTY);
            case CASTLE_LONG:
            //TODO
            case CASTLE_SHORT:
            case PROMOTION:
        }
    }

    public List<Field> 
}
