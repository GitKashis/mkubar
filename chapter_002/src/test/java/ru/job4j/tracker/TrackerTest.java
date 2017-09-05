package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSort. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 28.08.2017
 */
public class TrackerTest {


    /**
     * Тест метода Add(Item).
     * Создаем трекер, добавляем 2 объекта,
     * методом checkItem(int) находим Item и сравниваем с ожидаемым значением.
     */
    @Test
    public void testAdd() {
        // создаем трекер и 2 заявки.
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L, "comment");
        Item item2 = new Item("test2","testDescription",223L, "comment");

        // Добавляем заявку в трекер. Теперь в объекте проинициализирован id.
        tracker.add(item1);
        tracker.add(item2);

        // Сравниваем два объекта - то, что записано и найдено
        // прямым обращением по индексу (метод checkItem(int) с тем, что добавляли.
        assertThat(tracker.checkItem(0), is(item1));
        assertThat(tracker.checkItem(1), is(item2));
    }

    @Test
    public void addComment() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        Tracker previous = new Tracker();
        Tracker next = new Tracker();

        //добавляем 2 заявки в трекер. Id инициализирован.
        Item item1 = new Item("test1","testDescription",123L, "comment");
        Item item2 = new Item("test2","testDescription",223L, "comment");

        next.add(item1);
        next.add(item2);

        // Проверяем,
        assertNotEquals(previous, next);
    }

    /**
     * Тест поиска по ключу.
     * Метод findById возвращает результат поиска,
     * который сравниваем с тем, что добавляли.
     */
    @Test
    public void testFindById() throws Exception {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L, "comment");
        Item item2 = new Item("test2","testDescription",223L, "comment");

        // Добавляем заявки в трекер. Теперь в трекере должно быть два объекта Item .
        tracker.add(item1);
        tracker.add(item2);

        // Проверяем, что заявка с таким id существует и равна искомому значению.
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

    /**
     * Тест поиска по имени.
     * Метод findByName возвращает соответствующую запись,
     * которую сравниваем с именем того, что добавляли.
     */
    @Test
    public void findByName() throws Exception {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1","testDescription",123L, "comment");
        Item item2 = new Item("test2","testDescription",223L, "comment");

        // Добавляем заявки в трекер. Теперь в трекере должно быть два объекта Item .
        tracker.add(item1);
        tracker.add(item2);

        // Проверяем, что заявка с таким именем существует и равна искомому значению.
        assertThat(tracker.findByName("test2").getName(), is("test2"));
    }

    @Test
    public void getAll() throws Exception {

    }

    /**
     *  Тест метода update(Item newItem).
     *
     * {@link ru.job4j.tracker.Tracker}
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L, "comment");
        // Добавляем заявку в трекер. Теперь в объекте проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L, "new comment");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

}