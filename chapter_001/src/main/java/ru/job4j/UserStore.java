package ru.job4j;

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
