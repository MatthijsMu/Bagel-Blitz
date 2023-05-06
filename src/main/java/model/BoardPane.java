package model;

import java.util.Map;

public interface BoardPane {
    public void set(Board board);
    public void update(Map<Field, Piece> newPieceMap);
}
