package ru.job4j.chess.figure;

import ru.job4j.chess.Cell;
import ru.job4j.chess.Figure;

import static ru.job4j.chess.Board.BOARD_SIZE;

/**
 * Created by Kubar on 24.09.2017.
 */
class Bishop extends Figure {

    /**
     * Конструктор создает фигуру на указанной позиции.
     *
     * @param position
     */
    Bishop(Cell position) {
        super(position);
    }

//    void toMove(Cell position) {
//        for (int X = 0; X < BOARD_SIZE; X++)
//            for (int Y = 0; Y < BOARD_SIZE; Y++) {
//                int i = 0; // переменная для перемещения влево-вправо от положения фигуры
//                while ((X + i) > BOARD_SIZE + 8) {
//                    X = X + 1;
//                    board[X][Y] = FireWhiteBlack;
//                    i++;
//                }
//                while ((X - i) < BOARD_SIZE) {
//                    X = X - 1;
//                    board[X][Y] = FireWhiteBlack;
//                    i++;
//                }
//            }
//    }
}

