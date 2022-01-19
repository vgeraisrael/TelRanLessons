package Controller;

public class Menu {
    Item[] items;
    InputOutput io;

    public Menu(Item[] items, InputOutput io) {
        this.items = items;
        this.io = io;
    }

    public void runMenu() {
        while (true){
            for (int i = 0; i < items.length; i++) {
                io.outputLine((i + 1) + ". " + items[i].displayName());
            }
            Integer res = io.inputInteger("Make your choise", 1, items.length);

            if(res==null) return;

            try{
                items[res - 1].perforn();
            } catch (Exception e){
                io.outputLine(e.getMessage());
            }

            if(items[res-1].isExit()) return;
        }
    }
}
