package Controller;

public class ExitItem implements Item{

    @Override
    public String displayName() {
        return "Exit";
    }

    @Override
    public void perforn() {
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
