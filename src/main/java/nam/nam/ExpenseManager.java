package nam.nam;

import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> listOfExpenses;

    public ExpenseManager() {
        this.listOfExpenses = new ArrayList<Expense>();
    }

    public void addExpense(Expense expense) {
        listOfExpenses.add(expense);
    }

    public void deleteExpense(int id) {
        listOfExpenses.removeIf(expense -> expense.getId() == id);
    }

    public void listExpenses() {
        for (Expense expense : this.listOfExpenses) {
            System.out.println(expense);
        }
    }

    public double summary(){
        double sum = 0;
        for(Expense expense : this.listOfExpenses){
            sum += expense.getAmount();
        }
        return sum;
    }
}
