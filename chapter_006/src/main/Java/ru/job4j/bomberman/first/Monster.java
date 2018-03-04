package ru.job4j.bomberman.first;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class Monster implements Runnable {

    private ExecutorService es;

    private ReentrantLock[][] gameBoard;

    private int positionX;
    private int positionY;

    public Monster(ExecutorService es, ReentrantLock[][] gameBoard) {
        this.es = es;
        this.gameBoard = gameBoard;
        this.positionX = this.gameBoard.length - 1;
        this.positionY = this.gameBoard[0].length - 1;
        es.execute(this);
    }

    private void moveMonster() {
        Random random = new Random();
        ReentrantLock lock;
        while (!this.es.isShutdown()) {
            int nextX = this.positionX;
            int nextY = this.positionY;
            if (random.nextBoolean()) {
                if (random.nextBoolean()) {
                    if (nextX - 1 > -1) {
                        nextX--;
                        lock = this.gameBoard[nextX][nextY];
                        if (lock.tryLock()) {
                            this.positionX = nextX;
                            lock.unlock();
                        }
                    }
                } else {
                    if (nextX + 1 < this.gameBoard[0].length) {
                        nextX++;
                        lock = this.gameBoard[nextX][nextY];
                        if (lock.tryLock()) {
                            this.positionX = nextX;
                            lock.unlock();
                        }
                    }
                }
            } else {
                if (random.nextBoolean()) {
                    if (nextY - 1 > -1) {
                        nextY--;
                        lock = this.gameBoard[nextX][nextY];
                        if (lock.tryLock()) {
                            this.positionY = nextY;
                            lock.unlock();
                        }
                    }
                } else {
                    if (nextY + 1 < this.gameBoard.length) {
                        nextY++;
                        lock = this.gameBoard[nextX][nextY];
                        if (lock.tryLock()) {
                            this.positionY = nextY;
                            lock.unlock();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        this.moveMonster();
    }
}