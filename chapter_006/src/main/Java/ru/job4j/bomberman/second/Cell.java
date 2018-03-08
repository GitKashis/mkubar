package ru.job4j.bomberman.second;

import java.util.concurrent.locks.ReentrantLock;

public abstract class Cell {

    private int positionX;
    private int positionY;

    private Cell cell;

    private final ReentrantLock lock;

    /**
     * Default constructor.
     */
    public Cell() {
        this.lock = new ReentrantLock();
    }

    public Cell getCell() {
        return cell;
    }

    public boolean setCell(Cell cell) {
        if (lock.tryLock()) {
            this.cell = cell;
            lock.unlock();
            return true;
        } else {
            return false;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
