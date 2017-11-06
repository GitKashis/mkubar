package ru.job4j.sorting;

import java.util.Arrays;


public class ArrayLine {
    public String[] getLine() {
        return this.line;
    }

    private String[] line;

    public ArrayLine(String[] line) {
        this.line = line;
    }

    public String[] toArray(){
        return this.line;
    }

    public int getLenght(){
        return this.line.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayLine arrayLine = (ArrayLine) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(line, arrayLine.line);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(line);
    }

    @Override
    public String toString() {
        return Arrays.toString(line);
    }

}
