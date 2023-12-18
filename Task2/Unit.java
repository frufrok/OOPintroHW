package Task2;

import java.util.HashMap;

public abstract class Unit implements LevelChangeable {
    private String name;
    private int currentLevel;
    private int currentExperience;
    public Unit(String name) {
        this.name = name;
        this.currentLevel = 1;
        this.currentExperience = 0;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrentLevel() {
        return this.currentLevel;
    }
    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }
    public int getCurrentExperience() {
        return this.currentExperience;
    }
    public void setCurrentExperience(int experience) {
        this.currentExperience = experience;
    }
    abstract public HashMap<Integer,Integer> getLevelsExperiences();
    @Override
    public String toString() {
        int currentLevelExperience = ExperienceChangedHandler.getCurrentLevelExperience(this);
        if (currentLevelExperience >= 0) {
            return String.format("Юнит %s, текущий уровень: %d, текущий опыт: %d, следующий уровень по достижении %d",
                    this.name, this.currentLevel, this.currentExperience, ExperienceChangedHandler.getCurrentLevelExperience(this));
        }
        else {
            return String.format("Юнит %s, текущий уровень: %d, текущий опыт: %d, полностью прокачан.",
                    this.name, this.currentLevel, this.currentExperience);
        }
    }
}
