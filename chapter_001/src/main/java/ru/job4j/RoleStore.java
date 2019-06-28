package ru.job4j;

import java.util.Iterator;

public class RoleStore implements Store<Role> {//extends AbstractStore {

    private SimpleArray<Role> simpleArray;
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
    public void add(Role model) {
        if (index > 0) {
            simpleArray.add(model);
        }
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean result = false;
        Base modelTmp = (Base) findById(id);
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
    public Role findById(String id) {
        Iterator iter = simpleArray.iterator();
        Role result = null;
        index = 0;
        while (iter.hasNext()) {
            Role it = (Role) iter.next();
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
