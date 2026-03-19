//@@author Kiri
package seedu.duke.commands;

import seedu.duke.data.child.Name;
import seedu.duke.data.elf.Elf;
import seedu.duke.data.exception.IllegalValueException;

public class ElfCommand extends Command {
    public static final String MESSAGE_SUCCESS = "Ho ho ho! New elf added: %1$s";
    private final Elf toAdd;
    
    public ElfCommand(String name) throws IllegalValueException {
        this.toAdd = new Elf(new Name(name));
    }
    
    @Override
    public String execute() {
        elfList.add(toAdd);
        return String.format(MESSAGE_SUCCESS, toAdd);
    }
}
//@@author