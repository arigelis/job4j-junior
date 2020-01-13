package ru.job4j;

import java.util.List;

public class Analize {


    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
        int difference = previous.size() - current.size();
        if (difference > 0) {
            result.deleted = difference;
        } else if (difference < 0) {
            result.added = Math.abs(difference);
        }

        for (int i = 0; i < previous.size(); i++) {
            for (int j = 0; j < current.size(); j++) {
                if (previous.get(i).id == current.get(j).id) {
                    if (!previous.get(i).name.equalsIgnoreCase(current.get(j).name)) {
                        result.changed++;
                    }
                    break;
                }
            }
        }

        return result;

    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {

        int added;
        int changed;

        int deleted;

    }

}
