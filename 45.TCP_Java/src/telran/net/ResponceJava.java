package telran.net;

import java.io.Serializable;

public class ResponceJava implements Serializable {
    public TCPResponseCode code;
    public Serializable responceData;

    public ResponceJava(TCPResponseCode code, Serializable responceData) {
        this.code = code;
        this.responceData = responceData;
    }
}
