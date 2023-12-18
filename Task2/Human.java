package Task2;

import java.util.HashMap;

public class Human extends Unit{

    public Human(String name) {
        super(name);
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
