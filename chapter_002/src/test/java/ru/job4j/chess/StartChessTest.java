package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.chessexeptions.*;
import ru.job4j.chess.figures.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartChessTest {
    /**
     * Test moving from E3 to A7.
     */
    @Test
    public void whenMoveElephantFromE3ToA7ThenItMoved() {
        Board board = new Board();
        Figure bishop = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(0, 6));

        assertThat(result, is(expected));
    }
    /**
     * Test moving from E3 to H6.
     */
    @Test
    public void whenMoveElephantFromE3ToH6ThenItMoved() {
        Board board = new Board();
        Figure bishop = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(7, 5));

        assertThat(result, is(expected));
    }
    /**
     * Test moving from E3 to G1.
     */
    @Test
    public void whenMoveElephantFromE3ToG1ThenItMoved() {
        Board board = new Board();
        Figure bishop = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(6, 0));

        assertThat(result, is(expected));
    }
    /**
     * Test moving from E3 to C1.
     */
    @Test
    public void whenMoveElephantFromE3ToC1ThenItMoved() {
        Board board = new Board();
        Figure bishop = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop);
        boolean expected = true;
        boolean result = board.move(board.getCell(4, 2), board.getCell(2, 0));

        assertThat(result, is(expected));
    }

    /**
     * Test FigureNotFoundException.
     */
    @Test(expected = FigureNotFoundException.class)
    public void figureNotFound() {
        Board board = new Board();
        Figure bishop = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop);
        board.move(board.getCell(4, 0), board.getCell(2, 0));
    }

    /**
     * Если клетка назначения не на пути движения фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void wrongWayMove() {
        Board board = new Board();
        Figure bishop = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop);
        board.move(board.getCell(4, 2), board.getCell(4, 4));
    }

    /**
     * Если ячейка уже занята?.
     */
    @Test(expected = OccupiedWayException.class)
    public void moveToOccupedcell() {
        Board board = new Board();
        Figure bishop1 = new Bishop(board.getCell(0, 0));
        Figure bishop2 = new Bishop(board.getCell(4, 2));
        board.addFigure(bishop1);
        board.addFigure(bishop2);
        board.move(board.getCell(0, 0), board.getCell(2, 2));
        board.move(board.getCell(4, 2), board.getCell(3, 3));

        board.move(board.getCell(3, 3), board.getCell(1, 1));


    }
}
