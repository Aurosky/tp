//@@author GShubhan
package seedu.clauscontrol.commands;

/**
 * Finalises the nice and naughty lists, preventing further action changes.
 */
public class FinalizeCommand extends Command {

    @Override
    public String execute() {
        try {
            return "Lists have been finalised! No more actions can be added. You can now allocate gifts!";
        } catch (Exception e) {
            return "Something went wrong finalising the lists!";
        }
    }
}
//@@author
