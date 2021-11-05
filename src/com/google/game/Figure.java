package com.google.game;

public enum Figure {
    CROSS ('X'),
    ZERO ('0');

    private final char symbol;

    Figure(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
