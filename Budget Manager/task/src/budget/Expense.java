package budget;

public class Expense {
    private String title;
    private float amount;

    public Expense(String title, float amount) {
        this.title = title;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getAmount() {
        return amount;
    }

    public String getAmountString() {
        return String.format("$%.2f", amount);
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
