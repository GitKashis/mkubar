package ru.job4j.chess;

/**
 * Класс Board содержит массив ячеек и набор фигур.
 * Created by Kubar on 24.09.2017.
 */
public class Board {
    public final static int BOARD_SIZE=8;
    private Cell[][] cells = new Cell[8][8];
    Figure[] figures;

    /**
     * Метод заполняет доску ячейками, присваивая каждой координаты [char][int].
     */
    private void fillBoard(){
        final char[] alph = "abcdefgh".toCharArray();
        for (int j = 0; j < 8; j++){
            for (int i = 0; i < 8; i++){
            this.cells[i][j] = new Cell(alph[i], j + 1);
            }
        }
    }

    /**
     * Метод должен должен проверить:
     *
     * @param source - ячейка первоначального положения.
     * @param dist - ячейка назначения.
     * @return - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
     * @throws ImpossibleMoveException - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
     * @throws OccupiedWayException - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
     * @throws FigureNotFoundException - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
    //todo
        return false;
    }

    private class ImpossibleMoveException extends Exception {
    }

    private class OccupiedWayException extends Exception {
    }

    private class FigureNotFoundException extends Exception {
    }
}
