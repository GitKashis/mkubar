package ru.job4j.bomberman.second;

public class FieldStatus extends Cell {

    private Cell cell = null;

    public FieldStatus() {
        super();
    }

    @Override
    public String toString() {
        String string;
        if (cell == null) {
            string = String.valueOf((char) 9617);
        } else {
            string = this.cell.toString();
        }
        return string;
    }
}
