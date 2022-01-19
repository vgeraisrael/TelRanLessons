package Controller;

public class SubmenuItem implements Item {

    String displayedName;
    InputOutput inputOutput;
    Item[] items;

    public SubmenuItem(String displayedName, InputOutput inputOutput, Item[] items) {
        this.displayedName = displayedName;
        this.inputOutput = inputOutput;
        this.items = items;
    }

    @Override
    public String displayName() {
        return displayedName;
    }

    @Override
    public void perforn() {
        Menu menu = new Menu(items, inputOutput);
        menu.runMenu();
    }


}
