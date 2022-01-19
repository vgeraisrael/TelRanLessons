package telran.net.server;

import telran.net.RequestJava;
import telran.net.ResponceJava;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClientJava implements Runnable{
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket socket;
    ProtocolJava protocol;

    public ServerClientJava(Socket socket, ProtocolJava protocol) throws IOException {
        this.socket = socket;
        this.protocol = protocol;
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while(true) {
                RequestJava requestJava = (RequestJava) ois.readObject();
                ResponceJava responceJava = protocol.getResponce(requestJava);
                oos.writeObject(responceJava);
            }
        } catch (EOFException eof){
            System.out.println("Client close connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
