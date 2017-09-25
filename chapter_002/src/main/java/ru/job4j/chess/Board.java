package ru.job4j.chess;

/**
 * Класс Board содержит массив ячеек и набор фигур.
 * Created by Kubar on 24.09.2017.
 */
public class Board {

    private Cell[][] cells = new Cell[8][8];
    private Figure[] figures = new Figure[1];

    /**
     * Добавляем на поле фигуры с именем и начальной позицией.
     */
    private void fillFigure(){
        this.figures[0] = new Bishop("Bishop", cells[3][3]);
    }

    /**
     * Фигура 'Слон'
     */
    private class Bishop extends Figure {
        Bishop(String name, Cell position) {
            super(name, position);
            System.out.println("Создание " + this.info());
        }

        /**
         * Метод должен работать так:
         * Если фигура может туда пойти. то Вернуть массив ячеек. которые должна пройти фигура.
         * Если фигура туда пойти не может. выбросить исключение ImposibleMoveException.
         *
         * @param dist - задают ячейку куда следует пойти.
         */

        public Cell[] way(Cell dist) {

            int x0 = this.position.getHorisontal();
            int y0 = this.position.getVertical();
            int x1 = dist.getHorisontal();
            int y1 = dist.getVertical();

            // вправо-вверх
            if ((x1 > x0)&&(y1 > y0)){
                //сделать шаг
                x0++;
                y0++;
                System.out.println("x0 = " + x0 + "; y0 = " + y0 + ";");
            }

            // вправо-вниз
            if ((x1 > x0)&&(y1 < y0)){
                x0++;
                y0--;
                System.out.println("x0 = " + x0 + "; y0 = " + y0 + ";");
            }

            //влево-вверх
            if ((x1 < x0)&&(y1 > y0)){
                x0--;
                y0++;
                System.out.println("x0 = " + x0 + "; y0 = " + y0 + ";");
            }

            //влево-вниз
            if ((x1 < x0)&&(y1 < y0)){
                x0--;
                y0--;
                System.out.println("x0 = " + x0 + "; y0 = " + y0 + ";");
            }

            return new Cell[]{new Cell(x0, y0)};
        }

    }

    /**
     * Метод заполняет доску ячейками, присваивая каждой координаты [char][int].
     */
    public void fillBoard(){

        for (int j = 0; j < 8; j++){
            for (int i = 0; i < 8; i++){
                this.cells[i][j] = new Cell(i, j);
                System.out.println(this.cells[i][j]);
            }
        }
    }

    /**
     * Метод должен должен проверить:
     *
     * @param source - ячейка первоначального положения.
     * @param dist - ячейка назначения.
     * @return - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
//     * @throws ImpossibleMoveException - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
//     * @throws OccupiedWayException - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
//     * @throws FigureNotFoundException - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     */
    public void move(Cell source, Cell dist) {

        figures[0].clone(dist);
        //return true;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.fillBoard();
        board.fillFigure();
        board.figures[0].way(board.cells[2][2]);
        System.out.println(board.figures[0].info());
        board.move(board.cells[3][3] , board.cells[2][2]);
        System.out.println(board.figures[0].info());
    }
}
