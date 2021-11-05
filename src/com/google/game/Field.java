package com.google.game;

import com.google.exception.PointIsOutOfGameBoundsException;
import com.google.exception.ThePointIsBusyException;

public class Field {

    private final Character[][] field;
    private final Integer fieldSize = 3;
    private Integer countOfEmptyCells;
    private final Character EMPTY = ' ';

    public Field() {
        this.countOfEmptyCells = 9;
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

    public void addSymbol(Move move) throws ThePointIsBusyException, PointIsOutOfGameBoundsException {
        checkMove(move);
        field[move.getX()][move.getY()] = move.getTypeOfFigure().getSymbol();
        countOfEmptyCells--;
    }

    public void checkMove(Move move) throws PointIsOutOfGameBoundsException, ThePointIsBusyException{
        if (move.getY() > fieldSize || move.getX() > fieldSize) {
            throw new PointIsOutOfGameBoundsException();
        }
        if (field[move.getX()][move.getY()] != EMPTY) {
            throw new ThePointIsBusyException();
        }
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
