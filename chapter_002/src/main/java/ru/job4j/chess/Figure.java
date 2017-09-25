package ru.job4j.chess;
import ru.job4j.chess.MoveExceptions;

/**
 * Абстрактный класс Figure.
 * Created by Kubar on 24.09.2017.
 */
abstract class Figure {
    final Cell position;
    final String name;

    /**
     * Конструктор создает фигуру на указанной позиции.
     * @param position - текущая позиция фигуры.
     */
    Figure(String name, Cell position) {
        this.name = name;
        this.position = position;
    }

    /**
     * Метод должен работать так:
     * Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
     * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException.
     * @param dist - задают ячейку куда следует пойти.
     */
    public abstract Cell[] way(Cell dist);

    public void clone(Cell dist){
        this.position.setHorisontal(dist.getHorisontal());
        this.position.setVertical(dist.getVertical());
    }

    /**
     * Общий метод для всех фигур.
     * @return сообщает свое местоположение
     */
    String info() {
        return "Figure " + this.name + " on position " + this.position.getHorisontal() + this.position.getVertical();
    }
}
