package ru.job4j.sorting;

import java.util.Arrays;


public class ArrayLine implements Comparable {
    public String[] getLine() {
        return line;
    }

    private String[] line;

    public ArrayLine(String[] line) {
        this.line = line;
    }

    public String[] toArray(){
        return this.line;
    }

    public Integer getLenght(){
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

//    public int compareTo(ArrayLine o2){
//        ArrayLine o1 = this;
//
//        if (o1.getLenght() > o2.getLenght()){return 1;}
//            else if (o1.getLenght() < o2.getLenght()){return -1;}
//            return 0;
//    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(line);
    }

    @Override
    public String toString() {
        return Arrays.toString(line);
    }

    @Override
    public int compareTo(Object o) {
        int compareValue =  this.toString().compareTo(o.toString());
        if (compareValue == 0) return this.toString().length() - o.toString().length();
        return compareValue;
    }
}
