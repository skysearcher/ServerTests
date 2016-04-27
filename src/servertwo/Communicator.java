package servertwo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Joshua on 4/26/2016.
 */
public class Communicator extends Thread {
    private Socket socket;
    private int clientNumber;

    public Communicator(Socket givenSocket, int givenClientNumber){
        socket = givenSocket;
        clientNumber = givenClientNumber;
    }

    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("You are client # = " + clientNumber);
            out.println("Client Connection starting . . . ");
            while(true){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
