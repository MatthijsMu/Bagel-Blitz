package org.chess.model;

public class Field {
    private int X;
    private int Y;

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == this.getClass()) {
            return ((Field) obj).getX() == getX() && ((Field) obj).getY() == getY();
        }
        else return false;
    }

    public Field() {
        this.X = -1;
        this.Y = -1;
    }

    public Field(int X, int Y) {
        if (X < 0 || X > 7 || Y < 0 || Y > 7) {
            throw new IllegalArgumentException("X and Y must be between 0 and 7");
        }
        this.X = X;
        this.Y = Y;
    }

    public boolean isValid() {
        return X >= 0 || X <= 7 || Y >= 0 || Y <= 7;
    }

    public int getX() {
        if (!isValid()) {
            throw new IllegalStateException("Invalid field has no X");
        }
        return this.X;
    }

    public int getY() {
        if (!isValid()) {
            throw new IllegalStateException("Invalid field has no Y");
        }
        return this.Y;
    }

    public Field shift(Direction direction) {
        if(!isValid()) {
            throw new IllegalStateException("Invalid field cannot be shifted");
        }
        int newX = this.X + direction.getdX();
        int newY = this.Y + direction.getdY();
        if (X < 0 || X > 7 || Y < 0 || Y > 7) {
            return new Field();
        }
        else return new Field(newX, newY);
    }
}

