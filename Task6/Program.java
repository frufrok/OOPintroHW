package Task6;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
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
    }

    static void printIndicator(int value) {
        Indicator indicator = new Indicator();
        Checker checker1 = new Checker() {
            @Override
            public boolean check(int x) {
                return (0 <= x && x <= 30);
            }

            @Override
            public String getDescription() {
                return "x in [0,30]";
            }
        };
        Checker checker2 = new Checker() {
            @Override
            public boolean check(int x) {
                return (31 <= x && x <= 75);
            }

            @Override
            public String getDescription() {
                return "x in [31,75]";
            }
        };
        Checker checker3 = new Checker() {
            @Override
            public boolean check(int x) {
                return (76 <= x && x <= 100);
            }

            @Override
            public String getDescription() {
                return "x in [76,100]";
            }
        };
        Checker checker4 = new Checker() {
            @Override
            public boolean check(int x) {
                return (x < 0 || x > 100);
            }

            @Override
            public String getDescription() {
                return "x out of [0,100]";
            }
        };
        Formatter redFormatter = new Formatter() {
            @Override
            public String format(int x) {
                return ANSI_RED + x + ANSI_RESET;
            }

            @Override
            public String getDescription() {
                return "red x";
            }
        };
        Formatter yellowFormatter = new Formatter() {
            @Override
            public String format(int x) {
                return ANSI_YELLOW + x + ANSI_RESET;
            }

            @Override
            public String getDescription() {
                return "yellow x";
            }
        };
        Formatter greenFormatter = new Formatter() {
            @Override
            public String format(int x) {
                return ANSI_GREEN + x + ANSI_RESET;
            }

            @Override
            public String getDescription() {
                return "green x";
            }
        };
        Formatter outOfRangeFormatter = new Formatter() {
            @Override
            public String format(int x) {
                return "некорректно";
            }

            @Override
            public String getDescription() {
                return "некорректно";
            }
        };
        indicator.addCheck(checker1, redFormatter);
        indicator.addCheck(checker2, yellowFormatter);
        indicator.addCheck(checker3, greenFormatter);
        indicator.addCheck(checker4, outOfRangeFormatter);
        Controller controller = new Controller(indicator, new ConsolePrinter());
        try {
            controller.printFormatted(value);
        }
        catch (IndicatorIncompleteException e) {
            Printer printer = new ConsolePrinter();
            printer.print("Индикатор не завершен:");
            printer.print(e.getMessage());
        }
    }

}