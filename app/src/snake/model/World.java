package snake.model;

import snake.model.basictypes.Colour;
import snake.model.board.Board;
import snake.model.clock.Clock;

public interface World {
    public Board getBoard();
    public void  setBoard(Board board);
    public Clock getClock();
    public Colour getTomove();
    public Colour setTomove();
}
