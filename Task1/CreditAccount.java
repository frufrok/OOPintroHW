package Task1;

public class CreditAccount extends Account {
    public CreditAccount(int id, double initialAmount) {
        super(id, initialAmount);
    }

    public CreditAccount(int id) {
        super(id);
    }

    @Override
    public void takeAmount(double value) {
        value = Account.round(value);
        if (value > 0) {
            double commission = Account.round(value * 0.01);
            this.addHistoryRecord(String.format("Запрошено снятие средств на сумму: %.2f. Комиссия банка: %.2f.", value, commission));
            super.takeAmount(value + commission);
        }
        else {
            this.addHistoryRecord(String.format("Неудачная попытка снятия средств на сумму: %.2f. Текущий баланс: %.2f.", value,
                            this.getAmountProtected()));
        }
    }

    @Override
    public String toString() {
        return String.format("Credit account ID: %s", this.getID());
    }
}
