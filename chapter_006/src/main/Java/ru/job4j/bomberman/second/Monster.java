package ru.job4j.bomberman.second;

import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Monster extends Cell implements Runnable {

    /**
     * Random object.
     */
    private static Random random = new Random();

    private String name = "Monster";

    private final Cell[][] gameBoard;

    private final ExecutorService es;

    /**
     * Construct to start position in board.
     */
    public Monster(final Cell[][] gameBoard, final ExecutorService es) {
        this.gameBoard = gameBoard;
        this.setCell(this);
        setPositionX(this.gameBoard.length - 1);
        setPositionY(this.gameBoard[0].length - 1);
        this.es = es;
        this.es.submit(this);
    }

    /**
     * Next step.
     * @return int
     */
    private boolean getNextStep() {
        return Monster.random.nextBoolean();
    }

    @Override
    public void run() {
        while (this.gameBoard[this.getPositionX()][this.getPositionY()].getCell() == null) {
            if (this.gameBoard[this.getPositionX()][this.getPositionY()].setCell(this)) {
                break;
            }
        }
        while (GameBoard.gameWorck) {
            int nextX = this.getPositionX();
            int nextY = this.getPositionY();
            if (this.getNextStep()) {
                if (this.getNextStep()) {
                    if (this.getPositionX() + 1 < this.gameBoard.length) {
                        nextX++;
                    }
                } else {
                    if (this.getPositionX() - 1 > -1) {
                        nextX--;
                    }
                }
            } else {
                if (this.getNextStep()) {
                    if (this.getPositionY() + 1 < this.gameBoard[0].length) {
                        nextY++;
                    }
                } else {
                    if (this.getPositionY() - 1 > -1) {
                        nextY--;
                    }
                }
            }
            if (gameBoard[nextX][nextY].getCell() == null) {
                if (gameBoard[nextX][nextY].setCell(this) && gameBoard[this.getPositionX()][this.getPositionY()].setCell(null)) {
                    this.setPositionX(nextX);
                    this.setPositionY(nextY);
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!GameBoard.gameWorck) {
            es.execute(this);
        }
    }

    @Override
    public String toString() {
        return String.valueOf((char) 9927);
    }
}
