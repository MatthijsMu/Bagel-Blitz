package model;

public interface World {
    public Board getBoard();
    public void  setBoard(Board board);
    public Clock getClock();
    public Colour getTomove();
    public Colour setTomove();
}
