package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.MoveExceptions.FigureNotFoundException;
import ru.job4j.chess.MoveExceptions.ImposibleMoveException;
import ru.job4j.chess.MoveExceptions.OccupiedWayException;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование методов way(), move(), исключений Exception.
 * Created by Kubar on 27.09.2017.
 */
public class BoardTest {

    /**
     * проверим, что фигура 'Слон' получает путь, в соответствии с которым должна делать ходы.
     */
    @Test
    public void testWay() throws ImposibleMoveException {
        // инициализация
        Board board = new Board();
        // рисуем клетки
        board.fillBoard();
        // расставляем фигуры
        board.fillFigure();
        board.figures[0].position.setHorisontal(0);
        board.figures[0].position.setVertical(0);

        // полученный результат
        Cell[] resultArray = board.figures[0].way(board.cells[2][2]);
        // ожидаемый результат
        Cell[] expectArray = new Cell[]{board.cells[0][0], board.cells[1][1], board.cells[2][2]};
        // сравниваем
        boolean result = isContainsAll(resultArray, expectArray);
        assertThat(result, is(true));
    }

    /**
     * Вспомогательный метод для проверки равенства массивов не учитывая их порядок (аналог коллекции Set).
     *
     * @return true если все элементы target принадлежат source.
     */
    private boolean isContainsAll(Cell[] source, Cell[] target) {
        boolean result = false;
        for (Cell cells : target) {
            if (!Arrays.asList(source).contains(cells)) {
                result = false;
                break;
            } else result = true;
        }

        return result;
    }

    /**
     * Тестирование исключения "Сюда нельзя ходить".
     *
     * throws ImposibleMoveException.
     */
    @Test(expected = ImposibleMoveException.class)
    public void testWrongWay() throws ImposibleMoveException {
        // инициализация
        Board board = new Board();
        // рисуем клетки
        board.fillBoard();
        // расставляем фигуры
        board.fillFigure();
        // полученный результат
        board.figures[0].way(board.cells[2][1]);
    }

    /**
     * Тестирование исключения "Фигура не найдена.".
     *
     * throws FigureNotFoundException.
     */
    @Test(expected = FigureNotFoundException.class)
    public void testMoveIsEmpty() throws FigureNotFoundException, ImposibleMoveException, OccupiedWayException {
        // инициализация
        Board board = new Board();
        // рисуем клетки
        board.fillBoard();
        // расставляем фигуры
        board.fillFigure();
        // полученный результат
        board.figures[0].way(board.cells[2][2]);
        board.move(board.cells[1][2], board.cells[2][2]);
    }

    /**
     * Тестирование исключения "Путь занят фигурами".
     *
     * @throws OccupiedWayException.
     */
    @Test(expected = OccupiedWayException.class)
    public void testOccupiedWay() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveException {
        // инициализация
        Board board = new Board();
        // рисуем клетки
        board.fillBoard();
        // расставляем фигуры
        board.fillFigure();
        // полученный результат
        board.figures[0].way(board.cells[2][2]);
        board.cells[1][1].setBusy(true);
        board.move(board.cells[0][0], board.cells[2][2]);
    }
}