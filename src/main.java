import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import model.Expense;
import service.ExpenseService;
import util.InputUtil;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputUtil inputUtil = new InputUtil(scanner);

        ExpenseService expenseService = new ExpenseService();

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("         EXPENSE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Find Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Search Expense");
            System.out.println("7. Expense Summary");
            System.out.println("8. Monthly Summary");
            System.out.println("9. Sort by Amount");
            System.out.println("0. Exit");
            System.out.println("================================");

          int choice =
        inputUtil.readMenuChoice(
                "Enter your choice: ",
                0,
                9
        );

            switch (choice) {

                case 1:

                  addExpense(expenseService, inputUtil);

                    break;

                case 2:

                   viewExpenses(expenseService);

                    break;

                case 3:

                findExpense(expenseService,inputUtil);

                 break;

                case 4:

                 updateExpense(expenseService, inputUtil);

                    break;

                case 5:

                deleteExpense(expenseService, inputUtil);
                break;

                case 6:

                searchExpenses(expenseService, inputUtil);

                 break;

                 case 7:
                 showSummary(expenseService, inputUtil);
                 break;

                 case 8:

                 monthlySummary(expenseService, inputUtil);
                 break;

                 case 9:

                 sortExpenses(expenseService, inputUtil);
                 break;

                 case 0:

                    System.out.println("Thank you for using Expense Tracker!");

                    scanner.close();

                    return;

                 default:

                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void addExpense(ExpenseService expenseService,
        InputUtil inputUtil) {

    double amount =
            inputUtil.readDouble("Enter amount: ");

    String category =
            inputUtil.readString("Enter category: ");

    String description =
            inputUtil.readString("Enter description: ");

    LocalDate date =
            inputUtil.readDate("Enter date (YYYY-MM-DD): ");

    String paymentMethod =
            inputUtil.readString("Enter payment method: ");

    Expense expenseItem =
            new Expense(
                    0,
                    amount,
                    category,
                    description,
                    date,
                    paymentMethod
            );

    expenseService.addExpense(expenseItem);

    System.out.println("Expense added successfully.");
}

private static void viewExpenses(
        ExpenseService expenseService) {

    List<Expense> expenses =
            expenseService.getAllExpenses();

    if (expenses.isEmpty()) {

        System.out.println("No expenses found.");

    } else {

        for (Expense expense : expenses) {

            printExpense(expense);
        }

        
    }
}

private static void findExpense(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    int id =
            inputUtil.readInt("Enter expense ID: ");

    Expense foundExpense =
            expenseService.findExpenseById(id);

    if (foundExpense != null) {

        printExpense(foundExpense);

    } else {

        System.out.println("Expense not found.");
    }
}

private static void updateExpense(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    int updateId =
            inputUtil.readInt("Enter expense ID: ");

    Expense expenseToUpdate =
            expenseService.findExpenseById(updateId);

    if (expenseToUpdate == null) {

        System.out.println("Expense not found.");
        return;
    }

    double amount =
            inputUtil.readDouble("Enter new amount: ");

    String category =
            inputUtil.readString("Enter new category: ");

    String description =
            inputUtil.readString("Enter new description: ");

    LocalDate date =
            inputUtil.readDate(
                    "Enter new date (YYYY-MM-DD): "
            );

    String paymentMethod =
            inputUtil.readString("Enter new payment method: ");

    boolean updated =
            expenseService.updateExpense(
                    updateId,
                    amount,
                    category,
                    description,
                    date,
                    paymentMethod
            );

    if (updated) {

        System.out.println(
                "Expense updated successfully."
        );
    }
}


private static void deleteExpense(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    int deleteId =
            inputUtil.readInt("Enter expense ID: ");

    Expense expense =
            expenseService.findExpenseById(deleteId);

    if (expense == null) {

        System.out.println("Expense not found.");
        return;
    }

    System.out.println(
            "You are about to delete expense:"
    );

    System.out.println(
            "ID: " + expense.getId()
    );

    System.out.println(
            "Amount: " + expense.getAmount()
    );

    System.out.println(
            "Category: " + expense.getCategory()
    );

    System.out.println(
            "Description: " + expense.getDescription()
    );

    boolean confirmed =
            inputUtil.readYesNo(
                    "Are you sure? (yes/no): "
            );

    if (!confirmed) {

        System.out.println(
                "Deletion cancelled."
        );

        return;
    }

    boolean deleted =
            expenseService.deleteExpense(deleteId);

    if (deleted) {

        System.out.println(
                "Expense deleted successfully."
        );
    }
}

private static void searchExpenses(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    String keyword =
            inputUtil.readString(
                    "Enter category or description: "
            );

    List<Expense> results =
            expenseService.searchExpenses(keyword);

    if (results.isEmpty()) {

        System.out.println("No matching expenses found.");

    } else {

        System.out.println("Matching Expenses:");

        for (Expense expense : results) {

            printExpense(expense);
        }

        
    }
}

private static void showSummary(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    double total =
            expenseService.calculateTotal();

    System.out.println("----------------------------");
    System.out.printf("Total Expenses: ₹%,.2f%n", total);

    System.out.println();
    System.out.println("Category-wise Spending:");

    Map<String, Double> categoryTotals =
            expenseService.getCategoryTotals();

    for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {

        System.out.printf(
                "%s: ₹%,.2f%n",
                entry.getKey(),
                entry.getValue()
        );
    }

    System.out.println("----------------------------");
}


private static void monthlySummary(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    int year =
            inputUtil.readInt("Enter year: ");

    int month =
            inputUtil.readInt("Enter month (1-12): ");

    if (month < 1 || month > 12) {

        System.out.println("Invalid month.");
        return;
    }

   Month selectedMonth = Month.of(month);

String monthName =
        selectedMonth.getDisplayName(
                TextStyle.FULL,
                Locale.ENGLISH
        );

    double total =
            expenseService.getTotalByMonth(year, month);

    Map<String, Double> categoryTotals =
            expenseService.getCategoryTotalsByMonth(
                    year,
                    month
            );

    System.out.println("----------------------------");

    System.out.println(
            "Monthly Summary: " + monthName + " " + year
    );

    System.out.printf(
            "Total Expenses: ₹%,.2f%n",
            total
    );

    System.out.println();

    System.out.println("Category-wise Spending:");

    if (categoryTotals.isEmpty()) {

        System.out.println("No expenses found for this month.");

    } else {

        for (Map.Entry<String, Double> entry
                : categoryTotals.entrySet()) {

            System.out.printf(
                    "%s: ₹%,.2f%n",
                    entry.getKey(),
                    entry.getValue()
            );
        }
    }

    System.out.println("----------------------------");
}

private static void sortExpenses(
        ExpenseService expenseService,
        InputUtil inputUtil) {

    System.out.println("----------------------------");
    System.out.println("Sort Expenses");
    System.out.println("1. Highest Amount");
    System.out.println("2. Lowest Amount");
    System.out.println("3. Newest First");
    System.out.println("4. Oldest First");

    int choice =
            inputUtil.readMenuChoice(
                    "Enter your choice: ",
                    1,
                    4
            );

    List<Expense> sortedExpenses;

    switch (choice) {

        case 1:
            sortedExpenses =
                    expenseService.getExpensesSortedByAmount();
            break;

        case 2:
            sortedExpenses =
                    expenseService.getExpensesSortedByAmountAscending();
            break;

        case 3:
            sortedExpenses =
                    expenseService.getExpensesSortedByDate();
            break;

        case 4:
            sortedExpenses =
                    expenseService.getExpensesSortedByDateAscending();
            break;

        default:
            return;
    }

    if (sortedExpenses.isEmpty()) {

        System.out.println("No expenses found.");
        return;
    }

    System.out.println("----------------------------");
    System.out.println("Sorted Expenses:");
    System.out.println("----------------------------");

    for (Expense expense : sortedExpenses) {

        printExpense(expense);
    }
}


private static void printExpense(Expense expense) {

    System.out.println("----------------------------");
    System.out.println("ID: " + expense.getId());
    System.out.printf("Amount: ₹%.2f%n", expense.getAmount());
    System.out.println("Category: " + expense.getCategory());
    System.out.println("Description: " + expense.getDescription());
    System.out.println("Date: " + expense.getDate());
    System.out.println("Payment Method: " + expense.getPaymentMethod());
}



}
