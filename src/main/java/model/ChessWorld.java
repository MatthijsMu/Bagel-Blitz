package model;

import java.util.Stack;

import model.basictypes.Colour;
import model.basictypes.Move;
import model.board.Board;

public class ChessWorld {
    
    

    private int enPassantLine = -1;

    private Colour toMove = WHITE;

    private Stack<Board> history;

    /**
     * 
     * @param m : move to apply to the board
     * @return true if and only if m is a valid move and was applied to the world.
     */
    public void apply(Move m) {
        if(m.movingPiece)
    }

    /**
     * retakes the top move of moveHistory and leaves the board in the state before it
     */
    public void retake() {

    }


    public World(Board board, Clock clock) {
        board 
    }
}
