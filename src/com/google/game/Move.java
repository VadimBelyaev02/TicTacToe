package com.google.game;

public class Move {

    private int x;
    private int y;
    private Figure typeOfFigure;

    public Move(Figure typeOfFigure) {
        this.typeOfFigure = typeOfFigure;
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
        this.typeOfFigure = figureOfFigure;
    }

    public Figure getTypeOfFigure() {
        return typeOfFigure;
    }
}
