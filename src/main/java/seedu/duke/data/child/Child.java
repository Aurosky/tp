package seedu.duke.data.child;

import java.util.ArrayList;
import seedu.duke.data.Gift.Gift;

//Solution below inspired by https://github.com/se-edu/addressbook-level2/blob/master/src/seedu/addressbook/data
// /person/Person.java
public class Child implements ReadOnlyChild{
    private Name name;
    private ArrayList<Gift> gifts;

    public Child(Name name) {
        this.name = name;
        this.gifts=new ArrayList<>();
    }
    public void addGift(Gift gift){
        gifts.add(gift);
    }
    public Gift getGift(int index){
        return gifts.get(index);
    }
    public void removeGift(int index){
        gifts.remove(index);
    }
    public ArrayList<Gift> getGifts(){
        return gifts;
    }

    @Override
    public Name getName() {
        return name;
    }

    // ChatGPT was used to ideate and generate this mutator method
    public void editName(Name newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
