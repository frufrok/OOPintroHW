package Task1;

import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) {
        Account acc1 = new Account(1, 90);
        checkAccount(acc1);
        Account acc2 = new CreditAccount(2, 100);
        checkAccount(acc2);
        DepositAccount acc3 = new DepositAccount(3, 110);
        checkAccount(acc3);

        System.out.println("Переводим время на 1 месяц назад для последнего пополнения.");
        acc3.turnBackInTimeDemo();
        System.out.println("Время последнего пополнения:");
        System.out.println(acc3.getLastPutDateTime());
        System.out.println("Снимаем средства.");
        acc3.takeAmount(50);
        printHistory(acc3);
    }
    
    private static void printHistory(Account account) {
        System.out.println("История операций:");
        for (HistoryRecord operation : account.getOperationsHistory()) {
            System.err.println(operation);
        }
    }

    private static void checkAccount(Account account) {
        System.out.println("Создан аккаунт:");
        System.out.println(account);

        account.putAmount(-10);
        account.putAmount(0);
        account.putAmount(10);
        // Для проверки времени последнего зачисления.
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.putAmount(10.123456);

        account.takeAmount(-10);
        account.takeAmount(0);
        account.takeAmount(50);
        account.takeAmount(10.123456);
        account.takeAmount(200);

        System.out.println("Текущий баланс:");
        System.err.println(account.getAmount());
        printHistory(account);
        System.out.println();
    }
}
