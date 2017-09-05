package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Class BubbleSort. Решение задачи. Часть 001, урок 3.1
 * @author Mikhail Kubar
 * @since 28.08.2017
 */
public class TrackerTest {

    @Test
    public void add() throws Exception {
        Tracker previous = new Tracker();
        Tracker next = new Tracker();
        Item item = new Item("test1","testDescription",123L, "comment");
        // Добавляем заявку в трекер. Теперь в объекте проинициализирован id.
        next.add(item);
        // Проверяем,
        assertNotEquals(previous, next);
    }

    @Test
    public void addComment() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findById() throws Exception {

    }

    @Test
    public void findByName() throws Exception {

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