package model;

public enum Direction {
    NORTH(0,1), SOUTH(0,-1), WEST(-1,0), EAST(1,0),
    NORTH_EAST(1,1), NORTH_WEST(-1,1), SOUTH_EAST(1,-1), SOUTH_WEST(-1,-1);

    private int dFile;
    private int dRank;

    public int getdFile() {
        return dFile;
    }

    public int getdRank() {
        return dRank;
    }

    private Direction(int dF, int dR) {
        dFile = dF; 
        dRank = dR;
    }
}
