package ru.job4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {


    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();

        Map<Integer, String> currentMap = current.stream().collect(
                Collectors.toMap(User::getId, User::getName));

        for (int i = 0; i < previous.size(); i++) {
            if (currentMap.get(previous.get(i).getId()) == null) {
                result.deleted++;
            } else if (!currentMap.get(previous.get(i).getId()).equals(previous.get(i).getName())) {
                result.changed++;
            }
        }

        //{old realisation
//        int difference = previous.size() - current.size();
//        if (difference > 0) {
//            result.deleted = difference;
//        } else if (difference < 0) {
//            result.added = Math.abs(difference);
//        }
//
//        for (int i = 0; i < previous.size(); i++) {
//            for (int j = 0; j < current.size(); j++) {
//                if (previous.get(i).id == current.get(j).id) {
//                    if (!previous.get(i).name.equalsIgnoreCase(current.get(j).name)) {
//                        result.changed++;
//                    }
//                    break;
//                }
//            }
//        }
//}old


//new real{
//        Map<Integer, List<String>>
//                previousMap = previous
//                .stream()
//                .collect(
//                        Collectors
//                                .groupingBy(
//                                        User::getId,
//                                        Collectors
//                                                .mapping(
//                                                        User::getName,
//                                                        Collectors
//                                                                .toList())));
//
//        Map<Integer, List<String>>
//                currentMap = current
//                .stream()
//                .collect(
//                        Collectors
//                                .groupingBy(
//                                        User::getId,
//                                        Collectors
//                                                .mapping(
//                                                        User::getName,
//                                                        Collectors
//                                                                .toList())));

//        Iterator iterator = previousMap.entrySet().iterator();

//        previousMap.entrySet().forEach(entry -> {
//            if (!currentMap.containsKey(entry.getKey())) {
//                result.deleted++;
//            } else if (!currentMap.get(entry.getKey()).equals(entry.getValue())) {
//                result.changed++;
//            }
//        });
        //}new real


        result.added = current.size() - Math.abs(previous.size() - result.deleted);
        return result;
    }

    public static class User {
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Info {

        int added;
        int changed;

        int deleted;

    }

}
