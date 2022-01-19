package Controller;

public interface Item {
    String displayName();
    void perforn() throws Exception;

    default boolean isExit(){
        return false;
    }
}
