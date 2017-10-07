package ru.job4j.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * todo: comment
 * Created by Kubar on 08.10.2017.
 */
public class IteratorConverterTest {

    @Test
    public void testIterators(){
        Iterator<Integer> i1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> i2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> i3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();

        Iterator<Integer> itc = IteratorConverter.iteratorConvert(i1, i2, i3);
        while (itc.hasNext()){
            System.out.print(itc.next() + ", ");
        }
//        int result = itc.next();
//        assertThat(result, is(4));
    }

}