package com.google.player;

import com.google.game.GameField;
import com.google.game.Figure;

public interface Player {

    void makeMove(GameField field);

    Figure getTypeOfFigure();

    String getName();
}
