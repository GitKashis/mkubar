package ru.job4j.chess;

import ru.job4j.chess.MoveExceptions.*;

/**
 * Класс Board содержит массив ячеек, набор фигур и реализацию их ходов.
 * Created by Kubar on 24.09.2017.
 */
class Board {
    //  двумерный массив-поле.
    final Cell[][] cells = new Cell[8][8];
    Figure[] figures = new Figure[1];

    /**
     * Добавляем на поле фигуры с именем и начальной позицией.
     */
    void fillFigure() {
        this.figures[0] = new Bishop("Bishop", cells[0][0]);
    }

    /**
     * Фигура 'Слон'.
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
            Cell[] result = new Cell[Math.abs(x0 - x1) + 1];

            // проверяем, находится ли фигура на линии движения.
            if (Math.abs(x0 - x1) == Math.abs(y0 - y1)) {
                int diagonalX, diagonalY;
                int i = 0;

                if ((x0 < x1) && (y0 < y1) || (x0 > x1) && (y0 > y1))
                    do {
                        diagonalX = Math.max(x0, x1) - i;
                        diagonalY = Math.max(y0, y1) - i;
                        result[i++] = cells[diagonalX][diagonalY];
                    }
                    while ((diagonalX > Math.min(x0, x1)));

                else {
                    do {
                        diagonalX = Math.max(x0, x1) - i;
                        //меняется направление по вертикали.
                        diagonalY = Math.min(y0, y1) + i;
                        result[i++] = cells[diagonalX][diagonalY];
                    }
                    while ((diagonalX > Math.min(x0, x1)));
                }

            } // если на указанную клетку нельзя пройти, выбрасываем исключение.
            else throw new ImposibleMoveException("Сюда НЕЛЬЗЯ ходить");

            return result;
        }
    }

    /**
     * Метод заполняет доску ячейками, присваивая каждой координаты [int][int].
     */
    void fillBoard() {

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
     * ImpossibleMoveException - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     * @throws OccupiedWayException    - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     * @throws FigureNotFoundException - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     */
    boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        // проверим существование фигуры в клетке source.
        if (!source.isBusy()) {
            throw new FigureNotFoundException("Фигура не найдена");
        }

        // получим путь фигуры
        Cell[] arrayOfWay = figures[0].way(dist);

        //проверим, не заняты ли они.
        for (Cell cell : arrayOfWay) {
            // не учитываем занятой собственную позицию.
            if (cell.equals(figures[0].position)) {
                continue;
            }
            else if (cells[cell.getHorisontal()][cell.getVertical()].isBusy()) {
                throw new OccupiedWayException("Путь занят фигурами");
            }
        }
        //если исключений не произошло, переставляем фигуру.
        source.setBusy(false);
        figures[0].clone(dist);
        dist.setBusy(true);
        return true;
    }

//    public static void main(String[] args) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
//        Board board = new Board();
//        board.fillBoard();
//        board.fillFigure();
//        try {
//            // board.cells[1][1].setBusy(true);
//            board.move(board.cells[0][0], board.cells[2][2]);
//        } catch (ImposibleMoveException | OccupiedWayException | FigureNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
