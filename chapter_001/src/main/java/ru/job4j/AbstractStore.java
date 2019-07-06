package ru.job4j;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray;

    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }


    public AbstractStore() {
        this.simpleArray = new SimpleArray<T>(10);
    }

    public void add(T model) {
        simpleArray.add(model);
    }

    public boolean replace(String id, T model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.remove(index);
            result = true;
        }
        return result;
    }

    public T findById(String id) {
        T result = null;
        int index = getIndex(id);
        if (index != -1) {
            result = simpleArray.get(index);
        }
        return result;
    }

    public int getIndex(String id) {
        int res = -1;
        int index = 0;
        for (T model : simpleArray) {
            if (model.getId().equalsIgnoreCase(id)) {
                res = index;
                break;
            }
            index++;
        }
        return res;
    }
}
