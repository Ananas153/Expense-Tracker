package nam.nam;

import java.time.LocalDate;

public class Expense {
    private int id;
    private LocalDate purchasedDate;
    private String description;
    private double amount;

    public Expense(int id, LocalDate purchasedDate, String description, double amount) {
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
        return id + "\t" + purchasedDate + "\t" + description + "\t\t$" + amount;
    }
}
