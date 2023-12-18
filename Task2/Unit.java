package Task2;

import java.util.HashMap;

public abstract class Unit implements LevelChangeable {
    private String name;
    private int currentLevel;
    private int currentExperience;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCurrentLevel() {
        return this.currentLevel;
    }
    public int getCurrentExperience() {
        return this.currentExperience;
    }
    public int getCurrentLevelExperience() {
        HashMap<Integer, Integer> map = this.getLevelsExperiences();
        return map.getOrDefault(this.getCurrentLevel(), -1);
    }
    abstract public HashMap<Integer,Integer> getLevelsExperiences();
    public void changeExperience(int value) {
        int newValue = this.currentExperience + value;
        int curLevelExp = this.getCurrentLevelExperience();
        if (newValue >= 0) {
            if (curLevelExp >= 0 && newValue >= curLevelExp) {
                this.currentLevel += 1;
                this.changeExperience(newValue - curLevelExp);
            }
            else {
                this.currentExperience = newValue;
            }
        }
        else {
            if (this.currentLevel > 1) {
                this.currentLevel -= 1;
                this.changeExperience(newValue + this.getCurrentExperience());
            }
            else {
                this.currentExperience = 0;
            }
        }
    }

    public Unit(String name) {
        this.name = name;
        this.currentLevel = 1;
        this.currentExperience = 0;
    }

    @Override
    public String toString() {
        int currentLevelExperience = this.getCurrentLevelExperience();
        if (currentLevelExperience >= 0) {
            return String.format("Юнит %s, текущий уровень: %d, текущий опыт: %d, следующий уровень по достижении %d",
                    this.name, this.currentLevel, this.currentExperience, this.getCurrentLevelExperience());
        }
        else {
            return String.format("Юнит %s, текущий уровень: %d, текущий опыт: %d, полностью прокачан.",
                    this.name, this.currentLevel, this.currentExperience);
        }
    }
}
