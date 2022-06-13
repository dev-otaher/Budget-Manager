package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Expense> parseData() {
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

    public static void printExpenses(List<Expense> expenses) {
        float total = 0.0f;
        for (Expense expense : expenses) {
            System.out.printf("%s %s", expense.getTitle(), expense.getAmountString());
            total += expense.getAmount();
        }
        System.out.printf("Total: $%.2f", total);
    }

    public static void main(String[] args) {
        // write your code here
        printExpenses(parseData());
    }
}

