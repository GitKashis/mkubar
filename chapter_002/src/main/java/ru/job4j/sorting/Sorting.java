package ru.job4j.sorting;

import java.util.*;

public class Sorting {

    public List<ArrayLine> convertToList(String[] source){
        List<ArrayLine> out = new ArrayList<>();

        for (String aSource : source) {
            ArrayLine arrayLine = new ArrayLine(aSource.split("/"));
            out.add(arrayLine);
        }
        return out;
    }

    public List<ArrayLine> checkAndAdd(List<ArrayLine> list){

        List<ArrayLine> out = new ArrayList<>();

        Iterator<ArrayLine> it = list.listIterator();
        while (it.hasNext()){
            ArrayLine str = it.next();
            out.add(str);
            ArrayLine subLine = new ArrayLine(Arrays.copyOfRange(str.toArray(), 0, str.toArray().length - 1));
            if((str.toArray().length > 1)&&(!(list.contains(subLine)))) out.add(subLine);
            }
        HashSet<ArrayLine> hs = new HashSet<>(out);
        return new ArrayList<>(hs);
}

    public List<ArrayLine> sort(List<ArrayLine> list){

        Comparator<ArrayLine> pcomp = new firstComp().thenComparing(new lengthComp()).thenComparing(new twoComp());
        Collections.sort(list, pcomp);

    return list;
    }

    class firstComp implements Comparator<ArrayLine>{

        public int compare(ArrayLine o1, ArrayLine o2) {
            int compValue = o1.toArray()[0].compareTo( o2.toArray()[0]);
            return compValue;
        }
    }

    class twoComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            int compareValue = o1.toArray().length - (o2.toArray().length);
            if (o1.getLenght() < 1) return -1;
               else if (o1.toArray()[1] == (o2.toArray()[1]))
                        return compareValue;
               return compareValue;
        }
    }

    class threeComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            if (o1.getLenght() < o2.getLenght()) return - 1;
                else
                        return o1.toArray()[2].compareTo( o2.toArray()[2]);
        }
    }

    class lengthComp implements Comparator<ArrayLine>{
        public int compare(ArrayLine o1, ArrayLine o2) {
            return o1.toArray().length - (o2.toArray().length);
        }
    }
}
