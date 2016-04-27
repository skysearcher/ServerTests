package requestserver;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Joshua on 4/26/2016.
 */
public class ServerOne {
    private static final int SERVER_PORT_NUMBER = 8081;
    private static final int MAX_WAITING_CONNECTIONS = 10;

    private static HttpServer server;

    private static HttpHandler mainHandler;

    public ServerOne() {

    }

    public void run() {
        try {
            server = HttpServer.create(new InetSocketAddress(SERVER_PORT_NUMBER), MAX_WAITING_CONNECTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.setExecutor(null);

        server.createContext("/test", mainHandler);
        server.start();
    }

    public static void main(String[] args) {
        mainHandler = new OneHandler();
        new ServerOne().run();
    }
}
