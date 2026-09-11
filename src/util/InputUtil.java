package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {

    private Scanner scanner;

    public InputUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String message) {

    while (true) {

        System.out.print(message);

        try {

            return Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            System.out.println("Invalid number. Please try again.");
        }
    }
}

public int readMenuChoice(String message, int min, int max) {

    while (true) {

        int choice = readInt(message);

        if (choice >= min && choice <= max) {

            return choice;
        }

        System.out.println(
                "Invalid choice. Please enter a number between "
                + min + " and " + max + "."
        );
    }
}

public double readDouble(String message) {

    while (true) {

        System.out.print(message);

        try {

            double value = Double.parseDouble(scanner.nextLine());

            if (value <= 0) {

                System.out.println("Amount must be greater than 0.");
                continue;
            }

            return value;

        } catch (NumberFormatException e) {

            System.out.println("Invalid amount. Please try again.");
        }
    }
}

public String readString(String message) {

    while (true) {

        System.out.print(message);

        String value = scanner.nextLine();

        if (value.trim().isEmpty()) {

            System.out.println("Input cannot be empty.");
            continue;
        }

        return value.trim();
    }
}

public LocalDate readDate(String message) {

    while (true) {

        System.out.print(message);

        try {

            return LocalDate.parse(scanner.nextLine());

        } catch (DateTimeParseException e) {

            System.out.println("Invalid date. Please use YYYY-MM-DD.");
        }
    }
}

public boolean readYesNo(String message) {

    while (true) {

        String input =
                readString(message);

        if (input.equalsIgnoreCase("yes")
                || input.equalsIgnoreCase("y")) {

            return true;
        }

        if (input.equalsIgnoreCase("no")
                || input.equalsIgnoreCase("n")) {

            return false;
        }

        System.out.println(
                "Please enter yes or no."
        );
    }
}


    
}
