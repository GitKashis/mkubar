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

    private void move() {
        Random random = new Random();
        int nextX = this.positionX;
        int nextY = this.positionY;
        if (random.nextBoolean()) {

            if (random.nextBoolean()) {
                if (nextX - 1 > -1) {
                    nextX--;
                    this.positionX = nextX;
                }
            } else {
                if (nextX + 1 < this.gameBoard[0].length) {
                    nextX++;
                    this.positionX = nextX;
                }
            }
        }
        else {
            if (random.nextBoolean()) {
                if (nextY - 1 > -1) {
                    nextY--;
                    this.positionY = nextY;
                }
            } else {
                if (nextY + 1 < this.gameBoard.length) {
                    nextY++;
                    this.positionY = nextY;

                }
            }
        }
    }

    private void moveMonster() {
        ReentrantLock lock = new ReentrantLock();
        while (!this.es.isShutdown()) {
            lock.tryLock();
            this.move();
            lock.unlock();
        }
    }

    @Override
    public void run() {
        this.moveMonster();
    }
}