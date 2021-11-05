package com.google.game;

public class Move {
    private int x;
    private int y;
    private Figure figureOfFigure;

    public Move(int x, int y, Figure figureOfFigure) {
        this.x = x;
        this.y = y;
        this.figureOfFigure = figureOfFigure;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setTypeOfFigure(Figure figureOfFigure) {
        this.figureOfFigure = figureOfFigure;
    }

    public Figure getTypeOfFigure() {
        return figureOfFigure;
    }
}
