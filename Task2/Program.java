package Task2;

public class Program {
    public static void main(String[] args) {
        Human man = new Human("Азат");
        print(man.toString());
        print("Все уровни:");
        System.out.print(man.getLevelsExperiences());
        print("");

        BaseEvent event1 = new BaseEvent("Домашнее задание сдано", 15);
        print(event1.toString());
        ExperienceChangedHandler.handleExperienceChanged(man, event1);
        print(man.toString());

        BaseEvent event2 = new BaseEvent("Завалена промежуточная аттестация", -150);
        print(event2.toString());
        ExperienceChangedHandler.handleExperienceChanged(man, event2);
        print(man.toString());

        BaseEvent event3 = new BaseEvent("Защита диплома успешно пройдена", 500);
        print(event3.toString());
        ExperienceChangedHandler.handleExperienceChanged(man, event3);
        print(man.toString());

    }
    public static void print(String txt) {
        System.out.println(txt);
    }
}
