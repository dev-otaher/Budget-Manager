package budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private final List<Expense> expenses;
    private float balance;

    public BudgetManager() {
        balance = 0;
        expenses = new ArrayList<>();
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getBalanceString() {
        return String.format("Balance: $%.2f", validateBalance(balance - getExpensesTotal()));
    }

    public float validateBalance(float balance) {
        if (balance < 0) {
            return 0;
        }
        return balance;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public float getExpensesTotal() {
        float expensesTotal = 0f;
        for (Expense expense : expenses) {
            expensesTotal += expense.getAmount();
        }
        return expensesTotal;
    }

    public String getExpensesTotalString() {
        return String.format("Total sum: $%.2f", getExpensesTotal());
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}
