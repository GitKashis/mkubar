package ru.job4j.Bank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StartUI {
    private Map<User, List<Account>> users = new HashMap<>();

    private void addUser(User user) {
        //для нового юзера создаем счет по реквизитам
        List<Account> aList = new LinkedList<>();
        Account account = new Account("requisites0");
        aList.add(account);
        users.put(user, aList);
    }
    public void deleteUser(User user) {
        users.remove(user);
    }

    List<Account> getUserAccounts (User user) {
        return users.get(user);
    }
    public static void main(String[] args) {
        StartUI stage = new StartUI();
        stage.addUser(new User("Petr", "passport"));
        stage.addUser(new User("Ivan", "passport"));
        User Mary = new User("Mary", "passport");
        Account mAccount = new Account("requisites1");
        stage.addUser(Mary);
        stage.addAccountToUser(Mary, mAccount);
        stage.users.forEach((key,value) -> System.out.println(key + " :" + value));
        System.out.println(stage.getUserAccounts(Mary));
        stage.deleteUser(Mary);
        stage.users.forEach((key,value) -> System.out.println(key + " :" + value));
    }

    void addAccountToUser(User user, Account account) {
        users.get(user).add(account);
    }


}
