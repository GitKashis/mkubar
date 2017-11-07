package ru.job4j.chess;

import ru.job4j.chess.figures.Figure;

/**
 * Класс описывает клетку на доске.
 */
public class Cell {
    /**
     * X - координаты по вертикали.
     */
    private int positionX;
    /**
     * Y координаты по горизонтали.
     */
    private int positionY;

    private Figure figure = null;

    private boolean busy;

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean isBusy() {
        return this.busy;
    }

    /**
     * Конструктор.
     * @param positionX - X - по вертикали.
     * @param positionY -  Y cпо горизонтали.
     */
    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.busy = false;
    }

    public int[] getPosition() {
        return new int[]{this.positionX, this.positionY};
    }

    public Figure getFigure() {
        return this.figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    // переопределяем методы для сравнения ячеек при проверке исключения OccupiedWay.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        return positionX == cell.positionX && positionY == cell.positionY && busy == cell.busy;
    }

    @Override
    public int hashCode() {
        int result = positionX;
        result = 31 * result + positionY;
        result = 31 * result + (busy ? 1 : 0);
        return result;
    }
}
