package seedu.budgetbuddy.commands;

import seedu.budgetbuddy.expense.ExpenseManager;

public class DeleteExpenseCommand extends Command {
    int index;

    public DeleteExpenseCommand(int index) {
        this.index = index;
    }

    public static boolean isCommand(String command) {
        return command.startsWith("delete expense");
    }

    public void execute(){
        ExpenseManager.deleteExpense(index);
    }
}