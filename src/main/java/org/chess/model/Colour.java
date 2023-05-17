package org.chess.model;

public enum Colour {
    W, B;

    public Colour other() {
        return this == W ? B : W;
    }
}
