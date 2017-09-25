package ru.job4j.chess;

/**
 * Created by Kubar on 24.09.2017.
 */
public abstract class Figure {

    protected boolean white;
    final Cell position;

    /**
     * Конструктор создает фигуру на указанной позиции.
     * @param position
     */
    protected Figure(Cell position) {
        this.position = position;
    }

    public Cell[] way(Cell dist) {

        return new Cell[0];
    }

}
