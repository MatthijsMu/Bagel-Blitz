package org.chess.model;

public enum CastleMove implements Move {
    SHORT(6), LONG(2);

    private int kingX;

    private CastleMove(int kingX) {
        this.kingX = kingX;
    }
    


    @Override
    public boolean isLegal(Colour as, Board on) {
        if(Util.inCheck(as, on))
            return false;

        int Y = as == Colour.W ? 0 : 7;
        int rookX = this == SHORT ? kingX - 1: kingX + 1;
        
        if(Util.attacked(as, on, kingX, Y) || Util.attacked(as, on, rookX, Y))
            return false;
            
        if(on.occupied(kingX, Y) || on.occupied(rookX, Y))
            return false;
        
        return true;

    }
    @Override
    public void applyTo(Colour as, Board b) {
        int from = 4;
        int Y = as == Colour.W ? 0 : 7;
        int rookX = this == SHORT ? kingX - 1: kingX + 1;

        int cornerX = this == SHORT ? 7: 0;

        b.swap(rookX, Y, cornerX, Y);
        b.swap(kingX, Y, from, Y);
    }
    @Override
    public void retake(Colour as, Board b) {
        applyTo(as, b);
    }
}
