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

    public static void main(String[] args) {
        List<User> persons =
                Arrays.asList(
                        new User("Andrew", 57),
                        new User("Igor", 25),
                        new User("Ira", 32),
                        new User("Vitia", 8));

        System.out.println(sort(persons));
    }
}
