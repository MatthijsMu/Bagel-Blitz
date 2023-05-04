package model;

public interface World {
    public Board getBoard();
    public void  setBoard(Board board);
    public Clock getClock();
    public Colour getToMove();
    public Colour setToMove();
}
