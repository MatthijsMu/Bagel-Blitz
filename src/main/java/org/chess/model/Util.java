package org.chess.model;

import org.chess.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static List<Field> ray(Colour colour, Field field, Board board, Direction direction) {
        List<Field> fields = new ArrayList<>();
        for (Field f = field.shift(direction); f.isValid() && (!board.occupied(f)
                || board.get(f).getColour() == colour.other()); f = f.shift(direction)) {
            fields.add(0, f);
            if (board.occupied(f))
                break;
        }
        return fields;
    }

    public static Optional<Field> rayTip(Colour colour, Field field, Board board, Direction direction) {
        Field endField = field;
        for (Field f = field.shift(direction); f.isValid() && (!board.occupied(f)
                || board.get(f).getColour() == colour.other()); f = f.shift(direction)) {
            endField = f;
            if (board.occupied(f))
                break;
        }
        return endField == field ? Optional.empty() : Optional.of(endField);
    }

    public static Optional<Piece> rayedPiece(Colour colour, Field field, Board board, Direction direction) {
        Optional<Field> rt = rayTip(colour, field, board, direction);
        if (rt.isPresent())
            return Optional.of(board.get(rt.get()));
        else
            return Optional.empty();
    }

    public static List<Field> bishopFields(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        for (Direction d : Direction.DIAGONALDIRECTIONS)
            fields.addAll(ray(colour, field, board, d));
        return fields;
    }

    public static List<Field> rookFields(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        for (Direction d : Direction.STRAIGHTDIRECTIONS)
            fields.addAll(ray(colour, field, board, d));
        return fields;
    }

    public static List<Field> queenFields(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(bishopFields(colour, field, board));
        fields.addAll(rookFields(colour, field, board));
        return fields;
    }

    public static List<Field> knightFields(Field field) {
        List<Field> fields = new ArrayList<>();
        Direction[] ns = {Direction.N, Direction.S};
        Direction[] ew = {Direction.E, Direction.W};
        for (Direction d : ns)
            for (Direction e : ew) {
                fields.add(field.shift(d).shift(e).shift(d));
                fields.add(field.shift(d).shift(e).shift(e));
            }
        return fields.stream().filter(f -> f.isValid()).collect(Collectors.toList());
    }

    public static List<Field> pawnPseudoAttackFields(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        Direction[] attDir = new Direction[2];
        if (colour == Colour.W) {
            attDir[0] = Direction.N_E;
            attDir[1] = Direction.N_W;
        } else {
            attDir[0] = Direction.S_E;
            attDir[1] = Direction.S_W;
        }

        for (Direction d : attDir) {
            Field f = field.shift(d);
            if (f.isValid())
                fields.add(f);
        }
        return fields;
    }

    public static List<Field> pawnStepsFields(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        int startrank = colour == Colour.W ? 1 : 6;
        Direction movDir = colour == Colour.W ? Direction.N : Direction.S;
        Field f = field.shift(movDir);
        if (f.isValid() && !board.occupied(f)) {
            fields.add(f);
            f = f.shift(movDir);
            if (f.isValid() && board.occupied(f) && field.getY() == startrank)
                fields.add(f);
        }
        return fields;
    }

    public static List<Field> kingFields(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            final Field shifted = field.shift(direction);
            if (shifted.isValid() && (!board.occupied(shifted) || board.get(shifted).getColour() != colour))
                fields.add(shifted);
        }
        return fields;
    }


    public static boolean attacked(Colour as, Board b, Field f) {
        for (Field field : pawnPseudoAttackFields(as, f, b))
            if (b.occupied(field) && b.get(field) == Piece.P(PieceType.PAWN, as.other()))
                return true;
        for (Field field : rookFields(as, f, b))
            if (b.get(field) == Piece.P(PieceType.ROOK, as.other()))
                return true;
        for (Field field : bishopFields(as, f, b))
            if (b.get(field) == Piece.P(PieceType.BISHOP, as.other()))
                return true;
        for (Field field : queenFields(as, f, b))
            if (b.get(field) == Piece.P(PieceType.QUEEN, as.other()))
                return true;
        for (Field field : knightFields(f))
            if (b.get(field) == Piece.P(PieceType.KNIGHT, as.other()))
                return true;
        for (Field field : kingFields(as, f, b))
            if (b.get(field) == Piece.P(PieceType.KING, as.other()))
                return true;
        return false;
    }

    public static boolean attacked(Colour as, Board b, int x, int y) {
        return attacked(as, b, new Field(x, y));
    }

    public static Field find(Board board, Piece piece) {
        /**
         * @param board: the Board on which piece should be found;
         * @param piece: the Piece to be found
         * @returns the location of first occurrence of piece on board
         *          starting from a1 working row-first iteration to h8
         *          invalid Field if no occurrence found.
         */
        Iterator<Field> fieldIterator = board.fieldIterator();
        Iterator<Piece> pieceIterator = board.pieceIterator();
        while (fieldIterator.hasNext()) {
            Field f = fieldIterator.next();
            if (pieceIterator.next() == piece)
                return f;
        }
        return new Field();
    }

    public static boolean inCheck(Colour as, Board b) {
        return attacked(as, b, find(b, Piece.P(PieceType.KING, as)));
    }

    public static List<Move> bishopMoves(Colour colour, Field field, Board board) {
        return bishopFields(colour, field, board).stream()
                .map(f -> new OrdinaryMove(Piece.P(PieceType.BISHOP, colour), field, f, board.get(f)))
                .filter(m -> m.isLegal(colour, board))
                .collect(Collectors.toList());
    }

    public static List<Move> rookMoves(Colour colour, Field field, Board board) {
        return rookFields(colour, field, board).stream()
                .map(f -> new OrdinaryMove(Piece.P(PieceType.ROOK, colour), field, f, board.get(f)))
                .filter(m -> m.isLegal(colour, board))
                .collect(Collectors.toList());
    }

    public static List<Move> queenMoves(Colour colour, Field field, Board board) {
        return queenFields(colour, field, board).stream()
                .map(f -> new OrdinaryMove(Piece.P(PieceType.QUEEN, colour), field, f, board.get(f)))
                .filter(m -> m.isLegal(colour, board))
                .collect(Collectors.toList());
    }

    public static List<Move> knightMoves(Colour colour, Field field, Board board) {
        return knightFields(field).stream()
                .map(f -> new OrdinaryMove(Piece.P(PieceType.KNIGHT, colour), field, f, board.get(f)))
                .filter(m -> m.isLegal(colour, board))
                .collect(Collectors.toList());
    }

    public static List<Move> pawnMoves(Colour colour, Field field, Board board, Field EPField) {
        List<Move> epMoves = pawnPseudoAttackFields(colour, field, board).stream()
                .filter(f -> f.equals(EPField))
                .map(f -> new EPMove(field, f))
                .filter(m -> m.isLegal(colour, board))
                .collect(Collectors.toList());
        epMoves.addAll(
                pawnPseudoAttackFields(colour, field, board).stream()
                        .filter(f -> board.occupied(f) && board.get(f).getColour() != colour)
                        .map(f -> new OrdinaryMove(Piece.P(PieceType.PAWN, colour), field, f, board.get(f)))
                        .filter(m -> m.isLegal(colour, board))
                        .collect(Collectors.toList()));
        epMoves.addAll(
                pawnStepsFields(colour,field,board).stream()
                        .map(f -> new OrdinaryMove(Piece.P(PieceType.PAWN, colour), field, f, board.get(f)))
                        .filter(m -> m.isLegal(colour, board))
                        .collect(Collectors.toList())
        );

        return epMoves;
    }

    public static List<Move> kingMoves(Colour colour, Field field, Board board) {
        List<Move> stepMoves = kingFields(colour, field, board).stream()
                .filter(f -> attacked(colour, board, field))
                .map(f -> new OrdinaryMove(Piece.P(PieceType.KING, colour), field, f, board.get(f)))
                .collect(Collectors.toList());
        stepMoves.addAll(
                Arrays.stream(new CastleMove[]{CastleMove.SHORT, CastleMove.LONG})
                        .filter(castleMove -> castleMove.isLegal(colour,board))
                        .collect(Collectors.toList())
        );
        return stepMoves;
    }


}
