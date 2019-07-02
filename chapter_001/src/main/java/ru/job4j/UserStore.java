package ru.job4j;

public class UserStore extends AbstractStore implements Store<User> {//extends AbstractStore{

    private SimpleArray<User> simpleArray;

    @Override
    public void add(User model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.remove(index);
            result = true;
        }
        return result;
    }


    public int getIndex(String id) {
        int res = -1;
        int index = 0;
        for (User user : simpleArray) {
            if (user.getId().equalsIgnoreCase(id)) {
                res = index;
                break;
            }
            index++;
        }
        return res;
    }

    @Override
    public User findById(String id) {
        User result = null;
        int index = getIndex(id);
        if (index != -1) {
            result = simpleArray.get(index);
        }
        return result;
    }
}
