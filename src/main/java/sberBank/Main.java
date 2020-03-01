package sberBank;

import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.setMoney(10000);

        List<Operationist> operationistList = new ArrayList<Operationist>();
        Operationist op1 = new Operationist(bank, "first Operator");
        Operationist op2 = new Operationist(bank, "second Operator");
        Operationist op3 = new Operationist(bank, "third Operator");
        operationistList.add(op1);
        operationistList.add(op2);
        operationistList.add(op3);

        for (Operationist operationist : operationistList) {
            operationist.start();
        }

        for (int i = 0; i < 10; i++) {
            boolean flag = true;
            if (i/2 == 0) {
                flag = false;
            }
             operationistList.get(0).addClients(new Client(flag, ((int) (Math.random() * 250) ), ((int) (Math.random() * 5000) ), ("Client№ " + (i+1))));

            Collections.sort(operationistList, new Comparator<Operationist>() {
                public int compare(Operationist o1, Operationist o2) {
                    return o1.getCountOfClients().compareTo(o2.getCountOfClients());
                }
            });
        }
    }
}
