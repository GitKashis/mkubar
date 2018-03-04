package ru.job4j.bomberman.first;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class GameBoard {

    private ReentrantLock[][] gameBoard;

    private ExecutorService es = Executors.newFixedThreadPool(2);

    public GameBoard(int size) {
        this.gameBoard = new ReentrantLock[size][size];

        for (int i = 0; i < this.gameBoard.length; i++) {
            for (int j = 0; j < this.gameBoard[0].length; j++) {
                this.gameBoard[i][j] = new ReentrantLock();
            }
        }
        addMonsterInGame();
    }

    private void addMonsterInGame() {
        new Monster(this.es, this.gameBoard);
    }

    public void exitGame() {
        es.shutdown();
    }

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(20);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameBoard.exitGame();
    }
}
