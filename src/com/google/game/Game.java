package com.google.game;

import com.google.player.Player;


public class Game {

    private final GameField field;
    private final Player firstPlayer;
    private final Player secondPlayer;


    public Game(Player firstPlayer, Player secondFlayer, int fieldSize) {
        this.field = new GameField(fieldSize);
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondFlayer;
    }

    public void playing() {
        field.show();
        do {
            firstPlayer.makeMove(field);
            if (hasWinner()) {
                break;
            }
            secondPlayer.makeMove(field);
        } while (!hasWinner());
    }

    public boolean hasWinner() {
        return checkDraw() || checkDiagonals() || checkLines();
    }

    private boolean checkDiagonals() {
        for (int i = 0; i < field.getFieldSize(); i++) {

        }
    }

    private boolean checkLines() {
        for (int i = 0; i < field.getFieldSize(); i++) {
            int j;
            boolean flag = true;
            for (j = 0; j < field.getFieldSize(); j++) {
                if (field.getCell(i, 0) == ' ' || field.getCell(i, 0) != field.getCell(i, j)) {
                    flag = false;
                } else {
                    continue;
                }
                if (field.getCell(0, i) != ' ' && field.getCell(0, i) == field.getCell(j, i)) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                if (field.getCell(0, i) == field.getCell(1, i)) {
                    System.out.println(getPlayerBySymbol(field.getCell(0, i)) + " is winner!");
                } else {
                    System.out.println(getPlayerBySymbol(field.getCell(i, 0)) + " is winner!");
                }
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw() {
        if (field.getCountOfEmptyCells() == 0) {
            System.out.println("Draw");
            return true;
        }
    }

    private String getPlayerBySymbol(char symbol) {
        if (firstPlayer.getTypeOfFigure().getSymbol() == symbol) {
            return firstPlayer.getName();
        } else {
            return secondPlayer.getName();
        }
    }
}