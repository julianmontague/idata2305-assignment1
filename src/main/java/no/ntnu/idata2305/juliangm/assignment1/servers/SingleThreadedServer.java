/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package no.ntnu.idata2305.juliangm.assignment1.servers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import no.ntnu.idata2305.juliangm.assignment1.computation.SearchSimulator;

/**
 *
 * @author julian
 */
public class SingleThreadedServer implements Runnable {
    protected int serverPort = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    public SingleThreadedServer() {}

    public SingleThreadedServer(int port) {
        this.serverPort = port;
    }

    @Override
    public void run() {
        openServerSocket();

        while (!this.isStopped()) {
            try {
                Socket client = this.serverSocket.accept();
                OutputStream out = client.getOutputStream();
                out.write(SearchSimulator.processClientRequest().getBytes());
                out.flush();
                client.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        System.out.println("Server stopped.");
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    private synchronized void stop() {
        this.isStopped = true;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}
