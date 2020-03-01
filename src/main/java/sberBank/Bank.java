package sberBank;

public class Bank {

    private int money;

    public synchronized void minusMoney(int minus) {
        money = money - minus;
        System.out.println("Общий счёт: " + money);

    }
    public synchronized void plusMoney (int plus) {
        money = money + plus;
        System.out.println("Общий счёт: " + money);

    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int  getMoney() {
        return money;
    }
}
