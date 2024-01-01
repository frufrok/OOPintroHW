package Task6;

public class Controller {
    private Indicator indicator;
    private Printer printer;
    public Controller(Indicator indicator, Printer printer) {
        this.indicator = indicator;
        this.printer = printer;
    }
    public void printFormatted(int x) throws IndicatorIncompleteException {
        this.printer.print(this.indicator.getFormatted(x));
    }
    public Indicator getIndicator() {
        return this.indicator;
    }
    public Printer getPrinter() {
        return this.printer;
    }
}
