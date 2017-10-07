package ru.job4j.Bank;

import java.util.*;

/**
 * Задание: реализовать коллекцию Map для банка.
 */
class StartUI {

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
    void addUser(User user) {
        //для нового юзера создаем счет по реквизитам
        List<Account> aList = new LinkedList<>();
        users.put(user, aList);
    }

    /**
     * удаление пользователя.
     *
     * @param user
     */
    void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * добавить счёт пользователю.
     *
     * @param user
     * @param account
     */
    void addAccountToUser(User user, Account account) {
        users.get(user).add(account);
    }

    /**
     * получить список счетов для пользователя.
     *
     * @param user
     * @return
     */
    List<Account> getUserAccounts(User user) {
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
    boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, int amount) {

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

    Map<User, List<Account>> getMap(){
        return users;
    }
}
