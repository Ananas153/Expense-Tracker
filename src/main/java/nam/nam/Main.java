package nam.nam;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
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
                System.out.println("Expense added successfully (ID:" + expenseAdd.getId() + ")");
                break;
            case "list":
                expenseManager.listExpenses();
                break;
            case "summary":
                if (args.length == 1) {
                    System.out.println("Total expenses: $" + expenseManager.summary());
                } else if (args[1].equals("--month")) {
                    if (Integer.parseInt(args[2]) >= 1 && Integer.parseInt(args[2]) <= 12) {
                        System.out.println("Total expenses for " + Month.of(Integer.parseInt(args[2]))
                                + ": " + expenseManager.summaryByMonth(Integer.parseInt(args[2])));
                    } else {
                        System.out.println("There's only 12 month, please insert 1 to 12 for January to December");
                    }
                }
                break;
            case "delete":
                if (!args[1].equals("--id")) {
                    System.out.println("Wrong flag, use --id to select the expense to delete");
                }
                if (Integer.parseInt(args[2]) > 0 && Integer.parseInt(args[2]) <= expenseManager.counterExpense()) {
                    expenseManager.deleteExpense(Integer.parseInt(args[2]));
                    ExpenseStorage.saveToCSV(FILE_PATH, expenseManager.getListOfExpenses());
                    System.out.println("Expense deleted successfully");
                } else {
                    System.out.println("ID out of bound");
                }
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