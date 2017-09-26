package ru.job4j.chess;

import ru.job4j.chess.MoveExceptions.*;

/**
 * Класс Board содержит массив ячеек, набор фигур и реализацию их ходов.
 * Created by Kubar on 24.09.2017.
 */
public class Board {
    //  двумерный массив-поле.
    private final Cell[][] cells = new Cell[8][8];
    private Figure[] figures = new Figure[1];

    /**
     * Добавляем на поле фигуры с именем и начальной позицией.
     */
    private void fillFigure() {
        this.figures[0] = new Bishop("Bishop", cells[0][2]);
    }

    /**
     * Фигура 'Слон'
     */
    private class Bishop extends Figure {
        Bishop(String name, Cell position) {
            super(name, position);
        }

        /**
         * Метод должен работать так:
         * Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
         * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException.
         *
         * @param dist - задают ячейку куда следует пойти.
         */
        public Cell[] way(Cell dist) throws ImposibleMoveException {
            int x0 = this.position.getHorisontal();
            int y0 = this.position.getVertical();
            int x1 = dist.getHorisontal();
            int y1 = dist.getVertical();
            Cell[] result = new Cell[Math.abs(x0 - x1)];

            // проверяем, находится ли фигура на линии движения.
            if (Math.abs(x0 - x1) == Math.abs(y0 - y1)) {
                int diagonalX, diagonalY;
                int i = 1;

                do {
                    diagonalX = Math.max(x0, x1) - i;
                    diagonalY = Math.max(y0, y1) - i;
                    result[i - 1] = cells[diagonalX][diagonalY];
                    i++;
                }
                while (diagonalX > Math.min(x0, x1));

            } // если на указанную клетку нельзя пройти, выбрасываем исключение.
            else throw new ImposibleMoveException("Сюда НЕЛЬЗЯ ходить");

            return result;
        }
    }

    /**
     * Метод заполняет доску ячейками, присваивая каждой координаты [int][int].
     */
    private void fillBoard() {

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                this.cells[i][j] = new Cell(i, j);
            }
        }
    }

    /**
     * Метод должен должен проверить:
     *
     * @param source - ячейка первоначального положения.
     * @param dist   - ячейка назначения.
     * @return - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
     * @throws ImpossibleMoveException - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     * @throws OccupiedWayException    - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     * @throws FigureNotFoundException - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     */
    private boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        // проверим существование фигуры в клетке source.
        if (!source.isBusy()) {
            throw new FigureNotFoundException("Фигура не найдена");
        }

        // получим путь фигуры
        Cell[] arrayOfWay = figures[0].way(dist);

        //проверим, не заняты ли они.
        for (Cell cell : arrayOfWay) {
            if (cells[cell.getHorisontal()][cell.getVertical()].isBusy()) {
                throw new OccupiedWayException("Путь занят фигурами");
            }
        }
        //если исключений не произошло, переставляем фигуру.
        figures[0].clone(dist);;
        return true;
    }

//    public static void main(String[] args) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
//        Board board = new Board();
//        board.fillBoard();
//        board.fillFigure();
//    try {
//        board.move(board.cells[0][2], board.cells[2][0]);
//        }
//    catch (ImposibleMoveException | OccupiedWayException | FigureNotFoundException e) {
//        System.out.println(e.getMessage());
//        }
//    }
}
