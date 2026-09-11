package service;
import model.Expense;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

import repository.ExpenseRepository;

public class ExpenseService {
    private List<Expense> expenses;
    private int nextId;
    private ExpenseRepository expenseRepository;

    public ExpenseService() {

    expenseRepository = new ExpenseRepository("../data/expenses.txt");

    expenses = expenseRepository.loadExpenses();

    nextId = 1;

    for (Expense expense : expenses) {

        if (expense.getId() >= nextId) {
            nextId = expense.getId() + 1;
        }
    }
}

    public void addExpense(Expense expense) {

    Expense newExpense = new Expense(
            nextId,
            expense.getAmount(),
            expense.getCategory(),
            expense.getDescription(),
            expense.getDate(),
            expense.getPaymentMethod()
    );

    expenses.add(newExpense);

    nextId++;
    expenseRepository.saveExpenses(expenses);
}

    public List<Expense> getAllExpenses() {
        return expenses;
    }


    public Expense findExpenseById(int id) {

    for (Expense expense : expenses) {

        if (expense.getId() == id) {
            return expense;
        }
    }

    return null;
}

public boolean deleteExpense(int id) {

    for (int i = 0; i < expenses.size(); i++) {

        if (expenses.get(i).getId() == id) {

            expenses.remove(i);

            expenseRepository.saveExpenses(expenses);

            return true;
        }
    }

    return false;
}

public boolean updateExpense(
        int id,
        double amount,
        String category,
        String description,
        LocalDate date,
        String paymentMethod) {

    Expense expense = findExpenseById(id);

    if (expense != null) {

        expense.setAmount(amount);
        expense.setCategory(category);
        expense.setDescription(description);
        expense.setDate(date);
        expense.setPaymentMethod(paymentMethod);

        expenseRepository.saveExpenses(expenses);
        return true;
    }

    return false;
}

public List<Expense> searchExpenses(String keyword) {

    List<Expense> results = new ArrayList<>();

    for (Expense expense : expenses) {

        if (expense.getCategory().toLowerCase().contains(keyword.toLowerCase())
                || expense.getDescription().toLowerCase().contains(keyword.toLowerCase())) {

            results.add(expense);
        }
    }

    return results;
}

public double calculateTotal() {

    double total = 0;

    for (Expense expense : expenses) {

        total = total + expense.getAmount();
    }

    return total;
}

public double getTotalByCategory(String category) {

    double total = 0;

    for (Expense expense : expenses) {

        if (expense.getCategory().equalsIgnoreCase(category)) {
            total = total + expense.getAmount();
        }
    }

    return total;
}

public Map<String, Double> getCategoryTotals() {

    Map<String, Double> categoryTotals = new HashMap<>();

    for (Expense expense : expenses) {

        String category = expense.getCategory();

        double currentTotal =
                categoryTotals.getOrDefault(category, 0.0);

        categoryTotals.put(
                category,
                currentTotal + expense.getAmount()
        );
    }

    return categoryTotals;
}

public double getTotalByMonth(int year, int month) {

    double total = 0;

    for (Expense expense : expenses) {

        LocalDate date = expense.getDate();

        if (date.getYear() == year
                && date.getMonthValue() == month) {

            total = total + expense.getAmount();
        }
    }

    return total;
}

public Map<String, Double> getCategoryTotalsByMonth(
        int year,
        int month) {

    Map<String, Double> categoryTotals =
            new HashMap<>();

    for (Expense expense : expenses) {

        LocalDate date = expense.getDate();

        if (date.getYear() == year
                && date.getMonthValue() == month) {

            String category =
                    expense.getCategory();

            double currentTotal =
                    categoryTotals.getOrDefault(
                            category,
                            0.0
                    );

            categoryTotals.put(
                    category,
                    currentTotal + expense.getAmount()
            );
        }
    }

    return categoryTotals;
}

public List<Expense> getExpensesSortedByAmount() {

    List<Expense> sortedExpenses =
            new ArrayList<>(expenses);

    sortedExpenses.sort(
            Comparator.comparingDouble(
                    Expense::getAmount
            ).reversed()
    );

    return sortedExpenses;
}

public List<Expense> getExpensesSortedByDate() {

    List<Expense> sortedExpenses =
            new ArrayList<>(expenses);

    sortedExpenses.sort(
            Comparator.comparing(
                    Expense::getDate
            ).reversed()
    );

    return sortedExpenses;
}

public List<Expense> getExpensesSortedByAmountAscending() {

    List<Expense> sortedExpenses =
            new ArrayList<>(expenses);

    sortedExpenses.sort(
            Comparator.comparingDouble(
                    Expense::getAmount
            )
    );

    return sortedExpenses;
}

public List<Expense> getExpensesSortedByDateAscending() {

    List<Expense> sortedExpenses =
            new ArrayList<>(expenses);

    sortedExpenses.sort(
            Comparator.comparing(
                    Expense::getDate
            )
    );

    return sortedExpenses;
}

}

   