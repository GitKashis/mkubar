package ru.job4j.sorting;

import java.util.*;
import static java.util.Collections.reverseOrder;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;


public class Sorting {

    public static List<ArrayLine> convertToList(String[] source){
        List<ArrayLine> out = new ArrayList<>();

        for (String aSource : source) {
            ArrayLine arrayLine = new ArrayLine(aSource.split("/"));
            out.add(arrayLine);
        }
        return out;
    }

    public static List<ArrayLine> checkAndAdd(List<ArrayLine> list){

        List<ArrayLine> out = new ArrayList<>();

        Iterator<ArrayLine> it = list.listIterator();
        while (it.hasNext()){
            ArrayLine str = it.next();
            out.add(str);
            ArrayLine subLine = new ArrayLine(Arrays.copyOfRange(str.toArray(), 0, str.toArray().length - 1));
            if((str.toArray().length > 1)&&(!(list.contains(subLine)))) out.add(subLine);
            }
        HashSet<ArrayLine> hs = new HashSet<>(out);
        return hs.stream().collect(toList());
}

public static List<ArrayLine> sort(List<ArrayLine> list){

Collections.sort(list);

//        return list.stream().sorted(
//                comparing(ArrayLine::toString)
//                        .thenComparing(comparing(ArrayLine::getLenght)))
//                .collect(toList());
return list;
    }
    public static void main(String[] args) {
        String[] source = new String[]{
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };

        //convertToList(source).forEach(o -> System.out.println(o.toString()));
        List<ArrayLine> out = checkAndAdd(convertToList(source));
        System.out.println("Сортировка:");
        sort(out).forEach(o -> System.out.println(o.toString()));

    }


}
