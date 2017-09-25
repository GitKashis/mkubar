package ru.job4j.chess;

/**
 * Класс описывает координаты и состояние ячейки.
 * Created by Kubar on 24.09.2017.
 */
 public class Cell {
    private char horisontal;
    private int vertical;

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    private boolean isBusy;

    public char getHorisontal() {
        return horisontal;
    }

    public int getVertical() {
        return vertical;
    }

    Cell(char horisontal, int vertical) {
        this.horisontal = horisontal;
        this.vertical = vertical;
    }

    @Override
    public String toString() {
        return "Cell{" + horisontal + "" + vertical +   ", isBusy=" + isBusy +'}';
    }
}
