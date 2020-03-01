package sberBank;

public class Bank {

    private int money;

    public synchronized void minusMoney(int minus) {
        money = money - minus;
    }
    public synchronized void plusMoney (int plus) {
        money = money + plus;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
