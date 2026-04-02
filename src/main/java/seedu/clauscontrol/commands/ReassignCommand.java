//@@author GShubhan
package seedu.clauscontrol.commands;

/**
 * Manually reassigns a child to either the nice or naughty list.
 */
public class ReassignCommand extends Command {

    private final int childIndex;
    private final String list;

    public ReassignCommand(int childIndex, String list) {
        this.childIndex = childIndex;
        this.list = list;
    }

    @Override
    public String execute() {
        try {
            if (isFinalized) {
                return "Cannot reassign after the lists have been finalised!";
            }
            if (childList == null || childList.isEmpty()) {
                return "The child list is empty!";
            }
            if (childIndex < 1 || childIndex > childList.size()) {
                return "Enter a valid child index!";
            }
            if (!list.equals("nice") && !list.equals("naughty")) {
                return "Enter either nice or naughty";
            }
            childList.get(childIndex - 1).setListAssignment(list);
            return childList.get(childIndex - 1).getName()
                    + " has been reassigned to the " + list + " list!";
        } catch (Exception e) {
            return "Something went wrong with reassignment!";
        }
    }
}
//@@author
