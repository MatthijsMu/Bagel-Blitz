package org.chess.model;

public enum Direction {
    N(0,1), S(0,-1), W(-1,0), E(1,0),
    N_E(1,1), N_W(-1,1), S_E(1,-1), S_W(-1,-1);

    public static final Direction[] DIAGONALDIRECTIONS = { Direction.N_E, Direction.N_W, Direction.S_E,
        Direction.S_W };
    public static final Direction[] STRAIGHTDIRECTIONS = { Direction.N, Direction.S, Direction.E,
        Direction.W };


    private int dX;
    private int dY;

    public int getdX() {
        return dX;
    }

    public int getdY() {
        return dY;
    }

    private Direction(int dF, int dR) {
        dX = dF; 
        dY = dR;
    }

    public Direction opposite() {
        switch(this) {
            case N : return S;
            case S : return N;
            case W : return E;
            case E : return W;
            case N_E : return S_W;
            case N_W : return S_E;
            case S_E : return N_W;
            case S_W : return N_E;
            default: return null;
        }
    }

    

    public boolean isDiag() {
        switch(this) {
            case N : 
            case S : 
            case W : 
            case E : return false;
            case N_E : 
            case N_W :
            case S_E :
            case S_W : return true;
            default: return false;
        }
    }

    public boolean isStraight() {
        switch(this) {
            case N : 
            case S : 
            case W : 
            case E : return true;
            case N_E : 
            case N_W :
            case S_E :
            case S_W : return false;
            default: return false;
        }
    }
}
