package ru.job4j.chess2.figures;

import ru.job4j.chess2.Cell;
import ru.job4j.chess2.chessexeptions.ImpossibleMoveException;

/**
 * Абстрактный класс для фигуры.
 */
public abstract class Figure {
    /**
     * Позиция фигуры на доске.
     */
    private Cell position;

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell pos) {
        this.position = pos;
    }


    /**
     * Конструктор.
     *
     * @param posX, posY - позиция фигуры.
     */
    public Figure(int posX, int posY) {
        this.position = new Cell(posX, posY);
    }

    /**
     * Метод описывает движение фигуры.
     *
     * @param dist - клетка назначения.
     * @return Cell[].
     * @throws ImpossibleMoveException - если фигура не может идти на эту клетку.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

}
