//@@author GShubhan
package seedu.clauscontrol.commands;

import seedu.clauscontrol.data.todo.Todo;
import java.util.ArrayList;

/**
 * Lists all todo items.
 */
public class TodoListCommand extends Command {
    private final ArrayList<Todo> todoList;

    public TodoListCommand(ArrayList<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public String execute() {
        try {
            if (todoList == null || todoList.isEmpty()) {
                return "No todos added yet!";
            }
            StringBuilder sb = new StringBuilder("Here are your todos:\n");
            for (int i = 0; i < todoList.size(); i++) {
                if (todoList.get(i) != null) {
                    sb.append(i + 1).append(". ").append(todoList.get(i)).append("\n");
                }
            }
            return sb.toString().trim();
        } catch (Exception e) {
            return "Something went wrong displaying todos!";
        }
    }
}
//@@author
