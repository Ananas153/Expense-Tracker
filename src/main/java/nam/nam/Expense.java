package nam.nam;

import java.time.LocalDate;

public class Expense {
    private int id;
    private LocalDate purchasedDate;
    private double amount;
    private String description;

    public Expense(int id, LocalDate purchasedDate, double amount, String description) {
        this.id = id;
        this.purchasedDate = purchasedDate;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", purchasedDate=" + purchasedDate +
                ", description='" + description +
                ", amount=" + amount + '\'' +
                '}';
    }
}
