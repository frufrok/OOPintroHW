package Task2;

public class BaseEvent implements ExperienceProvidable{
    private String name;
    private int experience;
    public String getName() {
        return this.name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    protected void setExperience(int value) {
        this.experience = value;
    }
    @Override
    public int getExperience() {
        return this.experience;
    }
    public BaseEvent(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return String.format("Событие \"%s\" меняет опыт: %d.", this.name, this.experience);
    }
}
