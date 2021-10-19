package lesson4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lesson4 {
    public static void main(String[] args) {
        // task 1
        Map<String, Integer> resultTask1 = task1(
                "один",
                "два",
                "один",
                "три",
                "четыре",
                "два",
                "пять",
                "солнце",
                "воздух",
                "вода",
                "воздух",
                "вода",
                "вода"
        );
        for (String key : resultTask1.keySet()) {
            System.out.println(key + ": " + resultTask1.get(key));
        }

        // task 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", 12345678);
        phoneBook.add("Иванов", 98798797);
        phoneBook.add("Сидоров", 98665635);
        phoneBook.add("Сидоров", 21494142);
        phoneBook.add("Сидоров", 78127717);
        phoneBook.add("Петров", 98723789);

        System.out.println("*** Задача №2");
        System.out.print("Введите фамилию: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        List<Integer> phones = phoneBook.get(name);
        if(phones != null) {
            for (Integer phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Абонент не найден");
        }


    }

    /**
     * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
     * уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое
     * слово.
     */
    public static Map<String, Integer> task1(String... values) {
        Map<String, Integer> result = new HashMap<>();
        for (String v : values) {
            if (!result.containsKey(v)) {
                result.put(v, 1);
            } else {
                result.put(v, result.get(v) + 1);
            }
        }
        return result;
    }
}
