package telran.net;

import java.io.*;
import java.net.Socket;

public class TCPClientJava implements Closeable {

    protected ObjectInputStream ois;
    protected ObjectOutputStream oos;
    protected Socket socket;

    public TCPClientJava(String hostName, int port) {
        try {
            socket = new Socket(hostName, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Socket creation unsuccessful");
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

    @SuppressWarnings("unchecked")
    protected <T> T sendRequest(String requestType, Serializable requestData) throws Exception {
        try {
            RequestJava requestJava = new RequestJava(requestType, requestData);
            oos.writeObject(requestJava);

            ResponceJava responceJava = (ResponceJava) ois.readObject();

            if(responceJava.code != TCPResponseCode.OK) {
                throw new Exception(responceJava.code.toString());
            }
            return (T)responceJava.responceData;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
