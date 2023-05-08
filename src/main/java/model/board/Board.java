package model.board;

import java.util.List;

import model.basictypes.Field;
import model.basictypes.Move;
import model.basictypes.Piece;

public interface Board {
    public interface MoveListener {
        public void onNewMove(Field oldField, Field newField, Piece oldPiece, Piece newPiece);
    }

    public interface RetakeListener {
        public void onRetake(Field oldField, Field newField, Piece oldPiece, Piece newPiece);
    }

    public void addMoveListener(MoveListener moveListener);
    public void addRetakeListener(RetakeListener retakeListener);
    
    public Piece getPiece(Field field);
    public void setPiece(Field field, Piece piece);
    public void move(Move move);
    public boolean valid(Move move);
    public List <Move> getMoves(Field field);
    public void set(Board otherBoard);
}


