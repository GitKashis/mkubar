package ru.job4j.chess;

/**
 * Класс содержит исключительные ситуации проверки ходов.
 * Created by Kubar on 24.09.2017.
 */

class MoveExceptions{

    /**
     * Проверить может ли фигура так двигаться.
     */
    static class ImposibleMoveException extends Exception {
        ImposibleMoveException(String msg) {
            super(msg);
        }
    }

    /**
     * Проверить что полученный путь не занят фигурами.
     */
    static class OccupiedWayException extends Exception{
         OccupiedWayException(String msg) {
            super(msg);
        }
    }

    /**
     * Что в заданной ячейки есть фигура.
     */
    static class FigureNotFoundException  extends Exception{
        FigureNotFoundException(String msg) {
            super(msg);
        }
    }
}

