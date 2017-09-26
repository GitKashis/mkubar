package ru.job4j.chess;
import ru.job4j.chess.MoveExceptions.*;

/**
 * Абстрактный класс Figure, определяет движение фигуры и её положение на поле.
 * Created by Kubar on 24.09.2017.
 */
abstract class Figure {
    final Cell position;
    private final String name;

    /**
     * Конструктор создает фигуру на указанной позиции.
     * @param position - текущая позиция фигуры.
     */
    Figure(String name, Cell position) {
        this.name = name;
        this.position = position;
        this.position.setBusy(true);
    }

    /**
     * Метод должен работать так:
     *  - Если фигура может туда пойти. то Вернуть массив ячеек, которые должна пройти фигура.
     *  - Если фигура туда пойти не может, выбросить исключение ImposibleMoveException.
     * @param dist - задают ячейку куда следует пойти.
     */
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

    /**
     * Метод перезаписывает собственные координаты фигуры.
     * @param dist - клетка назначения.
     */
    void clone(Cell dist){
        this.position.setHorisontal(dist.getHorisontal());
        this.position.setVertical(dist.getVertical());
    }
}
