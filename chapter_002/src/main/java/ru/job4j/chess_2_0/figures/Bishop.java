package ru.job4j.chess_2_0.figures;

import ru.job4j.chess_2_0.Cell;
import ru.job4j.chess_2_0.chessexeptions.ImpossibleMoveException;

/**
 * Фигура 'Слон'.
 */
public class Bishop extends Figure {

    /**
     * Конструктор.
     *
     * @param posX, posY - позиция фигуры на доске.
     */
    public Bishop(int posX, int posY) {
        super(posX, posY);

    }

    /**
     * Метод проверки возможных ходов для фигуры
     * .
     *
     * @param dist - клетка назначения.
     * @return Cell[] - клетки, по которым нужно пройти в точку назначения.
     * @throws ImpossibleMoveException - если фигура не может пойти на эту клетку.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        // текущая позиция
        int thisX = this.getPosition().getPosX();
        int thisY = this.getPosition().getPosY();

        // клетка назначения.
        int distX = dist.getPosX();
        int distY = dist.getPosY();

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
