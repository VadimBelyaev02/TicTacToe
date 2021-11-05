package com.google.game;

import com.google.exception.ThePointIsBusyException;
import com.google.exception.PointIsOutOfGameBoundsException;
import com.google.player.Machine;
import com.google.player.Person;
import com.google.player.Player;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {

    private Field field;
    private Player firstPlayer;
    private Player secondPlayer;

    public Game() {
        init();
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        isCorrect = true;
        Figure firstFigure = Figure.CROSS;
        Figure secondFigure = Figure.ZERO;

        System.out.print("Enter the first player's name: ");
        String firstName = scanner.next();
        System.out.print("Enter the second player's name: ");
        String secondName = scanner.next();

        do {

            System.out.println("Would you like to play with a real player or with a machine?");
            System.out.println("1 - alive");
            System.out.println("2 - machine");
            int yourOpponent;
            try {
                yourOpponent = scanner.nextInt();
            } catch (InputMismatchException exception) {
                isCorrect = false;
                scanner.next();
                continue;
            }
            if (yourOpponent == 1) {
                secondPlayer = new Person(secondName, secondFigure);
            } else if (yourOpponent == 2) {
                secondPlayer = new Machine(secondName,secondFigure);
            } else {
                isCorrect = false;
            }

            firstPlayer = new Person(firstName, firstFigure);
            field = new Field();
        } while (!isCorrect);
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
        char winSymbol = ' ';
        for (int i = 0; i < field.getFieldSize(); i++) {
            if (field.getCell(0, i) == field.getCell(1, i) && field.getCell(0, i) == field.getCell(2, i)) {
                winSymbol = field.getCell(0, i);
                break;
            }
            if (field.getCell(i, 0) == field.getCell(i, 1) && field.getCell(i, 0) == field.getCell(i, 2)) {
                winSymbol = field.getCell(i, 0);
                break;
            }
        }

        if (field.getCell(0, 0) == field.getCell(1, 1) && field.getCell(0, 0) == field.getCell(2, 2)) {
            winSymbol = field.getCell(0, 0);
        }

        if (field.getCell(0, 2) == field.getCell(1, 1) && field.getCell(0, 2) == field.getCell(2, 0)) {
            winSymbol = field.getCell(0, 2);
        }

        if (winSymbol == firstPlayer.getTypeOfFigure().getSymbol()) {
            System.out.println(firstPlayer.getName() + " is winner!");
            return true;
        }

        if (winSymbol == secondPlayer.getTypeOfFigure().getSymbol()){
            System.out.println(secondPlayer.getName() + " is winner!");
            return true;
        }

        if (field.getCountOfEmptyCells() == 0) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}
