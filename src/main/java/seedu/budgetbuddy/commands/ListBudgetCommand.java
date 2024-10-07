package seedu.budgetbuddy.commands;

import seedu.budgetbuddy.transaction.budget.BudgetManager;

import java.time.YearMonth;

/**
 * Represents a command to list all budgets managed by the BudgetManager.
 * This command retrieves and displays the current budgets for the user.
 */
public class ListBudgetCommand extends Command {
    private YearMonth date;

    /**
     * Constructs a ListBudgetCommand with an optional YearMonth.
     *
     * @param date The YearMonth for which budgets should be listed, or null for all budgets.
     */
    public ListBudgetCommand(YearMonth date) {
        this.date = date;
    }
    /**
     * Checks if the provided command matches the command to list budget.
     *
     * @param command The command to be checked.
     * @return True if the command matches "list budget", false otherwise.
     */
    public static boolean isCommand(String command) {
        return command.startsWith("list budget");
    }

    /**
     * Executes the command to list all budgets by invoking the BudgetManager's method.
     */
    @Override
    public void execute() {
        BudgetManager.listBudgets(date); // List all budgets
    }
}
