package sberBank;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Operationist extends Thread {

    private final List<Client> clients = new ArrayList<Client>();

    public List<Client> getClients() {
        return clients;
    }

    private Bank bank;
    private String operatorName;
    private Integer countOfClients = 0;

    public Operationist(Bank bank, String operatorName) {
        this.bank = bank;
        this.operatorName = operatorName;
    }
    public void addClients(Client client) {
        synchronized (clients) {
            clients.add(client);
            countOfClients = countOfClients + 1;
            clients.notify();
        }
    }

    public Integer getCountOfClients() {
        return countOfClients;
    }

    @Override
    public void run() {
        while (true) {
            if (clients.isEmpty()) {
                synchronized (clients) {
                    try {
                        clients.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Client currentClient = clients.remove(0);
                countOfClients = countOfClients - 1;
                if (currentClient.isWithdrawMoney()) {
                    if (currentClient.getMoney() > bank.getMoney()) {
                        System.out.println("Оператор "+ operatorName + " не может выдать деньги клинту " + currentClient.getClientName());
                        this.clients.add(currentClient);
                    } else {
                        bank.minusMoney(currentClient.getMoney());
                        try {
                            Thread.sleep(currentClient.getTime());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Клиент "+ currentClient.getClientName() + " снял деньги у оператора" + operatorName);
                        System.out.println("Общий счёт: " + bank.getMoney());
                    }
                } else {
                    bank.plusMoney(currentClient.getMoney());
                    System.out.println("Клиент "+ currentClient.getClientName() + " положил деньги в банк у операционистки " + operatorName);
                    try {
                        Thread.sleep(currentClient.getTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
