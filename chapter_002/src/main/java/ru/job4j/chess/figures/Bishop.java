package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.chessexeptions.ImpossibleMoveException;

/**
 * Фигура Слон'.
 */
public class Bishop extends Figure {

    /**
     * Конструктор.
     * @param position - позиция фигуры на доске.
     */
    public Bishop(Cell position) {
        super(position);
        position.setFigure(this);
    }

    /**
     * Метод проверки возможных ходов для фигуры
     * .
     * @param dist - клетка назначения.
     * @return Cell[].
     * @throws ImpossibleMoveException - если фигура не может пойти на эту клетку.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        // текущая позиция
        int thisX = this.getCell().getPosition()[0];
        int thisY = this.getCell().getPosition()[1];

        // клетка назначения.
        int distX = dist.getPosition()[0];
        int distY = dist.getPosition()[1];

        Cell[] cells;

        // если клетка назначения принадлежит диагоналям, то считаем ячейки,
        // иначе генерируем исключение.
        if (Math.abs(thisX - distX) == Math.abs(thisY - distY)) {

            cells = new Cell[Math.abs(thisX - distX)];
            int deltaX = Math.abs(distX - thisX) / (distX - thisX);
            int deltaY = Math.abs(distY - thisY) / (distY - thisY);

            int i = 0;
            int startX = thisX + deltaX;
            int startY = thisY + deltaY;

            while (startX != distX + deltaX) {
                cells[i++] = new Cell(startX, startY);
                startX += deltaX;
                startY += deltaY;
            }

        } else {
            throw new ImpossibleMoveException();
        }
        return cells;
    }
}
