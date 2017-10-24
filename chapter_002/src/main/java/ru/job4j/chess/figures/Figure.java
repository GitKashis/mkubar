package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.chessexeptions.ImpossibleMoveException;

/**
 * Абстрактный класс для фигуры.
 */
public abstract class Figure {

    /**
     * Позиция фигуры на доске.
     */
    private final Cell position;

    /**
     * Конструктор.
     * @param position - позиция фигуры.
     */
    public Figure(Cell position) {
        this.position = position;
        this.position.setBusy(true);
    }

    /**
     * Get cell.
     * @return Cell.
     */
    public Cell getCell() {
        return position;
    }

    /**
     * Метод описывает движение фигуры.
     * @param dist - клетка назначения.
     * @return Cell[].
     * @throws ImpossibleMoveException  - если фигура не может идти на эту клетку.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Двигаем фигуру на новую позицию.
     * Старую клетку освобождаем, новую занимаем.
     * @param dist - клетка назначени.
     */
    public void clone(Cell dist) {
        position.setFigure(null);
        position.setBusy(false);
        dist.setFigure(this);
        dist.setBusy(true);
    }
}
