package quotableserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Joshua on 4/26/2016.
 */
public class Handler implements HttpHandler {
    private String requestBody;
    private int requests;

    public Handler() {
        requests = 0;
    }

    public void testHandle(HttpExchange exchange) {
        String info = "Congratulations!! You are Handle number: " + requests;
        ArrayList<String> content = new ArrayList<String>();
        content.add("text/html");
        exchange.getResponseHeaders().put("Content-Type", content);
        try {
            exchange.sendResponseHeaders(200, info.length());
            exchange.getResponseBody().write(info.getBytes());
            exchange.getResponseBody().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        requests++;
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        Scanner scan = new Scanner(exchange.getRequestBody());
        requestBody = "";
        while (scan.hasNext()) {
            requestBody += scan.nextLine();
        }


        if (path.contains("/test")) {
            testHandle(exchange);
            return;
        } else if (path.contains("/user")) {
            return;
        }
    }
}
