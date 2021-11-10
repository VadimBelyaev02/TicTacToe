package com.google.player;

import com.google.game.GameField;
import com.google.game.Figure;
import com.google.game.Move;

import java.util.Random;

public class Machine implements Player {

    private final Figure typeOfFigure;
    private String name;
    private Move move;

    public Machine(String name, Figure typeOfFigure) {
        this.name = name;
        this.typeOfFigure = typeOfFigure;
        this.move = new Move(typeOfFigure);
    }

    @Override
    public void makeMove(GameField field) {
        Random random = new Random();
        move.setX(random.nextInt(field.getFieldSize()));
        move.setY(random.nextInt(field.getFieldSize()));
        field.addSymbol(move);
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
