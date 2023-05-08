package model;

import java.util.ArrayList;
import java.util.List;

import model.basictypes.Colour;
import model.basictypes.Direction;
import model.basictypes.Field;
import model.basictypes.Piece;
import model.basictypes.PieceType;
import model.board.Board;

public class Attacks {

    public static List<Field> rayAttack(Colour colour, Field field, Board board, Direction direction) {
        List<Field> fields = new ArrayList<>();
        for (Field f = field.shift(direction); f.isValid() && (board.getPiece(f) == Piece.EMPTY
                || board.getPiece(f).getColour() != colour; f = f.shift(direction))) {
            fields.add(0,f);
            if (board.getPiece(f) != Piece.EMPTY)
                break;
        }
        return fields;
    }

    public static List<Field> bishopAttacks(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        Direction[] diagonalDirections = { Direction.NORTH_EAST, Direction.NORTH_WEST, Direction.SOUTH_EAST,
                Direction.SOUTH_WEST };
        for (Direction d : diagonalDirections)
            fields.addAll(rayAttack(colour, field, board, d));
        return fields;
    }

    public static List<Field> rookAttacks(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        Direction[] straightDirections = { Direction.NORTH, Direction.SOUTH, Direction.EAST,
                Direction.WEST };
        for (Direction d : straightDirections)
            fields.addAll(rayAttack(colour, field, board, d));
        return fields;
    }

    public static List<Field> queenAttacks(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(bishopAttacks(colour, field, board));
        fields.addAll(rookAttacks(colour, field, board));
        return fields;
    }

    public static List<Field> kingAttacks(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        for (Direction d : Direction.values()) {
            Field f = field.shift(d);
            if (board.getPiece(f) == Piece.EMPTY || board.getPiece(f).getColour() != colour)
                fields.add(f);
        }
        return fields;
    }

    public static List<Field> knightAttacks(Colour colour, Field field, Board board) {
        List<Field> fields = new ArrayList<>();
        Direction[] ns = {Direction.NORTH, Direction.SOUTH};
        Direction[] ew = {Direction.EAST, Direction.WEST};
        for(Direction d : ns)
            for(Direction e: ew) {
                fields.add(field.shift(d).shift(e).shift(d));
                fields.add(field.shift(d).shift(e).shift(e));
            }
        return fields;
    }

    public static List<Field> pawnAttacks(Colour colour, Field field, Board board) {

    }

    public static List<Field> attackingBishops(Colour colour, Field field, Board board) {
        List<Field> bishops = new ArrayList<>();
        List<Field> rayTips = new ArrayList<>();
        Direction[] diagonalDirections = { Direction.NORTH_EAST, Direction.NORTH_WEST, Direction.SOUTH_EAST,
            Direction.SOUTH_WEST };
        for(Direction d : diagonalDirections)
            rayTips.add(rayAttack(colour, field, board, d).get(0));
        for (Field f : rayTips)
            if(board.getPiece(f).getPieceType() == PieceType.BISHOP)
                bishops.add(f);
        return bishops;
        
    }

    public static List<Field> attackingRooks(Colour colour, Field field, Board board) {
        List<Field> rooks = new ArrayList<>();
        List<Field> rayTips = new ArrayList<>();
        Direction[] straightDirections = { Direction.NORTH, Direction.SOUTH, Direction.EAST,
            Direction.WEST };
        for(Direction d : straightDirections)
            rayTips.add(rayAttack(colour, field, board, d).get(0));
        for (Field f : rayTips)
            if(board.getPiece(f).getPieceType() == PieceType.ROOK)
                rooks.add(f);
        return rooks;
    }

    public static List<Field> attackingQueens(Colour colour, Field field, Board board) {
        List<Field> queens = new ArrayList<>();
        List<Field> rayTips = new ArrayList<>();
        for(Direction d : Direction.values())
            rayTips.add(rayAttack(colour, field, board, d).get(0));
        for (Field f : rayTips)
            if(board.getPiece(f).getPieceType() == PieceType.QUEEN)
                queens.add(f);
        return queens;
    }

    public static List<Field> attackingKnights(Colour colour, Field field, Board board) {
        List<Field> knights = new ArrayList<>();
        for(Field f : knightAttacks(colour, field, board))
            if(board.getPiece(f).getPieceType() == PieceType.KNIGHT)
                knights.add(f);
        return knights;
    }

    public static List<Field> attackingKings(Colour colour, Field field, Board board) {
        List<Field> kings
        for(Direction d : Direction.values()) {
            Field f = field.shift(d);
            if(board.getPiece(field.shift(d)).getPieceType() == PieceType.KING)
                kings.add(0, f);
        }
    }

    public static List<Field> attackingPawns(Colour colour, Field field, Board board) {
        
    }



}
