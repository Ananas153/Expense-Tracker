package nam.nam;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseStorage {
    private static final String DELIMITER = ",";

    public static ArrayList<Expense> loadFromCSV(String filePath) {
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine(); // Skip header line (assumes first line is a header)

            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);

                int id = Integer.parseInt(values[0]);
                LocalDate date = LocalDate.parse(values[1]);
                String description = values[2];
                double amount = Double.parseDouble(values[3]);

                Expense expense = new Expense(id, date, amount, description);
                expenses.add(expense);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load expenses from CSV file: " + filePath, e);
        }
        return expenses;
    }

    public static void saveToCSV(String filePath, ArrayList<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Write header
            writer.write("id,date,description,amount");
            writer.newLine();

            // Write each expense line
            for (Expense expense : expenses) {
                writer.write(
                        expense.getId() + DELIMITER +
                                expense.getPurchasedDate() + DELIMITER +
                                expense.getDescription() + DELIMITER +
                                expense.getAmount()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save expenses to file: " + filePath, e);
        }
    }
}
