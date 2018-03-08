package ru.job4j.bomberman.first;

import org.junit.Test;

public class GameBoardTest {

    @Test
    public void whenCreateBoardThenIsCreated() {
        GameBoard board = new GameBoard(5);
        board.addMonsterInGame();
        board.exitGame();
    }
}