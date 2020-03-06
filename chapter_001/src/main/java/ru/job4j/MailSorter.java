package ru.job4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MailSorter {
    public void sort(HashMap<String, Set<String>> links) {
        boolean chan = false; //изменилась ли коллекция
        boolean duplicates = true; //был ли на текущей итеерации дубликат
        while (duplicates) {
            for (Map.Entry<String, Set<String>> entry : links.entrySet()) {
                for (Map.Entry<String, Set<String>> entryInternal : links.entrySet()) {
                    if (entry.getKey().equals(entryInternal.getKey())) {
                        continue;
                    }

                    Set<String> list = new HashSet<>();
                    Set<String> listInt = new HashSet<>();

                    list.addAll(entry.getValue());
                    listInt.addAll(entryInternal.getValue());

                    if (list.retainAll(listInt) && list.size() > 0) {
                        entry.getValue().addAll(entryInternal.getValue());
                        links.remove(entryInternal.getKey());
                        chan = true;
                        break;
                    }
                }
                if (chan) {
                    chan = false;
                    break;
                }
                duplicates = false;
            }
        }
    }
}
