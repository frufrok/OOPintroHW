package Task6;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public interface myLambda{
        int applyLambdaExpression(int x, int y, int z);
    }

    public static void main(String[] args) {
        System.out.println(ANSI_YELLOW + "green" + ANSI_RESET);
        System.out.println("standard");
        System.out.println(ANSI_RED + "red" + ANSI_RESET);

        printIndicator(24); // красный
        printIndicator(34); // желтый
        printIndicator(74); // желтый
        printIndicator(95); // зеленый
        printIndicator(100); // зеленый

        printIndicator(-5);  // некорректно
        printIndicator(101); // некорректно

        myLambda lambda = ((x, y, z) -> (int) Math.round(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2)));
        System.out.println(lambda.applyLambdaExpression(1,2,3));
    }

    static void printIndicator(int value) {
        // TODO: код вписать тут
    }

}