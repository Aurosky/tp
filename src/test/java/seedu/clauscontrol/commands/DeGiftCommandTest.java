//@@author prerana-r11
package seedu.clauscontrol.commands;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.clauscontrol.data.child.Child;
import seedu.clauscontrol.data.child.Name;
import seedu.clauscontrol.data.exception.IllegalValueException;
import seedu.clauscontrol.data.gift.Gift;
import seedu.clauscontrol.parser.Parser;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DeGiftCommandTest {

    private static Parser parser;
    private static ArrayList<Child> childList;

    @BeforeAll
    public static void setup() throws IllegalValueException {
        parser = new Parser(new ArrayList<>());
        childList = new ArrayList<>();
        Child child = new Child(new Name("John Doe"));
        child.addGift(new Gift("chocolate"));
        childList.add(child);
    }


    @Test
    public void degift_valid_removesGift() throws Exception {
        String input = "degift 1 1";
        Command command = parser.parseCommand(input);
        command.setData(childList, null, true);
        command.execute();
        assertEquals(0, childList.get(0).getGifts().size());
    }


    @Test
    public void degift_invalidChildIndex_returnsError() throws Exception {
        String input = "degift 2 1";
        Command command = parser.parseCommand(input);
        command.setData(childList, null, true);
        String result = command.execute();
        assertEquals("Please enter valid child index", result);
    }


    @Test
    public void degift_invalidGiftIndex_returnsError() throws Exception {
        String input = "degift 1 5";
        Command command = parser.parseCommand(input);
        command.setData(childList, null, true);
        String result = command.execute();
        assertEquals("Please enter valid gift index", result);
    }


    @Test
    public void degift_deliveredGift_returnsError() throws Exception {
        childList.get(0).getGifts().add(new Gift("ball"));
        childList.get(0).getGifts().get(0).markDelivered();

        String input = "degift 1 1";
        Command command = parser.parseCommand(input);
        command.setData(childList, null, true);
        String result = command.execute();
        assertTrue(result.contains("Cannot remove delivered gift"));
    }
}
//@@author
