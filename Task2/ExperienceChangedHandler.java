package Task2;

public class ExperienceChangedHandler {
    public static void handleExperienceChanged(LevelChangeable levelChangeable,
                                        ExperienceProvidable experienceProvidable) {
        int value = experienceProvidable.getExperience();
        System.out.printf("Обрабатываем изменение опыта на %d.%n", value);
        levelChangeable.changeExperience(value);
    }
}
