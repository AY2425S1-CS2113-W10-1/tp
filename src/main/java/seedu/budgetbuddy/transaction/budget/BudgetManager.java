package seedu.budgetbuddy.transaction.budget;

import seedu.budgetbuddy.Ui;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Manages the budgets for different months and years.
 * Provides methods to add, retrieve, and manage multiple budgets.
 */
public class BudgetManager {
    private static int numberOfBudgets = 0;
    private static ArrayList<Budget> budgets = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(BudgetManager.class.getName());

    /**
     * Construct a BudgetManager of array content incomes
     *
     * @param budgets The content to be instantiated
     * @param numberOfBudgets The initial count of budgets managed by BudgetManager.
     */
    public BudgetManager(ArrayList<Budget> budgets, int numberOfBudgets){
        BudgetManager.budgets = budgets;
        BudgetManager.numberOfBudgets = numberOfBudgets;
    }

    /**
     * Adds a new budget to the list and increments the total number of budgets.
     * Displays a message indicating that a new budget has been added.
     *
     * @param budget The Budget object to be added.
     */
    public static void addBudget(Budget budget) {
        assert budget != null : "Budget to be added cannot be null";
        budgets.add(budget);
        numberOfBudgets++;
        logger.info("Added budget: " + budget);
        Ui.displayBudgetTransactionMessage(budget.toString(), numberOfBudgets);
    }

    /**
     * Deletes budget from the list and decrements the total number of budgets.
     * Displays a message indicating that a budget is deleted.
     *
     * @param budget The Budget object to be added.
     */
    public static void deleteBudget(Budget budget) {
        assert budget != null : "Budget to be deleted cannot be null";
        budgets.remove(budget);
        numberOfBudgets--;
        logger.info("Deleted budget: " + budget);
        Ui.displayBudgetDeletedMessage(budget.toString(), numberOfBudgets);
    }

    /**
     * Returns the current number of budgets.
     *
     * @return The total number of budgets.
     */
    public static int getNumberOfBudgets() {
        return numberOfBudgets;
    }

    /**
     * Retrieves a budget for the specified YearMonth date.
     *
     * @param date The YearMonth representing the month and year for the budget.
     * @return The existing Budget for the specified date, or null if no budget exists.
     */
    public static Budget getBudget(YearMonth date) {
        assert date != null : "Date cannot be null";
        for (Budget budget : budgets) {
            if (budget.getDate().equals(date)) {
                logger.info("Retrieved budget for date: " + date);
                return budget;
            }
        }
        logger.info("No budget found for date: " + date);
        return null; // No budget found for the specified date
    }

    /**
     * Lists all or specified budgets managed by the manager.
     * Displays each budget with its corresponding number.
     */
    public static void listBudgets(YearMonth date) {
        String result = "";
        if (date == null) {
            logger.info("No date specified for listing budget.");

            result += "Here are the budgets for the 12 most recent entries:\n";

            int entriesToDisplay = Math.min(budgets.size(), 12);
            for (int counter = 1; counter <= entriesToDisplay; counter++) {
                Budget budget = budgets.get(budgets.size() - counter);
                result += counter + ". " + budget.toString() + "\n";
            }
        } else {
            // Assume validator guarantees date is valid
            logger.info("Listing budgets for date: " + date);

            Budget budget = getBudget(date);

            if (budget != null) {
                result += "Here is the budget for the specified month:\n";
                result += budget.toString();
            }
        }
        Ui.displayToUser(result);
    }

    /**
     * A get-function to obtain the information in the current Budget List.
     *
     * @return return the budget ArrayList
     */
    public static ArrayList<Budget> getBudgets() {
        return budgets;
    }

    /**
     * Resets the state of the BudgetManager by clearing all budgets and
     * setting the total number of budgets to zero.
     * <p>
     * This method is used for unit testing, ensuring that each test
     * starts with a clean slate and does not retain any state from
     * previous tests.
     * </p>
     */
    public static void reset() {
        numberOfBudgets = 0;
        budgets.clear();
    }
}
