package servertwo;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Joshua on 4/26/2016.
 */
public class ServerTwo {
    public static void main(String[] args){
        System.out.println("The Server is running . . . ");
        int clientNumber = 0;
        try {
            ServerSocket listener = new ServerSocket(9091);
            while (true){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
