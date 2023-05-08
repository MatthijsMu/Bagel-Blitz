package model.board;

import java.util.ArrayList;
import java.util.List;

import model.basictypes.Colour;
import model.basictypes.Direction;
import model.basictypes.Field;
import model.basictypes.Move;
import model.basictypes.Piece;
import model.basictypes.PieceType;

public class ChessBoard implements Board {
    public static final int ROW_SIZE = 8;
    public static final int COL_SIZE = ROW_SIZE;

    private Piece[][] board = {
        {Piece.W_ROOK, Piece.W_KNIGHT, Piece.W_BISHOP, Piece.W_QUEEN, Piece.W_KING, Piece.W_BISHOP, Piece.W_KNIGHT, Piece.W_ROOK},
        {Piece.W_PAWN, Piece.W_PAWN,   Piece.W_PAWN,   Piece.W_PAWN,  Piece.W_PAWN, Piece.W_PAWN,   Piece.W_PAWN,   Piece.W_PAWN},
        {Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY,   Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY},
        {Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY,   Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY},
        {Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY,   Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY},
        {Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY,   Piece.EMPTY,  Piece.EMPTY,    Piece.EMPTY,    Piece.EMPTY},
        {Piece.B_ROOK, Piece.B_KNIGHT, Piece.B_BISHOP, Piece.B_QUEEN, Piece.B_KING, Piece.B_BISHOP, Piece.B_KNIGHT, Piece.B_ROOK},
        {Piece.B_PAWN, Piece.B_PAWN,   Piece.B_PAWN,   Piece.B_PAWN,  Piece.B_PAWN, Piece.B_PAWN,   Piece.B_PAWN,   Piece.B_PAWN}
    }; 

    private Colour toMove = Colour.WHITE;

    List<MoveListener> moveListeners = new ArrayList<>(0);
    List<RetakeListener> retakeListeners = new ArrayList<>(0);

    @Override
    public void addMoveListener(MoveListener moveListener) {
        moveListeners.add(moveListener);
    }

    @Override
    public void addRetakeListener(RetakeListener retakeListener) {
        retakeListeners.add(retakeListener);
    }

    @Override
    public Piece getPiece(Field field) {
        if(!field.isValid()) {
            throw new IllegalArgumentException("Field must be valid");
        }
        else {
            return board[field.getY()][field.getX()];
        }
    }

    @Override
    public void setPiece(Field field, Piece piece) {
        board[field.getY()][field.getX()] = piece;
    }

    @Override
    public void move(Move move) {
        setPiece(move.getFromField(), Piece.EMPTY);
        if(move.getpromotionPiece() != Piece.NONE) {
            setPiece(move.getToField(), move.getpromotionPiece());
        }
    }

    @Override
    public List<Move> getMoves(Field field) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoves'");
    }

    @Override
    public void set(Piece[][] board) {
        for(int x = 0; x < ROW_SIZE; x++) 
            for(int y = 0; y < COL_SIZE; y++) {
                setPiece(new Field(x,y), otherBoard.getPiece(new Field(x,y)));
            }
    }

    @Override
    public Piece[][] get() {
        return this.board.clone();
    }
}
