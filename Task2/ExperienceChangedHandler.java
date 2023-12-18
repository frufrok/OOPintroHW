package Task2;

public class ExperienceChangedHandler {
    public static void handleExperienceChanged(LevelChangeable levelChangeable,
                                        ExperienceProvidable experienceProvidable) {
        int value = experienceProvidable.getExperience();
        System.out.printf("Обрабатываем изменение опыта на %d.%n", value);
        changeExperience(levelChangeable, value);
    }

    private static void changeExperience(LevelChangeable levelChangeable, int value) {
        int currentLevel = levelChangeable.getCurrentLevel();
        int newValue = levelChangeable.getCurrentExperience() + value;
        int curLevelExp = getCurrentLevelExperience(levelChangeable);
        if (newValue >= 0) {
            if (curLevelExp >= 0 && newValue >= curLevelExp) {
                currentLevel++;
                levelChangeable.setCurrentLevel(currentLevel);
                System.out.printf("Новый уровень %d!%n", currentLevel);
                changeExperience(levelChangeable, newValue - curLevelExp);
            }
            else {
                levelChangeable.setCurrentExperience(newValue);
            }
        }
        else {
            if (currentLevel > 1) {
                currentLevel --;
                System.out.printf("Снижение уровня до %d!%n", currentLevel);
                levelChangeable.setCurrentLevel(currentLevel);
                changeExperience(levelChangeable, newValue + levelChangeable.getCurrentExperience());
            }
            else {
                levelChangeable.setCurrentExperience(0);
            }
        }
    }

    public static int getCurrentLevelExperience(LevelChangeable levelChangeable) {
        return levelChangeable.getLevelsExperiences().getOrDefault(levelChangeable.getCurrentLevel(), -1);
    }
}
