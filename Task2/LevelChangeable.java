package Task2;

import java.util.HashMap;

public interface LevelChangeable {
    int getCurrentLevel();
    int getCurrentExperience();
    int getCurrentLevelExperience();
    HashMap<Integer, Integer> getLevelsExperiences();
    void changeExperience(int value);
}
