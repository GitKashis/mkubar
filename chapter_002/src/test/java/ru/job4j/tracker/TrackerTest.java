package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class TrackerTest. Тестирование методов класса Tracker;
 * {@link ru.job4j.tracker.Tracker}
 *
 * @author Mikhail Kubar
 * @since 05.09.2017
 */
public class TrackerTest {

    // создаем трекер и 2 заявки.
    Tracker tracker = new Tracker();
    Item item1 = new Item("test1", "testDescription",  "comment");
    Item item2 = new Item("test2", "testDescription",  "comment");

    /**
     * Тест метода Add(Backe).
     * Создаем трекер, добавляем 2 объекта,
     * методом checkItem(int) находим Backe и сравниваем с ожидаемым значением.
     */
    @Test
    public void testAdd() {
        // Добавляем заявку в трекер. Теперь в объекте проинициализирован id.
        tracker.add(item1);
        tracker.add(item2);

        // Сравниваем два объекта - то, что записано и найдено
        // прямым обращением по индексу (метод checkItem(int) с тем, что добавляли.
        assertThat(tracker.getAll()[0], is(item1));
        assertThat(tracker.getAll()[1], is(item2));
    }

    /**
     * Тестирование добавления коментария.
     * Добавляем объект без коментария, далее к нему же дописываем коммент,
     * проверяем, что получилось. Сравниваем с ожидаемым значением.
     */
    @Test
    public void addComment() throws Exception {
        //создаем заявку с пустым комментом, добавляем в трекер.
        Item item = new Item("test", "testDescription",  "");
        tracker.add(item);
        String testComment = "newComment";
        //для объекта item записываем testComment.
        tracker.addComment(item, testComment);
        //находим объект, проверяем, что содержит item в поле comment,
        //сравниваем  с ожидаемым значением.
        String result = tracker.findById(item.getId()).getComment();
        assertEquals(result, testComment);
    }

    /**
     * Тестирование удаления элемента из массива.
     * Проверяем по количеству элементов до и после,
     * а так же поиском по Id.
     */
    @Test
    public void delete() throws Exception {

        tracker.add(item1);
        tracker.add(item2);
        //previous next - количество элементов массива.
        int previous = tracker.getAll().length;
        //удаляем.
        tracker.delete(item2);
        int next = tracker.getAll().length;
        //Проверяем количеством.
        assertThat(next, is(previous - 1));
        //проверяем поиском по id.
        assertNull(tracker.findById(item2.getId()));
    }

    /**
     * Тест поиска по ключу.
     * Метод findById возвращает результат поиска,
     * который сравниваем с тем, что добавляли.
     */
    @Test
    public void testFindById() throws Exception {

        // Добавляем заявки в трекер. Теперь в трекере должно быть два объекта Backe .
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
        // Добавляем заявки в трекер. Теперь в трекере должно быть два объекта Backe .
        tracker.add(item1);
        tracker.add(item2);
        // Проверяем, что заявка с таким именем существует и равна искомому значению.
        assertThat(tracker.findByName("test2").getName(), is("test2"));
    }

    /**
     * Тестирование по количеству возвращаемых элементов.
     * Проверяется на соответствие с ожидаемым значениемэ
     */
    @Test
    public void getAll() throws Exception {
        tracker.add(item1);
        tracker.add(item2);
        //ожидается 2 элемента.
        int result = tracker.getAll().length;
        assertThat(result, is(2));
    }

    /**
     * Тест метода update(Backe).
     * Создаем объект, записываем в трекер.
     * Далее создаем второй объект, задаем новые параметры,
     * перезаписываем по тому же Id и сравниваем с ожидаемым значением.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Item previous = new Item("test1", "testDescription",  "comment");
        // Добавляем заявку в трекер. Теперь в объекте проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", "new comment");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void findIndex() throws Exception {
        tracker.add(item1);
        tracker.add(item2);

        assertThat(tracker.getAll()[1], is(item2));
    }
}