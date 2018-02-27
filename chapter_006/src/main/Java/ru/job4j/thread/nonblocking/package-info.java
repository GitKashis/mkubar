package ru.job4j.thread.nonblocking;

/*
1. Неблокирующий кеш [#4741]

1. Необходимо сделать кеш для хранение моделей. в кеше должны быть методы
add, update delete,
2. Кеш должен работать на неблокирующих алгоритмах. - использовать ConcurrentHashMap
3. В кеше должна быть возможность проверять валидность данных. Например. Два пользователя прочитали данные task_1
первый пользователь изменил поле имя и второй сделал тоже самое. нужно перед обновлением данных проверить,
что текущий пользователь не затер данные другого пользователя. если данные затерты то выбросить OplimisticException.
Такая реализация достигается за счет введение с модель поля version и перед обновлением данных проверять
текущую версию и ту что обновляем и увеличивать на один каждый раз когда обновили. если версии не равны то кидать исключение.
 */