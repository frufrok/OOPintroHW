package Task6;

public class IndicatorIncomplete extends Exception{
    private String message = "";
    public IndicatorIncomplete(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }

}
