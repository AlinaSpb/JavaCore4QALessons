package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getFruits() {
        return fruits;
    }

    public float getWeight() {
        float result = 0.0f;
        for (Fruit f : fruits) {
            result += f.getWeight();
        }
        return result;
    }

    public boolean compare(Box box) {
        return getWeight() == box.getWeight();
    }

    public void moveFrom(Box<T> box){
        fruits.addAll(box.getFruits());
        box.getFruits().clear();
    }
}
