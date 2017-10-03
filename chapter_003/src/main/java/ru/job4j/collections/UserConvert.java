package ru.job4j.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.*;

/**
 * Преобразования List в Map. [#10093]
 * Created by Kubar on 02.10.2017.
 */
class User {
    private String name, city;
    private int age;

    User(String name, String city) {
        this.name = name;
        this.city = city;
    }

    User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return format("User: %s, age %s.", name, age);
    }

    int getAge() {
        return age;
    }
}



public class UserConvert{

    private static HashMap<Integer, User> process(List<User> list) {

    return (HashMap<Integer, User>) IntStream.range(0,list.size())
            .boxed()
            .collect(Collectors.toMap (i -> i, list::get));
    }

    public static void main(String[] args) {
        List<User> persons =
                Arrays.asList(
                        new User("Andrew", "Pskov"),
                        new User("Igor", "Moscov"),
                        new User("Ira", "Tula"),
                        new User("Vitia", "Riga"));
        HashMap<Integer, User> map = process(persons);

        for (Map.Entry entry : map.entrySet())
            System.out.println(format("%s. %s.", entry.getKey(), entry.getValue()));
    }

}
