package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        String commmand = tokens[0];

        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!commmand.equals("End")) {
            String result = "";
            switch (commmand) {
                case "Create":

                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    result = "Account ID" + account.getId() + " created";
                    break;

                case "Deposit":
                    int accountId = Integer.parseInt(tokens[1]);
                    double amount = Integer.parseInt(tokens[2]);

                    BankAccount current = accounts.get(accountId);
                    if (current == null) {
                        result = "Account does not exist";
                        break;
                    }
                    current.deposit(amount);
                    accounts.put(accountId, current);
                    result = String.format("Deposited %.0f to ID%s", amount, accountId);
                    break;

                case "SetInterest":
                    double interset = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interset);
                    break;
                case "GetInterest":
                    int accountId2 = Integer.parseInt(tokens[1]);
                    int year = Integer.parseInt(tokens[2]);

                    BankAccount current2 = accounts.get(accountId2);
                    if (current2 == null) {
                        result = "Account does not exist";
                        break;
                    }
                    double accountIterest = current2.getInterest(year);
                    result = String.format("%.2f", accountIterest);
                    break;

            }
            if (!result.isEmpty()) {
                System.out.println(result);
            }


            tokens = scanner.nextLine().split(" ");
            commmand = tokens[0];

        }

    }
}
