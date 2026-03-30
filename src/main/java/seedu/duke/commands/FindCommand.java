//@@author Kiri
package seedu.duke.commands;

import seedu.duke.data.child.Child;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindCommand extends Command {
    private static final Logger logger = Logger.getLogger(FindCommand.class.getName());
    
    // 定义搜索类型
    public enum SearchType {
        NAME, AGE, LOCATION
    }
    
    private final String query;
    private final SearchType type;
    
    public FindCommand(String query, SearchType type) {
        assert query != null : "Query should not be null";
        this.query = query.trim().toLowerCase();
        this.type = type;
        logger.log(Level.FINE, "FindCommand initialized. Type: " + type + ", Query: " + query);
    }
    
    @Override
    public String execute() {
        if (childList.isEmpty()) {
            return "The child list is empty!";
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < childList.size(); i++) {
            Child child = childList.get(i);
            boolean isMatch = false;
            
            switch (type) {
            case NAME:
                isMatch = child.getName().toString().toLowerCase().contains(query);
                break;
            
            case AGE:
                if (child.hasAge()) {
                    isMatch = String.valueOf(child.getAge()).equals(query);
                }
                break;
            
            case LOCATION:
                if (child.hasLocation()) {
                    isMatch = child.getLocation().toLowerCase().contains(query);
                }
                break;
            }
            
            if (isMatch) {
                String ageInfo = child.hasAge() ? ", Age: " + child.getAge() : "";
                String locInfo = child.hasLocation() ? ", Loc: " + child.getLocation() : "";
                
                sb.append(String.format("[%d] %s%s%s\n",
                        i + 1, child.getName(), ageInfo, locInfo));
                count++;
            }
        }
        
        if (count == 0) {
            return "No match found for " + type.toString().toLowerCase() + ": " + query;
        } else {
            return "Found " + count + " matches:\n" + sb.toString().trim();
        }
    }
}
//@@author
