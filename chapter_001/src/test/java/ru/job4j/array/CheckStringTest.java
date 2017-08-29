package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Mikhail Kubar
 * @version 1.0
 * @since 29.08.2017
 */
public class CheckStringTest {

    /**
     * Метод сверяет ожидаемое значение
     * с результатом выполнения проверки.
     */
    @Test
    public void containsTest() {
        //Создаем класс-обёртку для метода contains.
        CheckString check = new CheckString();
        // Задаём строку поиска и подстроку.
        String origin = "Hello world";
        String sub = "world";
        //Проверяем результат.
        boolean result = check.contains(origin, sub);
        //Задаем ожидаемый результат.
        boolean expected = true;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, is(expected));
    }
}