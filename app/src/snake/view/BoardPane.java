package snake.view;

import java.util.Map;

import snake.model.basictypes.Field;
import snake.model.basictypes.Piece;
import snake.model.board.Board;

public interface BoardPane {
    public void set(Board board);
    public void update(Map<Field, Piece> newPieceMap);
}
