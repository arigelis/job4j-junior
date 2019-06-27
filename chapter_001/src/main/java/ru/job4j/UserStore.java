package ru.job4j;

import java.util.Iterator;

public class UserStore extends AbstractStore{

    SimpleArray<User> simpleArray;
    int index = 0;

    @Override
    public void add(Base model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        Base modelTmp = findById(id);
        simpleArray.set(index, model);
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Base model = findById(id);
        simpleArray.remove(index);
        return result;
    }

    @Override
    public Base findById(String id) {
        Iterator iter = simpleArray.iterator();
        Base result = null;
        index = 0;
        while (iter.hasNext()) {
            Base it = (Base) iter.next();
            if (it.getId().equalsIgnoreCase(id)) {
                result = it;
                break;
            }
            index++;
        }
        return result;
    }
}
