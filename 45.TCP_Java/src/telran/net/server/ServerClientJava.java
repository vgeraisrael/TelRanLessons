package telran.net.server;

import telran.net.RequestJava;
import telran.net.ResponceJava;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerClientJava implements Runnable{
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket socket;
    ProtocolJava protocol;
    static AtomicBoolean shutdown = new AtomicBoolean(false);

    public ServerClientJava(Socket socket, ProtocolJava protocol) throws IOException {
        this.socket = socket;
        this.protocol = protocol;
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while(!shutdown.get()) {
                try {
                    RequestJava requestJava = (RequestJava) ois.readObject();
                    ResponceJava responceJava = protocol.getResponce(requestJava);
                    oos.writeObject(responceJava);
                    oos.reset();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (SocketTimeoutException e){

                }
            }
        } catch (EOFException eof){
            System.out.println("Client close connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
