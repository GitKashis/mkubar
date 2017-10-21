package ru.job4j.chess;

import ru.job4j.chess.figures.Figure;

/**
 * Класс описывает клетку на доске.
 */
public class Cell {
    /**
     * X - координаты по вертикали.
     */
    private int positionX;
    /**
     * Y координаты по горизонтали.
     */
    private int positionY;

    private Figure figure = null;
    private Board board = null;

    /**
     * Конструктор.
     * @param positionX - X - по вертикали.
     * @param positionY -  Y cпо горизонтали.
     * @param board - Board.
     */
    public Cell(int positionX, int positionY, Board board) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.board = board;
    }

    public int[] getPosition() {
        return new int[]{this.positionX, this.positionY};
    }

    public Figure getFigure() {
        return this.figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Board getBoard() {
        return this.board;
    }
}
