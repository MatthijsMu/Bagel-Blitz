package org.chess.model;

import java.util.Collections;
import java.util.List;

public class Game {
    private Board board;
    private boolean castleWA;
    private boolean castleWH;
    private boolean castleBA;
    private boolean castleBH;

    private Field EPField;

    @FunctionalInterface
    private interface BoardListener {
        void onNewBoard(Board newBoard);
    }

    @FunctionalInterface
    private interface MoveListener {
        void onNewMove(Move newMove);
    }

    private List<BoardListener> boardListeners;
    private List<MoveListener> moveListeners;

    public void notifyBoardListeners(Board b) {
        boardListeners.forEach(boardListener -> boardListener.onNewBoard(b));
    }

    public void notifyMoveListeners(Move m) {
        moveListeners.forEach(moveListener -> moveListener.onNewMove(m));
    }

    public List<Move> generateMoves(Colour c, Field f) {
        if (c != board.get(f).getColour())
            return Collections.emptyList();
        else switch (board.get(f).getPieceType()) {
            case PAWN:
                return Util.pawnMoves(c, f, board, EPField);
            case KNIGHT:
                return Util.knightMoves(c, f, board);
            case BISHOP:
                return Util.bishopMoves(c, f, board);
            case ROOK:
                return Util.rookMoves(c, f, board);
            case QUEEN:
                return Util.queenMoves(c, f, board);
            case KING:
                return Util.kingMoves(c, f, board);
            default:
                return Collections.emptyList();
        }
    }
}

