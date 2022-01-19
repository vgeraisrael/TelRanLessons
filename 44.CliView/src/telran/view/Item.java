package telran.view;

public interface Item {
    String displayName();
    void perforn() throws Exception;

    default boolean isExit(){
        return false;
    }
}
