package no.ntnu.idata2305.juliangm.assignment1.computation;

import no.ntnu.idata2305.juliangm.assignment1.utils.ResponseGenerator;

import java.io.OutputStream;
import java.net.Socket;

public class AsyncSearchSimulator implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText = null;

    public AsyncSearchSimulator(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    public void run() {
        long time1 = System.currentTimeMillis();
        System.out.println("Request processing started at: " + time1);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("Request processing ended at: " + time2);


    }
}