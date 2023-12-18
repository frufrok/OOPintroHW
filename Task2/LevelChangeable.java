package Task2;

import java.util.HashMap;

public interface LevelChangeable {
    int getCurrentLevel();
    void setCurrentLevel(int level);
    int getCurrentExperience();
    void setCurrentExperience(int exp);
    HashMap<Integer, Integer> getLevelsExperiences();
}
