package ru.job4j.collections;

import java.util.*;

/**
 * Организовать сортировку User [#10034]
 * Created by Kubar on 03.10.2017.
 */
public class SortUser {
    /**
     * Метод возвращает TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * @param list списко User
     * @return TreeSet<User>
     */
    private static Set<User> sort(List<User> list){
        Set<User> sortedSet = new TreeSet<>(Comparator.comparing(User::getAge));
        sortedSet.addAll(list);
        return sortedSet;
    }

    /**
     * Отсортировать List<User> по длине имени.
     * @param list список User
     * @return List входящий отсортированый параметр
     */
    private static List<User> sortNameLength (List<User> list){
        list.sort(Comparator.comparingInt(p -> p.getName() .length()));
        return list;
    }

    /**
     * Отсортировать List<User> по имени и возрасту.
     * @param list список User
     * @return List входящий отсортированый параметр
     */
    private static List<User> sortByAllFields(List<User> list){
        list.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));
        return list;
    }


    public static void main(String[] args) {
        List<User> persons =
                Arrays.asList(
                        new User("Andrew", 57),
                        new User("Vitia", 44),
                        new User("Igor", 25),
                        new User("Ira", 32),
                        new User("Andrew", 11),
                        new User("Vitia", 8));

        // сортировка по длине имени
        System.out.println(sortNameLength(persons));
        // сортировка по имени и возрасту
        System.out.println(sortByAllFields(persons));
    }
}
