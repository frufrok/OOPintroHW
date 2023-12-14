package Task1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends Account {

    private LocalDateTime lastPutDateTime;

    public DepositAccount(int id, double initialAmount) {
        super(id, initialAmount);
        this.lastPutDateTime = LocalDateTime.now();
    }

    public DepositAccount(int id) {
        this(id, 0);
    }

    public LocalDateTime getLastPutDateTime() {
        this.addHistoryRecord(String.format("Запрошена дата и время последнего пополнения счета. Время и дата последнего пополнения: %s", this.lastPutDateTime.toString()));
        return this.lastPutDateTime;
    }

    @Override
    public void takeAmount(double value) {
        value = Account.round(value);
        if (value > 0) {
            long elapsed = ChronoUnit.MONTHS.between(lastPutDateTime, LocalDateTime.now());
            if (elapsed >= 1) {
                super.takeAmount(value);
            } else {
                this.addHistoryRecord(String.format(
                        "Неудачная попытка снятия средств на сумму: %.2f. Дата последнего пополнения: %s.", value,
                        this.lastPutDateTime));
            }
        } else {
            this.addHistoryRecord(
                    String.format("Неудачная попытка снятия средств на сумму: %.2f. Текущий баланс: %.2f.", value,
                            this.getAmountProtected()));
        }
    }
    
    @Override
    public void putAmount(double value) {
        value = round(value);
        if (value > 0) {
            super.putAmount(value);
            this.lastPutDateTime = LocalDateTime.now();
        } else {
            addHistoryRecord(String.format("Неудачная попытка зачисления средств на сумму: %.2f. Текущий баланс: %.2f.",
                    value, getAmountProtected()));
        }
    }

    @Override
    public String toString() {
        return String.format("Deposit account ID: %s", this.getID());
    }

    public void turnBackInTimeDemo() {
        this.lastPutDateTime = LocalDateTime.now().minusMonths(1);
    }
}
