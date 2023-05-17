package org.chess.model;

import java.util.Iterator;

public class Board {
    public static final int SIZE = 8;

    public boolean inBounds(int x, int y) {
        return x < SIZE && x >= 0 && y < SIZE && y >= 0;
    }

    private Piece[][] board = {
            {Piece.W_ROOK, Piece.W_KNIGHT, Piece.W_BISHOP, Piece.W_QUEEN, Piece.W_KING, Piece.W_BISHOP, Piece.W_KNIGHT, Piece.W_ROOK},
            {Piece.W_PAWN, Piece.W_PAWN, Piece.W_PAWN, Piece.W_PAWN, Piece.W_PAWN, Piece.W_PAWN, Piece.W_PAWN, Piece.W_PAWN},
            {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
            {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
            {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
            {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
            {Piece.B_ROOK, Piece.B_KNIGHT, Piece.B_BISHOP, Piece.B_QUEEN, Piece.B_KING, Piece.B_BISHOP, Piece.B_KNIGHT, Piece.B_ROOK},
            {Piece.B_PAWN, Piece.B_PAWN, Piece.B_PAWN, Piece.B_PAWN, Piece.B_PAWN, Piece.B_PAWN, Piece.B_PAWN, Piece.B_PAWN}
    };

    public Piece get(Field field) {
        if (!field.isValid()) {
            throw new IllegalArgumentException("Field must be within bounds of Board");
        } else {
            return board[field.getY()][field.getX()];
        }
    }

    public Piece get(int x, int y) {
        if (!inBounds(x, y)) {
            throw new IllegalArgumentException("x,y must be within bounds of Board");
        } else {
            return board[y][x];
        }
    }

    public void set(Field field, Piece piece) {
        if (!field.isValid()) {
            throw new IllegalArgumentException("Field must be within bounds of Board");
        } else {
            board[field.getY()][field.getX()] = piece;
        }
    }

    public void set(int x, int y, Piece piece) {
        if (!inBounds(x, y)) {
            throw new IllegalArgumentException("Field must be within bounds of Board");
        } else {
            board[y][x] = piece;
        }
    }

    public void swap(Field f1, Field f2) {
        Piece temp = get(f1);
        set(f1, get(f2));
        set(f2, temp);
    }

    public void swap(Field f1, int x2, int y2) {
        Piece temp = get(f1);
        set(f1, get(x2, y2));
        set(x2, y2, temp);
    }

    public void swap(int x1, int y1, Field f2) {
        Piece temp = get(x1, y1);
        set(x1, y1, get(f2));
        set(f2, temp);
    }

    public void swap(int x1, int y1, int x2, int y2) {
        Piece temp = get(x1, y1);
        set(x1, y1, get(x2, y2));
        set(x2, y2, temp);
    }

    public String toFEN() {
        /*
         * todo: BREGT
         */
        return null;
    }

    public Board(String FENString) {
        /*
         * todo: BREGT
         */
    }

    public boolean occupied(Field f) {
        return get(f) != Piece.EMPTY;
    }

    public boolean occupied(int x, int y) {
        return get(x, y) != Piece.EMPTY;
    }

    public Iterator<Piece> pieceIterator() {
        /**
         * @returns Iterator that iterates through Pieces on board row-majorly.
         */
        return new Iterator<Piece>() {
            private int x = 0;

            @Override
            public boolean hasNext() {
                return x < SIZE * SIZE;
            }

            @Override
            public Piece next() {
                int temp = x;
                x++;
                return get(x % 8, x / 8);
            }
        };
    }

    public Iterator<Field> fieldIterator() {
        /**
         * @returns Iterator that iterates through Fields on board row-majorly.
         */
        return new Iterator<Field>() {
            private int x = 0;

            @Override
            public boolean hasNext() {
                return x < SIZE * SIZE;
            }

            @Override
            public Field next() {
                return new Field(x % 8, x / 8);
            }
        };
    }

}
