package seedu.budgetbuddy;

import seedu.budgetbuddy.commands.*;
import seedu.budgetbuddy.validators.*;

/**
 * The Parser class is responsible for interpreting user commands.
 *
 * It analyzes the user input, identifies the corresponding command,
 * and returns the appropriate Command object for execution.
 */
public class Parser {

    /**
     * Analyzes the user's input and returns the appropriate {@code Command} object.
     * It checks the input against known commands for expense, income, or exit operations.
     *
     * @param userCommandText The input string provided by the user.
     * @return The corresponding {@code Command} to execute, or an {@code IncorrectCommand}
     *         if the input is invalid.
     */
    public Command parseCommand(String userCommandText) {
        if (AddExpenseCommand.isCommand(userCommandText)) {
            return AddExpenseValidator.processCommand(userCommandText);
        }
        if (DeleteExpenseCommand.isCommand(userCommandText)) {
            return DeleteExpenseValidator.processCommand(userCommandText);
        }
        if (ListExpenseCommand.isCommand(userCommandText)) {
            return new ListExpenseCommand();
        }
        if (AddIncomeCommand.isCommand(userCommandText)) {
            return AddIncomeValidator.processCommand(userCommandText);
        }
        if (DeleteIncomeCommand.isCommand(userCommandText)) {
            return DeleteIncomeValidator.processCommand(userCommandText);
        }
        if (ListIncomeCommand.isCommand(userCommandText)) {
            return new ListIncomeCommand();
        }
        if (AddBudgetCommand.isCommand(userCommandText)) {
            return AddBudgetValidator.processCommand(userCommandText);
        }
        if (ExitCommand.isCommand(userCommandText)) {
            return new ExitCommand();
        }
        if (HelpCommand.isCommand(userCommandText)){
            return new HelpCommand();
        }
        return new IncorrectCommand("Invalid input");
    }
}
