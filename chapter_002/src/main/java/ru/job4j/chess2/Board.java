package ru.job4j.chess2;

import ru.job4j.chess2.chessexeptions.*;
import ru.job4j.chess2.figures.Figure;

public class Board {

    /**
     * Figure array.
     */
    private Figure[] figures = new Figure[32];

    /**
     * Move figure at the chess board.
     *
     * @param source - клетка с фигурой.
     * @param dist   - клетка назначения.
     * @return boolean.
     * @throws ImpossibleMoveException - iфигура не может сюда ходить.
     * @throws OccupiedWayException    - клетка назначения уже занята.
     * @throws FigureNotFoundException - фигура не найдена.
     */
    public boolean moveAnyFigure(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        // определим фигуру, которая находится в точке source, для этого
        // у каждой фигуры из массива фигур опросим позицию. Если никто не откликнулся - генерируем исключение NotFound.
        // k - индекс фигуры в массиве.
        int k;
        for (k = 0; k < figures.length; k++) {
            if ((figures[k] != null) && (source.equals(figures[k].getPosition()))) {
                break;
            }
        }
        // Никого не нашли? Исключение!
        if (k == figures.length) {
            throw new FigureNotFoundException();
        }

        // фигуру нашли.
        // Проверим, может ли она пойти из точки source в точку dist. За это отвечает метод way.

        Cell[] figureWay = figures[k].way(dist);

        if (figureWay == null) {
            throw new ImpossibleMoveException();
        }

        // в результате работы метода way получено направление прохода,
        // т.е. массив чистых клеток, по координатам совпадающим с клетками на доске.
        // Сравним клетки полученого пути с клетками на доске. Для этого для каждой клетки массива way
        // опросим координаты всех фигур.

        for (Cell aFigureWay : figureWay) {
            for (Figure figure : figures) {
                if ((figure != null) && (aFigureWay.equals(figure.getPosition()))) {
                    throw new OccupiedWayException();
                }
            }
        }

        // Путь на доске чист. Двигаем фигуру.

        figures[k].setPosition(dist);
        return true;
    }

    /**
     * Add figure at array.
     *
     * @param figure - figure.
     */
    public void addFigure(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                break;
            }
        }
    }
}
