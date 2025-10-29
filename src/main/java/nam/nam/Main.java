package nam.nam;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static final String FILE_PATH = "C:/Users/ngoth/Desktop/Expense Tracker/src/main/resources/ExpenseList.csv";

    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager(initialFile());

        switch (args[0]) {
            case "add":
                if (!args[1].equals("--description") || !args[3].equals("--amount")) {
                    System.out.println("Wrong flag, use both --description and --amount to add value");
                }
                Expense expenseAdd = new Expense(expenseManager.counterExpense() + 1, LocalDate.now(), Double.parseDouble(args[4]), args[2]);
                expenseManager.addExpense(expenseAdd);
                ExpenseStorage.saveToCSV(FILE_PATH, expenseManager.getListOfExpenses());
                System.out.println("# Expense added successfully (ID:" + expenseAdd.getId() + ")");
                break;
            case "list":
                break;
        }
    }

    public static ArrayList<Expense> initialFile() {
        File file = new File(FILE_PATH);
        try {
            if (!file.isFile()) {
                file.createNewFile();
                System.out.println("File created with name: " + file.getName() +
                        " at " + file.getAbsolutePath());
            }
            return ExpenseStorage.loadFromCSV(FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize task file", e);
        }
    }
}