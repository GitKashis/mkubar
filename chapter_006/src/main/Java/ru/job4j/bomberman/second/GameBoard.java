package ru.job4j.bomberman.second;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameBoard {

    private final int defaultSize = 7;

    private volatile Cell[][] gameBoard;

    /**
     * Count busy cell in game board.
     */
    private int countBusyCell = 0;

    /**
     * Count cell in game board.
     */
    private int countCell = 0;

    private ExecutorService es = Executors.newCachedThreadPool();

    static volatile boolean gameWorck = true;

    private String nickNameGamer;

    /**
     * Initialize board for the game.
     * @param size boar if size not even size up +1
     */
    public GameBoard(int size, String nickName) {
        if (size > this.defaultSize) {
            if (size % 2 == 0) {
                this.gameBoard = new Cell[size + 1][size + 1];
            } else {
                this.gameBoard = new Cell[size][size];
            }
        } else {
            this.gameBoard = new Cell[defaultSize][defaultSize];
        }
        this.setBlockInBoard();
        nickNameGamer = nickName;
        this.countCell = this.gameBoard.length * this.gameBoard[0].length;
    }

    /**
     * Method initialize star board.
     */
    private void setBlockInBoard() {
        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard.length; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    this.gameBoard[i][j] = new BlockElement(i, j);
                    this.countBusyCell++;
                } else {
                    this.gameBoard[i][j] = new FieldStatus();
                }
            }
        }
    }

    /**
     * Add monsters in game board.
     */
    public void addMonsters() {
        new Gamer(this.nickNameGamer, this.gameBoard, this.es);
        while ((float)this.countBusyCell / this.countCell < 0.25F) {
            new Monster(this.gameBoard, this.es);
            countBusyCell++;
        }
    }

    /**
     * Override to wive board.
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.gameBoard[0].length; i++) {
            for (int j = 0; j < this.gameBoard.length; j++) {
                    builder.append(this.gameBoard[j][i].toString());
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }
}
