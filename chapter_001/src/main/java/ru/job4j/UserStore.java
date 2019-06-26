package ru.job4j;

public class UserStore implements Store {

    SimpleArray simpleArray;

    @Override
    public void add(Base model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
//        simpleArray
        return false;
    }

    @Override
    public Base findById(String id) {
        return null;
    }
}
