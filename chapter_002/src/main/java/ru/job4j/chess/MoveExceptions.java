package ru.job4j.chess;

/**
 * Created by Kubar on 24.09.2017.
 */

public class MoveExceptions {

    class ImposibleMoveException extends Exception {
    }
    private class ImpossibleMoveException extends Exception {
    }

    private class OccupiedWayException extends Exception {
    }

    private class FigureNotFoundException extends Exception {
    }
}

