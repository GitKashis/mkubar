package ru.job4j.chess;

import ru.job4j.chess.chessexeptions.*;
import ru.job4j.chess.figures.Figure;

public class Board {
    /**
     * Chess board.
     */
    private Cell[][] boardField = new Cell[8][8];
    /**
     * Figure array.
     */
    private Figure[] figures = new Figure[32];

    /**
     * Constructor. Fill board by cells.
     */
    public Board() {
        fillBoardByCell();
    }

    /**
     * Move figure at the chess board.
     * @param source - cell with figure.
     * @param dist - destination cell.
     * @return boolean.
     * @throws ImpossibleMoveException - if this figure can't go to specified cell.
     * @throws OccupiedWayException - if specified cell is occupied.
     * @throws FigureNotFoundException - if at specified cell there isn't figure.
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        if (source.getFigure() == null) {
            throw new FigureNotFoundException();
        }
        Figure figure = source.getFigure();
        Cell[] figureWay = figure.way(dist);

        if (figureWay == null) {
            throw new ImpossibleMoveException();
        }

        // в результате работы метода way получено направление прохода,
        // т.е. массив чистых клеток, по координатам совпадающих с клетками на доске.
        // Сравним клетки полученого пути с клетками на доске. Если соответствующая клетка на доске будет isBusy, то
        // генерируем исключение.
        for (Cell cellFromFihureWay : figureWay) {
            Cell cellFromBoardField = boardField[cellFromFihureWay.getPosition()[0]][cellFromFihureWay.getPosition()[1]];
            if (!cellFromFihureWay.equals(cellFromBoardField)) {
                throw new OccupiedWayException();
            }
        }
        figure.clone(dist);
        return true;
    }

    /**
     * Add cells at chess board.
     */
    private void fillBoardByCell() {
        for (int i = 0; i < boardField.length; i++) {
            for (int j = 0; j < boardField.length; j++) {
                boardField[i][j] = new Cell(i, j);
            }
        }
    }

    /**
     * Return specified cell.
     * @param positionX - x coordinate(numbers at chess).
     * @param positionY - y coordinate(letters at chess board).
     * @return Cell.
     */
    public Cell getCell(int positionX, int positionY) {
        return this.boardField[positionX][positionY];
    }

    /**
     * Add figure at array.
     * @param figure - figure.
     */
    public void addFigure(Figure figure) {
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                break;
            }
        }
    }
}
