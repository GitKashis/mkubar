package ru.job4j.chess;

/**
 * Класс описывает координаты и состояние ячейки.
 * Created by Kubar on 24.09.2017.
 */
 class Cell {
    private int horisontal;
    private int vertical;
    private boolean isBusy;

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
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
    }

    @Override
    public String toString() {
        return "Cell{" + horisontal + "" + vertical +   ", isBusy=" + isBusy +'}';
    }

    public void setHorisontal(int horisontal) {
        this.horisontal = horisontal;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }
}
