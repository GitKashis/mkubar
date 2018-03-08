package ru.job4j.bomberman.second;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameBoardTest {

    /**
     * Test class GameBoard.
     */
    @Test
    public void whenCreateNewBoardThenCreateBoard() {
        GameBoard gameBoard = new GameBoard(5, "Max");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 7; j++) {
                    builder.append(String.valueOf((char) 9617));
                }
            } else {
                for (int j = 0; j < 7; j++) {
                    if (j % 2 != 0) {
                        builder.append(String.valueOf((char) 9608));
                    } else {
                        builder.append(String.valueOf((char) 9617));
                    }
                }
            }
            builder.append("\r\n");
        }
        System.out.println(gameBoard.toString());
        assertThat(builder.toString(), is(gameBoard.toString()));
    }
}