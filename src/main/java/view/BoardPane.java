package view;

import java.util.Map;

import model.basictypes.Field;
import model.basictypes.Piece;
import model.board.Board;

public interface BoardPane {
    public void set(Board board);
    public void update(Map<Field, Piece> newPieceMap);
}
