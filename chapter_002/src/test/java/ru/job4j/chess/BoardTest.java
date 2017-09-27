package ru.job4j.chess;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by Kubar on 27.09.2017.
 */
public class BoardTest {

    /**
     *
     */
    @Test
    public void testWay() throws MoveExceptions.ImposibleMoveException {
        // инициализация
        Board board = new Board();
        // рисуем клетки
        board.fillBoard();
        // расставляем фигуры
        board.fillFigure();


        // полученный результат
        Cell[] resultArray = board.figures[0].way(board.cells[1][3]);
        // ожидаемый результат
        Cell[] expectArray = new Cell[]{board.cells[1][3]};
        // сравниваем
        assertThat(resultArray, is(expectArray));
    }

}