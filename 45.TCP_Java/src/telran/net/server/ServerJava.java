package telran.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;

public class ServerJava implements Runnable {

    ServerSocket serverSocket;
    ProtocolJava protocol;
    int port;
    ExecutorService executor;
    int threadsQuantity = Runtime.getRuntime().availableProcessors() * 2;
    private int timeout;

    public ServerJava(ProtocolJava protocol, int port, ExecutorService executor, int timeout) throws IOException {
        this.protocol = protocol;
        this.port = port;
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(timeout);
        this.executor = executor;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        System.out.println("Server is running on port " + port);

        try {
            while(!ServerClientJava.shutdown.get()) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientSocket.setSoTimeout(timeout);
                    ServerClientJava active = new ServerClientJava(clientSocket, protocol);
                    executor.execute(active);
                } catch (SocketTimeoutException e) {

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void switchShutdown() {
        ServerClientJava.shutdown.set(true);
    }
}
