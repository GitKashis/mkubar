package ru.job4j.yandex;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализовать объект для учета однотипных событий в системе.
 * Например, отправка фото в сервисе фотографий.
 * События поступают в произвольный момент времени.
 * Возможно как 10К событий в секунду так и 2 в час.

 * Интерфейс:
    1. Учесть событие.
    2. Выдать число событий за последнюю минуту (60 секунд).
    3. Выдать число событий за последний час (60 минут).
    4. Выдать число событий за последние сутки (24 часа).
 */
public class EventAction implements EventCounter {

    private static final int SECOND_SIZE = 1000;
    private static final int MINUTE_SIZE = 60 * SECOND_SIZE;
    private static final int HOUR_SIZE = 60 * MINUTE_SIZE;
    private static final int DAY_SIZE = 24 * HOUR_SIZE;

    /**
     * Т.к. нагрузка может быть очень высокой, следует предусмотреть многопоточную обработку
     * и учесть, что в одно и то же время могут произойти несколько событий,
     * соответственно их время создания будет одинаквым.
     * Для учета событий и храненя значений их времени выбираем список.
     * (Хотя интерфейс Navigable удобнее для извлечения диапазона значений,
     * но он предусматривает только уникальные ключи)
     */
    private volatile List<Long> list;

    /**
     * Конструктор.
     * В данном случае не учитывается ситуация out of memory или перегрузка IO.
     * При обработке больших потоков данных следует использовать интерфейс BlockingQueue
     * чтобы иметь возможности задавать размер queue и следить за переполением.
     */
    EventAction() {
        list = new LinkedList<>();
    }

    /**
     * при возникновении события учитывается время его создания.
     * Учитывая высокую нагруженность для разных событий время возникновения
     * может быть одинаковым.
     */
    @Override
    public void eventPerformed() {
        list.add(System.currentTimeMillis());
    }

    /**
     * Метод запроса количества событий за определенный промежуток времени.
     *
     * @param period - время отчета.
     * @return количество событий за период.
     */
    @Override
    public long getEventCount(TimePeriod period) {
        long result;
        long currentTimeMillis = System.currentTimeMillis();

        switch (period){
            case LAST_DAY: {result = (currentTimeMillis - DAY_SIZE); break;}
            case LAST_HOUR: {result = (currentTimeMillis - HOUR_SIZE); break;}
            case LAST_MINUTE: {result = (currentTimeMillis - MINUTE_SIZE); break;}
            case LAST_SECOND: {result = (currentTimeMillis - SECOND_SIZE); break;}

            default: throw new IllegalArgumentException("Unknown time period " + period);
        }
        long finalResult = result;

        return list.stream().filter(p -> p >= finalResult && p <= currentTimeMillis)
                .collect(Collectors.toList()).size();
    }
}
