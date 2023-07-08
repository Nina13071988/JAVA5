package HW5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task1 {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public void print() {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> e1, Map.Entry<String, List<String>> e2) {
                return Integer.compare(e2.getValue().size(), e1.getValue().size());
            }
        });

        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        task1 phoneBook = new task1();
        phoneBook.add("John", "123456");
        phoneBook.add("Jane", "234567");
        phoneBook.add("John", "345678");
        phoneBook.add("Jane", "456789");
        phoneBook.add("John", "567890");
        phoneBook.print();
    }
}