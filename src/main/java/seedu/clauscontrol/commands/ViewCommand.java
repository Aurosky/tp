package seedu.clauscontrol.commands;

import seedu.clauscontrol.data.child.Child;
import seedu.clauscontrol.data.gift.Gift;
import java.util.ArrayList;

//@@author shrabasti-c
public class ViewCommand extends Command{
    private final int childIndex;

    public ViewCommand(int childIndex) {
        this.childIndex = childIndex;
    }

    @Override
    public String execute() {
        if (childIndex < 0 || childIndex >= childList.size()) {
            return "Invalid position :(";
        }

        Child child = childList.get(childIndex);
        int age = child.getAge();
        String ageMessage = (age == -1)? "Not Provided": String.valueOf(age);
        String location = child.getLocation();
        String locationMessage = (location == null )? "Not Provided": location;
        StringBuilder sb= new StringBuilder("Name: " + child.getName() + " \n");
        sb.append("Age: ").append(ageMessage).append("\n");
        sb.append("Location: ").append(locationMessage).append("\n");

        ArrayList<Gift> gifts = child.getGifts();
        if (!gifts.isEmpty()) {
            sb.append("Gifts: \n");
            createList(gifts, sb);
        }
        sb.append("Current Status: ").append((child.getTotalScore() >= 0) ? "Nice" : "Naughty").append(" \n");
        return sb.toString();
    }

    private static void createList(ArrayList<Gift> gifts, StringBuilder sb) {
        for (int j = 0; j < gifts.size(); j++) {
            sb.append("   ")
                    .append(j + 1)
                    .append(". ")
                    .append(gifts.get(j))
                    .append("\n");
        }
    }
}
//@@author
