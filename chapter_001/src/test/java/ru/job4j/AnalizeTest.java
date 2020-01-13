package ru.job4j;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AnalizeTest {

    @Test
    public void testDiff() {
        List<Analize.User> prev = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Analize.User user = new Analize.User();
            user.name = "user" + i;
            user.id = i;
            prev.add(user);
        }

        List<Analize.User> curr = new ArrayList<>();
        curr.add(prev.get(0));
        Analize.User tmp = new Analize.User();
        tmp.name = "lalala";
        tmp.id = prev.get(1).id;
        curr.add(tmp);
        curr.add(prev.get(2));

        Analize.User user = new Analize.User();
        user.name = "user4";
        user.id = 4;

        curr.add(user);

        Analize analize = new Analize();
        Analize.Info info = analize.diff(prev, curr);
        System.out.println("Changed: "+info.changed +";\n"+"Added: "+info.added+";\n"+"Deleted: "+info.deleted);
    }
}