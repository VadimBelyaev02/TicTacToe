package com.google.player;

import com.google.game.GameField;
import com.google.game.Move;
import com.google.game.Figure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person implements Player {

    private final Figure typeOfFigure;
    private final Move move;
    private String name;

    public Person(String name, Figure typeOfFigure) {
        this.name = name;
        this.typeOfFigure = typeOfFigure;
        this.move = new Move(typeOfFigure);
    }

    @Override
    public void makeMove(GameField field) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        do {
            isCorrect = true;
            System.out.println(name + ", enter the point's coords: ");
            try {
                move.setX(scanner.nextInt());
                move.setY(scanner.nextInt());
                if (!field.isCoordsCorrect(move)) {
                    System.out.println("Incorrect!");
                    isCorrect = false;
                    continue;
                }
                field.addSymbol(move);
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect input, try again");
                scanner.next();
                isCorrect = false;
            }
        } while (!isCorrect);

        field.show();
    }

    @Override
    public Figure getTypeOfFigure() {
        return typeOfFigure;
    }

    @Override
    public String getName() {
        return name;
    }

}
