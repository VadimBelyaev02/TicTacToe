package com.google.game;


public class GameField {

    private final Character[][] field;
    private final Integer fieldSize;
    private Integer countOfEmptyCells;
    private static final Character EMPTY = ' ';

    public GameField(Integer fieldSize) {
        this.fieldSize = fieldSize;
        this.countOfEmptyCells = fieldSize * fieldSize;
        field = new Character[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY;
            }
        }
    }


    public void show() {
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                System.out.print("|");
                System.out.print(field[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public void addSymbol(Move move) {
        field[move.getX()][move.getY()] = move.getTypeOfFigure().getSymbol();
        countOfEmptyCells--;
    }

    public boolean isCoordsCorrect(Move move) {
        if (move.getY() > fieldSize || move.getX() > fieldSize || move.getX() < 0 || move.getY() < 0) {
            return false;
        }
        return field[move.getX()][move.getY()] == EMPTY;
    }

    public Integer getCountOfEmptyCells() {
        return countOfEmptyCells;
    }

    public void setCountOfEmptyCells(Integer count) {
        this.countOfEmptyCells = count;
    }

    public Integer getFieldSize() {
        return fieldSize;
    }

    public char getCell(int i, int j) {
        return field[i][j];
    }
}
