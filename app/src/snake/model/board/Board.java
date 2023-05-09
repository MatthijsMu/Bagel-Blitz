package snake.model.board;

import java.util.List;
import java.util.Map;

import snake.model.basictypes.Field;
import snake.model.basictypes.Move;
import snake.model.basictypes.Piece;

public interface Board {
    public interface MoveListener {
        public void onNewMove(Map<Field, Piece> change);
    }

    public interface RetakeListener {
        public void onRetake(Map<Field, Piece> change);
    }

    public void addMoveListener(MoveListener moveListener);
    public void addRetakeListener(RetakeListener retakeListener);
    
    public Piece getPiece(Field field);
    public void setPiece(Field field, Piece piece);
    public void move(Move move);
    public List <Move> getMoves(Field field);
    public void set(Piece[][] board);
    public Piece[][] get();
}


