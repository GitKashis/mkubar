package ru.job4j.generic;

import ru.job4j.SimpleArray.SimpleArray;

/**
 *
 * Created by Kubar on 08.10.2017.
 */
class AbstractStore<T extends Base> implements Store<Base> {
    /**
     * Storage.
     */
    private SimpleArray<Base> storage;

    /**
     * Constructor for AbstracStorage.
     * @param storage - storage.
     */
    AbstractStore(SimpleArray<Base> storage) {
        this.storage = storage;
    }

    /**
     * Get this storage.
     * @return SimpleArray.
     */
    public SimpleArray<Base> getStorage() {
        return this.storage;
    }

    /**
     * Add new item in storage.
     * @param model - item.
     * @return Base - added element.
     */
    @Override
    public Base add(Base model) {
        this.storage.add(model);
        return storage.get(storage.getIndex(model));
    }

    /**
     * Update element in storage by ID.
     * @param model - item.
     * @return Base - element before updating.
     */
    @Override
    public Base update(Base model) {
        Base oldElem = null;
        for (Base item : storage) {
            if (item.getId().equals(model.getId())) {
                oldElem = item;
                storage.update(storage.getIndex(item), model);
                break;
            }
        }
        return oldElem;
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
                storage.delete(storage.getIndex(item));
                result = true;
                break;
            }
        }
        return result;
    }
}
