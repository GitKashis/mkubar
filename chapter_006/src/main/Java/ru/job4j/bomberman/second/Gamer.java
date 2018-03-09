package ru.job4j.bomberman.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;

public class Gamer extends Cell implements Runnable{

    private String name;

    private Cell[][] gameBoard;

    private ExecutorService es;

    /**
     * Orders object.
     */
    private Cell cell;

    /**
     * Constructor.
     * @param nickName name gamer
     * @param gameBoard game board
     * @param es ExecutorService
     */
    public Gamer(String nickName, Cell[][] gameBoard, ExecutorService es) {
        this.name = nickName;
        this.gameBoard = gameBoard;
        this.es = es;
        this.cell = this;
        this.gameBoard[0][0] = this;
        this.es.submit(this);
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (GameBoard.gameWorck) {
            String command = "";
            int nextCellX = this.getPositionX();
            int nextCellY = this.getPositionY();
            do {
                try {
                    command = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (this.checkInput(command));
            if (command.equals("a") && this.getPositionX() - 1 > -1) {
                nextCellX = this.getPositionX() - 1;
            }
            if (command.equals("d") && this.getPositionX() + 1 < this.gameBoard.length) {
                nextCellX = this.getPositionX() + 1;
            }
            if (command.equals("w") && this.getPositionY() - 1 > -1) {
                nextCellY = this.getPositionY() - 1;
            }
            if (command.equals("s") && this.getPositionY() + 1 < this.gameBoard[0].length) {
                nextCellY = this.getPositionY() + 1;
            }
            if (gameBoard[nextCellX][nextCellY].getCell() == null) {
                Cell tmp = gameBoard[nextCellX][nextCellY];
                if (gameBoard[nextCellX][nextCellY].setCell(this)) {
                    gameBoard[this.getPositionX()][this.getPositionY()] = tmp;
                    this.setPositionX(nextCellX);
                    this.setPositionY(nextCellY);
                }
            }
        }
        es.execute(this);
    }

    /**
     * Check input to move.
     * @param command input
     * @return yes or not
     */
    private boolean checkInput(String command) {
        if (command.equals("w") | command.equals("d") | command.equals("s") | command.equals("a")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.valueOf((char) 9977);
    }
}
