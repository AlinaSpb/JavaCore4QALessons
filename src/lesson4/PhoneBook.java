package lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров. В этот
 * телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона
 * по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
 * запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneBook {
    private Map<String, List<Integer>> book = new HashMap<>();

    public void add(String name, Integer phoneNumber) {
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<>());
        }
        book.get(name).add(phoneNumber);
    }

    public List<Integer> get(String name) {
        return book.get(name);
    }
}
