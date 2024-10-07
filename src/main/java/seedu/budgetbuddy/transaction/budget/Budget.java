package seedu.budgetbuddy.transaction.budget;

import seedu.budgetbuddy.Ui;

import java.time.YearMonth;

/**
 * Represents a budget for a specific month and year.
 * A budget tracks a specified amount of money and the corresponding month and year.
 * Provides methods to edit and retrieve budget details.
 */
public class Budget {

    private double amount;
    private YearMonth date;

    /**
     * Constructs a Budget object with the specified amount and date.
     *
     * @param amount The amount allocated for the budget.
     * @param date   The YearMonth representing the month and year for the budget.
     */
    public Budget(double amount, YearMonth date) {
        this.amount = amount;
        this.date = date;
    }

    /**
     * Adds an additional amount to the current budget and displays a message indicating the updated budget.
     *
     * @param additionalAmount The amount to be added to the existing budget.
     */
    public void addAmount(double additionalAmount) {
        this.amount += additionalAmount;
        Ui.displayBudgetTransactionMessage(toString(), BudgetManager.getNumberOfBudgets());
    }

    /**
     * Gets the amount of the budget.
     *
     * @return The budget amount.
     */
    public double getAmount() {
        return amount; // Getter for the budget amount
    }

    /**
     * Gets the date of the budget.
     *
     * @return The YearMonth representing the budget date.
     */
    public YearMonth getDate() {
        return date; // Getter for the budget date
    }

    /**
     * Returns a string representation of the budget, including its amount and date.
     *
     * @return A string in the format "Amount: {amount}  Date: {date}".
     */
    public String toString() {
        String output = "";
        output += "Amount: " + amount;
        output += "  Date: " + date;
        return output;
    }
}