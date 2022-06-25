package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static BudgetManager budgetManager;

    private static List<Expense> parseData() {
        List<Expense> expenses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String title = data.substring(0, data.lastIndexOf('$')).trim();
            float amount = Float.parseFloat(data.replace(title + " $", ""));
            expenses.add(new Expense(title, amount));
        }
        return expenses;
    }

    private static void addIncome() {
        System.out.println("\nEnter income:");
        float income = Float.parseFloat(scanner.nextLine());
        budgetManager.setBalance(income);
        System.out.println("Income was added!\n");
    }

    private static void addExpense() {
        System.out.println("\nEnter purchase name:");
        String title = scanner.nextLine();
        System.out.println("Enter its price:");
        float price = Float.parseFloat(scanner.nextLine());
        Expense expense = new Expense(title, price);
        budgetManager.addExpense(expense);
        System.out.println("Purchase was added!\n");
    }

    private static void printExpenses() {
        System.out.println("\n");
        if (budgetManager.getExpenses().size() == 0) {
            System.out.println("The purchase list is empty\n");
            return;
        }
        for (Expense expense : budgetManager.getExpenses()) {
            System.out.printf("%s %s\n", expense.getTitle(), expense.getAmountString());
        }
        System.out.println(budgetManager.getExpensesTotalString() + "\n");
    }

    public static void main(String[] args) {
        // write your code here
        Menu menu = new Menu();
        scanner = new Scanner(System.in);
        budgetManager = new BudgetManager();
        int choice;
        do {
            menu.print();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    printExpenses();
                    break;
                case 4:
                    System.out.println("\n" + budgetManager.getBalanceString() + "\n");
                    break;
                case 0:
                    System.out.println("\n" + "Bye!" + "\n");
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }
}

