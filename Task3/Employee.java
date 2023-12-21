package Task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class Employee implements Comparable{
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age) {
        new Employee(name, age, 0);
    }

    public Employee(String name) {
        new Employee(name, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        return String.format("Работник %s (возраст: %d, зарплата: %.2f)", this.name, this.age, this.salary);
    }

    @Override
    public int compareTo(Object o) {
        Employee another = (Employee) o;
        if (this.equals(another)) {
            return 0;
        }
        else {
            if (this.age > another.age) {
                return 1;
            }
            else if (this.age < another.age) {
                return  -1;
            }
            else {
                if (this.salary > another.salary) {
                    return 1;
                }
                else if (this.salary < another.salary) {
                    return -1;
                }
                else {
                    return this.name.compareTo(another.name);
                }
            }
        }
    }
}
