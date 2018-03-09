package ru.job4j.bomberman.second;

public class BlockElement extends Cell {

    private final String name = "Block";

    /**
     * start position block in board.
     * @param positionX in board
     * @param positionY in board
     */
    public BlockElement(final int positionX, final int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
        this.setCell(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf((char) 9608);
    }
}
