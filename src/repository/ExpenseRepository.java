package repository;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.time.LocalDate;

import model.Expense;

public class ExpenseRepository {

    private String filePath;
    public ExpenseRepository(String filePath) {
        this.filePath = filePath;
    }

    public void saveExpenses(List<Expense> expenses) {

    try {


        BufferedWriter writer =
                new BufferedWriter(new FileWriter(filePath));

        for (Expense expense : expenses) {

            writer.write(
                    expense.getId() + "," +
                    expense.getAmount() + "," +
                    expense.getCategory() + "," +
                    expense.getDescription() + "," +
                    expense.getDate() + "," +
                    expense.getPaymentMethod()
            );

            writer.newLine();
        }

        writer.close();

    } catch (IOException e) {

        System.out.println("Error saving expenses.");
       // e.printStackTrace();
    }
}


public List<Expense> loadExpenses() {

    List<Expense> expenses = new ArrayList<>();

    try {

        BufferedReader reader =
                new BufferedReader(new FileReader(filePath));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            double amount = Double.parseDouble(data[1]);
            String category = data[2];
            String description = data[3];
            LocalDate date = LocalDate.parse(data[4]);
            String paymentMethod = data[5];

            Expense expense = new Expense(
                    id,
                    amount,
                    category,
                    description,
                    date,
                    paymentMethod
            );

            expenses.add(expense);
        }

        reader.close();

    } catch (IOException e) {

        System.out.println("No saved expenses found.");

    }

    return expenses;
}

    
}
