package com.google.player;

import com.google.exception.PointIsOutOfGameBoundsException;
import com.google.game.Field;
import com.google.game.Figure;

public interface Player {

    void makeMove(Field field);

    Figure getTypeOfFigure();

    String getName();
}
