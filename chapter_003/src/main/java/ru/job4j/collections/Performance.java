package ru.job4j.collections;

import java.util.*;

import static java.lang.String.*;

/*
 * Написать программу, которая замеряет время вставки в коллекцию большого количества
 * случайных строк и удаления в коллекции первых n элементов для:
 * LinkedList
 * ArrayList
 * TreeSet
*/

public class Performance {
    private static final int amount = 300000;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println(format("1. ArrayList insert: %sms. ", add(new ArrayList(), amount)));
        System.out.println(format("2. LinkedList insert: %sms. ", add(new LinkedList(), amount)));
        System.out.println(format("3. TreeSet insert: %sms. ", add(new TreeSet(), amount)));

        System.out.println(format("4. ArrayList delete: %sms. ", delete(new ArrayList(), amount)));
        System.out.println(format("5. LinkedList delete: %sms. ", delete(new LinkedList(), amount)));
        System.out.println(format("6. TreeSet delete: %sms. ", delete(new TreeSet(), amount)));
    }

    private static long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        long finish = System.currentTimeMillis();
        return (finish - start);
    }

    private static long delete(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.remove(Integer.toString(i));
        }
        long finish = System.currentTimeMillis();
        return (finish - start);
    }
}
