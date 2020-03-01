package sberBank;

public class Client  {
    private Boolean isWithdrawMoney;// снять деньги
    private Integer money;
    private Integer time;
    private String clientName;

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setWithdrawMoney(boolean withdrawMoney) {
        isWithdrawMoney = withdrawMoney;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isWithdrawMoney() {
        return isWithdrawMoney;
    }

    public int getMoney() {
        return money;
    }

    public int getTime() {
        return time;
    }

    public Client(boolean isWithdrawMoney, int money, int time, String clientName) {
        this.isWithdrawMoney = isWithdrawMoney;
        this.money = money;
        this.time = time;
        this.clientName = clientName;
    }
}
