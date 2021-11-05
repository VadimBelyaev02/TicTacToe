package com.google.player;

import com.google.exception.PointIsOutOfGameBoundsException;
import com.google.exception.ThePointIsBusyException;
import com.google.game.Field;
import com.google.game.Move;
import com.google.game.Figure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person implements Player {

    private final Figure typeOfFigure;
    private String name;

    public Person(String name, Figure typeOfFigure) {
        this.name = name;
        this.typeOfFigure = typeOfFigure;
    }

    @Override
    public void makeMove(Field field) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        do {
            isCorrect = true;
            System.out.println(name + ", enter the point's coords: ");
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                field.addSymbol(new Move(x, y, typeOfFigure));
            } catch (PointIsOutOfGameBoundsException ex) {
                System.out.println("The point is out of bounds, try again");
                isCorrect = false;
            } catch (ThePointIsBusyException ex) {
                System.out.println("The point is busy, try again");
                isCorrect = false;
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
