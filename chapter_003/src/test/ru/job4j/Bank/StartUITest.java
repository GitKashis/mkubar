package ru.job4j.Bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * todo: comment
 * Created by Kubar on 07.10.2017.
 */
public class StartUITest {
    // тестовые данные
    private StartUI bankMap = new StartUI();

    private User mary = new User("Mary", "passport");
    private Account maryAcc1 = new Account("maryAcc1");

    private User ivan = new User("Ivan", "passport");
    private Account ivanAcc1 = new Account("ivanAcc1");

    /**
     * Тестируем метод addUser
     */
    @Test
    public void addUserThenPutInMap() {

        bankMap.addUser(mary);
        boolean result = bankMap.getMap().containsKey(mary);

        assertThat(result, is(true));
    }

    /**
     * Тестирование метода deleteUser.
     */
    @Test
    public void deleteUserWhenRemoveFromMap() {
        bankMap.addUser(mary);
        // проверим, что пользователь добавлен.
        boolean resultAdd = bankMap.getMap().containsKey(mary);
        bankMap.deleteUser(mary);
        // проверим, что пользователь более не существует в коллекции.
        boolean resultDell = bankMap.getMap().containsKey(mary);
        assertThat(resultAdd && resultDell, is(false));
    }

    /**
     * Тестируем добавление аккаунта пользователю.
     */
    @Test
    public void addAccountToUser() {
        bankMap.addUser(mary);
        bankMap.addAccountToUser(mary, maryAcc1);

        // для пользователя получим список его аккаунтов,
        // проверим, есть ли там тот аккаунт, который мы добавляли
        boolean result = bankMap.getUserAccounts(mary).contains(maryAcc1);

        assertThat(result, is(true));
    }

    /**
     * тестирование перевода,
     * при удачном завершении должно вернуть true.
     */
    @Test
    public void transferMoneyFromSrcToDest() {
        bankMap.addUser(mary);
        bankMap.addAccountToUser(mary, maryAcc1);
        bankMap.addUser(ivan);
        bankMap.addAccountToUser(ivan, ivanAcc1);

        boolean result = bankMap.transferMoney(mary, maryAcc1, ivan, ivanAcc1, 50);

        assertThat(result, is(true));
    }
}