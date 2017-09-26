package ru.job4j.chess;

/**
 * Класс описывает координаты и состояние ячейки.
 * Created by Kubar on 24.09.2017.
 */
 class Cell {
    private int horisontal;
    private int vertical;
    private boolean isBusy;

    boolean isBusy() {
        return this.isBusy;
    }

    void setBusy(boolean busy) {
        this.isBusy = busy;
    }

    int getHorisontal() {
        return horisontal;
    }

    int getVertical() {
        return vertical;
    }

    Cell(int horisontal, int vertical) {
        this.horisontal = horisontal;
        this.vertical = vertical;
        this.isBusy = false;
    }

    @Override
    public String toString() {
        return "Cell{" + horisontal + "" + vertical +   ", isBusy=" + isBusy +'}';
    }

    void setHorisontal(int horisontal) {
        this.horisontal = horisontal;
    }

    void setVertical(int vertical) {
        this.vertical = vertical;
    }
}
