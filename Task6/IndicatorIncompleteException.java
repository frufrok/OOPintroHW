package Task6;

public class IndicatorIncompleteException extends Exception{
    private String message = "";
    public IndicatorIncompleteException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }

}
