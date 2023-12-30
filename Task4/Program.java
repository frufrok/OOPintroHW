package Task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        //Box<String> strings = new Box<>(); // не должно компилироваться

        Box<Orange> oranges = new Box<>();
        oranges.add(new Orange(1));
        print("Вес коробки после добавления первого апельсина весом 1:");
        System.out.println(oranges.getWeight()); // 1
        print("Вес коробки после добавления второго апельсина весом 2:");
        oranges.add(new Orange(2));
        System.out.println(oranges.getWeight()); // 3

        Box<Apple> apples = new Box<>();
        //apples.add(new Orange(3)); // не должно компилироваться!
        apples.add(new GoldenApple(5)); // это ок

        Box<GoldenApple> goldenApples = new Box<>();
        goldenApples.add(new GoldenApple(5)); // это ок
        //goldenApples.add(new Apple(3)); // не должно компилироваться!

        //oranges.move(apples); // не должно компилироваться!
        goldenApples.move(apples); // это ок
        //apples.move(goldenApples); // не должно компилироваться!

        Box<Orange> newOranges = new Box<>();
        oranges.move(newOranges);
        print("Вес пустой коробки после пересыпания апельсинов из нее:");
        System.out.println(oranges.getWeight()); // 0 после пересыпания
        print("Вес новой коробки после пересыпания апельсинов в нее:");
        System.out.println(newOranges.getWeight()); // 3 после пересыпания

        print("Сообщений из цикла быть не должно");
        for (Orange o: oranges) { // цикл компилируется, но не запускается, потому oranges - пустой
            print("Вес апельсина:");
            System.out.println(o.getWeight());
        }

        print("Перечисление по коробке апельсинов:");
        for (Orange o: newOranges) { // цикл компилируется, и запускается
            // Должно вывести 1 2 (или 2 1) - порядок неважен
            print("Вес апельсина:");
            System.out.println(o.getWeight());
        }

        print("Перечисление по коробке яблок:");
        for (Apple a: apples) { // цикл компилируется, и запускается
            // Должно вывести 5 5
            print("Вес яблока:");
            System.out.println(a.getWeight());
        }
    }

    static class Box<T extends Fruit> implements Iterable<T>{
        // Реализовать данный класс!!!
        List<T> content;
        public Box() {
            this.content = new ArrayList<>();
        }
        public Box(List<T> list) {
            this.content = list;
        }

        public void add(T fruit) {
            this.content.add(fruit);
        }

        public void clear() {
            this.content.clear();
        }

        public int getWeight() {
            int result = 0;
            for (T fruit : this) {
                result += fruit.getWeight();
            }
            return result;
        }

        @Override
        public Iterator<T> iterator() {
            return this.content.iterator();
        }

        void move(Box<? super T> target) {
            for(T fruit : this) {
                target.add(fruit);
            }
            this.clear();
        }
    }

    static class Fruit {
        private final int weight;

        public Fruit(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Orange extends Fruit {
        public Orange(int weight) {
            super(weight);
        }
    }

    static class Apple extends Fruit {
        public Apple(int weight) {
            super(weight);
        }
    }

    static class GoldenApple extends Apple {
        public GoldenApple(int weight) {
            super(weight);
        }
    }

    static void print(String message) {
        System.out.println(message);
    }
}
