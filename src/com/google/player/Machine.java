package com.google.player;

import com.google.exception.PointIsOutOfGameBoundsException;
import com.google.exception.ThePointIsBusyException;
import com.google.game.Field;
import com.google.game.Figure;
import com.google.game.Move;

import java.util.Random;

public class Machine implements Player {

    private final Figure typeOfFigure;
    private String name;

    public Machine(String name, Figure typeOfFigure) {
        this.name = name;
        this.typeOfFigure = typeOfFigure;
    }

    @Override
    public void makeMove(Field field) {
        Random random = new Random();
        boolean isCorrect;
        do {
            isCorrect = true;
            int x = random.nextInt(field.getFieldSize());
            int y = random.nextInt(field.getFieldSize());
            try {
                field.addSymbol(new Move(x, y, typeOfFigure));
            } catch (PointIsOutOfGameBoundsException | ThePointIsBusyException ex) {
                isCorrect = false;
            }
        } while (!isCorrect);

        field.show();
        field.setCountOfEmptyCells(field.getCountOfEmptyCells() + 1);
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
