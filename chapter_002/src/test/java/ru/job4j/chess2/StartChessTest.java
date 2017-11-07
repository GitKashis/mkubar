package ru.job4j.chess2;

import org.junit.Test;
import ru.job4j.chess2.chessexeptions.*;
import ru.job4j.chess2.figures.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartChessTest {
    /**
     * Test moving from E3 to A7.
     */
    @Test
    public void whenMoveElephantFromE3ToA7ThenItMoved() {
        Board board = new Board();
        board.addFigure(new Bishop(4, 2));

        boolean result = board.moveAnyFigure(new Cell(4, 2), new Cell(0, 6));

        assertThat(result, is(true));
    }

    /**
     * Test moving from E3 to H6.
     */
    @Test
    public void whenMoveElephantFromE3ToH6ThenItMoved() {
        Board board = new Board();
        board.addFigure(new Bishop(4, 2));

        boolean result = board.moveAnyFigure(new Cell(4, 2), new Cell(7, 5));

        assertThat(result, is(true));
    }

    /**
     * Test moving from E3 to G1.
     */
    @Test
    public void whenMoveElephantFromE3ToG1ThenItMoved() {
        Board board = new Board();
        board.addFigure(new Bishop(4, 2));

        boolean result = board.moveAnyFigure(new Cell(4, 2), new Cell(6, 0));

        assertThat(result, is(true));
    }

    /**
     * Test moving from E3 to C1.
     */
    @Test
    public void whenMoveElephantFromE3ToC1ThenItMoved() {
        Board board = new Board();
        board.addFigure(new Bishop(4, 2));

        boolean result = board.moveAnyFigure(new Cell(4, 2), new Cell(2, 0));

        assertThat(result, is(true));
    }

    /**
     * Test FigureNotFoundException.
     */
    @Test(expected = FigureNotFoundException.class)
    public void figureNotFound() {
        Board board = new Board();
        board.addFigure(new Bishop(4, 2));

        board.moveAnyFigure(new Cell(4, 0), new Cell(2, 0));
    }

    /**
     * Если клетка назначения не на пути движения фигуры.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void wrongWayMove() {
        Board board = new Board();
        board.addFigure(new Bishop(4, 2));

        board.moveAnyFigure(new Cell(4, 2), new Cell(4, 4));
    }

    /**
     * Если ячейка уже занята?.
     */
    @Test(expected = OccupiedWayException.class)
    public void moveToOccupedcell() {
        Board board = new Board();
        board.addFigure(new Bishop(0, 0));
        board.addFigure(new Bishop(4, 2));

        board.moveAnyFigure(new Cell(0, 0), new Cell(3, 3));
        board.moveAnyFigure(new Cell(4, 2), new Cell(3, 3));
    }

}
