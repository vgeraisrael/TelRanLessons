package telran.net;

import java.io.Serializable;

public class RequestJava implements Serializable {
    public String requestType;
    public Serializable requestData;

    public RequestJava(String requestType, Serializable requestData) {
        this.requestType = requestType;
        this.requestData = requestData;
    }
}
