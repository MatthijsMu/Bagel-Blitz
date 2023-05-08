package model;

import model.basictypes.Colour;
import model.board.Board;
import model.clock.Clock;

public interface World {
    public Board getBoard();
    public void  setBoard(Board board);
    public Clock getClock();
    public Colour getTomove();
    public Colour setTomove();
}
