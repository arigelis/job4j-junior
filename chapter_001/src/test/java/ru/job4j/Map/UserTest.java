package ru.job4j.Map;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class UserTest {

    @Test
    public void twoEqualObjectsInMap() {
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Ivan", 30, calendar);
        User user2 = new User("Ivan", 30, calendar);

        Object object = new Object();

        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(user1, object);
        userObjectMap.put(user2, object);

        for (Map.Entry<User, Object> user : userObjectMap.entrySet()) {
            System.out.println(user.getValue() + " / " + user.getKey());
        }

    }

}