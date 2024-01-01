package Task6;
import java.util.HashMap;
import java.util.Map;

public class Indicator {
    Map<Checker, Formatter> checks = new HashMap<>();
    public Indicator(HashMap<Checker, Formatter> checks) {
        this.checks = checks;
    }
    public Indicator() {

    }
    public void addCheck(Checker checker, Formatter formatter) {
        checks.put(checker, formatter);
    }
    public void deleteCheck(Checker checker) {
        checks.remove(checker);
    }
    public String getFormatted(int x) throws IndicatorIncomplete {
        for (Checker check : checks.keySet()) {
            if (check.check(x)) {
                return checks.get(check).format(x);
            }
        }
        throw new IndicatorIncomplete(this.toString());
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Checker check : checks.keySet()) {
            stringBuilder.append(check.getDescription());
            stringBuilder.append(" -> ");
            stringBuilder.append(checks.get(check).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
