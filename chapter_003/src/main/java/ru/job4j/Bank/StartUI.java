package ru.job4j.Bank;

import java.util.*;

/**
 * Задание: реализовать коллекцию Map для банка.
 */
public class StartUI {

    /**
     * Коллекция обозначает, что у каждого пользователя может быть
     * список банковских счетов.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * добавление пользователя.
     *
     * @param user
     */
    private void addUser(User user) {
        //для нового юзера создаем счет по реквизитам
        List<Account> aList = new LinkedList<>();
        users.put(user, aList);
    }

    /**
     * удаление пользователя.
     *
     * @param user
     */
    private void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * добавить счёт пользователю.
     *
     * @param user
     * @param account
     */
    private void addAccountToUser(User user, Account account) {
        users.get(user).add(account);
    }

    /**
     * получить список счетов для пользователя.
     *
     * @param user
     * @return
     */
    private List<Account> getUserAccounts(User user) {
        return users.get(user);
    }

    /**
     * метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     *
     * @param srcUser    - плательщик.
     * @param srcAccount - исходящий счет.
     * @param dstUser    - получатель.
     * @param dstAccount - счет назначение
     * @param amount     - сумма.
     * @return true/false
     */
    private boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {

        boolean result = users.containsKey(srcUser) && users.containsKey(dstUser);
        if (result) {
            Account sourceAcc = users.get(srcUser).stream().filter(p -> p.equals(srcAccount)).findAny().get();
            Account sourceDest = users.get(dstUser).stream().filter(p -> p.equals(dstAccount)).findAny().get();

            if ((sourceAcc.getValue() - amount) >= 0) {
                sourceAcc.setValue(sourceAcc.getValue() - amount);
                sourceDest.setValue(sourceAcc.getValue() + amount);
            } else result = false;
        }
        return result;
    }


//    public static void main(String[] args) {
//        StartUI stage = new StartUI();
//
//        User mary = new User("Mary", "passport");
//        Account maryAcc1 = new Account("maryAcc1");
//        stage.addUser(mary);
//        stage.addAccountToUser(mary, maryAcc1);
//
//        User petr = new User("Petr", "passport");
//        Account petrAcc1 = new Account("petrAcc1");
//        Account petrAcc2 = new Account("petrAcc2");
//        stage.addUser(petr);
//        stage.addAccountToUser(petr, petrAcc1);
//        stage.addAccountToUser(petr, petrAcc2);
//
//        User ivan = new User("Ivan", "passport");
//        Account ivanAcc1 = new Account("ivanAcc1");
//        Account ivanAcc2 = new Account("ivanAcc2");
//        stage.addUser(ivan);
//        stage.addAccountToUser(ivan, ivanAcc1);
//        stage.addAccountToUser(ivan, ivanAcc2);
//
//        stage.users.forEach((key, value) -> System.out.println(key + " :" + value));
//
//        System.out.println(stage.transferMoney(ivan, ivanAcc2, ivan, ivanAcc1, 50));
//    }
}
