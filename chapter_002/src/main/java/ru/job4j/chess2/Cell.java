package ru.job4j.chess2;

/**
 * Класс описывает клетку на доске.
 */
public class Cell {
    /**
     * X - координаты по вертикали.
     */
    private int posX;
    /**
     * Y координаты по горизонтали.
     */
    private int posY;

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        return posX == cell.posX && posY == cell.posY;
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" + "posX=" + posX + ", posY=" + posY + '}';
    }
}
