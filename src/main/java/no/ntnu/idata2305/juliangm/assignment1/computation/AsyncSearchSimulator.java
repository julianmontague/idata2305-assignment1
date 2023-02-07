package no.ntnu.idata2305.juliangm.assignment1.computation;

import java.io.OutputStream;
import java.net.Socket;

public class AsyncSearchSimulator implements Runnable {

    protected Socket clientSocket = null;
    protected String serverText = null;

    public AsyncSearchSimulator(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    @Override
    public void run() {
        try {
            OutputStream out = this.clientSocket.getOutputStream();
            out.write(SearchSimulator.processClientRequest().getBytes());
            out.flush();
            this.clientSocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}