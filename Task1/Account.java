package Task1;

import java.util.ArrayList;

public class Account {
    private final int id;
    private double amount;
    private ArrayList<HistoryRecord> operationsHistory;

    public Account(int id, double initialAmount) {
        this.id = id;
        this.operationsHistory = new ArrayList<>();
        addHistoryRecord(String.format("Создан аккаунт."));
        if (initialAmount > 0) {
            putAmount(initialAmount);
        }
    }

    public Account(int id) {
        this(id, 0);
    }

    public int getID() {
        return this.id;
    }

    public ArrayList<HistoryRecord> getOperationsHistory() {
        return this.operationsHistory;
    }

    protected void addHistoryRecord(String record) {
        this.operationsHistory.add(new HistoryRecord(record));
    }

    public void putAmount(double value) {
        value = round(value);
        if (value > 0) {
            this.amount += value;
            addHistoryRecord(String.format("Зачисление средств на сумму: %.2f. Текущий баланс: %.2f.", value, getAmountProtected()));
        } else {
            addHistoryRecord(String.format("Неудачная попытка зачисления средств на сумму: %.2f. Текущий баланс: %.2f.", value, getAmountProtected()));
        }
    }
    
    protected double getAmountProtected() {
        return Account.round(amount);
    }
    
    public double getAmount() {
        addHistoryRecord(String.format("Запрошен баланс. Текущий баланс: %.2f.", getAmountProtected()));
        return getAmountProtected();
    }

    public void takeAmount(double value) {
        value = round(value);
        if (value > 0) {
            if (value <= this.amount) {
                this.amount -= value;
                addHistoryRecord(String.format("Снятие средств на сумму: %.2f. Текущий баланс: %.2f.", value,
                                getAmountProtected()));
            } else {
                addHistoryRecord(String.format("Неудачная попытка снятия средств на сумму: %.2f. Текущий баланс: %.2f.", value, getAmountProtected()));
            }
        } else {
            addHistoryRecord(String.format("Неудачная попытка снятия средств на сумму: %.2f. Текущий баланс: %.2f.", value, getAmountProtected()));
        }
    }
    
    @Override
    public String toString() {
        return String.format("Account ID: %s", this.id);
    }

    static protected double round(double value) {
        return Math.round(value * 100) / 100.0;
    }
}
