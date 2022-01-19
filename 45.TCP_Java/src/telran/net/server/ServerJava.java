package telran.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable {

    ServerSocket serverSocket;
    ProtocolJava protocol;
    int port;

    public ServerJava(ProtocolJava protocol, int port) throws IOException {
        this.protocol = protocol;
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        System.out.println("Server is running on port " + port);

        try {
            while(true) {
                Socket clientSocket = serverSocket.accept();
                ServerClientJava active = new ServerClientJava(clientSocket, protocol);
                active.run();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
