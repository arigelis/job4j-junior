package ru.job4j;

import org.testng.annotations.Test;
import org.testng.collections.Sets;

import java.util.HashMap;
import java.util.Set;

import static org.testng.Assert.*;

public class MailSorterTest {

    @Test
    public void testSort() {
        MailSorter mailSorter = new MailSorter();
        HashMap<String, Set<String>> links = new HashMap<>();
        links.put("user1", Sets.newHashSet("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        links.put("user2", Sets.newHashSet("foo@gmail.com", "ups@pisem.net"));
        links.put("user3", Sets.newHashSet("xyz@pisem.net", "vasya@pupkin.com"));
        links.put("user4", Sets.newHashSet("ups@pisem.net", "aaa@bbb.ru"));
        links.put("user5", Sets.newHashSet("xyz@pisem.net"));
        mailSorter.sort(links);
    }
}