package reflection;

public class Z implements IX{
    String zStr = "zStr";

    public Z(String zStr) {
        this.zStr = zStr;
    }

    @Override
    public void action() {
        System.out.println("Action in Z class " + zStr);
    }
}
