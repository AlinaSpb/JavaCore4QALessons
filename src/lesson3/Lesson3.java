package lesson3;

import java.util.Arrays;

public class Lesson3 {

    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(method1(arr)));

        // Задача 2
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Вес коробки с яблоками равна весу коробки с апельсинами? " + appleBox.compare(orangeBox));


        Box<Apple> box1 = new Box();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        System.out.println("В коробке box1 кол-во фруктов: " + box1.getFruits().size());

        Box<Apple> box2 = new Box<>();
        box2.moveFrom(box1);
        System.out.println("В коробке box1 кол-во фруктов: " + box1.getFruits().size());
        System.out.println("В коробке box2 кол-во фруктов: " + box2.getFruits().size());


        Box<Orange> box3 = new Box();
        box3.addFruit(new Orange());






    }

    /*
     * Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
     * */
    public static String[] method1(String[] arr) {
        String s = arr[1];
        arr[1] = arr[0];
        arr[0] = s;
        return arr;
    }
}
