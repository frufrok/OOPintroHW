package Task3;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        ArrayList<Employee> list = getRandomEmployers(20, 18, 65, 25, 250);

        print("Список рандомных сотрудников:");
        printList(convertToObjectList(list));
        print("");

        print("Сортируем по убыванию возраста:");
        list.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()) * -1);
        printList(convertToObjectList(list));
        print("");

        print("Сортируем по возрастанию зарплаты:");
        // Сортируем через лямбда-выражение
        list.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        printList(convertToObjectList(list));
        print("");

        print("Топ-5 по зарплате в алфавитном порядке:");
        ArrayList<Employee> topFive = new ArrayList<>();
        for (int i = list.size() - 5 - 1; i < list.size(); i++) {
            topFive.add(list.get(i));
        }
        // Сортируем через Comparator.comparing() метод по ключу
        topFive.sort(Comparator.comparing(Employee::getName));
        printList(convertToObjectList(topFive));
        print("");

        print("Сложная сортировка:");
        // Сортируем через экземпляр класса Comparator
        Comparator myComparator = (o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            }
            else {
                Employee e1 = (Employee) o1;
                Employee e2 = (Employee) o2;
                if (e1.getAge() > e2.getAge()) {
                    return 1;
                }
                else if (e1.getAge() < e2.getAge()) {
                    return -1;
                }
                else {
                    if (e1.getSalary() > e2.getSalary()) {
                        return -1;
                    }
                    else if (e1.getSalary() < e2.getSalary()){
                        return 1;
                    }
                    else {
                        return e1.getName().compareTo(e2.getName());
                    }
                }
            }
        };
        list.sort(myComparator);
        printList(convertToObjectList(list));
        print("");

        print("Другой список (для проверки):");
        list = getRandomEmployers(10, 18, 25, 45, 50);
        printList(convertToObjectList(list));
        print("");
        print("Сложная сортировка:");
        list.sort(myComparator);
        printList(convertToObjectList(list));
    }

    public static ArrayList<Object> convertToObjectList(ArrayList<Employee> list) {
        return new ArrayList<>(list);
    }

    public static void printList(ArrayList<Object> list) {
        for (Object element : list) {
            System.out.println(element.toString());
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static ArrayList<Employee> getRandomEmployers(int count, int minAge, int maxAge, int minSalary, int maxSalary) {
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Random intRandom = new Random();
            list.add(new Employee(String.format("Name%d", i + 1), intRandom.nextInt(minAge, maxAge), intRandom.nextInt(minSalary, maxSalary) * 1000));
        }
        Collections.shuffle(list);
        return list;
    }
}
