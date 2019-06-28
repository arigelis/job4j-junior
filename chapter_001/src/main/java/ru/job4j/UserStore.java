package ru.job4j;

import java.util.Iterator;

public class UserStore implements Store<User> {//extends AbstractStore{

    private SimpleArray<User> simpleArray;
    private int index = 0;

//    @Override
//    public void add(Base model) {
//        simpleArray.add(model);
//    }
//
//    @Override
//    public boolean replace(String id, Base model) {
//        boolean result = false;
//        Base modelTmp = findById(id);
//        simpleArray.set(index, model);
//        return result;
//    }

    @Override
    public void add(User model) {
        if (index > 0) {
            simpleArray.add(model);
        }
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result = false;
        Base modelTmp = findById(id);
        if (index > 0) {
            simpleArray.set(index, model);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Base model = findById(id);
        if (index > 0) {
            simpleArray.remove(index);
        }
        return result;
    }

    @Override
    public User findById(String id) {
        Iterator iter = simpleArray.iterator();
        User result = null;
        index = 0;
        while (iter.hasNext()) {
            User it = (User) iter.next();
            if (it.getId().equalsIgnoreCase(id)) {
                result = it;
                break;
            }
            index++;
        }
        if (result == null) {
            index = -1;
        }
        return result;
    }
}
