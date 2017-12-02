package ru.job4j.generic;

import ru.job4j.simplearray.SimpleArray;

/**
 *
 * Created by Kubar on 08.10.2017.
 */
public class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Storage.
     */
    private SimpleArray<T> storage;

    /**
     * Constructor for AbstracStorage.
     * @param storage - storage.
     */
    AbstractStore(SimpleArray<T> storage) {
        this.storage = storage;
    }

    /**
     * Get this storage.
     * @return simplearray.
     */
    public SimpleArray<T> getStorage() {
        return this.storage;
    }

    /**
     * Add new item in storage.
     * @param model - item.
     * @return Base - added element.
     */
    @Override
    public T add(T model) {
        this.storage.add(model);
        return storage.get(storage.getIndex(model));
    }

    /**
     * Update element in storage by ID.
     * @param model - item.
     * @return Base - element before updating.
     */
    @Override
    public T update(T model) {
        Base oldElem = null;
        for (Base item : storage) {
            if (item.getId().equals(model.getId())) {
                oldElem = item;
                storage.update(storage.getIndex((T) item), model);
                break;
            }
        }
        return (T) oldElem;
    }

    /**
     * Delete element from storage.
     * @param id - item.
     * @return boolean.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (Base item : storage) {
            if (item.getId().equals(id)) {
                storage.delete(storage.getIndex((T) item));
                result = true;
                break;
            }
        }
        return result;
    }
}
