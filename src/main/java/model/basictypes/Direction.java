package model.basictypes;

public enum Direction {
    NORTH(0,1), SOUTH(0,-1), WEST(-1,0), EAST(1,0),
    NORTH_EAST(1,1), NORTH_WEST(-1,1), SOUTH_EAST(1,-1), SOUTH_WEST(-1,-1);

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
}
