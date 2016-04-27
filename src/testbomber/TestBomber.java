package testbomber;

import shared.HttpURLResponse;
import timer.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Joshua on 4/26/2016.
 */
public class TestBomber {
    private String URL_PREFIX = "";
    private String SERVER_HOST;
    private int SERVER_PORT;

    private String HTTP_GET = "GET";

    public TestBomber(String serverAddress){
        SERVER_PORT = 8081;
        SERVER_HOST = serverAddress;
        URL_PREFIX = "http://" + SERVER_HOST + ":" + SERVER_PORT;
    }


    public void bomb(){
        StopWatch stop = new StopWatch();
        stop.start();
        for(int i = 0; i < 10000; i++){
            System.out.println("Time since Start Before = " + stop.getElapsedTime());
            HttpURLResponse test = doGet("/test");
            System.out.println(test.getResponseBody());
            if(test.getResponseBody().equals("")){
                i = 10000;
            }
            System.out.println("Time since Start After = " + stop.getElapsedTime());
        }
        stop.stop();
    }

    public HttpURLResponse doGet(String urlPath) {
        HttpURLResponse result = new HttpURLResponse();
        try {
            URL url = new URL(URL_PREFIX + urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HTTP_GET);
            connection.setDoOutput(true);

            connection.connect();
            OutputStreamWriter myOut = new OutputStreamWriter(connection.getOutputStream());
            myOut.flush();


            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                if (connection.getContentLength() != 0) {
                    result.setResponseCode(connection.getResponseCode());
                    result.setResponseLength(connection.getContentLength());
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    result.setResponseBody(myReader.readLine());
                    result.setCookie(connection.getHeaderField("Set-cookie"));
                    connection.disconnect();
                }
            } else {
                //    System.out.println(connection.getResponseMessage());
                int code = connection.getResponseCode();
                connection.disconnect();
            }
        } catch (IOException e) {
            System.out.println("Connection Failure");
        }
        return result;
    }


    public static void main(String[] args) {
        TestBomber test;
        if(args.length > 0){
            test = new TestBomber(args[0]);
        }else{
            test = new TestBomber("localhost");
        }
        test.bomb();
    }
}
