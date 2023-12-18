package Task2;

import java.util.HashMap;

public class Human extends Unit{

    public Human(String name) {
        super(name);
    }

    @Override
    public int getCurrentLevelExperience() {
        HashMap<Integer, Integer> map = this.getLevelsExperiences();
        return map.getOrDefault(this.getCurrentLevel(), -1);
    }

    @Override
    public HashMap<Integer, Integer> getLevelsExperiences() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            map.put(i, 10 * i);
        }
        return map;
    }


}
